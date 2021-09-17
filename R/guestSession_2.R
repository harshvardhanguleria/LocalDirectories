x <- c(10, 20, 30, 40)
pie(x)
labl <- c('A', 'B', 'C', 'D')
pie(x, labl, col=rainbow(length(x)))

install.packages('RColorBrewer')
library(RColorBrewer)
pal <- brewer.pal(4, 'set 2')#-------

mydat <- table(iris$Species)
mydat
lbl <- paste(names(mydat), "\n", sep="")
pie(mydat, lbl, main="Pie chart")

install.packages('plotrix')
library(plotrix)
pie3D(x)

#Barplot----
barplot(airquality$Ozone, main="Ozone",)
count <- table(mtcars$vs,mtcars$gear)
barplot(count, beside = TRUE)

#histograms---
hist(trees$Height)
trees

hist(trees$Height, col="orange", xlab="Height", prob=TRUE)

#box plot---
boxplot(trees, col="orange")

airquality

mean(airquality$Ozone, na.rm = TRUE)

table(airquality$Ozone)
describe(airquality)
library(psych)

median(airquality$Ozone, na.rm=TRUE)

Mode<-function(x){
    tbl<-table(x)
    sol<-tbl[which.max(tbl)]
    return(sol)
}

Mode(airquality$Ozone)
