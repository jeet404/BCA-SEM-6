def allCal(a, b):
    c = a + b
    d = a - b
    e = a * b
    f = a / b
    return c, d, e, f


result = allCal(10, 5)
print("---Result---")
for i in result:
    print(i, end=" ")
