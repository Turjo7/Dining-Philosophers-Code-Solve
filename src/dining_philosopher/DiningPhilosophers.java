/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dining_philosopher;

/**
 *
 * @author turjoasusr505c
 */
public class DiningPhilosophers {
   public   static int philosophersNumber = 5;
    static Philosophers philosophers[] = new Philosophers[philosophersNumber];




    public static void main(String argv[]) {
       



        for (int i = 0; i < philosophersNumber; i++) {
            philosophers[i] = new Philosophers(i);
            philosophers[i].start();
        }

    }
}
