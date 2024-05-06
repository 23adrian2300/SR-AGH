package sr.ice.server.devices.ovens;

import SmartHome.*;
import com.zeroc.Ice.Current;

import java.util.logging.Logger;

public class ModdedOvenImpl extends OvenImpl implements ModdedOven {

    private State state = State.OFF;
    private Logger logger = Logger.getLogger(ModdedOvenImpl.class.getName());
    private int temperature = 0;

    private OvenMode mode = OvenMode.GRILL;

    private String name = "Modded Oven";

    public ModdedOvenImpl() {
    }

    public ModdedOvenImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName(Current current) {
        logger.info("Oven name requested: " + name);
        return this.name;
    }

    @Override
    public void setMode(OvenMode mode, Current current) throws InvalidOvenModeException {
        if (mode == OvenMode.GRILL || mode == OvenMode.WARM || mode == OvenMode.DEFROST || mode == OvenMode.BAKE) {
            logger.info("Oven mode set to: " + mode);
            this.mode = mode;
        } else {
            logger.warning("Invalid oven mode: " + mode);
            throw new InvalidOvenModeException();
        }
    }

    @Override
    public void setTemperature(int temp, Current current) throws WrongTemperaturevaluesException {
        if (temp < 0 || temp > 300) {
            logger.warning("Wrong temperature value: " + temp);
            throw new WrongTemperaturevaluesException();
        }
        this.temperature = temp;
        logger.info("Temperature set to: " + temp);
    }

    @Override
    public int getTemperature(Current current) {
        logger.info("Temperature requested: " + temperature);
        return this.temperature;
    }

    @Override
    public State getState(Current current) {
        logger.info("Oven state requested: " + state);
        return this.state;
    }

    @Override
    public void changeState(Current current) throws ChangeStateException {
        if (getState(current) == State.OFF) {
            state = State.ON;
        } else {
            state = State.OFF;
        }
        logger.info("Oven state changed to: " + state);
    }

    @Override
    public OvenMode getMode(Current current) {
        logger.info("Oven mode requested: " + mode);
        return this.mode;
    }

    @Override
    public OvenMode[] getSupportedModes(Current current) {
        logger.info("Supported modes requested");
        return new OvenMode[]{OvenMode.GRILL, OvenMode.WARM, OvenMode.DEFROST, OvenMode.BAKE};
    }
}
