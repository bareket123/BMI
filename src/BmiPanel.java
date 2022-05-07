import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class BmiPanel extends JPanel {
    private JButton submit, exit;
    private JPanel buttonPanel;

    public BmiPanel() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(Constants.BMI_PANEL_WIDTH, Constants.BMI_PANEL_HEIGHT));
       PersonData personData = new PersonData();
       Gender gender=new Gender();
       personData.add(gender);
       BodyStructure bodyStructure = new BodyStructure();
        UserHeight userHeightSlider = new UserHeight();
        UserWeight userWeight = new UserWeight();
        userHeightSlider.add(userWeight);

        submit = new JButton("Submit");
        submit.setBackground(Color.RED);
        exit =new JButton("Exit");
        exit.setBackground(Color.CYAN);
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize (new Dimension(Constants.BUTTON_PANEL_WIDTH, Constants.BUTTON_PANEL_HEIGHT));
        buttonPanel.setBackground (Color.PINK);
        buttonPanel.add (submit);
        buttonPanel.add (exit);
        add (buttonPanel,BorderLayout.SOUTH);
        submit.addActionListener (e -> {
            BmiCalculationsPanel bmiCalculationsPanel=new BmiCalculationsPanel(personData,gender,userWeight,userHeightSlider,bodyStructure);
            userWeight.add(bmiCalculationsPanel,BorderLayout.NORTH);
            userWeight.revalidate();
            userWeight.repaint();
            submit.setEnabled(false);

        });
        exit.addActionListener (e -> {
           System.exit(0);

        });



        add(personData,BorderLayout.WEST);
       add(userHeightSlider, BorderLayout.EAST);
       add(bodyStructure, BorderLayout.CENTER);

    }

}