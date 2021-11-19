install.packages('ubiquity')
library(ubiquity)
getwd();
setwd("D:/Codes/local_directories/R")
fr = workshop_fetch(section="Reporting", overwrite = TRUE)
install.packages('readxl')
library(readxl)
install.packages('readr')
insatll.packages('tidyverse')

insuranceData <- read.csv("D:\\Codes\\insurance.csv", header=TRUE)
head(insuranceData)
age <- insuranceData[1:10, 1:1]
bmi <- insuranceData[1:10, 4:4]
print(age)
print(bmi)
print(mean(age))
print(mean(bmi))

install.packages('ggpubr')

library(ggpubr)
ggboxplot(insuranceData$age, 
          ylab = "Age",
          xlab = FALSE, 
          ggtheme = theme_minimal())
shapiro.test(insuranceData$age)
ggqqplot(insuranceData$age,
         ylab = "Age",
         ggtheme = theme_minimal())
result <-t.test(insuranceData$age, mu = 25)
result

women_weight <- c(38.9, 61.2, 73.3, 21.8, 63.4, 64.6, 48.4, 48.8, 48.5)
men_weight <- c(67.8, 60, 63.4, 76, 89.4, 73.3, 67.3, 61.3, 62.4) 
my_data <- data.frame( 
  group = rep(c("Woman", "Man"), each = 9),
  weight = c(women_weight,  men_weight)
)
print(my_data)
install.packages("dplyr")
library(dplyr)
group_by(my_data, group) %>%
  summarise(
    count = n(),
    mean = mean(weight, na.rm = TRUE),
    sd = sd(weight, na.rm = TRUE)
  )
ggboxplot(my_data, x = "group", y = "weight", 
          color = "group", palette = c("#00AFBB", "#E7B800"),
          ylab = "Weight", xlab = "Groups")
# Shapiro-Wilk normality test for Men's weights
with(my_data, shapiro.test(weight[group == "Man"]))# p = 0.1
# Shapiro-Wilk normality test for Women's weights
with(my_data, shapiro.test(weight[group == "Woman"])) # p = 0.6
res.ftest <- var.test(weight ~ group, data = my_data)
res.ftest
# Compute t-test
res <- t.test(women_weight, men_weight, var.equal = TRUE)
res
# printing the p-value
res$p.value
# printing the mean
res$estimate
# Data in two numeric vectors
# ++++++++++++++++++++++++++
# Weight of the mice before treatment
before <-c(200.1, 190.9, 192.7, 213, 241.4, 196.9, 172.2, 185.5, 205.2, 193.7)
# Weight of the mice after treatment
after <-c(392.9, 393.2, 345.1, 393, 434, 427.9, 422, 383.9, 392.3, 352.2)
# Create a data frame
my_data <- data.frame( 
  group = rep(c("before", "after"), each = 10),
  weight = c(before,  after)
)
# Print all data
print(my_data)
group_by(my_data, group) %>%
  summarise(
    count = n(),
    mean = mean(weight, na.rm = TRUE),
    sd = sd(weight, na.rm = TRUE)
  )
ggboxplot(my_data, x = "group", y = "weight", 
          color = "group", palette = c("#00AFBB", "#E7B800"),
          order = c("before", "after"),
          ylab = "Weight", xlab = "Groups")
install.packages("PairedData")
# Subset weight data before treatment
before <- subset(my_data,  group == "before", weight,
                 drop = TRUE)
# subset weight data after treatment
after <- subset(my_data,  group == "after", weight,
                drop = TRUE)
# Plot paired data
library(PairedData)
pd <- paired(before, after)
plot(pd, type = "profile") + theme_bw()
# compute the difference
d <- with(my_data, 
          weight[group == "before"] - weight[group == "after"])
# Shapiro-Wilk normality test for the differences
shapiro.test(d) # => p-value = 0.6141
# Compute t-test
res <- t.test(before, after, paired = TRUE)
res
# printing the p-value
res$p.value
# printing the mean
res$estimate

my_data <- PlantGrowth
# Show a random sample
set.seed(1234)
dplyr::sample_n(my_data, 10)
# Show the levels
levels(my_data$group)
my_data$group <- ordered(my_data$group,
                         levels = c("ctrl", "trt1", "trt2"))
group_by(my_data, group) %>%
  summarise(
    count = n(),
    mean = mean(weight, na.rm = TRUE),
    sd = sd(weight, na.rm = TRUE)
  )
ggboxplot(my_data, x = "group", y = "weight", 
          color = "group", palette = c("#00AFBB", "#E7B800", "#FC4E07"),
          order = c("ctrl", "trt1", "trt2"),
          ylab = "Weight", xlab = "Treatment")
ggline(my_data, x = "group", y = "weight", 
       add = c("mean_se", "jitter"), 
       order = c("ctrl", "trt1", "trt2"),
       ylab = "Weight", xlab = "Treatment")
# Compute the analysis of variance
res.aov <- aov(weight ~ group, data = my_data)
# Summary of the analysis
summary(res.aov)
TukeyHSD(res.aov)
install.packages("multcomp")
library(multcomp)
summary(glht(res.aov, linfct = mcp(group = "Tukey")))
pairwise.t.test(my_data$weight, my_data$group,
                p.adjust.method = "BH")
# 1. Homogeneity of variances
plot(res.aov, 1)
oneway.test(weight ~ group, data = my_data)
data1<-swiss
head(data1, 4)
install.packages("ggplot2")
library("ggplot2")
ggplot(data1, aes(x = Fertility, y = Infant.Mortality)) + geom_point() +  geom_smooth(method = "lm", se = TRUE, color = 'black')
shapiro.test(data1$Fertility)
shapiro.test(data1$Infant.Mortality)
cor(data1$Fertility,data1$Infant.Mortality)
Tes<- cor.test(swiss$Fertility,swiss$Infant.Mortality,method = "pearson")
Tes
