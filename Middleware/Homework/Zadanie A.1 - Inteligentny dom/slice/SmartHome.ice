module SmartHome{

    exception WrongRGBvaluesException{};
    exception InvalidOvenModeException{};
    exception WrongTemperaturevaluesException{};
    exception ChangeStateException{};
    exception ChangeFanSpeedException{};

    enum State{
        ON,
        OFF
    };

    struct RGB{
        int r;
        int g;
        int b;
    };
    
    enum OvenMode{
        BAKE,
        GRILL,
        DEFROST,
        WARM
    };

    sequence<OvenMode> OvenModes;

    interface Lamp{
        idempotent string getName();
        idempotent void changeState() throws ChangeStateException;
        idempotent State getState();
    };

    interface RGBLamp extends Lamp{
        idempotent void setRGB(RGB rgb) throws WrongRGBvaluesException;
        idempotent RGB getRGB();
    };

    
    interface Oven{
        idempotent string getName();
        idempotent void setTemperature(int temp) throws WrongTemperaturevaluesException;
        idempotent int getTemperature();
        idempotent State getState();
        idempotent void changeState() throws ChangeStateException;
    };

    interface ModdedOven extends Oven{
        idempotent void setMode(OvenMode mode) throws InvalidOvenModeException;
        idempotent OvenMode getMode();
        idempotent OvenModes getSupportedModes();
    };
    interface ConvectionOven extends ModdedOven{
        idempotent void setFanSpeed(int speed) throws ChangeFanSpeedException;
        idempotent int getFanSpeed();
    };

}