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
package rockpaperscissors;

import java.util.Random;

public class GameFrame extends javax.swing.JFrame {

    private int playerScore = 0;
    private int computerScore = 0;
    private final String[] choices = {"Rock", "Paper", "Scissors"};
    private final Random random = new Random();

    public GameFrame() {
        initComponents();
        setLocationRelativeTo(null); // Centers the window on screen
    }

    private void playGame(String playerChoice) {
        // Computer generates a random choice (0, 1, or 2)
        int computerIndex = random.nextInt(3);
        String computerChoice = choices[computerIndex];

        // Update choice labels
        lblPlayerChoice.setText("Player Choice: " + playerChoice);
        lblComputerChoice.setText("Computer Choice: " + computerChoice);

        // Determine the winner
        if (playerChoice.equals(computerChoice)) {
            lblStatus.setText("It's a Tie!");
        } else if (
            (playerChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
            (playerChoice.equals("Paper") && computerChoice.equals("Rock")) ||
            (playerChoice.equals("Scissors") && computerChoice.equals("Paper"))
        ) {
            lblStatus.setText("You Win this round!");
            playerScore++;
        } else {
            lblStatus.setText("Computer Wins this round!");
            computerScore++;
        }

        // Update score display
        lblScore.setText("Score - You: " + playerScore + " | Computer: " + computerScore);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        btnRock = new javax.swing.JButton();
        btnPaper = new javax.swing.JButton();
        btnScissors = new javax.swing.JButton();
        lblPlayerChoice = new javax.swing.JLabel();
        lblComputerChoice = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();

        setDefaultClone = javax.swing.WindowConstants.EXIT_ON_CLOSE;
        setTitle("Rock Paper Scissors Game");
        setResizable(false);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Rock Paper Scissors");

        lblStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus.setText("Choose your move!");

        btnRock.setText("Rock");
        btnRock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRockActionPerformed(evt);
            }
        });

        btnPaper.setText("Paper");
        btnPaper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaperActionPerformed(evt);
            }
        });

        btnScissors.setText("Scissors");
        btnScissors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScissorsActionPerformed(evt);
            }
        });

        lblPlayerChoice.setText("Player Choice: -");

        lblComputerChoice.setText("Computer Choice: -");

        lblScore.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScore.setText("Score - You: 0 | Computer: 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRock, javax.swing.GroupLayout.PREFERRED_Name, 85, javax.swing.GroupLayout.PREFERRED_Name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPaper, javax.swing.GroupLayout.PREFERRED_Name, 85, javax.swing.GroupLayout.PREFERRED_Name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnScissors, javax.swing.GroupLayout.PREFERRED_Name, 85, javax.swing.GroupLayout.PREFERRED_Name))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPlayerChoice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblComputerChoice)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addComponent(lblStatus)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlayerChoice)
                    .addComponent(lblComputerChoice))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRock, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_Name)
                    .addComponent(btnPaper, javax.swing.GroupLayout.PREFERRED_Name, 35, javax.swing.GroupLayout.PREFERRED_Name)
                    .addComponent(btnScissors, javax.swing.GroupLayout.PREFERRED_Name, 35, javax.swing.GroupLayout.PREFERRED_Name))
                .addGap(18, 18, 18)
                .addComponent(lblScore)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void btnRockActionPerformed(java.awt.event.ActionEvent evt) {                                        
        playGame("Rock");
    }                                       

    private void btnPaperActionPerformed(java.awt.event.ActionEvent evt) {                                         
        playGame("Paper");
    }                                        

    private void btnScissorsActionPerformed(java.awt.event.ActionEvent evt) {                                            
        playGame("Scissors");
    }                                           

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnPaper;
    private javax.swing.JButton btnRock;
    private javax.swing.JButton btnScissors;
    private javax.swing.JLabel lblComputerChoice;
    private javax.swing.JLabel lblPlayerChoice;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration                   
}

    }

    