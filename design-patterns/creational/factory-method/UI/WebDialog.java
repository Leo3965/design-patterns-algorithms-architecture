/**
 * HTML Dialog will produce HTML buttons.
 */
public class WebDialog extends Dioalog {

    @Override
    protected Button createButton() {
        return new HTMLButton();
    }

}
