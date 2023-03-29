package designpatterns.creational.abstractfactory.furniture;
public class VictorianChair implements Chair {

    @Override
    public void sitOn() {
       System.out.println("Sit! Victorian");
    }

}
