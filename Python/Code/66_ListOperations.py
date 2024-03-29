lst = list(range(1, 5))
print(lst)
lst.append(9)
print(lst)
lst[1] = 8  # update 1st element of lst
print(lst)
lst[1:3] = 10, 11  # update 1st and 2nd elements of lst
print(lst)
lst.remove(9)  # delete 9 from lst
print(lst)
del lst[1]  # delete 1st element from lst
print(lst)
lst.reverse()
print(lst)
# Python's list methods
num = [10, 20, 30, 40, 50]
n = len(num)
print("No of elements in num: ", n)
num.append(60)
print("Num after appending 60: ", num)
num.insert(0, 5)
print("Num after inserting 5 at 0th position: ", num)
num1 = num.copy()
print("Newly created list num1: ", num1)
num.extend(num1)
print("num after appending num1:", num)
n = num.count(50)
print("No of times 50 found in the list num: ", n)
num.remove(50)
print("Num after removing 50:", num)
num.pop()
print("num after removing ending element:", num)
num.sort()
print("num after sorting:", num)
num.reverse()
print("Num after reversing:", num)
num.clear()
print("num after removing all elements:", num)
