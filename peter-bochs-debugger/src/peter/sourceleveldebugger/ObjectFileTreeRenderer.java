package peter.sourceleveldebugger;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.tree.TreeCellRenderer;

import com.petersoft.CommonLib;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.BorderLayout;

public class ObjectFileTreeRenderer extends JPanel implements TreeCellRenderer {
	ImageIcon rootIcon = new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/script.png"));
	ImageIcon archiveIcon = new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/package.png"));
	ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/image.png"));
	ImageIcon objectsIcon = new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/images.png"));
	ImageIcon libraryIcon = new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/book.png"));

	JLabel nameLabel = new JLabel();
	JLabel sizeLabel = new JLabel();

	public ObjectFileTreeRenderer() {
		setLayout(new BorderLayout());
		add(nameLabel, BorderLayout.CENTER);
		add(sizeLabel, BorderLayout.EAST);
		sizeLabel.setForeground(Color.LIGHT_GRAY);
		this.setPreferredSize(new Dimension(170, 1));
	}

	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
		try {
			ObjectFileTreeNode node = (ObjectFileTreeNode) value;
			nameLabel.setText(node.toString());
			if (node.file != null) {
				sizeLabel.setText(CommonLib.convertFilesize(node.file.length()));
			} else {
				sizeLabel.setText("");
			}
			if (selected) {
				this.setBackground(UIManager.getColor("Tree.selectionBackground"));
				this.setBorder(new LineBorder(UIManager.getColor("Tree.selectionBorderColor"), 1));
			} else {
				this.setBackground(UIManager.getColor("Tree.background"));
				this.setBorder(new LineBorder(UIManager.getColor("Tree.background"), 1));
			}
			if (node.file == null) {
				if (node.name.toLowerCase().endsWith(".map")) {
					nameLabel.setIcon(rootIcon);
				} else if (node.name.toLowerCase().startsWith("archive")) {
					nameLabel.setIcon(archiveIcon);
				} else if (node.name.toLowerCase().startsWith("objects")) {
					nameLabel.setIcon(objectsIcon);
				} else {
					nameLabel.setIcon(null);
				}
			} else {
				if (node.file.getName().toLowerCase().endsWith(".a")) {
					nameLabel.setIcon(libraryIcon);
				} else if (node.file.getName().toLowerCase().endsWith(".o")) {
					nameLabel.setIcon(objectIcon);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return this;
	}

	@Override
	public Dimension getPreferredSize() {
		Dimension d_check = nameLabel.getPreferredSize();
		Dimension d_label = sizeLabel.getPreferredSize();
		return new Dimension(30 + d_check.width + d_label.width, (d_check.height < d_label.height ? d_label.height : d_check.height));
	}

}
