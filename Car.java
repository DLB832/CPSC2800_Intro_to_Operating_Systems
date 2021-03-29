/**
 * @author Derek Campbell (DLB832)
 * @version 3/27/2021
 * NOTE: CPSC.2800.20473
 * 
 */

/**
 * @Class Car: By implementing the Runnable interface, Threads can be created and be passed the instance of the Car class.
 * @Method run(): overrides the Thread class' run() making it unique to threads that are Car objects.
 */
public class Car implements Runnable {
    
    public void run() {
            
        try {
            //System.out.println("I am a thread."); //verifies creation of the thread.
            Thread.sleep(1499);
            BridgeExclusion.bridge.acquire(); //acquires the semaphore, providing mutual exclusion. Should wait until a permit is released if unsuccessful.
            System.out.println(Thread.currentThread().getName() + " has enterred the bridge.");
            Thread.sleep(3000); //sleep to simulate crossing the bridge. Or for regular threads, performing some task.
            System.out.println(Thread.currentThread().getName() + " has successfully crossed the bridge and exited.");
        } catch (Exception e) {
  
        } finally {
            BridgeExclusion.bridge.release();   //releases the semaphore, allowing a new thread to acquire it.
        }    
        
    }

}
