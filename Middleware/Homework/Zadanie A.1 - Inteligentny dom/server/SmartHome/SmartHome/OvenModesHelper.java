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

/**
 * Helper class for marshaling/unmarshaling OvenModes.
 **/
public final class OvenModesHelper
{
    public static void write(com.zeroc.Ice.OutputStream ostr, OvenMode[] v)
    {
        if(v == null)
        {
            ostr.writeSize(0);
        }
        else
        {
            ostr.writeSize(v.length);
            for(int i0 = 0; i0 < v.length; i0++)
            {
                OvenMode.ice_write(ostr, v[i0]);
            }
        }
    }

    public static OvenMode[] read(com.zeroc.Ice.InputStream istr)
    {
        final OvenMode[] v;
        final int len0 = istr.readAndCheckSeqSize(1);
        v = new OvenMode[len0];
        for(int i0 = 0; i0 < len0; i0++)
        {
            v[i0] = OvenMode.ice_read(istr);
        }
        return v;
    }

    public static void write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<OvenMode[]> v)
    {
        if(v != null && v.isPresent())
        {
            write(ostr, tag, v.get());
        }
    }

    public static void write(com.zeroc.Ice.OutputStream ostr, int tag, OvenMode[] v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            int pos = ostr.startSize();
            OvenModesHelper.write(ostr, v);
            ostr.endSize(pos);
        }
    }

    public static java.util.Optional<OvenMode[]> read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            istr.skip(4);
            OvenMode[] v;
            v = OvenModesHelper.read(istr);
            return java.util.Optional.of(v);
        }
        else
        {
            return java.util.Optional.empty();
        }
    }
}
