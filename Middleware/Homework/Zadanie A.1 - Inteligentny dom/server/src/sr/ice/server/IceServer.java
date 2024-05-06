package sr.ice.server;

import SmartHome.ModdedOven;
import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Identity;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;
import sr.ice.server.devices.lamps.LampImpl;
import sr.ice.server.devices.lamps.RgbLampImpl;
import sr.ice.server.devices.ovens.ConvectionOvenImpl;
import sr.ice.server.devices.ovens.ModdedOvenImpl;
import sr.ice.server.devices.ovens.OvenImpl;

public class IceServer {
    public void t1(String[] args) {
        int status = 0;
        Communicator communicator = null;

        try {
            // 1. Inicjalizacja ICE -utworzenie communicatora
            communicator = Util.initialize(args);

            // 2. Konfiguracja adaptera jest w pliku konfiguracyjnym podanym jako parametr uruchomienia serwera
            ObjectAdapter lampAdapter = communicator.createObjectAdapter("LampAdapter");
            ObjectAdapter ovenAapter = communicator.createObjectAdapter("OvenAdapter");
            // 3. Utworzenie serwanta/serwantów
            LampImpl livingroomlampServant = new LampImpl("LivingRoom Lamp");
            LampImpl bathroomlampServant = new LampImpl("Bathroom Lamp");

            RgbLampImpl rgbLampServant = new RgbLampImpl("RGB Lamp");

            OvenImpl ovenServant = new OvenImpl("Kitchen Oven");
            ModdedOven moddedOvenServant = new ModdedOvenImpl("Modded Oven");
            ConvectionOvenImpl convectionOvenServant = new ConvectionOvenImpl("Oven with convection");

            // 4. Dodanie wpisów do tablicy ASM, skojarzenie nazwy obiektu (Identity) z serwantem
            lampAdapter.add(livingroomlampServant, new Identity("livingRoomLamp", "lamp"));
            lampAdapter.add(bathroomlampServant, new Identity("bathRoomLamp", "lamp"));
            lampAdapter.add(rgbLampServant, new Identity("rgbLamp", "lamp"));

            ovenAapter.add(ovenServant, new Identity("oven", "oven"));
            ovenAapter.add(moddedOvenServant, new Identity("moddedOven", "oven"));
            ovenAapter.add(convectionOvenServant, new Identity("convectionOven", "oven"));

            // 5. Aktywacja adaptera i wejście w pętlę przetwarzania żądań
            lampAdapter.activate();
            ovenAapter.activate();

            System.out.println("Entering event processing loop...");

            communicator.waitForShutdown();

        } catch (Exception e) {
            e.printStackTrace(System.err);
            status = 1;
        }
        if (communicator != null) {
            try {
                communicator.destroy();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                status = 1;
            }
        }
        System.exit(status);
    }


    public static void main(String[] args) {
        IceServer app = new IceServer();
        app.t1(args);
    }
}