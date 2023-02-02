from employee import *

basic = float(input("Enter Basic Salary : "))
gross = basic + da(basic) + hra(basic)
print("Gross Salary = {:10.2f}".format(gross))
net = gross - pf(basic) - tax(gross)
print("Net Salary = {:10.2f}".format(net))
