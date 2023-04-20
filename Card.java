public class Card {
    private String name;
    private int number;
    private char suit;
    private String FilePath;

    public Card(String name, int number, char suit, String FilePath){
        this.name = name;
        this.number = number;
        this.suit = suit;
        this.FilePath = FilePath;
    }

    public String getName(){
        return this.name;
    }

    public int getNumber(){
        return this.number;
    }

    public char getSuit(){
        return this.suit;
    }

    public String getFilePath(){
        return this.FilePath;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public void setSuit(char suit){
        this.suit = suit;
    }

    public void setFilePath(String FilePath){
        this.FilePath = FilePath;
    }

}
