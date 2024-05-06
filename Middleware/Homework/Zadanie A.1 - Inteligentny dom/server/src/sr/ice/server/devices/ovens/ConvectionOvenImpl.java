package sr.ice.server.devices.ovens;

import SmartHome.ChangeFanSpeedException;
import SmartHome.ConvectionOven;
import com.zeroc.Ice.Current;

import java.util.logging.Logger;

public class ConvectionOvenImpl extends ModdedOvenImpl implements ConvectionOven {
    private int fanSpeed = 0;
    private Logger logger = Logger.getLogger(ConvectionOvenImpl.class.getName());

    public ConvectionOvenImpl() {
    }

    public ConvectionOvenImpl(String name) {
        super(name);
    }

    @Override
    public void setFanSpeed(int speed, Current current) throws ChangeFanSpeedException {
        if (speed < 0 || speed > 3) {
            logger.warning("Wrong fan speed value: " + speed);
            throw new ChangeFanSpeedException();
        }
        this.fanSpeed = speed;
        logger.info("Fan speed set to: " + speed);
    }

    @Override
    public int getFanSpeed(Current current) {
        logger.info("Fan speed requested: " + fanSpeed);
        return this.fanSpeed;
    }
}
