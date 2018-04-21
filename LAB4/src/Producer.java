/**
 * class which put objects into a buffer
 */
public class Producer extends Thread {
    /**
     * field of buffer
     */
    Buffer buf;

    /**
     * constructor
     * @param buf
     */
    Producer(Buffer buf)
    {
        this.buf=buf;
    }

    /**
     * runnable method
     */
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    /**
     * method which produce objects in buffer
     * @return finish msg
     */
    public int Produce(){
        if(buf.put()==1){
            return 1;
        }
        return 0;
    }
}