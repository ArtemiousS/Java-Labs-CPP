package Model;

public class Petal extends Concrete {
    private String color="Red";

    private boolean availability;
    Petal(){
        availability=true;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
    public boolean getAvailability(){
        return availability;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
