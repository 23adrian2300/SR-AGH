//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.10
//
// <auto-generated>
//
// Generated from file `SmartHome.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package SmartHome;

public interface RGBLamp extends Lamp
{
    void setRGB(RGB rgb, com.zeroc.Ice.Current current)
        throws WrongRGBvaluesException;

    RGB getRGB(com.zeroc.Ice.Current current);

    /** @hidden */
    static final String[] _iceIds =
    {
        "::Ice::Object",
        "::SmartHome::Lamp",
        "::SmartHome::RGBLamp"
    };

    @Override
    default String[] ice_ids(com.zeroc.Ice.Current current)
    {
        return _iceIds;
    }

    @Override
    default String ice_id(com.zeroc.Ice.Current current)
    {
        return ice_staticId();
    }

    static String ice_staticId()
    {
        return "::SmartHome::RGBLamp";
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
     * @throws com.zeroc.Ice.UserException -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_setRGB(RGBLamp obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
        throws com.zeroc.Ice.UserException
    {
        com.zeroc.Ice.Object._iceCheckMode(com.zeroc.Ice.OperationMode.Idempotent, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        RGB iceP_rgb;
        iceP_rgb = RGB.ice_read(istr);
        inS.endReadParams();
        obj.setRGB(iceP_rgb, current);
        return inS.setResult(inS.writeEmptyParams());
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_getRGB(RGBLamp obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(com.zeroc.Ice.OperationMode.Idempotent, current.mode);
        inS.readEmptyParams();
        RGB ret = obj.getRGB(current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        RGB.ice_write(ostr, ret);
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /** @hidden */
    final static String[] _iceOps =
    {
        "changeState",
        "getName",
        "getRGB",
        "getState",
        "ice_id",
        "ice_ids",
        "ice_isA",
        "ice_ping",
        "setRGB"
    };

    /** @hidden */
    @Override
    default java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceDispatch(com.zeroc.IceInternal.Incoming in, com.zeroc.Ice.Current current)
        throws com.zeroc.Ice.UserException
    {
        int pos = java.util.Arrays.binarySearch(_iceOps, current.operation);
        if(pos < 0)
        {
            throw new com.zeroc.Ice.OperationNotExistException(current.id, current.facet, current.operation);
        }

        switch(pos)
        {
            case 0:
            {
                return Lamp._iceD_changeState(this, in, current);
            }
            case 1:
            {
                return Lamp._iceD_getName(this, in, current);
            }
            case 2:
            {
                return _iceD_getRGB(this, in, current);
            }
            case 3:
            {
                return Lamp._iceD_getState(this, in, current);
            }
            case 4:
            {
                return com.zeroc.Ice.Object._iceD_ice_id(this, in, current);
            }
            case 5:
            {
                return com.zeroc.Ice.Object._iceD_ice_ids(this, in, current);
            }
            case 6:
            {
                return com.zeroc.Ice.Object._iceD_ice_isA(this, in, current);
            }
            case 7:
            {
                return com.zeroc.Ice.Object._iceD_ice_ping(this, in, current);
            }
            case 8:
            {
                return _iceD_setRGB(this, in, current);
            }
        }

        assert(false);
        throw new com.zeroc.Ice.OperationNotExistException(current.id, current.facet, current.operation);
    }
}
