package sr.ice.server.devices.ovens;

import SmartHome.ChangeStateException;
import SmartHome.Oven;
import SmartHome.State;
import SmartHome.WrongTemperaturevaluesException;
import com.zeroc.Ice.Current;

import java.util.logging.Logger;

public class OvenImpl implements Oven {

    private State state = State.OFF;
    private Logger logger = Logger.getLogger(OvenImpl.class.getName());
    private int temperature = 0;
    private String name = "Oven";

    public OvenImpl() {
    }

    public OvenImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName(Current current) {
        logger.info("Oven name requested: " + name);
        return this.name;
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
}
