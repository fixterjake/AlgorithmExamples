package com.fixterjake.algorithms;

import javax.swing.*;
import javax.swing.event.MenuKeyListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App extends JFrame {

    /** File holding random integers **/
    private final String numsPath = "nums.txt";
    /** File holding result of sorting **/
    private final String resultsPath = "results.txt";
    /** Number of integers to generate **/
    private int fileSize = 40000;
    /** List to populate and sort using given algorithms **/
    protected ArrayList<Integer> list = new ArrayList<Integer>();;
    /** List of execution times **/
    protected ArrayList<Long> executionTimes = new ArrayList<Long>();
    /** List of algorithm types tested **/
    protected ArrayList<String> algorithmTypes = new ArrayList<String>();

    public App() {
        this.setSize(800, 600);
        this.setTitle("Algorithm Examples");
        this.setLocationRelativeTo(null);
        this.setJMenuBar(createMenuBar());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.add(createMainView());
    }

    private JPanel createMainView() {
        final JPanel mainView = new JPanel();
        mainView.setLayout(new FlowLayout());
        JLabel numLabel = new JLabel("Number to sort");
        final JTextField numField = new JTextField("10000");
        numField.setSize(100, 10);
        JButton numButton = new JButton("Set");
        mainView.add(numLabel);
        mainView.add(numField);
        mainView.add(numButton);
        numButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    fileSize = Integer.parseInt(numField.getText());
                    JOptionPane.showMessageDialog(null, "Size has been set to " + numField.getText());
                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid size please try again.");
                }
            }
        });
        return mainView;
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem exit = new JMenuItem("Exit");
        file.add(exit);
        menuBar.add(file);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?") == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        return menuBar;
    }

    protected static long processTime(long time) {
        return time / 1000000;
    }

    public static void main(String[] args) {
        App app = new App();
        app.setVisible(true);
    }
}
