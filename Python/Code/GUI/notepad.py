import tkinter as tk
from tkinter import filedialog

# Create the window
window = tk.Tk()
window.title("Notepad")

# Set the dimensions of the text box
text_width = 80
text_height = 40

# Create the text box
text_box = tk.Text(window, width=text_width, height=text_height)
text_box.pack()

# Define file operations
current_file = None


def new_file():
    global current_file
    current_file = None
    text_box.delete("1.0", tk.END)


def open_file():
    global current_file
    filename = filedialog.askopenfilename()
    if filename:
        current_file = filename
        with open(filename, "r") as f:
            text_box.delete("1.0", tk.END)
            text_box.insert("1.0", f.read())


def save_file():
    global current_file
    if not current_file:
        filename = filedialog.asksaveasfilename()
        if filename:
            current_file = filename
    if current_file:
        with open(current_file, "w") as f:
            f.write(text_box.get("1.0", tk.END))


# Create a menu bar
menu_bar = tk.Menu(window)

# Add a File menu
file_menu = tk.Menu(menu_bar, tearoff=0)
file_menu.add_command(label="New", command=new_file)
file_menu.add_command(label="Open", command=open_file)
file_menu.add_command(label="Save", command=save_file)
file_menu.add_separator()
file_menu.add_command(label="Exit", command=window.quit)
menu_bar.add_cascade(label="File", menu=file_menu)

# Add an Edit menu
edit_menu = tk.Menu(menu_bar, tearoff=0)
edit_menu.add_command(label="Cut", command=lambda: text_box.event_generate("<Control-x>"))
edit_menu.add_command(label="Copy", command=lambda: text_box.event_generate("<Control-c>"))
edit_menu.add_command(label="Paste", command=lambda: text_box.event_generate("<Control-v>"))
menu_bar.add_cascade(label="Edit", menu=edit_menu)

# Add the menu bar to the window
window.config(menu=menu_bar)

# Start the event loop
window.mainloop()
