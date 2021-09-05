myData <- read.csv("/mnt/d/College/heart.csv", header=TRUE)
print("Summary of data")
summary(myData) # basic description and frequencies of the data
print("Structure of data")
str(myData) # basic structure of data
print("first 6 rows of data")
head(myData) # first 6 rows
print("first 10 rows of data")
head(myData, n=10) # first 10 rows
print("last 6 rows of data")
tail(myData) # last 6 rows
print("last 10 rows of data")
tail(myData, n=10) # last 10 rows
print("First 10 rows of data")
myData[1:10, ] # first 10 rows
print("First 10 rows of first 3 variables of data")
myData[1:10, 1:3] # first 10 rows for first 3 variables