package designpatterns.creational.factorymethod.ui;

/**
 * HTML button implementation.
 */
public class HTMLButton implements Button {

    @Override
    public void render() {
        System.out.println("<button>Test designpatterns.creationall.factorymethod.ui.Button</button>");
        onClick();
    }

    @Override
    public void onClick() {
        System.out.println("Click! designpatterns.creationall.factorymethod.ui.Button says - 'HelloRxJava World!'");
    }

}
