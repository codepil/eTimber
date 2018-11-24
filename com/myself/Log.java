package com.myself;

public class Log {

	public int lFeet, lIn, bFeet, bIn, quantity = 0;
	public double cft=0.0;

	public Log (){ super ();}

	public Log ( int lFeet, int lIn, int bFeet, int bIn, int quantity) {
		this.lFeet=lFeet; this.lIn=lIn; this.bFeet=bFeet; this.bIn=bIn; this.quantity=quantity;
		updateCFT();
	}

	public Log ( int lFeet, int lIn, int bFeet, int bIn, int quantity, double cft) {
			this.lFeet=lFeet; this.lIn=lIn; this.bFeet=bFeet; this.bIn=bIn; this.quantity=quantity;this.cft=cft;
	}

	public double getCFT(){
		return cft;
    }

    public void updateCFT(){
		double lengthIn, breadthIn, denominator, answerCFT, ft2in;
		denominator = 16;
		ft2in=12*12*12;

		lengthIn = lFeet * 12 + lIn;
		breadthIn = bFeet * 12 + bIn;

		answerCFT = (lengthIn * breadthIn * breadthIn * quantity)/(denominator*ft2in);
		cft = answerCFT;
	}

	public void updateLog(int lft, int lengthIn, int bft, int breadthIn, int quantity ){
		double denominator, answerCFT,ft2in;
		denominator = 16;
		ft2in=12*12*12;

        this.lFeet=lft; lIn=lengthIn; bFeet=bft; bIn= breadthIn; this.quantity=quantity;

		updateCFT();
	}

}