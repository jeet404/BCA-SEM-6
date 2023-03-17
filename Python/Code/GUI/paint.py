import tkinter as tk

# Create the window
window = tk.Tk()
window.title("Cartoon Drawing")

# Set the dimensions of the canvas
canvas_width = 500
canvas_height = 400

# Create the canvas
canvas = tk.Canvas(window, width=canvas_width, height=canvas_height, bg="white")
canvas.pack()

# Set the initial position of the pen
x = canvas_width // 2
y = canvas_height // 2

# Set the size of the pen
pen_size = 10

# Set the color of the pen
pen_color = "black"


# Draw with the pen
def draw(event):
    global x, y
    canvas.create_line(x, y, event.x, event.y, width=pen_size, fill=pen_color)
    x = event.x
    y = event.y


# Reset the pen position
def reset_position(event):
    global x, y
    x = event.x
    y = event.y


# Change the pen size
def change_pen_size(size):
    global pen_size
    pen_size = size


# Change the pen color
def change_pen_color(color):
    global pen_color
    pen_color = color


# Bind mouse events to the canvas
canvas.bind("<B1-Motion>", draw)
canvas.bind("<Button-1>", reset_position)

# Create a toolbar for changing the pen size and color
toolbar = tk.Frame(window, bg="white")
toolbar.pack(fill=tk.X)

size_label = tk.Label(toolbar, text="Pen Size: ")
size_label.pack(side=tk.LEFT)

small_button = tk.Button(toolbar, text="Small", command=lambda: change_pen_size(5))
small_button.pack(side=tk.LEFT)

medium_button = tk.Button(toolbar, text="Medium", command=lambda: change_pen_size(10))
medium_button.pack(side=tk.LEFT)

large_button = tk.Button(toolbar, text="Large", command=lambda: change_pen_size(15))
large_button.pack(side=tk.LEFT)

color_label = tk.Label(toolbar, text="Pen Color: ")
color_label.pack(side=tk.LEFT)

red_button = tk.Button(toolbar, text="Red", command=lambda: change_pen_color("red"))
red_button.pack(side=tk.LEFT)

green_button = tk.Button(toolbar, text="Green", command=lambda: change_pen_color("green"))
green_button.pack(side=tk.LEFT)

blue_button = tk.Button(toolbar, text="Blue", command=lambda: change_pen_color("blue"))
blue_button.pack(side=tk.LEFT)

# Start the event loop
window.mainloop()
