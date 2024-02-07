import javax.swing.*;

import java.util.Calendar;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class MyFrame extends JFrame implements ActionListener{
    //I WILL BE DECLARING GLOBAL VARIABLES HERE
    JLabel lmao;
    JTextField custom;

    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time; //gets the current time
    String day;
    String date;

    JLabel prescription;

    JLabel medis;
    JLabel dosage;
    JLabel freq;

    JTextField t;
    JButton button;

    JComboBox meds;
    JTextField dosageBox;
    JComboBox dosageUnit;
    JComboBox freqBox;

    JLabel conclusion;
    
    JLabel warning;

    Integer height = 800;
    Integer width = 600;

    JButton settings;
    Integer j = 1;
    
    JTabbedPane format;
    JPanel bedtime;
    //JComponent  calc;
    JPanel calc;
    JPanel algo;

    
    //String conc = "";


    //text(){} // default constructor

    MyFrame(){ //Constructor

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits program on close
        this.setTitle("MediAlert");
        this.setLayout(null);
        this.setSize(width, height);
        this.setResizable(true);
        this.getContentPane().setBackground(new Color(103, 74, 179));

        settings = new JButton("Settings");
        settings.setBounds(250, height - 150, 100, 35);
        settings.setFont(new Font("Arial", Font.PLAIN, 20));
        settings.setBackground(new Color(0x9F63C4));
        settings.setForeground(new Color(0xCEA2D7));
        settings.addActionListener(this);
        settings.setFocusable(false);
        settings.setBorder(null);


            //CLOCK
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
            
            //BEGIN CALCULATOR
            prescription = new JLabel("Enter your prescription below:");
            prescription.setBounds(0, 150, width, 20);
            prescription.setFont(new Font("Helvetica", Font.PLAIN, 15));
            prescription.setForeground(new Color(0xCEA2D7));
            prescription.setHorizontalAlignment(SwingConstants.CENTER);

            lmao = new JLabel();
            lmao.setText("MediAlert");
            lmao.setFont(new Font("Apple Casual", Font.ITALIC, 25));
            lmao.setBounds(0, 0, width, 50);
            lmao.setForeground(new Color(0xCEA2D7));
            lmao.setBackground(new Color(103, 74, 179));
            lmao.setHorizontalAlignment(SwingConstants.CENTER);

            
            conclusion = new JLabel();
            //conclusion.setText("hello");
            conclusion.setBounds(0, 400, width, 40);
            conclusion.setFont(new Font("Helvetica", Font.PLAIN, 15));
            conclusion.setForeground(new Color(0xCEA2D7));
            conclusion.setBackground(new Color(103, 74, 179));
            conclusion.setHorizontalAlignment(SwingConstants.CENTER);

            button = new JButton();
            button.setBounds(250, 350, 100, 35);
            button.setText("Calculate");
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            button.setBackground(new Color(0x9F63C4));
            button.setForeground(new Color(0xCEA2D7));
            button.addActionListener(this);
            button.setFocusable(false);
            button.setBorder(null);

            String[] medList = {"Select Your Medication", "Add Custom", "Ibuprofen" ,
                "Aspirin", "Zestril", "Synthroid", "Lipitor", "Glucophage", "Zocor", 
                "Norvasc", "Lopressor", "Acetaminophine", "Ventolin"};
        
            meds = new JComboBox(medList);
            meds.setBounds(width / 2 - 75, 200, 150, 35);
            meds.setFont(new Font("Helvetica", Font.PLAIN, 15));
            meds.addActionListener(this);
            meds.setEditable(true);
            meds.setMaximumRowCount(5);

            custom = new JTextField("");
            custom.setBounds(width / 2 - 75, 240, 150, 35);
            custom.setFont(new Font("Helvetica", Font.PLAIN, 15));
            //custom.addActionListener(this);
            custom.setEditable(true);
            //text content = new text();
            
            warning = new JLabel("<html>Dosage information listed should be used as a guideline only. Always consult your doctor or healthcare specialist <br>about any medicines.</html>");
            warning.setBounds(0, height - 100, width, 40);
            
            warning.setFont(new Font("Helvetica", Font.ITALIC, 10));
            warning.setForeground(new Color(0xCEA2D7));
            warning.setBackground(new Color(103, 74, 179));
            warning.setHorizontalAlignment(SwingConstants.CENTER);

            medis = new JLabel("Medication:");
            medis.setBounds(width / 2 - 50, 180, 100, 20);
            medis.setFont(new Font("Helvetica", Font.PLAIN, 15));
            medis.setForeground(new Color(0xCEA2D7));
            medis.setHorizontalAlignment(SwingConstants.CENTER);

            dosage = new JLabel("Dosage:");
            dosage.setBounds(75, 180, 100, 20);
            dosage.setFont(new Font("Helvetica", Font.PLAIN, 15));
            dosage.setForeground(new Color(0xCEA2D7));
            dosage.setHorizontalAlignment(SwingConstants.CENTER); 

            String[] units = {"mg", "mL"};        
            
            dosageUnit = new JComboBox(units);
            dosageUnit.setBounds(150, 200, 50, 35);
            dosageUnit.setFont(new Font("Helvetica", Font.PLAIN, 15));
            dosageUnit.addActionListener(this);
            dosageUnit.setEditable(true);
            dosageUnit.setMaximumRowCount(5);
            
            dosageBox = new JTextField("Enter amount");
            dosageBox.setBounds(50, 200, 100, 35);
            dosageBox.setFont(new Font("Helvetica", Font.PLAIN, 15));
            //dosageBox.addActionListener(this);
            dosageBox.setEditable(true);

            freq = new JLabel("Frequency:");
            freq.setBounds(425, 180, 100, 20);
            freq.setFont(new Font("Helvetica", Font.PLAIN, 15));
            freq.setForeground(new Color(0xCEA2D7));
            freq.setHorizontalAlignment(SwingConstants.CENTER);

            String[] frequencies = {"1", "2", "3", "4", "6"};
            freqBox = new JComboBox(frequencies);
            freqBox.setBounds(450, 200, 50, 35);
            freqBox.setFont(new Font("Helvetica", Font.PLAIN, 15));
            freqBox.addActionListener(this);
            freqBox.setEditable(true);
            freqBox.setMaximumRowCount(5);
        
            this.add(lmao);
            this.add(timeLabel);
            this.add(dayLabel); 
            this.add(settings);
            

            format = new JTabbedPane();

            calc = new JPanel();
            //calc = makeTextPanel("Settings"); 
            //
            
            calc.setBounds(height - 200, height, width, height - 200);
            format.addTab("Settings", calc);
            
            if(j == 1) this.add(calc);

            calc.add(prescription);
            calc.add(medis);
            calc.add(meds);
            calc.add(freq);
            calc.add(freqBox);
            calc.add(dosage);
            calc.add(dosageBox);
            calc.add(dosageUnit);
            calc.add(button);
            calc.add(conclusion);
            calc.add(warning);
            
            this.add(format);

            //algo.add(warning);
        

        this.setVisible(true);
        

        setTime(); //will update every single second
        
    }

    public void actionPerformed(ActionEvent i){
        if(i.getSource() == meds){
            if(meds.getSelectedIndex() == 1){
                //create a new JTextField
                calc.add(custom);
            }
        }
        if(i.getSource() == button) {
            if(meds.getSelectedIndex() != 0 && meds.getSelectedIndex() != 1){
                System.out.println(meds.getSelectedItem()); 
                conclusion.setText("Reminders set to take " + dosageBox.getText() + " " + dosageUnit.getSelectedItem() + " of " + meds.getSelectedItem() + " " + freqBox.getSelectedItem() + " times a day, at ");
            }
            else if(meds.getSelectedIndex() == 1){
                System.out.println(custom.getText());
                conclusion.setText("Reminders set to take " + dosageBox.getText() + " " + dosageUnit.getSelectedItem() + " of " + custom.getText() + " " + freqBox.getSelectedItem() + " times a day, at ");
            }
        }
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
}
