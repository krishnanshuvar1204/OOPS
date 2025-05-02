import javax.swing.*;
import java.awt.event.*;

public class TodoList {
    public static void main(String[] args) {
        JFrame f = new JFrame("To-Do List");
        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> list = new JList<>(model);
        JScrollPane scroll = new JScrollPane(list);
        scroll.setBounds(30, 30, 200, 150);
        JTextField taskField = new JTextField();
        taskField.setBounds(30, 190, 200, 30);
        JButton addBtn = new JButton("Add");
        addBtn.setBounds(240, 190, 80, 30);
        JButton removeBtn = new JButton("Remove");
        removeBtn.setBounds(240, 230, 80, 30);

        addBtn.addActionListener(e -> {
            String task = taskField.getText();
            if (!task.isEmpty()) model.addElement(task);
            taskField.setText("");
        });

        removeBtn.addActionListener(e -> {
            int selected = list.getSelectedIndex();
            if (selected != -1) model.remove(selected);
        });

        f.add(scroll); f.add(taskField);
        f.add(addBtn); f.add(removeBtn);
        f.setSize(370, 350);
        f.setLayout(null);
        f.setVisible(true);
    }
}
