n = int(input("Enter Range : "))
i = 1
while i <= n:
    j = n
    while j >= i:
        print("*", end=" ")
        j -= 1
    print()
    i += 1
print("Process Over")