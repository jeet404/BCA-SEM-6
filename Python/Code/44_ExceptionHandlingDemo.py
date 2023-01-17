num = int(input("Enter Number (Positive) : "))
try:
    assert num > 0
    print("Number is : ", num)
except AssertionError:
    print("Wrong Input Entered!")
