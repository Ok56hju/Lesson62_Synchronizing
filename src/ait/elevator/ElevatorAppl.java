package ait.elevator;

import ait.elevator.model.Elevator;
import ait.elevator.task.Truck;

public class ElevatorAppl {
    private static final int N_TRUCK = 1000;
    private static final int N_RACES = 10;
//    private static final int N_RACES2 = 5;
    private static final int CAPACITY = 20;

    public static void main(String[] args) throws InterruptedException {
        Elevator lenin= new Elevator("V. I. Lenit");
        Elevator stalin = new Elevator("Stalin");
        Truck[] trucks = new Truck[N_TRUCK];
        for (int i = 0; i < trucks.length; i++) {
            trucks[i%1] = new Truck(N_RACES/2, CAPACITY,lenin);
            trucks[i%2] = new Truck(N_RACES,CAPACITY/2,stalin);
        }
        Thread[] threads = new Thread[N_TRUCK];
        for (int i = 0; i < threads.length; i++) {

            threads[i] = new Thread(trucks[i]);
            threads[i].start();
        }
//        for (Thread thread: threads) {
//            thread.join();
//        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println("Elevator  " + lenin.getCurrentVolume() );
        System.out.println("Elevator  " + stalin.getCurrentVolume());
    }
}
