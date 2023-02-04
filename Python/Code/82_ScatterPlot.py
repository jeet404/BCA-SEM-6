import numpy as np
import pylab as pl
# Make an array of x values
x = np.array([1, 2, 3, 4, 5])
# Make an array of y values for each x value
y = np.array([1, 4, 9, 16, 25])
# use pylab to plot x and y as red circles
pl.plot(x, y, 'ro')
# show the plot on the screen
pl.show()
