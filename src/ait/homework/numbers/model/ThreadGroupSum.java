package ait.homework.numbers.model;

import ait.homework.numbers.task.OneGroupSum;

public class ThreadGroupSum extends GroupSum{
    static final int NUM_TASKS = 10_000;

    public ThreadGroupSum(int[][] numberGroups) {
        super(numberGroups);
    }

    @Override
    public int computeSum() throws InterruptedException {
        OneGroupSum[] tasks = new OneGroupSum[NUM_TASKS];
        for (int i = 0; i < tasks.length; i++)
            tasks[i] = new OneGroupSum(numberGroups[i]);
            for (int j = 0; j < tasks.length; j++)
                tasks[j] = new OneGroupSum(numberGroups[j]);
            Thread[] threads = new Thread[NUM_TASKS];
            for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
            int sum = 0;
        for (int i = 0; i < threads.length; i++) {
            sum += numberGroups;
        }
        return sum;
    }
}
