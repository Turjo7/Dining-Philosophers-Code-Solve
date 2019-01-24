/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dining_philosopher;
import java.util.concurrent.Semaphore;

import static dining_philosopher.DiningPhilosophers.philosophersNumber;

/**
 *
 * @author turjoasusr505c
 */


public class Fork {
    public Semaphore mutex = new Semaphore(1);
    public Semaphore s[] = new Semaphore[philosophersNumber];
    public static int state[] = new int[philosophersNumber];
    public static int THINKING = 0;
    public static int HUNGRY = 1;
    public static int EATING = 2;

    {

        for (int j = 0; j < philosophersNumber; j++)

        {
            s[j] = new Semaphore(1);
        }
    }
    void take_fork(int i) {
        try {
            mutex.acquire();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        state[i] = HUNGRY;
        System.out.println("Philosopher Number ->>>>> "+i+"is hungry");
        test(i);


        mutex.release();
        try {
            s[i].acquire();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }

    void put_fork(int i) {
        try {
            mutex.acquire();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        try {
            s[i].acquire();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        state[i] = THINKING;
        System.out.println("Philosopher Number --->>>" + i + " is thinking");
        int LEFT = (i + philosophersNumber - 1) % philosophersNumber;
        int RIGHT = (i + 1) % philosophersNumber;
        test(LEFT);
        test(RIGHT);
        mutex.release();
    }

    
     
     
     
    void test(int i) {
        int LEFT = (i + philosophersNumber - 1) % philosophersNumber;
        int RIGHT = (i + 1) % philosophersNumber;
        if (state[i] == HUNGRY && state[LEFT] != EATING && state[RIGHT] != EATING) {

            state[i] = EATING;
            System.out.println("Philosopher Number ----->>>" + i + " is eating");
            s[i].release();


        }


    }
}
