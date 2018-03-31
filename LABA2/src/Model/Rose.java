package Model;

public class Rose extends Flower {
    /**field which contain numbers of concrete*/
    private int count;
    /**field which contain object of class Concrete*/
    private Concrete conc;

    /**
     * it is a getter for count
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * it is a setter for conc
     * @return number of concrete
     */
    public int setConc() {
        if(count==0){
        this.conc = conc;
        return 0;
        }
        else
        {
            return 1;
        }
    }

    /**
     * Constructor of Rose
     */
    Rose(){
        count=0;
        conc=new Concrete();
    }

    /**
     * it is a getter for conc
     * @return conc
     */
    public Concrete getConc() {
        return conc;
    }
}
