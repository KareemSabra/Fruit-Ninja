package LogicPackage.Mementos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Memento")
@XmlAccessorType(XmlAccessType.FIELD)
public class Memento {

    @XmlElement (name = "currentScore")
    private int currentScore;

    private int bestScore;

    private int lives;

    public Memento(int currentScore, int bestScore, int lives){
        this.currentScore = currentScore;
        this.bestScore = bestScore;
        this.lives = lives;

    }

    public int getCurrentScore(){
        return currentScore;
    }
    public int getBestScore(){return bestScore;}
    public int getLives(){return lives;}

}
