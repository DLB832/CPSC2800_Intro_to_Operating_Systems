/**
 * @author Derek Campbell (DLB832)
 * @version 3/27/2021
 * NOTE: CPSC.2800.20473
 */

import java.util.Scanner;   //imports the Scanner class to determine user input.

/**
 * The VirtualAddress decomposes a virtual address into a page number and offset within the page.
 * @method userPageSize() checks to make sure the user inputs an appropriate page size.
 * @method userVirtualAddress() checks to make sure the user inputs an appropriate virtual address.
 * @method calculatePageNumberAndOffset() divides the virtual address by the page size to determine page number and offset.
 */
public class VirtualAddress {

    int pageSize; //inclusive power of 2 between 2^9 (512) and 2^14 (16384)
    long virtualAddress; //assume 32-bit virtual addressing (0-4294967295)
    Scanner sc = new Scanner(System.in);    //generates a new scanner object

    /**
     * Requests user input to determine the size of each page in memory.
     * must be of a power of 2 between 2^9 and 2^14
     */
    public void userPageSize() {

        System.out.println("Please input an appropriate page size:");   //prompts the user to input the page size
        pageSize = sc.nextInt();    //user input
        //needs to be:
        //2^9 = 512
        //2^10 = 1024
        //2^11 = 2048
        //2^12 = 4096
        //2^13 = 8192
        //or 2^14 = 16384
        if (pageSize == 512 || pageSize == 1024 || pageSize == 2048 || pageSize == 4096 || pageSize == 8192 || pageSize == 16384) {
            //TODO: could I store the appropriate values somewhere and check user input against that?
            //do nothing
        }else{
            userPageSize(); //try again
        }

    } 

    /**
     * Requests user input to determine the virtual addressing.
     * assumes 32-bit virtual addressing
     * @variable long upperBound: the largest input accepted 429,496,7295
     */
    public void userVirtualAddress() {
        
        long upperBound = 4294967295L;  //needs the L at the end to signify it is a long type 
        System.out.println("Please input an appropriate virtual address");  //prompts the user to input the virtual addressing
        virtualAddress = sc.nextLong(); //user input
        
        if (0 <= virtualAddress && virtualAddress <= upperBound ) { //makes sure the input is between bounds
            //do nothing
        }else{
            userVirtualAddress(); //try again
        }
    }

    /**
     * Calculates the page number and offset of the virtual address by requesting a page size and a virtual address from the user.
     * Invokes both the userPageSize() method and the userVirtualAddress() method.
     * @variable int pageNumber: the page number of the virtual address within memory.
     * @variable in pageOffset: the offset within the page number of the virtual address within memory.
     */
    public void calculatePageNumberAndOffset() {
        
        userPageSize();
        userVirtualAddress();
        int pageNumber = (int) (virtualAddress / pageSize);
        int pageOffset = (int) (virtualAddress % pageSize);
        System.out.println("The address is in virtual page: " + pageNumber);
        System.out.println("At offset: " + pageOffset);
    }


    public static void main(String[] args) {
        //can't make static references to non static methods. 
        //try making an object of the class first and then invoking the methods on that onject.

        VirtualAddress vAddress = new VirtualAddress(); //creates a new object of the VirtualAddress class
        vAddress.calculatePageNumberAndOffset(); //executes the decomposition of a virtual address into page number and offset.
    }


} 
