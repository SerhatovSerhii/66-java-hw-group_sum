package ait.homework.numbers.model;

public abstract class GroupSum{
    protected int[][] numberGroups;

    public GroupSum(int[][] numberGroups) {
        this.numberGroups = numberGroups;
    }
    public abstract int computeSum() throws InterruptedException;
}
