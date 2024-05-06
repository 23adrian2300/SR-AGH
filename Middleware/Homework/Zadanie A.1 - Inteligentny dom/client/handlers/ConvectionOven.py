def print_commands():
    print('Available commands:')
    print('1) commandslist - show available commands')
    print('2) getname - get lamp name')
    print('3) getstate - get lamp state')
    print('4) changestate - change lamp state')
    print('5) gettemperature - get oven temperature')
    print('6) settemperature - set oven temperature')
    print('7) getmode - get oven mode')
    print('8) setmode - set oven mode')
    print('9) getsupportedmodes - get supported modes')
    print('10) setfanspeed - set fan speed')
    print('11) getfanspeed - get fan speed')
    print('12) exit - exit from lamp handler')


def map_mode(mode):
    arg = 0
    if mode == "BAKE":
        arg = 0
    elif mode == "GRILL":
        arg = 1
    elif mode == "DEFROST":
        arg = 2
    elif mode == "WARM":
        arg = 3
    return arg


def convection_oven_handler(convection_oven, smart_home):
    print_commands()
    while True:
        arg = input(f'> ')
        if arg == 'commandslist' or arg == '1':
            print_commands()
        elif arg == 'getname' or arg == '2':
            name = convection_oven.getName()
            print('Modded oven name: ' + str(name))
        elif arg == "getstate" or arg == '3':
            state = convection_oven.getState()
            print('Modded oven state: ' + str(state))
        elif arg == "changestate" or arg == '4':
            try:
                convection_oven.changeState()
                print('Modded oven state was successfully changed.')
            except smart_home.ChangeStateException:
                print('Modded oven state was not changed.')
        elif arg == "gettemperature" or arg == '5':
            temperature = convection_oven.getTemperature()
            print('Moded oven temperature: ' + str(temperature))
        elif arg == "settemperature" or arg == '6':
            temperature = input(f'Enter temperature: ')
            try:
                temperature = int(temperature)
                convection_oven.setTemperature(temperature)
                print('Modded oven temperature was successfully changed.')
            except smart_home.WrongTemperaturevaluesException:
                print('Modded oven temperature was not changed.')
        elif arg == "getmode" or arg == '7':
            mode = convection_oven.getMode()
            print('Modded oven mode: ' + str(mode))
        elif arg == "setmode" or arg == '8':
            print('Available modes: BAKE, GRILL, DEFROST, WARM')
            while True:
                v = input(f'Enter mode: ')
                if v not in ["BAKE", "GRILL", "DEFROST", "WARM"]:
                    print('Unknown mode. Please try again.')
                elif v == "exit":
                    break
                else:
                    break
            try:
                mode = smart_home.OvenMode.valueOf(map_mode(v))
                convection_oven.setMode(mode)
                print('Modded oven mode was successfully changed.')
            except smart_home.InvalidOvenModeException:
                print('Modded oven mode was not changed.')
        elif arg == 'getsupportedmodes' or arg == '9':
            modes = convection_oven.getSupportedModes()
            print('Supported modes: ' + str(modes))
        elif arg == "setfanspeed" or arg == '10':
            speed = input(f'Enter fan speed: ')
            try:
                speed = int(speed)
                convection_oven.setFanSpeed(speed)
                print('Fan speed was successfully changed.')
            except smart_home.ChangeFanSpeedException:
                print('Fan speed was not changed.')
        elif arg == "getfanspeed" or arg == '11':
            speed = convection_oven.getFanSpeed()
            print('Fan speed: ' + str(speed))
        elif arg == "exit" or arg == '12':
            print("Exit from modded oven handler")
            break
        else:
            print('Unknown command. Please try again.')
