class Student:
    def __init__(self, n=".", m=0):
        self.name = n
        self.mark = m

    def display(self):
        print("Hi ,", self.name)
        print("Your marks is ", self.mark)


s = Student()
s.display()
s1 = Student("Jeet", 88)
s1.display()
