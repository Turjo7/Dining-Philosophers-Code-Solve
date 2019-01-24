/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dining_philosopher;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author turjoasusr505c
 */


public class Philosophers extends Thread {
    public int number;


    Philosophers(int num) {
       this.number = num;

    }
    Fork fork = new Fork();

    public void run() {
        System.out.println("Philosopher Number -->" + number);

        while (true) {
            think();
            fork.take_fork(number);
            eat();
            fork.put_fork(number);
        }

    }

    void eat() {
        try {
            int sleepTime = ThreadLocalRandom.current().nextInt(0, 1000);
            Thread.sleep(sleepTime);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    void think() {
        try {
            int sleepTime = ThreadLocalRandom.current().nextInt(0, 1000);
              System.out.println("Philosopher Number ------>" + " eats  " + sleepTime);
            Thread.sleep(sleepTime);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

}