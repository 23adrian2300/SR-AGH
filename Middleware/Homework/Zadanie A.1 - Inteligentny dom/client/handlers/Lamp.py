def print_commands():
    print('Available commands:')
    print('1) commandslist - show available commands')
    print('2) getname - get lamp name')
    print('3) getstate - get lamp state')
    print('4) changestate - change lamp state')
    print('5) exit - exit from lamp handler')

def lamp_handler(lamp, smart_home):
    print_commands()
    while True:
        arg = input(f'> ')
        if arg == 'commandslist' or arg == '1':
            print_commands()
        elif arg == 'getname' or arg == '2':
            name = lamp.getName()
            print('Lamp name: ' + str(name))
        elif arg == "getstate" or arg == '3':
            state = lamp.getState()
            print('Lamp state: ' + str(state))
        elif arg == "changestate" or arg == '4':
            try:
                lamp.changeState()
                print('Lamp state was successfully changed.')
            except smart_home.ChangeStateException:
                print('Lamp state was not changed.')
        elif arg == "exit" or arg == '5':
            print("Exit from lamp handler")
            break
        else:
            print('Unknown command. Please try again.')
