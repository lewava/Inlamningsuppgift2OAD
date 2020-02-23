package Uppgift_2;

import java.util.Observer;

public class Observable implements Observer {
    @Override
    public void update(java.util.Observable o, Object arg) {
        System.out.println("Uträkning gjord.");
    }
}
