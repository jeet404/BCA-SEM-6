n = int(input("Enter Range Number : "))
f = 0
s = 1
if n <= 0:
    print("Enter Positive Number!")
else:
    x = 2
    while x < n:
        next = f + s
        print(next, end=" ")
        f = s
        s = next
        x += 1
