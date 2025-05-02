import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class TrafficSimulator extends JFrame {
    private RoadPanel roadPanel;

    public TrafficSimulator() {
        setTitle("Traffic Management System");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        roadPanel = new RoadPanel();

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(2, 4, 10, 10));

        for (int i = 0; i < 4; i++) {
            int laneIndex = i;
            JButton normalBtn = new JButton("Add Car to Lane " + (i + 1));
            normalBtn.addActionListener(e -> roadPanel.addCar(laneIndex, false, null));
            JButton emergencyBtn = new JButton("Add Emergency to Lane " + (i + 1));
            emergencyBtn.addActionListener(e -> {
                String[] options = {"Fire Truck", "Ambulance"};
                int choice = JOptionPane.showOptionDialog(this, "Choose Emergency Vehicle Type:",
                        "Emergency Vehicle", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, options, options[0]);
                if (choice != -1) {
                    roadPanel.addCar(laneIndex, true, options[choice]);
                }
            });
            controlPanel.add(normalBtn);
            controlPanel.add(emergencyBtn);
        }

        add(controlPanel, BorderLayout.NORTH);
        add(roadPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TrafficSimulator::new);
    }
}

class Car {
    int x;
    final int y;
    final boolean isEmergency;
    final String type;
    final Color color;
    boolean passedSignal = false;
    boolean stopped = false;

    public Car(int startX, int y, boolean isEmergency, String type) {
        this.x = startX;
        this.y = y;
        this.isEmergency = isEmergency;
        this.type = type;
        this.color = isEmergency ? ("Fire Truck".equals(type) ? Color.MAGENTA : Color.RED) : Color.CYAN;
    }

    public void move(int direction) {
        this.x += direction * 5;
        this.stopped = false;
    }
}

class RoadPanel extends JPanel {
    private final List<Car>[] lanes;
    private boolean greenEast = true;
    private final int STOP_LINE_X = 800;
    private final int CAR_WIDTH = 50;
    private final int GAP_BETWEEN_CARS = 10;
    private final javax.swing.Timer simulationTimer;
    private final javax.swing.Timer toggleSignalTimer;

    @SuppressWarnings("unchecked")
    public RoadPanel() {
        lanes = new ArrayList[4];
        for (int i = 0; i < 4; i++) {
            lanes[i] = new ArrayList<>();
        }

        simulationTimer = new javax.swing.Timer(100, e -> {
            moveCars();
            checkEmergencyPriority();
            repaint();
        });
        simulationTimer.start();

        toggleSignalTimer = new javax.swing.Timer(10000, e -> toggleSignal()); // toggle every 8 seconds
        toggleSignalTimer.start();
    }

    public void addCar(int laneIndex, boolean isEmergency, String type) {
        int y = 100 + (laneIndex * 60);
        int startX = (laneIndex < 2) ? -CAR_WIDTH : getWidth();
        List<Car> lane = lanes[laneIndex];
        if (!lane.isEmpty()) {
            Car lastCar = lane.get(lane.size() - 1);
            if (laneIndex < 2) {
                startX = Math.max(lastCar.x - CAR_WIDTH - GAP_BETWEEN_CARS, -CAR_WIDTH);
            } else {
                startX = Math.min(lastCar.x + CAR_WIDTH + GAP_BETWEEN_CARS, getWidth());
            }
        }
        lanes[laneIndex].add(new Car(startX, y, isEmergency, type));
    }

    private void checkEmergencyPriority() {
        Car highestPriorityCar = null;
        int highestPriorityLane = -1;

        for (int i = 0; i < 4; i++) {
            boolean isEast = i < 2;
            List<Car> lane = lanes[i];
            for (Car car : lane) {
                if (car.isEmergency && car.stopped) {
                    if (highestPriorityCar == null ||
                            ("Fire Truck".equals(car.type) && "Ambulance".equals(highestPriorityCar.type))) {
                        highestPriorityCar = car;
                        highestPriorityLane = i;
                    }
                }
            }
        }

        if (highestPriorityCar != null) {
            greenEast = highestPriorityLane < 2;
        }
    }

    private void toggleSignal() {
        greenEast = !greenEast;
    }

    private void moveCars() {
        for (int i = 0; i < 4; i++) {
            boolean isEast = i < 2;
            int direction = isEast ? 1 : -1;
            List<Car> lane = lanes[i];

            for (int j = 0; j < lane.size(); j++) {
                Car car = lane.get(j);
                boolean canMove = true;

                if (j > 0) {
                    Car frontCar = lane.get(j - 1);
                    if (isEast && car.x + CAR_WIDTH + GAP_BETWEEN_CARS >= frontCar.x) {
                        canMove = false;
                    } else if (!isEast && car.x - CAR_WIDTH - GAP_BETWEEN_CARS <= frontCar.x) {
                        canMove = false;
                    }
                }

                if (isEast) {
                    if (!greenEast && !car.passedSignal && car.x + CAR_WIDTH >= STOP_LINE_X - 5 && car.x <= STOP_LINE_X + 10) {
                        canMove = false;
                    }
                    if (greenEast || car.x > STOP_LINE_X) {
                        canMove = true;
                    }
                } else {
                    if (greenEast && !car.passedSignal && car.x <= STOP_LINE_X + 5 && car.x + CAR_WIDTH >= STOP_LINE_X - 10) {
                        canMove = false;
                    }
                    if (!greenEast || car.x < STOP_LINE_X) {
                        canMove = true;
                    }
                }

                if (canMove) {
                    car.move(direction);
                    if (isEast && car.x > STOP_LINE_X) car.passedSignal = true;
                    if (!isEast && car.x < STOP_LINE_X) car.passedSignal = true;
                } else {
                    car.stopped = true;
                }
            }

            lane.removeIf(car -> car.x > getWidth() || car.x < -CAR_WIDTH);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.DARK_GRAY);
        for (int i = 0; i < 4; i++) {
            g.fillRect(0, 100 + (i * 60), getWidth(), 40);
        }

        g.setColor(Color.WHITE);
        g.fillRect(STOP_LINE_X, 90, 5, 300);

        g.setColor(greenEast ? Color.GREEN : Color.RED);
        g.fillOval(850, 50, 30, 30);
        g.setColor(!greenEast ? Color.GREEN : Color.RED);
        g.fillOval(100, 50, 30, 30);

        for (List<Car> lane : lanes) {
            for (Car car : lane) {
                g.setColor(car.color);
                g.fillRect(car.x, car.y, CAR_WIDTH, 30);
                g.setColor(Color.BLACK);
                g.fillOval(car.x + 5, car.y + 25, 10, 10);
                g.fillOval(car.x + 35, car.y + 25, 10, 10);
            }
        }
    }
}