package com.peterbochs;

import java.awt.BorderLayout;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import com.peterswing.CommonLib;

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
public class LicenseDialog extends javax.swing.JDialog {
	private JScrollPane jScrollPane1;
	private JEditorPane jEditorPane1;

	public LicenseDialog(JFrame frame) {
		super(frame, true);
		initGUI();
	}

	private void initGUI() {
		try {
			{
				this.setTitle("License");
				{
					jScrollPane1 = new JScrollPane();
					getContentPane().add(jScrollPane1, BorderLayout.CENTER);
					{
						jEditorPane1 = new JEditorPane();
						URL url = getClass().getClassLoader().getResource("com/peterbochs/license.html");
						jEditorPane1.setPage(url);
						jScrollPane1.setViewportView(jEditorPane1);
					}
				}
			}
			this.setSize(577, 463);
			CommonLib.centerDialog(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
