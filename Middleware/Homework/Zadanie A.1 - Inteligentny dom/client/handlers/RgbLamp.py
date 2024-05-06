def print_commands():
    print('Available commands:')
    print('1) commandslist - show available commands')
    print('2) getname - get lamp name')
    print('3) getstate - get lamp state')
    print('4) changestate - change lamp state')
    print('5) getrgb - get lamp color')
    print('6) setrgb - set lamp color')
    print('7) exit - exit from lamp handler')


def rgb_Lamp_handler(rgb_lamp, smart_home):
    print_commands()
    while True:
        arg = input(f'> ')
        if arg == "commandslist" or arg == '1':
            print_commands()
        elif arg == 'getname' or arg == '2':
            name = rgb_lamp.getName()
            print('RGBLamp name: ' + str(name))
        elif arg == "getstate" or arg == '3':
            state = rgb_lamp.getState()
            print('RGBLamp state: ' + str(state))
        elif arg == "changestate" or arg == '4':
            try:
                rgb_lamp.changeState()
                print('RGBLamp state was successfully changed.')
            except smart_home.ChangeStateException:
                print('RGBLamp state was not changed.')
        elif arg == "getrgb" or arg == '5':
            color = rgb_lamp.getRGB()
            print('RGBLamp color: ' + str(color))
        elif arg == "setrgb" or arg == '6':
            colors = input(f'Enter RGB colors separated by space: ')
            try:
                colors = list(map(int, colors.split(' ')))
                rgb = smart_home.RGB(colors[0], colors[1], colors[2])
                rgb_lamp.setRGB(rgb)
                print('RGBLamp color was successfully changed.')
            except smart_home.WrongRGBvaluesException:
                print('RGBLamp color was not changed.')
        elif arg == "exit" or arg == '7':
            print("Exit from RGBLamp handler")
            break
        else:
            print('Unknown command. Please try again.')
