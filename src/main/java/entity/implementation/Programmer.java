package entity.implementation;

import entity.Position;

/**
 * Created by bulov on 22.02.2017.
 */
public class Programmer extends Position {

    public Programmer() {
        super("Programmer", 40);
    }

    boolean writeCode(){
        return true;
    }
}
