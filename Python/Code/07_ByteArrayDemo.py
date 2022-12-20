# Program for byte type array
elements = [10, 20, 0, 40, 15]
# Convert the list into byte type array
x = bytearray(elements)
print(x)
for i in x:
    print(i)
x[0] = 100
for i in x:
    print(i)
