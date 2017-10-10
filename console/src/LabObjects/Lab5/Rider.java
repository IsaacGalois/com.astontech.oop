package LabObjects.Lab5;

public class Rider implements Commutes {
    @Override
    public String getCommuteMethod() {
        return "Bus";
    }

    @Override
    public int getCommuteTime() {
        return 45;
    }
}
