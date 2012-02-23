package com.peterbochs;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

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
public class TestJFrame extends javax.swing.JFrame {
	private JTabbedPane jTabbedPane1;
	private JPanel jPanel1;
	private JPanel jPanel5;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JTabbedPane jTabbedPane2;
	private JPanel jPanel2;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.petersoft.white.PetersoftWhiteLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TestJFrame inst = new TestJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public TestJFrame() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jTabbedPane1 = new JTabbedPane();
				getContentPane().add(jTabbedPane1, BorderLayout.CENTER);
				{
					jPanel1 = new JPanel();
					jTabbedPane1.addTab("jPanel1", null, jPanel1, null);
				}
				{
					jPanel2 = new JPanel();
					jTabbedPane1.addTab("jPanel2", null, jPanel2, null);
				}
				{
					jTabbedPane2 = new JTabbedPane();
					jTabbedPane1.addTab("jTabbedPane2", null, jTabbedPane2, null);
					jTabbedPane2.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
					jTabbedPane2.setTabPlacement(JTabbedPane.LEFT);
					{
						jPanel3 = new JPanel();
						jTabbedPane2.addTab("jPanel3", null, jPanel3, null);
					}
					{
						jPanel4 = new JPanel();
						jTabbedPane2.addTab("jPanel4", null, jPanel4, null);
					}
					{
						jPanel5 = new JPanel();
						jTabbedPane2.addTab("jPanel5", null, jPanel5, null);
					}
				}
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
