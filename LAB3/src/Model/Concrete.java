package Model;

/**
 * class Concrete which extends from Flower
 */
public class Concrete extends Flower {
    /**field smell*/
    private String smell;
    private Petal petals[];
    /**
     * getter of smell
     * @return smell
     */
    public String getSmell() {
        return smell;
    }

    /**
     * Constructor for Concrete
     */
    public Concrete(){
        smell="Пахнет аки чёрт";
        petals=new Petal[10];
     }

     public void dump(){
         for(int i=0;i<10;i++)
             petals[i].setAvailability(false);
     }
}
