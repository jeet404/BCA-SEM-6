# Break Statement
print("---Break Statement---")
n = 10
for i in range(1, n + 1):
    if i == 5:
        break
    else:
        print(i, end=" ")

# Continue Statement
print("\n---Continue Statement---")
for i in range(1, n + 1):
    if i == 5:
        continue
    else:
        print(i, end=" ")

# Pass Statement
print("\n---Pass Statement---")
for i in range(1, n + 1):
    if i <= 5:
        pass
    else:
        print(i, end=" ")
