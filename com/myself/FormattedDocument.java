package com.myself;

import javax.swing.*;
import javax.swing.text.*;

import java.awt.Toolkit;
import java.text.*;
import java.util.Locale;

public class FormattedDocument extends PlainDocument {
    private Format format;

    public FormattedDocument(Format f) {
        format = f;
    }

    public Format getFormat() {
        return format;
    }

    public void insertString(int offs, String str, AttributeSet a)
        throws BadLocationException {

        String currentText = getText(0, getLength());
        String beforeOffset = currentText.substring(0, offs);
        String afterOffset = currentText.substring(offs, currentText.length());
        String proposedResult = beforeOffset + str + afterOffset;
        //if (str.equalsIgnoreCase("\n"))System.out.println(" True its a enter");
        try {
            //format.parseObject(proposedResult);
            super.insertString(offs, str, a);
        } catch (//Parse
        Exception e) {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("FormattedDocument.insertString: could not parse: "
                               + proposedResult+ "  "+e);
        }
    }

    public void remove(int offs, int len) throws BadLocationException {
        String currentText = getText(0, getLength());
        String beforeOffset = currentText.substring(0, offs);
        String afterOffset = currentText.substring(len + offs,
                                                   currentText.length());
        String proposedResult = beforeOffset + afterOffset;

        try {
            //if (proposedResult.length() != 0)
                //format.parseObject(proposedResult);
            super.remove(offs, len);
        } catch (//Parse
        Exception e) {
            //Toolkit.getDefaultToolkit().beep();
            //System.err.println("bij remove: could not parse: " + proposedResult + " " +offs +" "+len+" "+ e);
        }
    }
}
