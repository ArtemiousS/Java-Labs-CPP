/**
 * class Buffer which contain buffer for threads
*/
public class Buffer {
    /**
     * private field with counts of objects
     */
    private int counter = 0;
    /**
     * max size of buffer
     */
    private int max=10;

    /**
     * method which put objects into buffer
     * @return msg about finishing of the method
     */
    synchronized int put() {
        if(counter<max) {
            counter++;
            return 0;
        }
        else return 1;
    }

    /**
     * method which  get objects from buffer
     * @return msg about finishing of the method
     */
    synchronized int get() {
        if(counter>0) {
            counter--;
            return 0;
        }
        else return 1;
    }

    /**
     * getter of counter
     * @return counter
     */
    public int getCounter() {
        return counter;
    }
}