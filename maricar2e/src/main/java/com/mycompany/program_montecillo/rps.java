/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.program_montecillo;
import java.util.Scanner;

/**
 *
 * @author CL2-PC
 */
public class rps {
    public static void main(String[] args ){
        Scanner input = new Scanner (System.in);
        System.out.println("[1]= Rock");
        System.out.println("[2]= Paper");
        System.out.println("[3]= Scissor");
        
        System.out.println("Enter Player 1:");
        int p1= input.nextInt();
        System.out.println("Enter Player 2:");
        int p2= input.nextInt();
        
        
        if (p1==1&&p2==1)
        {
            System.out.println("Draw:");
        }
        else if (p1==1&&p2==2)
        {
            System.out.println("Player 2 Wins");
        }
        else if (p1==1&&p2==3)
        {
            System.out.println("Player 1 Wins");
        }
        else if (p1==1&&p2==1)
        {
            System.out.println("Player 1 Wins");
        }
        else if (p1==2&&p2==2)
        {
            System.out.println("Draw");
        }
        else if (p1==3&&p2==2)
        {
            System.out.println("Player 1 Wins");
        }
        else if (p1==3&&p2==3)
        {
            System.out.println("Draw");
        }
}
private void btnComputeActionPerformed(java.awt.event.ActionEvent evt) {                                           
    double total = 0.0;
    
    // Check Snacks
    if (chkNova.isSelected()) {
        total += 22.0;
    }
    if (chkPiatos.isSelected()) {
        total += 25.0;
    }
    if (chkOishi.isSelected()) {
        total += 15.0;
    }
    
    // Check Drinks
    if (chkRoyal.isSelected()) {
        total += 30.0;
    }
    if (chkCoke.isSelected()) {
        total += 25.0;
    }
    if (chkSprite.isSelected()) {
        total += 22.0;
    }
    
    // Display total amount in the text field
    txtTotalAmount.setText(String.format("%.2f", total));
}                                          

private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {                                          
    try {
        double total = Double.parseDouble(txtTotalAmount.getText());
        double amountPaid = Double.parseDouble(txtAmountPaid.getText());
        
        if (amountPaid < total) {
            javax.swing.JOptionPane.showMessageDialog(this, "Insufficient payment!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        } else {
            double change = amountPaid - total;
            txtChange.setText(String.format("%.2f", change));
        }
    } catch (NumberFormatException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Please enter a valid numeric payment amount.", "Invalid Input", javax.swing.JOptionPane.WARNING_MESSAGE);
    }
}                                         

private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {                                         
    // Uncheck all checkboxes
    chkNova.setSelected(false);
    chkPiatos.setSelected(false);
    chkOishi.setSelected(false);
    chkRoyal.setSelected(false);
    chkCoke.setSelected(false);
    chkSprite.setSelected(false);
    
    // Clear text fields
    txtTotalAmount.setText("");
    txtAmountPaid.setText("");
    txtChange.setText("");
}                                        


On Sun, Oct 4, 2026, 10:38 PM Aira Bardaje <bardajeaira11@gmail.com> wrote:
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CAFE_MENU extends JFrame {

    // Checkboxes for Snacks
    private JCheckBox chkNova;
    private JCheckBox chkPiatos;
    private JCheckBox chkOishi;

    // Checkboxes for Drinks
    private JCheckBox chkRoyal;
    private JCheckBox chkCoke;
    private JCheckBox chkSprite;

    // Text Fields
    private JTextField txtTotalAmount;
    private JTextField txtAmountPaid;
    private JTextField txtChange;

    // Buttons
    private JButton btnCompute;
    private JButton btnChange;
    private JButton btnClear;

    public CAFE_MENU() {
        initComponents();
    }

    private void initComponents() {
        // Frame Settings
        setTitle("MENU");
        setSize(450, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        // Header
        JLabel lblMenu = new JLabel("MENU", SwingConstants.CENTER);
        lblMenu.setBounds(150, 10, 150, 25);
        add(lblMenu);

        // --- SNACKS SECTION ---
        JLabel lblSnack = new JLabel("Snack");
        lblSnack.setBounds(50, 50, 100, 20);
        add(lblSnack);

        chkNova = new JCheckBox("NOVA = 22");
        chkNova.setBounds(50, 80, 120, 20);
        add(chkNova);

        chkPiatos = new JCheckBox("PIATOS = 25");
        chkPiatos.setBounds(50, 110, 120, 20);
        add(chkPiatos);

        chkOishi = new JCheckBox("OISHI = 15");
        chkOishi.setBounds(50, 140, 120, 20);
        add(chkOishi);

        // --- DRINKS SECTION ---
        JLabel lblDrinks = new JLabel("Drinks");
        lblDrinks.setBounds(260, 50, 100, 20);
        add(lblDrinks);

        chkRoyal = new JCheckBox("ROYAL = 30");
        chkRoyal.setBounds(260, 80, 120, 20);
        add(chkRoyal);

        chkCoke = new JCheckBox("COKE = 25");
        chkCoke.setBounds(260, 110, 120, 20);
        add(chkCoke);

        chkSprite = new JCheckBox("SPRITE = 22");
        chkSprite.setBounds(260, 140, 120, 20);
        add(chkSprite);

        // --- PAYMENT SECTION ---
        JLabel lblTotal = new JLabel("Total Amount:");
        lblTotal.setBounds(50, 200, 100, 25);
        add(lblTotal);

        txtTotalAmount = new JTextField();
        txtTotalAmount.setBounds(160, 200, 120, 25);
        txtTotalAmount.setEditable(false); // Prevents manual editing
        add(txtTotalAmount);

        JLabel lblPaid = new JLabel("Amount Pay:");
        lblPaid.setBounds(50, 230, 100, 25);
        add(lblPaid);

        txtAmountPaid = new JTextField();
        txtAmountPaid.setBounds(160, 230, 120, 25);
        add(txtAmountPaid);

        JLabel lblChange = new JLabel("Change:");
        lblChange.setBounds(50, 260, 100, 25);
        add(lblChange);

        txtChange = new JTextField();
        txtChange.setBounds(160, 260, 120, 25);
        txtChange.setEditable(false);
        add(txtChange);

        // --- BUTTONS ---
        btnCompute = new JButton("COMPUTE");
        btnCompute.setBounds(160, 300, 120, 25);
        add(btnCompute);

        btnChange = new JButton("CHANGE");
        btnChange.setBounds(160, 330, 120, 25);
        add(btnChange);

        btnClear = new JButton("CLEAR");
        btnClear.setBounds(160, 360, 120, 25);
        add(btnClear);

        // --- ACTION LISTENERS ---

        // COMPUTE BUTTON: Calculates sum of selected items
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double total = 0.0;

                if (chkNova.isSelected()) total += 22.0;
                if (chkPiatos.isSelected()) total += 25.0;
                if (chkOishi.isSelected()) total += 15.0;

                if (chkRoyal.isSelected()) total += 30.0;
                if (chkCoke.isSelected()) total += 25.0;
                if (chkSprite.isSelected()) total += 22.0;

                txtTotalAmount.setText(String.format("%.2f", total));
            }
        });

        // CHANGE BUTTON: Calculates change based on amount paid
        btnChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String totalText = txtTotalAmount.getText();
                    String paidText = txtAmountPaid.getText();

                    if (totalText.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please click COMPUTE first to calculate the total.", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    double total = Double.parseDouble(totalText);
                    double paid = Double.parseDouble(paidText);

                    if (paid < total) {
                        JOptionPane.showMessageDialog(null, "Insufficient payment amount!", "Error", JOptionPane.ERROR_MESSAGE);
                        txtChange.setText("");
                    } else {
                        double change = paid - total;
                        txtChange.setText(String.format("%.2f", change));
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid numeric amount for payment.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // CLEAR BUTTON: Resets all choices and inputs
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chkNova.setSelected(false);
                chkPiatos.setSelected(false);
                chkOishi.setSelected(false);

                chkRoyal.setSelected(false);
                chkCoke.setSelected(false);
                chkSprite.setSelected(false);

                txtTotalAmount.setText("");
                txtAmountPaid.setText("");
                txtChange.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CAFE_MENU().setVisible(true);
        });
    }
}


}