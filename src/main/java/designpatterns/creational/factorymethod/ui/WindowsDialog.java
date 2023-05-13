package designpatterns.creational.factorymethod.ui;

/**
 * Windows Dialog will produce Windows buttons.
 */
public class WindowsDialog extends Dioalog {

    @Override
    protected Button createButton() {
        return new WindowsButton();
    }

}
