import javax.swing.*;
import java.awt.event.*;

public class Stopwatch {
    static int time = 0;
    static Timer timer;

    public static void main(String[] args) {
        JFrame f = new JFrame("Stopwatch");
        JLabel label = new JLabel("0");
        label.setBounds(150, 50, 100, 30);
        JButton startBtn = new JButton("Start");
        startBtn.setBounds(30, 100, 80, 30);
        JButton stopBtn = new JButton("Stop");
        stopBtn.setBounds(120, 100, 80, 30);
        JButton resetBtn = new JButton("Reset");
        resetBtn.setBounds(210, 100, 80, 30);

        timer = new Timer(1000, e -> {
            time++;
            label.setText(String.valueOf(time));
        });

        startBtn.addActionListener(e -> timer.start());
        stopBtn.addActionListener(e -> timer.stop());
        resetBtn.addActionListener(e -> {
            timer.stop();
            time = 0;
            label.setText("0");
        });

        f.add(label); f.add(startBtn);
        f.add(stopBtn); f.add(resetBtn);
        f.setSize(330, 200);
        f.setLayout(null);
        f.setVisible(true);
    }
}
