package com.myself;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ScalePanel extends JPanel {

	
    public ScalePanel(Image bgImage) {
        this.bgImage = bgImage;
        //super();
		initialize();
    }

    Image bgImage;

	private javax.swing.JButton jButton = null;
	private javax.swing.JTextField jTextField = null;
	private javax.swing.JScrollPane jScrollPane = null;
	private javax.swing.JTable jTable = null;
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
        this.add(getJButton(), null);
        this.add(getJTextField(), null);
        this.add(getJScrollPane(), null);
			
	}
    public void paintComponent(Graphics g) {
        /*double scaleX = this.getWidth() / (double) bgImage.getWidth(null);
        double scaleY = this.getHeight() / (double) bgImage.getHeight(null);
        AffineTransform xform = AffineTransform.getScaleInstance(scaleX,
scaleY);
        ((Graphics2D) g).drawImage(bgImage, xform, this);*/
        g.drawImage(bgImage,0,0,getWidth(),getHeight(),this); 
    }

    public static void main(String[] args) {
        BufferedImage img = new BufferedImage(200, 200,
BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        Paint paint = new GradientPaint(0, 0, Color.blue, 200, 200,
Color.WHITE);
        g.setPaint(paint);
        g.fillRect(0, 0, 200, 200);
        g.dispose();
		ImageIcon img1 = new ImageIcon("images/a773.jpg", "Convert CFT"); 

        ScalePanel sp = new ScalePanel(img1.getImage());

        JFrame frame = new JFrame();
        frame.getContentPane().add(sp);
		//frame.setSize(724, 364);
        frame.pack();
        frame.show();
    }

	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton() {
		if(jButton == null) {
			jButton = new javax.swing.JButton();
			jButton.setText("Ram");
			jButton.setOpaque(false);
		}
		return jButton;
	}
	/**
	 * This method initializes jTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	private javax.swing.JTextField getJTextField() {
		if(jTextField == null) {
			jTextField = new javax.swing.JTextField();
			jTextField.setText("some text");
		}
		return jTextField;
	}
	/**
	 * This method initializes jTable
	 * 
	 * @return javax.swing.JTable
	 */
	private javax.swing.JTable getJTable() {
		if(jTable == null) {
			jTable = new javax.swing.JTable();
		}
		return jTable;
	}
	/**
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private javax.swing.JScrollPane getJScrollPane() {
		if(jScrollPane == null) {
			jScrollPane = new javax.swing.JScrollPane();
			jScrollPane.setViewportView(getJTable());
			jScrollPane.setOpaque(false);
		}
		return jScrollPane;
	}
}

//@jve:visual-info  decl-index=0 visual-constraint="50,14"