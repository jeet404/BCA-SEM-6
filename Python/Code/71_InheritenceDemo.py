from teacher import Teacher


class Student(Teacher):
    def setmarks(self, marks):
        self.marks = marks

    def getmarks(self):
        return self.marks


s = Student()
s.setid(100)
s.setname("Jeet")
s.setaddress("Lathi road, Amreli")
s.setmarks(85)
print("Id = ", s.getid())
print("Name = ", s.getname())
print("Address = ", s.getaddress())
print("marks = ", s.getmarks())
