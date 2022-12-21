a = 25
b = 25
print(id(a))
print(id(b))
c = a + b
print(id(c))
# Identity Operator with is
lstA = [10, 20, 30]
lstB = [10, 20, 30]
if lstA is lstB:
    print("ListA and ListB have same id")
else:
    print("ListA and ListB do not have same id")
# Identity Operator with is not
A = 26
B = 26
if A is not B:
    print("A and B do not have same id")
else:
    print("A and B have same id")
