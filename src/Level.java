import java.util.ArrayList;

public class Level {
}

class Lawn{
    ArrayList<Character> activeChars;
    public Lawn(){
        activeChars=new ArrayList<>();
    }
    public void addCharacter(Character c){
        activeChars.add(c);
    }
    public void deleteCharacter(Character c){
        activeChars.remove(c);
    }
}