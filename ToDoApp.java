

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoApp {
    public static void main(String[] args) {
        // Frame
        JFrame frame = new JFrame("To-Do List App");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel for layout
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Text field to enter tasks
        JTextField taskField = new JTextField();
        panel.add(taskField, BorderLayout.NORTH);

        // List to store tasks
        DefaultListModel<String> taskListModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Add button action
        addButton.addActionListener(e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskField.setText(""); // clear input
            } else {
                JOptionPane.showMessageDialog(frame, "Enter a task!");
            }
        });

        // Delete button action
        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(frame, "Select a task to delete!");
            }
        });

        // Add panel to frame
        frame.add(panel);
        frame.setVisible(true);
    }
}
