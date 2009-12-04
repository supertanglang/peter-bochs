package peter;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
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
public class JAboutUsDialog extends javax.swing.JDialog {
	private JTextArea jTextArea1;

	/**
	 * Auto-generated main method to display this JDialog
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				JAboutUsDialog inst = new JAboutUsDialog(frame);
				inst.setVisible(true);
			}
		});
	}

	public JAboutUsDialog(JFrame frame) {
		super(frame);
		initGUI();
	}

	private void initGUI() {
		try {
			{
				this.setTitle("About us");
			}
			{
				jTextArea1 = new JTextArea();
				getContentPane().add(jTextArea1, BorderLayout.CENTER);
				String str = "";
				str += "\n\nWebsite : http://code.google.com/p/peter-bochs\n\n";
				str += "Forum : http://groups.google.com/group/peter-bochs\n\n";
				str += "Contact : Peter (mcheung63@hotmail.com)\n\n";
				str += "Version: " + Global.version;
				jTextArea1.setText(str);
				jTextArea1.setEditable(false);
				jTextArea1.setMargin(new java.awt.Insets(20, 20, 20, 20));
				jTextArea1.setBackground(new java.awt.Color(255,255,255));
			}
			setSize(400, 300);
			CommonLib.centerDialog(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
