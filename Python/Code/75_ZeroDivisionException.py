try:
    x = int(input("Enter number1:"))
    y = int(input("Enter number2:"))
    print(x / y)
except ZeroDivisionError:
    print("Can not divide zero")
