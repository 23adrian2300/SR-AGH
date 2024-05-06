def print_commands():
    print('Available commands:')
    print('1) commandslist - show available commands')
    print('2) getname - get lamp name')
    print('3) getstate - get lamp state')
    print('4) changestate - change lamp state')
    print('5) gettemperature - get oven temperature')
    print('6) settemperature - set oven temperature')
    print('7) exit - exit from lamp handler')


def oven_handler(oven, smart_home):
    print_commands()
    while True:
        arg = input(f'> ')
        if arg == 'commandslist' or arg == '1':
            print_commands()
        elif arg == 'getname' or arg == '2':
            name = oven.getName()
            print('Oven name: ' + str(name))
        elif arg == "getstate" or arg == '3':
            state = oven.getState()
            print('Oven state: ' + str(state))
        elif arg == "changestate" or arg == '4':
            try:
                oven.changeState()
                print('Oven state was successfully changed.')
            except smart_home.ChangeStateException:
                print('Oven state was not changed.')
        elif arg == "gettemperature" or arg == '5':
            temperature = oven.getTemperature()
            print('Oven temperature: ' + str(temperature))
        elif arg == "settemperature" or arg == '6':
            temperature = input(f'Enter temperature: ')
            try:
                temperature = int(temperature)
                oven.setTemperature(temperature)
                print('Oven temperature was successfully changed.')
            except smart_home.WrongTemperaturevaluesException:
                print('Oven temperature was not changed.')
        elif arg == "exit" or arg == '7':
            print("Exit from oven handler")
            break
        else:
            print('Unknown command. Please try again.')
