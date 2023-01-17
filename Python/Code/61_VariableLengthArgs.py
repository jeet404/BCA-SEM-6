def add(farg, *args):
    print("Formal Arg = ", farg)
    sum = 0
    for i in args:
        sum += i
    print("Sum = ", (farg + sum))


add(5, 15)
add(100, 10, 15, 20, 25)
