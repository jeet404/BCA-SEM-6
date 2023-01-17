# Else Suite With For Loop
print("\n---Else Suite With For Loop---")
for i in range(1, 10):
    if i % 2 == 0:
        print(i, end=" ")
else:
    print("\nOver")

# Else Suite With While Loop
print("\n---Else Suite With While Loop---")
x = 1
while x <= 10:
    if x <= 5:
        print(x, end=" ")
    x += 1
else:
    print("\nOver")
