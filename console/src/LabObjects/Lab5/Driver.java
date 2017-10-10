package LabObjects.Lab5;

public class Driver implements Commutes {
    @Override
    public String getCommuteMethod() {
        return "Car";
    }

    @Override
    public int getCommuteTime() {
        return 25;
    }
}
