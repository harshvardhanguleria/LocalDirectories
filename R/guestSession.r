x <- c(1, 2, 3, 4)

y <- c(5, 6, 7, 8)

plot(x, y)

plot(x, y, xlab = "x-axis", ylab = "y-axis", 
     pch = 15, type = "o", main = "Sample graph",
     col = "red")

x <- seq(-pi, pi, 0.1)

plot(x, sin(x), type = "l", col = "red")
lines(x, cos(x), type = "l", col = "blue")

legend("topright", c("sin(x)", "cos(x)"), fill = c("red", "blue"))

datasets::airquality
plot(airquality)

plot(airquality$Ozone, airquality$Solar.R)

describe(airquality) # function of psych library
install.packages("psych")
library(psych) # importing the library to use the psych function
describe(airquality)

head(airquality)
tail(airquality)

maximum <- max(airquality)
print(maximum)

airquality # displays the data

data <- airquality
data[is.na(data)] <- 0 # replacing all the NA values with 0
data

maximum <- max(airquality$Ozone)
maximum

