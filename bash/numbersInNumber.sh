echo "Enter a number: "
read number

len=`expr length "$number"`

case $len in
    3) echo "It is a three digit number"
    ;;
    2) echo "It is a two digit number"
    ;;
    1) echo "It is a single digit number"
    ;;
    *) echo "The number contains more than 3 digits"
esac