package ait.homework.numbers.model;

import ait.homework.numbers.task.OneGroupSum;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static ait.homework.numbers.model.ThreadGroupSum.NUM_TASKS;

public class ExecutorGroupSum extends GroupSum{
    public ExecutorGroupSum(int[][] numberGroups) {
        super(numberGroups);
    }

    @Override
    public int computeSum() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_TASKS);
        OneGroupSum[] tasks = new OneGroupSum[NUM_TASKS];
        for (int i = 0; i < tasks.length; i++)
        {
            executorService.execute(tasks[i]);
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        for (int j = 0; j < tasks.length; j++) {
            executorService.execute(tasks[j]);
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        int sum = 0;
        for (int i = 0; i < tasks.length; i++) {
            sum += numberGroups;
        }
        return sum;
    }
}
