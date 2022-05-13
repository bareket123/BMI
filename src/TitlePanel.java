import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JPanel {
    private JLabel mainTitleLabel;
    private JLabel instructions;

//Constructor: sets up panel with title and instructions labels.
    public TitlePanel(){
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBackground(Color.white);
        this.setPreferredSize(new Dimension(Constants.BMI_PANEL_WIDTH,50));

        mainTitleLabel=new JLabel("Bmi Calculator");
        mainTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainTitleLabel.setFont(new Font("Ariel",Font.BOLD,18));

        instructions=new JLabel("Please complete this form. Press the submit button when completed");
        instructions.setFont(new Font("Ariel",Font.BOLD,18));
        instructions.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(mainTitleLabel);
        add(instructions);
    }

    //getters and setters

    public JLabel getMainTitleLabel() {
        return mainTitleLabel;
    }

    public void setMainTitleLabel(JLabel mainTitleLabel) {
        this.mainTitleLabel = mainTitleLabel;
    }

    public JLabel getInstructions() {
        return instructions;
    }

    public void setInstructions(JLabel instructions) {
        this.instructions = instructions;
    }
}
