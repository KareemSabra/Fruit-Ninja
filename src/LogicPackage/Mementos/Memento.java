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

    public Memento(int currentScore){
        this.currentScore = currentScore;

    }

    public int getCurrentScore(){
        return currentScore;
    }

}
