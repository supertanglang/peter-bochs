package com.peterbochs.sourceleveldebugger;

import com.peterswing.advancedswing.enhancedtextarea.EnhancedTextArea;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class SourceDialog extends javax.swing.JDialog {
	public EnhancedTextArea enhancedTextArea1;

	public SourceDialog(JFrame frame, String title) {
		super(frame, title, true);
		initGUI();
	}

	private void initGUI() {
		try {
			{
				enhancedTextArea1 = new EnhancedTextArea();
				getContentPane().add(enhancedTextArea1, BorderLayout.CENTER);
				enhancedTextArea1.setText("enhancedTextArea1");
			}
			this.setSize(784, 570);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
