import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Testss{

    int xLocation, yLocation;
    static Testss handler = new Testss();

    public static Testss getInstance() {
        return handler;
    }

    public void mouseInitiallizer() {
        EventHandler mouseEvent = new EventHandler() {
            @Override
            public void handle(Event event) {

            }
        };
       // mouseMoved(new MouseEvent(MouseEvent.MOUSE_CLICKED, mouseEvent ) = MouseEvent.MOUSE_CLICKED);

    }

    public void mouseMoved(MouseEvent e) {
        xLocation = (int) e.getX();
        setX(xLocation);
        yLocation = (int) e.getY();
        setY(yLocation);

    }

    public int getX() {
        return xLocation;
    }

    public void setX(int x) {
        this.xLocation = x;
    }

    public int getY() {
        return yLocation;
    }

    public void setY(int y) {
        this.yLocation = yLocation;
    }

}