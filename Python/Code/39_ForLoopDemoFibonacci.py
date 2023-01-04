n = int(input("Enter Range Number : "))
f = 0
s = 1
if n <= 0:
    print("Enter Positive Number!")
else:
    for x in range(2, n):
        next = f + s
        print(next, end=" ")
        f = s
        s = next
