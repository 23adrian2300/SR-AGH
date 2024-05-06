import sys
import Ice
import SmartHome
from handlers.ConvectionOven import convection_oven_handler
from handlers.ModdedOven import modded_oven_handler
from handlers.Oven import oven_handler
from handlers.RgbLamp import rgb_Lamp_handler
from handlers.Lamp import lamp_handler

file_path = 'config.client'


def read_device_config(file_path):
    devices = {}
    keys = []
    with open(file_path, 'r') as file:
        for line in file:
            if line.strip() and '=' in line:
                key, value = line.strip().split('=')
                keys.append(key)
                change = value.strip().split(':')[0]
                category, device_id = change.split('/')
                devices[device_id] = {'category': category, 'ID': value.split(':')[0]}
    return devices, keys


def print_devices(devices):
    i = 0
    idx = []
    for device in devices:
        print(f'{i}) ID: {device}, Category: {devices[device]["category"]}')
        idx.append(device)
        i += 1
    return idx


def check_device_connection(keys, communicator):
    try:
        for key in keys:
            base = communicator.propertyToProxy(f'{key}')
            if base.ice_ping():
                print(f"Failed to connect to {key}")
                return False
        print("All devices are connected successfully!")
        return True
    except Exception as e:
        return False


if __name__ == '__main__':
    with Ice.initialize(['--Ice.Config=config.client'] + sys.argv) as communicator:
        print("Welcome to the SmartHome system!")
        devices, key = read_device_config(file_path)
        print("Checking device connections...")
        if not check_device_connection(key, communicator):
            print("Failed connection. Exiting...")
            sys.exit(1)
        print("Available devices")
        idx = print_devices(devices)
        smart_home = SmartHome
        while True:
            line = input(f'> ')
            args = line.split(' ')
            if args[0] == 'livingroomlamp' or args[0] == '' or args[0] == idx[0]:
                base = communicator.propertyToProxy(f'LivingRoomLamp.Proxy')
                lamp = SmartHome.LampPrx.checkedCast(base)
                lamp_handler(lamp, smart_home)
            if args[0] == 'bathroomlamp' or args[0] == '1' or args[0] == idx[1]:
                base = communicator.propertyToProxy(f'BathRoomLamp.Proxy')
                lamp = SmartHome.LampPrx.checkedCast(base)
                lamp_handler(lamp, smart_home)
            elif args[0] == 'rgblamp' or args[0] == '2' or args[0] == idx[2]:
                base = communicator.propertyToProxy(f'RGBLamp.Proxy')
                rgb_lamp = SmartHome.RGBLampPrx.checkedCast(base)
                rgb_Lamp_handler(rgb_lamp, smart_home)
            elif args[0] == 'oven' or args[0] == '3' or args[0] == idx[3]:
                base = communicator.propertyToProxy(f'Oven.Proxy')
                oven = SmartHome.OvenPrx.checkedCast(base)
                oven_handler(oven, smart_home)
            elif args[0] == 'moddedoven' or args[0] == '4' or args[0] == idx[4]:
                base = communicator.propertyToProxy(f'ModdedOven.Proxy')
                modded_oven = SmartHome.ModdedOvenPrx.checkedCast(base)
                modded_oven_handler(modded_oven, smart_home)
            elif args[0] == 'convectionoven' or args[0] == '5' or args[0] == idx[5]:
                base = communicator.propertyToProxy(f'ConvectionOven.Proxy')
                convection_oven = SmartHome.ConvectionOvenPrx.checkedCast(base)
                convection_oven_handler(convection_oven, smart_home)
            elif args[0] == 'devices' or args[0] == '6':
                print_devices(devices)
            elif args[0] == 'exit' or args[0] == '7':
                print("Thanks for using the SmartHome system!")
                break
            else:
                print('Unknown command. Please try again.')
