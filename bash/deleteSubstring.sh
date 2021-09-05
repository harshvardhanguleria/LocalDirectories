echo "Enter the string: "
read string
echo "Enter the shortest substring: "
read shortest
echo "Enter the longest substring: "
read longest

string1=$string
string2=$string
string3=$string
cutShortest=${string//$shortest/}
cutLongest=${string1//$longest/}
cutFront=${string2#"$shortest"}
cutLongest=${string3%"$longest"}

echo "After deleting $shortest from $string we get $cutShortest"
echo "After deleting $longest from $string we get $cutLongest"
echo "After deleting $shortest from $string we get $cutFront"
echo "After deleting $longest from $string we get $cutLongest"