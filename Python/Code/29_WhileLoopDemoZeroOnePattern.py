n = int(input("Enter Range : "))
i = 1
while i <= n:
    j = 1
    while j <= i:
        if j % 2 == 0:
            print("0", end=" ")
        else:
            print("1", end=" ")
        j += 1
    print()
    i += 1
print("Process Over")
