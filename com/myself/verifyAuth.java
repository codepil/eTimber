package com.myself;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class verifyAuth {
	boolean b = false;

	public static void main(String argv[]){

		verifyAuth vv = new verifyAuth();
		//vv.verifyPasswd();

	}

	public verifyAuth() { };

	public void setB(boolean bb){ b = bb;}
	public boolean getB(){ return b;}

    public void verifyPasswd(JFrame f) {

        //final JFrame f = new JFrame("Password");


        JLabel label = new JLabel("Enter the password: ");
        JPasswordField passwordField = new JPasswordField(10);
        passwordField.setEchoChar('*');


        passwordField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPasswordField input = (JPasswordField)e.getSource();
                char[] password = input.getPassword();
                if (isPasswordCorrect(password)) {
                    //JOptionPane.showMessageDialog(f, "Success! You typed the right password.");
                    //setB(true);
                } else {
                    //JOptionPane.showMessageDialog(f,
                      //  "Invalid password. Try again.",
                      //  "Error Message",
                      //  JOptionPane.ERROR_MESSAGE);
                    //setB(false);
                }
            }
        });

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPane.add(label, BorderLayout.WEST);
        contentPane.add(passwordField, BorderLayout.CENTER);

        f.setContentPane(contentPane);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        f.pack();
        f.setVisible(true);
    }

    private static boolean isPasswordCorrect(char[] input) {
        char[] correctPassword = { 'w', 'o', 'o', 'd' };
        if (input.length != correctPassword.length)
            return false;
        for (int i = 0;  i < input.length; i ++)
            if (input[i] != correctPassword[i])
                return false;
        return true;
    }
}