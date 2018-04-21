/**
 * class Consumer which get objects from buffer
 */
class Consumer extends Thread {
    /**
     * object of buffer
     */
    Buffer buf;

    /**
     * constructor
     * @param buf
     */
    Consumer(Buffer buf)
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
     * method which get objects from buffer
     * @return msg about finishing
     */
    public int Consume(){
        if(buf.get()==1)
        {
            return 1;
        }
        return 0;
    }
}