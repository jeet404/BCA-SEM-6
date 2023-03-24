# to find different parts of a URL
import urllib.parse

# take any url
url = 'http://www.dreamtechpress.com:80/engineering/computer-science.html'
# get a tuple with parts of the url
tpl = urllib.parse.urlparse(url)
# display the contents of the tuple
print(tpl)
# display different parts of the url
print('scheme = ', tpl.scheme)
print('Net location = ', tpl.netloc)
print('path = ', tpl.path)
print('parameters = ', tpl.params)
print('port number = ', tpl.port)
print('total url = ', tpl.geturl())
