import java.util.List;

public class Deck {
    
    private String faceName;
    private String suitName;

    public Deck(String face, String suit) {
        setFaceName(face.toLowerCase());
        setSuitName(suit.toLowerCase());
    }

    public String getFaceName() { return this.faceName; }
    public String getSuitName() { return this.suitName; }

    public static List<String> getValidFaceNames() {
        return List.of("ace", "2", "3", "4", "5", "6", 
                        "7", "8", "9", "10", 
                        "jack", "queen",
                        "king");
    }

    public static List<String> getValidSuitNames() {
        return List.of("hearts", "diamonds", 
                        "clubs", "spades");
    }

    public void setFaceName(String faceName) {
        List<String> validFaceNames = getValidFaceNames();
        if (validFaceNames.contains(faceName))
            this.faceName = faceName;
        else
            throw new IllegalArgumentException("Valid face names are: "+
                                    validFaceNames);
    }

    public void setSuitName(String suitName) {
        List<String> validSuitNames = getValidSuitNames();
        if (validSuitNames.contains(suitName))
            this.suitName = suitName;
        else
            throw new IllegalArgumentException("Valid suit names are: "+
                                    validSuitNames);
    }

    @Override
    public String toString() {
        return getFaceName() +" of "+ getSuitName();
    }
}