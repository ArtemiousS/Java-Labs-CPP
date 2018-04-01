package Model;
import Model.Flowers.Rose;
/**
 * class Flower which extends from Human
 */
public class Flower extends Human {
    /** field - High*/
    private int high;
    private Concrete conc;
    private Sheet sheet;
    private Rose rose;
    private  int countc;
    /**getter for field high*/
    public int getHigh() {
        return high;
    }

    public Concrete getConc() {
        return conc;
    }

    public int setConc() {
        if (countc==0) {
            conc = new Concrete();
            countc++;
            return 0;
        }
        else {
            return 1;
        }
    }

    public void growUp(){
        high++;
    }

    public Flower(){
        high=3;
        countc=0;
        rose=new Rose();
        sheet=new Sheet();

    }
}
