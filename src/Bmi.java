import javax.swing.*;

public class Bmi {
    public static void main(String[] args) {
        JFrame frame = new JFrame ("BMI");

          try {
           frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
              frame.setVisible(true);
              frame.setResizable(false);
              //define the controller and the view(the view is inside the controller).
               ControllerBmi controller=new ControllerBmi();
               frame.getContentPane().add(controller.view);
               frame.pack();
               frame.setLocationRelativeTo(null);
          }
          catch (Exception e){
             e.printStackTrace();
          }
            }
        }





