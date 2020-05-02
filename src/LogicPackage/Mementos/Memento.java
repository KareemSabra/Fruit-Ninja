package LogicPackage.Mementos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name= "Mementos")
@XmlAccessorType(XmlAccessType.FIELD)
public class Memento {
    @XmlElement(name = "currentScore")
    private int currentScore;

    @XmlElement(name = "lives")
    private int lives;

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getCurrentScore(){
        return currentScore;
    }
    public int getLives(){return lives;}

}
