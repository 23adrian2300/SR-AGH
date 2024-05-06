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
    print('10) exit - exit from lamp handler')


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


def modded_oven_handler(modded_oven, smart_home):
    print_commands()
    while True:
        arg = input(f'> ')
        if arg == 'commandslist' or arg == '1':
            print_commands()
        elif arg == 'getname' or arg == '2':
            name = modded_oven.getName()
            print('Moded oven name: ' + str(name))
        elif arg == "getstate" or arg == '3':
            state = modded_oven.getState()
            print('Moded oven state: ' + str(state))
        elif arg == "changestate" or arg == '4':
            try:
                modded_oven.changeState()
                print('Moded oven state was successfully changed.')
            except smart_home.ChangeStateException:
                print('Moded oven state was not changed.')
        elif arg == "gettemperature" or arg == '5':
            temperature = modded_oven.getTemperature()
            print('Modded oven temperature: ' + str(temperature))
        elif arg == "settemperature" or arg == '6':
            temperature = input(f'Enter temperature: ')
            try:
                temperature = int(temperature)
                modded_oven.setTemperature(temperature)
                print('Modded oven temperature was successfully changed.')
            except smart_home.WrongTemperaturevaluesException:
                print('Modded oven temperature was not changed.')
        elif arg == "getmode" or arg == '7':
            mode = modded_oven.getMode()
            print(mode)
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
                modded_oven.setMode(mode)
                print('Modded oven mode was successfully changed.')
            except smart_home.InvalidOvenModeException:
                print('Modded oven mode was not changed.')
        elif arg == 'getsupportedmodes' or arg == '9':
            modes = modded_oven.getSupportedModes()
            print('Supported modes: ' + str(modes))
        elif arg == "exit" or arg == '10':
            print("Exit from modded oven handler")
            break
        else:
            print('Unknown command. Please try again.')
