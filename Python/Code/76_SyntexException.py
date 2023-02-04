try:
    date = eval(input("Enter date: "))
except SyntaxError:
    print("Invalid date entered")
else:
    print("You entered: ", date)
