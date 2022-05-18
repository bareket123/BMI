import javax.swing.*;

public class Bmi {
    public static void main(String[] args) {
        JFrame frame = new JFrame ("BMI");

          try {
           frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
              frame.setVisible(true);
              frame.setResizable(false);
               BmiPanel panel=new BmiPanel();
                frame.getContentPane().add(panel);
                frame.pack();
                frame.setLocationRelativeTo(null);
          }
          catch (Exception e){
             e.printStackTrace();
          }
            }
        }





