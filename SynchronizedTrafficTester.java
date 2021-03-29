/**
 * @author Derek Campbell (DLB832)
 * @version 3/27/2021
 * NOTE: CPSC.2800.20473
 */

/**
 * @Class SynchronizedTrafficTester: A tester class used to simulate mutual exclussion and concurrency in a multithreaded system.
 * @Method main(): The runnable main method. Creates 10 cars which approach a single lane bridge from opposite directions and allows only 1 car to cross at a time.
 */
public class SynchronizedTrafficTester {
    
    
    public static void main(String[] args) {
    
        final int NUM_CARS = 10;    //5 on each side of the bridge.
        
       Thread[] carsAtBridge = new Thread[NUM_CARS];  //creates an array of threads to hold the cars

       for (int i = 0; i < carsAtBridge.length; i++) { 
           carsAtBridge[i] = new Thread(new Car());     //creates the Thread object by passing a class that implements runnable.
           if( i % 2 == 0){ //if the thread's position in the array is an even integer, it's approaching from the East.
                carsAtBridge[i].setName("East Bound Car #" + i);
                carsAtBridge[i].start();
           } else { //if the thread's position in the array is an odd integer, it's approaching from the West.
                carsAtBridge[i].setName("West Bound Car #" + i);
                carsAtBridge[i].start();
           }
           
           /**
            * carsAtBridge[i].start(); //invoking the start() method does two things:
            * 1: allocates memory and initializes the new thread in the JVM.
            * 2: it calls the run() method, making the thread elligible to run by the JVM.
            */
           
       }

    }
    
}
