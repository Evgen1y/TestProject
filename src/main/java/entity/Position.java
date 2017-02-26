package entity;

/**
 * Created by bulov on 22.02.2017.
 */
 public class Position {
    private String name = null;
    private double rate = 0;

    public Position(String name, double rate){
        this.name = name;
        this.rate = rate;
    }

    public void doCommand(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Position{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                '}';
    }
}


