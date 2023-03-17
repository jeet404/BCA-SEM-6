import socket
import threading
import tkinter as tk

window = tk.Tk()
window.title("Server")

text_width = 40
text_height = 20

text_box = tk.Text(window, width=text_width, height=text_height)
text_box.pack()

input_box = tk.Entry(window, width=text_width)
input_box.pack()

server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_socket.bind(('localhost', 8000))
server_socket.listen()

clients = []


def handle_client(client_socket, address):
    while True:
        try:
            data = client_socket.recv(1024).decode()
            if not data:
                break
            text_box.insert(tk.END, f"{data}\n")
            for client in clients:
                if client != client_socket:
                    client.sendall(data.encode())
        except:
            break
    clients.remove(client_socket)
    client_socket.close()


def accept_clients():
    while True:
        client_socket, address = server_socket.accept()
        clients.append(client_socket)
        threading.Thread(target=handle_client, args=(client_socket, address)).start()


threading.Thread(target=accept_clients).start()


def send_message(event):
    message = input_box.get()
    input_box.delete(0, tk.END)
    for client in clients:
        client.sendall(message.encode())


window.bind('<Return>', send_message)

# Start the event loop
window.mainloop()
