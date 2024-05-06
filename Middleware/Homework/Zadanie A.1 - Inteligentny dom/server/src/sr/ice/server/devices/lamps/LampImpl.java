package sr.ice.server.devices.lamps;

import SmartHome.Lamp;
import com.zeroc.Ice.Current;
import SmartHome.State;

import java.util.logging.Logger;

public class LampImpl implements Lamp {
    Logger logger = Logger.getLogger(LampImpl.class.getName());
    public LampImpl() {
    }

    public LampImpl(String name) {
        this.name = name;
    }

    private State state = State.OFF;
    private String name = "Lamp";

    @Override
    public String getName(Current current) {
        logger.info("Lamp name requested: " + name);
        return this.name;
    }

    @Override
    public void changeState(Current current) {
        if (state == State.OFF) {
            state = State.ON;
        } else {
            state = State.OFF;
        }
        logger.info("Lamp state changed to: " + state);
    }

    @Override
    public State getState(Current current) {
        logger.info("Lamp state requested: " + state);
        return this.state;
    }

}
