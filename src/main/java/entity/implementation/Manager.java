package entity.implementation;

import entity.Position;

/**
 * Created by bulov on 22.02.2017.
 */
public class Manager extends Position {

    public Manager() {
        super("Manager", 3000);
    }

    boolean sellService(){
        return true;
    }
}
