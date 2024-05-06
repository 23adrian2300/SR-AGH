package sr.ice.server.devices.lamps;

import SmartHome.RGB;
import SmartHome.RGBLamp;
import SmartHome.State;
import SmartHome.WrongRGBvaluesException;
import com.zeroc.Ice.Current;

import java.util.logging.Logger;

public class RgbLampImpl extends LampImpl implements RGBLamp {

    private Logger logger = Logger.getLogger(RgbLampImpl.class.getName());

    private State state = State.OFF;
    private RGB rgb = new RGB(0, 0, 0);
    private String name = "RGB Lamp";

    public RgbLampImpl() {
    }

    public RgbLampImpl(String name) {
        super(name);
    }

    @Override
    public String getName(Current current) {
        logger.info("RGB Lamp name requested: " + name);
        return this.name;
    }

    @Override
    public void changeState(Current current) {
        if(getState(current) == State.OFF){
            state = State.ON;
        } else {
            state = State.OFF;
        }
        logger.info("RGB Lamp state changed to: " + state);
    }

    @Override
    public State getState(Current current) {
        logger.info("RGB Lamp state requested: " + state);
        return this.state;
    }

    @Override
    public void setRGB(RGB rgb, Current current) throws WrongRGBvaluesException {
        if(rgb.r < 0 || rgb.r > 255 || rgb.g < 0 || rgb.g > 255 || rgb.b < 0 || rgb.b > 255){
            logger.warning("Wrong RGB values: " + rgb.r + " " + rgb.g + " " + rgb.b);
            throw new WrongRGBvaluesException();
        }
        this.rgb = rgb;
        logger.info("RGB Lamp RGB set to: " + rgb.r + " " + rgb.g + " " + rgb.b);
    }

    @Override
    public RGB getRGB(Current current) {
        logger.info("RGB Lamp RGB requested: " + rgb.r + " " + rgb.g + " " + rgb.b);
        return this.rgb;
    }
}
