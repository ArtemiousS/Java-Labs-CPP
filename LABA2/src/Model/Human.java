package Model;

/**
 * class Human
 */
public class Human {
    /** field name*/
    private String name;
    /** field flowers*/
    private Rose flowers[];
    /**field  count*/
    private int count;
    /**field mistakes*/
    private int mistakes;

    /**
     * getter of name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Constructor of Human
     */
    public Human()
    {
        name="Вася Лобзик";
        flowers=new Rose[10];
        count=0;
        mistakes=0;
    }

    /**
     * method which contains Shower activity
     * @param numberOfFlower
     * @return mistakes
     */
    public int Shower(int numberOfFlower){
        if(numberOfFlower<count){
            mistakes=flowers[numberOfFlower].setConc();
            return mistakes;
    }
    else return 2;
    }

    /**
     * this method contain planting activity
     * @return
     */
    public int Plant()
    {
        if(count<10) {
            flowers[count] = new Rose();
            count++;
        }
        else
        {
            mistakes=1;
        }
        return mistakes;
    }

    /**
     * this method contain smelling activity
     * @param numberOfFlower
     * @return smell or message
     */
    public String smell(int numberOfFlower){
        if(numberOfFlower<count) {
            return flowers[numberOfFlower].getConc().getSmell();
        }
        else{
            return "Нюхать пока что нечего, ты упоролся братишка";
        }
        }

    /**
     * getter of count
     * @return count
     */
    public int getCount() {
        return count;
    }
}
