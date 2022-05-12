import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gender extends JPanel {
    private JLabel genderLabel;
    private JRadioButton female, male;
    private ButtonGroup buttonGroup;


    public Gender() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(Constants.GENDER_PANEL_WIDTH, Constants.GENDER_PANEL_HEIGHT));
        this.setBackground(Color.PINK);


        genderLabel = new JLabel("Gender: ");
        genderLabel.setFont(new Font("Lucida Fax", Font.PLAIN, 35));

        female = new JRadioButton("female");
        female.setFont(new Font("Lucida Fax", Font.BOLD, 30));
        female.setBackground(Color.PINK);
        female.setForeground(Color.MAGENTA);
        female.setEnabled(true);

        male = new JRadioButton("male");
        male.setFont(new Font("Lucida Fax", Font.BOLD, 30));
        male.setBackground(Color.PINK);
        male.setForeground(Color.BLUE);
        male.setEnabled(true);

        this.buttonGroup = new ButtonGroup();
        buttonGroup.add(male);
        buttonGroup.add(female);

        add(genderLabel);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(male);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(female);


    }

    public JRadioButton getFemale() {
        return female;
    }

    public void setFemale(JRadioButton female) {
        this.female = female;
    }

    public JRadioButton getMale() {
        return male;
    }

    public void setMale(JRadioButton male) {
        this.male = male;
    }

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }

    public void setButtonGroup(ButtonGroup buttonGroup) {
        this.buttonGroup = buttonGroup;
    }

    public JLabel getGenderLabel() {
        return genderLabel;
    }

    public void setGenderLabel(JLabel genderLabel) {
        this.genderLabel = genderLabel;
    }




}





