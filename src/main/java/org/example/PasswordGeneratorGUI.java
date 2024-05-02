package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordGeneratorGUI extends JFrame
{
    private PasswordGenerator passwordGenerator;
    public PasswordGeneratorGUI()
    {
        super("Password Generator");
        setSize(500,570);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        addComponents();
        passwordGenerator = new PasswordGenerator();
    }
    private void addComponents()
    {
        //add title in the GUI
        JLabel titleLbl = new JLabel("Password Generator");
        titleLbl.setFont(new Font("Dialog",Font.BOLD,32));
        titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
        titleLbl.setBounds(0,15,500,40);
        add(titleLbl);

        //add result zone
        JTextArea resultTxt = new JTextArea();
        resultTxt.setEditable(false);
        resultTxt.setFont(new Font("Dialog",Font.CENTER_BASELINE,24));
        resultTxt.setBounds(15,100,450,70);
        resultTxt.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        add(resultTxt);

        //label PasswordLenght
        JLabel passwordLenghtLbl = new JLabel("Password Lenght");
        passwordLenghtLbl.setFont(new Font("Dialog",Font.ITALIC,24));
        passwordLenghtLbl.setHorizontalAlignment(SwingConstants.CENTER);
        passwordLenghtLbl.setBounds(15,200,250,50);
        add(passwordLenghtLbl);

        //password lenght Input
        JTextArea passwordLenghtTxt = new JTextArea();
        passwordLenghtTxt.setEditable(true);
        passwordLenghtTxt.setFont(new Font("Dialog", Font.BOLD,24));
        passwordLenghtTxt.setBounds(280,200,150,50);
        add(passwordLenghtTxt);

        //buttons
        JToggleButton uppercaseBtn = new JToggleButton("Uppercase");
        uppercaseBtn.setBounds(20,300,200,50);
        uppercaseBtn.setFont(new Font("Dialog",Font.ITALIC,24));
        JToggleButton lowercaseBtn = new JToggleButton("Lowercase");
        lowercaseBtn.setBounds(250,300,200,50);
        lowercaseBtn.setFont(new Font("Dialog",Font.ITALIC,24));
        JToggleButton numberBtn = new JToggleButton("Numbers");
        numberBtn.setBounds(20,365,200,50);
        numberBtn.setFont(new Font("Dialog",Font.ITALIC,24));
        JToggleButton symbolsBtn = new JToggleButton("Symbols");
        symbolsBtn.setBounds(250,365,200,50);
        symbolsBtn.setFont(new Font("Dialog",Font.ITALIC,24));
        add(uppercaseBtn);
        add(lowercaseBtn);
        add(numberBtn);
        add(symbolsBtn);

        //generate button
        JButton generateBtn = new JButton("Generate Password");
        generateBtn.setFont(new Font("Dialog",Font.PLAIN,32));
        generateBtn.setBounds(20,440,430,50);
        generateBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               int passwordLenght = Integer.parseInt(passwordLenghtTxt.getText());
               String generatedPassword = passwordGenerator.generatePassword(passwordLenght,uppercaseBtn.isSelected(),lowercaseBtn.isSelected(),numberBtn.isSelected(),symbolsBtn.isSelected());
               resultTxt.setText(generatedPassword);
            }
        });
        add(generateBtn);
    }
}
