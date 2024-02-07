import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;
 
public class TabDemo {
    //final static String BUTTONPANEL = "Tab with JButtons";
    //final static String TEXTPANEL = "Tab with JTextField";
    final static int extraWindowWidth = 100;
    Integer width = 600;
    Integer height = 800;

    JLabel warning;

    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time; //gets the current time
    String day;
    String date;

    JTabbedPane tabbedPane;
 
    public void addComponentToPane(Container pane) {
        
        tabbedPane = new JTabbedPane();
        
        //Create the "cards".
        JPanel card1 = new JPanel() {
            //Make the panel wider than it really needs, so
            //the window's wide enough for the tabs to stay
            //in one row.
            /*public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += extraWindowWidth;
                return size;
            }*/
            
        };
        card1.setPreferredSize(new Dimension(width, height));
        card1.setBackground(new Color(103, 74, 179));

        timeFormat = new SimpleDateFormat("hh:mm:ss a"); //USE ORACLE
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");

        timeLabel = new JLabel();
        timeLabel.setBounds(0, 50, width, 35);
        timeLabel.setFont(new Font("Helvetica", Font.PLAIN, 35));
        timeLabel.setForeground(new Color(0xCEA2D7));
        timeLabel.setBackground(new Color(103, 74, 179));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
            
        dayLabel = new JLabel(); 
        dayLabel.setBounds(0, 85, width, 20);
        dayLabel.setFont(new Font("Helvetica", Font.PLAIN, 15));
        dayLabel.setForeground(new Color(0xCEA2D7));
        dayLabel.setHorizontalAlignment(SwingConstants.CENTER);
    
        warning = new JLabel("<html>Dosage information listed should be used as a guideline only. Always consult your doctor or healthcare specialist <br>about any medicines.</html>");
        warning.setBounds(0, height - 100, width, 40); //does not work for x and y
        warning.setFont(new Font("Helvetica", Font.ITALIC, 10)); //works
        warning.setForeground(new Color(0xCEA2D7));
        warning.setBackground(new Color(103, 74, 179));
        warning.setHorizontalAlignment(SwingConstants.CENTER);
        
        card1.add(timeLabel);
        card1.add(dayLabel); 
        card1.add(warning);

        setTime();

        JPanel card2 = new JPanel();
        //card2.add(new JTextField("TextField", 20));
        card2.setPreferredSize(new Dimension(width, height));
        card2.setBackground(new Color(103, 74, 179));

 
        tabbedPane.addTab("Settings", card1);
        tabbedPane.addTab("Clock", card2);

        pane.add(tabbedPane, BorderLayout.CENTER);
    }

    public void setTime() {
        while(true){
            time = timeFormat.format(Calendar.getInstance().getTime()); //gets the current time
            timeLabel.setText(time); //labels the time with the current time
            
            date = dateFormat.format(Calendar.getInstance().getTime());
            day = dayFormat.format(Calendar.getInstance().getTime()); //gets the current time
            dayLabel.setText(day + " | " + date); 
            
            /* 
            date = dateFormat.format(Calendar.getInstance().getTime()); //gets the current time
            dateLabel.setText(date); */

        try{
            Thread.sleep(1000); //updates every one second
        }
        catch (InterruptedException e){
            e.printStackTrace();
            
        }
        }
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() { //the equivalent of MyFrame
        //Create and set up the window.
        JFrame frame = new JFrame("MediAlert");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        TabDemo demo = new TabDemo();
        demo.addComponentToPane(frame.getContentPane());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);

        frame.setLayout(null);
        //frame.setSize(width, height);
        frame.setResizable(true);
        frame.getContentPane().setBackground(new Color(103, 74, 179));

    }
 
    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}