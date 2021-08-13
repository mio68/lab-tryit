package mio68.lab.tryit.codewars;

public class Max {
    public static int sequence(int[] arr) {
        int maxSum = 0, sum = 0;
        boolean accumulationStarted = false;

        for (int num: arr) {
            //skip non positive numbers if accumulation phase not started
            if(num <= 0 && !accumulationStarted)
                continue;

            //detect first positive number to start accumulation phase
            if(num > 0 && !accumulationStarted) {
                //init new accumulation phase
                accumulationStarted = true;
                sum = num;
            }
            else
                //continue current accumulation
                sum += num;

            //update maxSum with current accumulation result
            if(sum > maxSum)
               maxSum = sum;

            //check accumulation result to stop current accumulation phase
            if(sum <= 0 )
                accumulationStarted = false;
        }
        return maxSum;
    }
}
