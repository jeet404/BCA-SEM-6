rno = int(input("Enter Roll Number : "))
name = input("Enter Name : ")
android = int(input("Enter Marks of Android : "))
dw = int(input("Enter Marks of DataWerehouse : "))
py = int(input("Enter Marks of Python : "))
project = int(input("Enter Marks of Project: "))

obt_marks = android + dw + py + project
per = obt_marks / 4

print("-------------STUDENT'S MARKSHEET-------------")
print("Your Roll Number is : " + str(rno))
print("Your Name is : " + name)
print("Obtained Marks are : " + str(obt_marks))
print("Your Percentage is : " + str(per))

if per >= 80:
    print("Grade : A+\nRemarks : Excellent")
elif per >= 70:
    print("Grade : A\nRemarks : Very Good")
elif per >= 60:
    print("Grade : B\nRemarks : Good")
elif per >= 50:
    print("Grade : C\nRemarks : Fair")
elif per >= 40:
    print("Grade : D\nRemarks : Poor")
elif per >= 33:
    print("Grade : E\nRemarks : Need Improvement")
else:
    print("FAIL!!!!\nRemarks : Failure")
