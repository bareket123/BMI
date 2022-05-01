import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    public Panel(){
       // this.setBackground(Color.getHSBColor(2,25,29));
        this.setLayout( new BorderLayout());
        this.setBackground(Color.PINK);
        this.setPreferredSize(new Dimension(Constants.GENERAL_PANEL_WIDTH,Constants.GENERAL_PANEL_HEIGHT));
        PersonData personData = new PersonData();
        Gender gender= new Gender();
        UserHeight userHeightSlider =new UserHeight();
        BodyStructure bodyStructure=new BodyStructure();
        UserWeight userWeight=new UserWeight();
        add(personData,BorderLayout.NORTH);
        add(gender,BorderLayout.SOUTH);
        add(userHeightSlider,BorderLayout.CENTER);
        add(bodyStructure,BorderLayout.EAST);
       add(userWeight,BorderLayout.WEST);
    }


}
