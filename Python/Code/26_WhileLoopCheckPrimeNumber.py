flag = 0
n = int(input("\nEnter Number : "))
i = 2
while i <= (n / 2):
    if n % i == 0:
        flag = 1
        break
    else:
        i += 1
if flag == 1:
    print(n, " is not a Prime Number")
elif flag == 0:
    print(n, " is a Prime Number")
