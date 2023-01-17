import math


def dispFactorial(n):
    for i in range(1, n + 1):
        print("Factorial of " + str(i) + " is : " + str(math.factorial(i)))


n = int(input("Enter Range Of Number : "))
dispFactorial(n)
