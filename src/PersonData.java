import javax.swing.*;
import java.awt.*;

public class PersonData extends JPanel {

    private FirstNamePanel firstNamePanel;
    private LastNamePanel lastNamePanel;
    private AgePanel agePanel;
    private Gender genderPanel;

    public PersonData() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(Constants.PERSON_DATA_PANEL_WIDTH, Constants.PERSON_DATA_PANEL_HEIGHT));
        setBackground(Color.PINK);
        firstNamePanel = new FirstNamePanel();
        lastNamePanel = new LastNamePanel();
        agePanel = new AgePanel();
        genderPanel=new Gender();

        add(Box.createRigidArea(new Dimension(20, 80)));
        add(firstNamePanel);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(lastNamePanel);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(agePanel);
        add(Box.createRigidArea(new Dimension(0, 100)));
        add(genderPanel);


    }

    public FirstNamePanel getFirstNamePanel() {
        return firstNamePanel;
    }

    public void setFirstNamePanel(FirstNamePanel firstNamePanel) {
        this.firstNamePanel = firstNamePanel;
    }

    public LastNamePanel getLastNamePanel() {
        return lastNamePanel;
    }

    public void setLastNamePanel(LastNamePanel lastNamePanel) {
        this.lastNamePanel = lastNamePanel;
    }

    public AgePanel getAgePanel() {
        return agePanel;
    }

    public void setAgePanel(AgePanel agePanel) {
        this.agePanel = agePanel;
    }

    public Gender getGenderPanel() {
        return genderPanel;
    }

    public void setGenderPanel(Gender genderPanel) {
        this.genderPanel = genderPanel;
    }



}

