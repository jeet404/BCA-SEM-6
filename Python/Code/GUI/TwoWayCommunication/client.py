import socket
import threading
import tkinter as tk

window = tk.Tk()
window.title("Client")

text_width = 40
text_height = 20

text_box = tk.Text(window, width=text_width, height=text_height)
text_box.pack()

input_box = tk.Entry(window, width=text_width)
input_box.pack()

client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client_socket.connect(('localhost', 8000))


def receive():
    while True:
        data = client_socket.recv(1024).decode()
        if not data:
            break
        text_box.insert(tk.END, f"{data}\n")


threading.Thread(target=receive).start()


def send_message(event):
    message = input_box.get()
    input_box.delete(0, tk.END)
    client_socket.sendall(message.encode())


window.bind('<Return>', send_message)

# Start the event loop
window.mainloop()
