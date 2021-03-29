/**
 * @author Derek Campbell (DLB832)
 * @version 3/27/2021
 * NOTE: CPSC.2800.20473
 */

import java.util.concurrent.Semaphore;

/**
 * Creates a binary Semaphore to allow for mutual exclusion in accessing a Thread's critical section
 */
public class BridgeExclusion {

    static Semaphore bridge = new Semaphore(1); //creates a semaphore with only 1 permit available. A binary semaphore allowing for 1 instance of a resource.
    
    /** was used for testing critical section and to ensure that the number of permits were appropriate. No longer needed.
    public static void crossBridge() {
        
        try {
            //bridge.acquire(); // decrements the semaphore's count.
            //System.out.print(bridge.availablePermits());  //prints the # of available permits. Should be 0.
            //System.out.print(bridge.availablePermits() + "Car: " + Thread.currentThread().getName() + " has enterred the bridge.");
            //Thread.sleep(4000); //sleep to simulate crossing the bridge
        } catch (Exception e) {
            
        } finally {
            //bridge.release(); //increments the semaphore's count.
            //System.out.println("Car: " + Thread.currentThread().getName() + " has successfully crossed the bridge and exited." + bridge.availablePermits());
            //System.out.println(bridge.availablePermits());    //prints the # of available permits. Should be 1.
        }
    }
    */
}
