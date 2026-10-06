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

    