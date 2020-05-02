package LogicPackage.Mementos;

import LogicPackage.Misc.ClassicTimer;
import LogicPackage.Misc.SaveTimer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
@XmlRootElement (name = "CareTaker")
@XmlAccessorType (XmlAccessType.FIELD)
public class CareTaker {

    @XmlElement(name = "Mementos")
    private List<Memento> mementoList = new ArrayList<>();


    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento get(int index){
        System.out.println(mementoList.get(0).getCurrentScore()+mementoList.get(0).getLives());
        return mementoList.get(index);
    }

}
