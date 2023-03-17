import smtplib

# list of email_id to send the mail
li = ["vipulbaldha2008@gmail.com"]

for dest in li:
    s = smtplib.SMTP('smtp.gmail.com', 587)
    s.starttls()
    s.login("example@gmail.com", "pass")
    message = "Hi i am coder, How are you?, This Email send by SMTPlib through the Python,Enjoy...."
    s.sendmail("communitycoder3@gmail.com", dest, message)
    s.quit()
