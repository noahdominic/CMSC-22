import java.util.Scanner;

/**
 * Created by Noah Dominic on 08/12/2016.
 */

public class Rule30 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int inputInt = in.nextInt();

        int charPerThread = inputInt/10;
        int start, end;

        R30Thread.current = new boolean[inputInt];
        R30Thread.next = new boolean[inputInt];

        for(int i = 0; i < inputInt; i++){
            R30Thread.current[i] = false;
            if(i == inputInt/2) {
                //System.out.println(i);
                R30Thread.current[i] = true;
            }
        }

        R30Thread s[] = new R30Thread[10];

        //Concurrency
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < inputInt; i++){
            start = 0;
            end = start + charPerThread - 1;
            for(int j = 0; j < 10; j++) {
                s[j] = new R30Thread(start, end, j);
                start = end + 1;
                end = start + charPerThread - 1;
            }


            //start
            for(int j = 0; j < 10; j++){
                s[j].start();
            }

            //join
            for(int j = 0; j < 10; j++){
                while(s[j].isAlive()) {
                    try {
                        s[j].join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            /*for(int j = 0; j < inputInt; j++){
                if(R30Thread.current[j] == true)
                    System.out.print('X');
                else
                    System.out.print('_');
            }
            System.out.println();*/

            R30Thread.current = R30Thread.next.clone();
        }
        long endTime = System.currentTimeMillis();

        //single-thread
        boolean[] current = new boolean[inputInt];
        boolean[] next = new boolean[inputInt];
        long startTime2 = System.currentTimeMillis();
        for(int i = 0; i < inputInt; i++){
            for(int j = 0; j < inputInt; j++){
                boolean x, y, z;

                if (i - 1 < 0) {
                    x = false;
                } else {
                    x = current[i - 1];
                }

                y = current[i];

                if (i == current.length -1) {
                    z = false;
                } else {
                    z = current[i + 1];
                }

                if(x && y && z || x && !y && z || x && y && !z || !x && !y && !z){
                    next[i] = false;
                } else {
                    next[i] = true;
                }
            }
        }
        long endTime2 = System.currentTimeMillis();

        System.out.println("Concurrency took   "+(endTime - startTime) + " ms");
        System.out.println("Single-thread took "+(endTime2 - startTime2) + " ms");
    }
}

class R30Thread extends Thread {
    int threadNo;//for debugging purposes only
    public static boolean[] current, next;
    private int start, end;

    public R30Thread(int start, int end, int threadNo){
        this.start = start;
        this.end = end;
        this.threadNo = threadNo;
    }

    public void run(){
        for (int i = start; i <= end; i++) {
            boolean x, y, z;

            if (i - 1 < 0) {
                x = false;
            } else {
                x = current[i - 1];
            }

            y = current[i];

            if (i == current.length -1) {
                z = false;
            } else {
                z = current[i + 1];
            }

            if(x && y && z || x && !y && z || x && y && !z || !x && !y && !z){
                next[i] = false;
            } else {
                next[i] = true;
            }
        }
    }
}
