/**
 * base class of threads
 */
public class MainThread {

    /**
     * fileds
     */
    private Producer producers[];
    private Consumer consumers[];
    private int countProd=0;
    private int countCons=0;

    /**
     * method which create producers
     * @param buf
     */
    public void makeProducer(Buffer buf){
        if(countProd<10) {
            producers[countProd]=new Producer(buf);
            producers[countProd].start();
            countProd++;
        }
    }

    /**
     * method whick create consumers
     * @param buf
     */
    public void makeConsumer(Buffer buf){
        if(countCons<10) {
            consumers[countCons]=new Consumer(buf);
            consumers[countCons].start();
            countCons++;
        }
    }

    /**
     * constructor
     */
    public MainThread(){
        producers=new Producer[10];
        consumers=new Consumer[10];
    }

    /**
     * getter for producers
     * @return producers
     */
    public Producer[] getProducers() {
        return producers;
    }

    /**
     * getter for consumers
     * @return consumers
     */
    public Consumer[] getConsumers() {
        return consumers;
    }

    /**
     * getter for counter which count numbers of consumers
     * @return count of cons
     */
    public int getCountCons() {
        return countCons;
    }

    /**
     * getter for counter which count numbers of producers
     * @return count of prod
     */
    public int getCountProd() {
        return countProd;
    }
}
