package ait.homework.numbers;

import ait.homework.numbers.model.ExecutorGroupSum;
import ait.homework.numbers.model.GroupSum;
import ait.homework.numbers.model.ParalelStreamGroupSum;
import ait.homework.numbers.model.ThreadGroupSum;
import ait.homework.numbers.test.GroupSumPerfomanceTest;

import java.util.Random;

public class GroupSumAppl {
    private static final int N_GROUPS = 10_000;
    private static final int NUMBER_PER_GROUP = 10_000;
    private static final int[][] arr = new int[N_GROUPS][NUMBER_PER_GROUP];
    public static Random random = new Random();
    public static void main(String[] args) {
        fillArray();
        GroupSum threadGroupSum = new ThreadGroupSum(arr);
        GroupSum executorGroupSum = new ExecutorGroupSum(arr);
        GroupSum streamGroupSum = new ParalelStreamGroupSum(arr);
        new GroupSumPerfomanceTest("ThreadGroupSum", threadGroupSum).runTest();
        new GroupSumPerfomanceTest("ExecutorGroupSum", executorGroupSum).runTest();
        new GroupSumPerfomanceTest("ParalelStreamGroupSum", streamGroupSum).runTest();


    }

    private static void fillArray() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = random.nextInt();
            }
        }
    }
}
