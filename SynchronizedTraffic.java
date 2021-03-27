import java.util.concurrent.Semaphore;

/**
 * @author Derek Campbell (DLB832)
 * @version 3/27/2021
 * NOTE: CPSC.2800.20473
 * 
 */

public class SynchronizedTraffic {
 
    Semaphore bridge = new Semaphore(1);    //only 1 resource available at time.
    //final int NUM_CARS = 5; //the number of cars in each thread (or each side of the bridge).


    public void crossBridge() {


        try {
            bridge.acquire(); //acquires semaphore, providing mutual exclusion
            System.out.println("Car: " + Thread.currentThread().getName() + " has enterred the bridge.");    //TODO: determine which car it is.
            Thread.sleep(3000); //sleep to simulate crossing the bridge
            System.out.println("Car: " + Thread.currentThread().getName() + " has successfully crossed the bridge and exited.");
        } catch (Exception e) {
            //TODO: handle exception
            //if busy, blocked
        } finally {
            bridge.release();   //placed in finally to ensure that semaphore is released
        }
    }
    
    //TODO: create threads. 1 thread should simulate east bound vehicles and 1 simulate west bound vehicles.
    /*Vehicles should wait(sleep) for some time, then attempt to cross.
     * once on the bridge it should sleep for some time to simulate traveling over the bridge.
     * output a message when a vehicle drives onto the bridge and another when it has completed crossing. 
     */

    

    //creating java threads: define a class that implements the runnable interface.
    public class Car implements Runnable { //each car is a thread which overrides the default run().
        
        public void run() {
            crossBridge();  //tries to cross the bridge
        }
    }

    /* thread creation in java involves creating a Thread object and passing it an instance of a class that implements
     * Runnable, followed by invoking the start() method on the Thread object.
     * TODO: create eastBound and westBound cars.
     */

     public static void main(String[] args) {
         final int NUM_CARS = 5;
         SynchronizedTraffic syncTraf = new SynchronizedTraffic();

        Thread[] eastBoundCars = new Thread[NUM_CARS];  //creates an array of threads for east bound cars
		for (int i = 0; i < eastBoundCars.length; i++) { 
			eastBoundCars[i] = new Thread(new syncTraf.Car());
			eastBoundCars[i].start();
		}

        Thread[] westBoundCars = new Thread[NUM_CARS];  //creates an array of threads for west bound cars
		for (int i = 0; i < westBoundCars.length; i++) { 
			eastBoundCars[i] = new Thread(new syncTraf.Car());
			westBoundCars[i].start();
		}


     }


}
