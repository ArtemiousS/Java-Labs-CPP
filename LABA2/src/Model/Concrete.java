package Model;

/**
 * class Concrete which extends from Flower
 */
public class Concrete extends Flower {
    /**field smell*/
    private String smell;

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
    Concrete(){
        smell="Пахнет аки чёрт";
     }
}
