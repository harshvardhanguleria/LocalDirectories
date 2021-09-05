echo "Enter a number: "
read number
echo "Enter the power: "
read power

i=0
ans=1

while [ $i -ne $power ]
do 
    ans=`expr $ans \* $number`
    i=`expr $i + 1`
done

echo "$number raised to $power =  $ans"