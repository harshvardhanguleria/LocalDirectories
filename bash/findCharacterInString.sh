echo "Enter string: "
read string
echo "Enter the character to be searched: "
read character

rest=${string#*$character}

if [[ $string == *$character* ]]; then 
    echo "$character is present in $string"
else
    echo "$character is absent from $string"
fi