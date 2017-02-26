package entity.implementation;

import entity.Position;

/**
 * Created by bulov on 22.02.2017.
 */
public class Designer extends Position {

    public Designer() {
        super("Designer", 25);
    }

    boolean drawLayout(){
        return true;
    }
}
