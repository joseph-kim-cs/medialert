import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;

public class TabDemo {
    // ... (other member variables and methods remain the same)
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel warning;

    JTabbedPane tabbedPane;

    public void addComponentToPane(Container pane) {
        // ... (same as before)

        JPanel card2 = new JPanel(new BorderLayout()); // Use BorderLayout for proper layout
        card2.setPreferredSize(new Dimension(width, height));
        card2.setBackground(new Color(103, 74, 179));

        JPanel clockPanel = new JPanel(new GridLayout(3, 1)); // Vertical layout for clock components
        clockPanel.setBackground(new Color(103, 74, 179));

        card2.add(clockPanel, BorderLayout.NORTH);

        clockPanel.add(timeLabel);
        clockPanel.add(dayLabel);
        clockPanel.add(warning);

        tabbedPane.addTab("Settings", card1);
        tabbedPane.addTab("Clock", card2);

        pane.add(tabbedPane, BorderLayout.CENTER);
    }

    public void setTime() {
        Thread timeUpdateThread = new Thread(() -> {
            while (true) {
                time = timeFormat.format(Calendar.getInstance().getTime());
                timeLabel.setText(time);

                date = dateFormat.format(Calendar.getInstance().getTime());
                day = dayFormat.format(Calendar.getInstance().getTime());
                dayLabel.setText(day + " | " + date);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        timeUpdateThread.start();
    }

    // ... (other methods remain the same)

    public static void main(String[] args) {
        // ... (LookAndFeel and other setup remains the same)

        // Schedule a job for the event dispatch thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }
}