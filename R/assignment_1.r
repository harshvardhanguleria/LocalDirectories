insuranceData <- read.csv("D:\\Codes\\insurance.csv", header=TRUE)
summary(insuranceData)

head(insuranceData)

x<-insuranceData[1:10, 1:1]
y<-insuranceData[1:10, 3:3]

plot(x, y)

plot(x, y, xlab="age", ylab="bmi", col="red", main="BMI vs Age",
     type='o', pch=15)

pie(x)
labl <- c(insuranceData[1:10, 2:2])
pie(x, labl, main="Age Pie Chart")

barplot(x, main="Age Bar Plot")

hist(y, main="BMI Histogram")

boxplot(y, col="red", main="BMI Box Plot")

print(max(x))
print(min(x))
print(mean(y))
print(median(y))
head(insuranceData)
