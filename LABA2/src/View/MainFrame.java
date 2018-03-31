package View;
import javax.swing.*;

import Model.Human;

import java.awt.*;
import java.awt.event.ActionEvent;


public class MainFrame {

    /** Field which contain a person*/
    private Human person;
    /**Field main frame*/
    private JFrame frame;
    /**field which contain useful txtfield*/
    protected JTextField textfield;

    /**
     * Constructor of main frame
     */
    public MainFrame() {
        person= new Human();
        frame = new JFrame("LABA 2");
        frame.setSize(300,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        JButton plant=new JButton("Посадить");
        JButton smell=new JButton("Понюхать");
        JButton shower=new JButton("Полить");

        frame.add(plant);
        frame.add(smell);
        frame.add(shower);

        plant.addActionListener(this::actionPlanting);
        shower.addActionListener(this::actionShower);
        smell.addActionListener(this::actionSmell);
    }

    /**
     * This method contain choosing of flower for Smelling
     * @param sm-event
     */
    public void actionSmell(ActionEvent sm){
        if(sm.getActionCommand().equals("Понюхать")) {
            JDialog smellFrame = new JDialog();
            smellFrame.setSize(250, 200);
            smellFrame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            smellFrame.setLocationRelativeTo(null);
            textfield = new JTextField(10);
            JButton smelling = new JButton("Smell");
            JLabel msg = new JLabel("Which flower you want to smell?");
            if (person.getCount() == 0) {
                smellFrame.add(new JLabel("There are no flowers for smelling"));
            }
            else {

                smellFrame.add(msg);
                smellFrame.add(textfield);
                smellFrame.add(smelling);
                smellFrame.setLayout(new FlowLayout());
                smellFrame.setVisible(true);

                //frame.setVisible(false);
                textfield.setActionCommand("txtField");
                smelling.addActionListener(this::actionSmelling);
            }
        }
    }

    /**
     * this method contain activity for Planting
     * @param pl-event
     */
    public void actionPlanting(ActionEvent pl){
        if(pl.getActionCommand().equals("Посадить")) {
            if ((person.Plant()) == 1) {
                JDialog wrongPlant = new JDialog();
                wrongPlant.setSize(200, 100);
                wrongPlant.setVisible(true);
                wrongPlant.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                wrongPlant.setLocationRelativeTo(null);
                wrongPlant.add(new JLabel("You can't planting more flowers"));
            } else {
                JDialog goodPlant = new JDialog();
                goodPlant.setSize(200, 100);
                goodPlant.setVisible(true);
                goodPlant.setLocationRelativeTo(null);
                goodPlant.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                goodPlant.add(new JLabel("Flower has been planted"));
            }
        }
    }

    /**
     * this method contain choosing of flower for Shower
     * @param sh-event
     */
    public void actionShower(ActionEvent sh) {
        if (sh.getActionCommand().equals("Полить")) {
            JDialog infoFrame = new JDialog();
            infoFrame.setSize(250, 200);
            infoFrame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            infoFrame.setLocationRelativeTo(null);
            textfield = new JTextField(10);
            JButton enter = new JButton("Enter");
            JLabel msg = new JLabel("Which flower you want to shower?");
            if (person.getCount() == 0) {
                infoFrame.add(new JLabel("There are no flowers for shower"));
            } else {
                infoFrame.add(msg);
                infoFrame.add(textfield);
                infoFrame.add(enter);
                infoFrame.setLayout(new FlowLayout());
                infoFrame.setVisible(true);
                textfield.setActionCommand("txtField");
                enter.addActionListener(this::actionShowing);
            }
        }
    }

    /**
     * this method contain action for Shower
     * @param sh-event
     */
    public void actionShowing(ActionEvent sh) {
        if(sh.getActionCommand().equals("Enter")){
            String tmp= textfield.getText();
            int wrongIn=person.Shower(Integer.parseInt(tmp));
            if(wrongIn==2)
            {
                JDialog mistake1=new JDialog();
                mistake1.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                mistake1.setSize(200,100);
                mistake1.setLocationRelativeTo(null);
                mistake1.setLayout(new FlowLayout());
                mistake1.setVisible(true);
                JLabel msgAboutMistake=new JLabel("Your input was incorrect");
                mistake1.add(msgAboutMistake);
            }
            if(wrongIn==1){
                JDialog mistake2=new JDialog();
                mistake2.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                mistake2.setSize(200,100);
                mistake2.setLocationRelativeTo(null);
                mistake2.setLayout(new FlowLayout());
                mistake2.setVisible(true);
                JLabel msgAboutMistake=new JLabel("This rose already has a concrete");
                mistake2.add(msgAboutMistake);
            }
        }
    }

    /**
     * method which realize action for smelling
     * @param as -event
     */
    public void actionSmelling(ActionEvent as) {
        if(as.getActionCommand().equals("Smell")) {
            String tmp=textfield.getText();
            String message=person.smell(Integer.parseInt(tmp));
            JDialog messageSmell=new JDialog();
            messageSmell.setLocationRelativeTo(null);
            messageSmell.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            messageSmell.setSize(300,100);
            messageSmell.add(new JLabel(message));
            messageSmell.setVisible(true);
        }
}
}
