echo "Enter string 1: "
read string1
echo "Enter string 2: "
read string2

if [ $string1 == $string2 ]
then 
    echo "Both are equal"
else
    echo "$string1 is not equal to $string2"
fi