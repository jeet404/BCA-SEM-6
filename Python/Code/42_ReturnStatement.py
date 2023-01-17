def giveInfo(name, age, email):
    data = {"Name": name, "Age": age, "Email": email}
    return data


nm = input("Enter Name : ")
ag = input("Enter Age : ")
eml = input("Enter Email : ")
result = giveInfo(nm, ag, eml)
print(result.keys())
print(result.values())
