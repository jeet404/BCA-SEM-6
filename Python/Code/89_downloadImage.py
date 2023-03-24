import urllib.request

# copy the image url
url = "https://cdn.pixabay.com/photo/2020/02/06/09/39/summer-4823612_960_720.jpg"
# download the image as myimage.jpg in curent directory
download = urllib.request.urlretrieve(url, "myimage1.jpg")
