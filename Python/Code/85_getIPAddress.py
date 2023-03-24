# knowing IP Address of a website
import socket

# take the sever name
host = 'jeet404.github.io'
try:
    # know the ip address of the website
    addr = socket.gethostbyname(host)
    print('IP Address = ' + addr)
except socket.gaierror:  # if get address info error occurs
    print('The website does not exist')
