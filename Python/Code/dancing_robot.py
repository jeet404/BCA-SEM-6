import pygame

# Initialize Pygame
pygame.init()

# Set up the screen
screen = pygame.display.set_mode((400, 400))

# Set the title of the window
pygame.display.set_caption("Dancing Robot")

# Load the images
robot_images = [
    pygame.image.load('images/s1.gif'),
    pygame.image.load('images/s2.gif'),
    pygame.image.load('images/s3.gif'),
    pygame.image.load('images/s4.gif'),
    pygame.image.load('images/s5.gif'),
]

# Set the initial position and image
robot_rect = robot_images[0].get_rect()
robot_rect.center = (200, 200)
current_image = 0

# Set the animation speed
animation_speed = 10

# Set the game loop
clock = pygame.time.Clock()
running = True

# Game loop
while running:

    # Handle events
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

    # Update the animation
    current_image += 1
    if current_image >= len(robot_images):
        current_image = 0
    robot_rect = robot_images[current_image].get_rect()
    robot_rect.center = (200, 200)

    # Draw the screen
    screen.fill((255, 255, 255))
    screen.blit(robot_images[current_image], robot_rect)

    # Update the screen
    pygame.display.update()

    # Set the clock speed
    clock.tick(animation_speed)

# Quit Pygame
pygame.quit()
