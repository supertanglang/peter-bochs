package peter;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;

import com.petersoft.CommonLib;

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
	private JLabel jLabel1;
	private JScrollPane jScrollPane1;

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
				getContentPane().setLayout(null);
				this.setTitle("About us");
				getContentPane().setBackground(new java.awt.Color(255, 255, 255));
				this.setResizable(false);
				{
					jScrollPane1 = new JScrollPane();
					getContentPane().add(jScrollPane1);
					jScrollPane1.setBounds(7, 263, 370, 95);
					{
						jTextArea1 = new JTextArea();
						jScrollPane1.setViewportView(jTextArea1);
						String str = "";
						str += "Website : http://code.google.com/p/peter-bochs\n";
						str += "Forum : http://groups.google.com/group/peter-bochs\n";
						str += "Contact : Peter (mcheung63@hotmail.com)\n";
						str += "Version: " + Global.version;
						jTextArea1.setText(str);
						jTextArea1.setEditable(false);
						jTextArea1.setMargin(new java.awt.Insets(20, 20, 20, 20));
						jTextArea1.setBackground(new java.awt.Color(255, 255, 255));
					}
				}
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jTextArea1.setBounds(12, 263, 360, 95);
				jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/peter-bochs-aboutbox.png")));
				jLabel1.setBounds(0, 12, 384, 356);
			}
			this.setSize(400, 400);
			CommonLib.centerDialog(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
