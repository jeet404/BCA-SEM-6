try:
    x = int(input("Enter a number between 5 and 10: "))
    assert 5 <= x <= 10
    print("The number entered:", x)
except AssertionError:
    print("The condition is not fulfilled")
