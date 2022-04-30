import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    public Panel(){
       // this.setBackground(Color.getHSBColor(2,25,29));
        this.setLayout( new BorderLayout());
        this.setBackground(Color.PINK);
        this.setPreferredSize(new Dimension(1000,500));
        PersonData personData = new PersonData();
        Gender gender= new Gender();
        Height heightSlider=new Height();
        add(personData,BorderLayout.NORTH);
        add(gender,BorderLayout.SOUTH);
        add(heightSlider,BorderLayout.EAST);

    }


}
