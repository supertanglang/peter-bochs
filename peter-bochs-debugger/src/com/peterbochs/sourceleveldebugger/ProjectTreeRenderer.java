package com.peterbochs.sourceleveldebugger;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.tree.TreeCellRenderer;

public class ProjectTreeRenderer extends JPanel implements TreeCellRenderer {
	ImageIcon rootIcon = new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/package.png"));
	ImageIcon fileIcon = new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/sourceleveldebugger/file.png"));
	ImageIcon fileCIcon = new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/sourceleveldebugger/file_c.png"));
	ImageIcon fileHIcon = new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/sourceleveldebugger/file_h.png"));
	//	ImageIcon archiveIcon = new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/package.png"));
	//	ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/image.png"));
	//	ImageIcon objectsIcon = new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/images.png"));
	//	ImageIcon libraryIcon = new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/book.png"));
	//	ImageIcon functionIcon = new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/page_white_cplusplus.png"));

	JLabel nameLabel = new JLabel();
	JLabel sizeLabel = new JLabel();

	public ProjectTreeRenderer() {
		setLayout(new BorderLayout());
		add(nameLabel, BorderLayout.CENTER);
		add(sizeLabel, BorderLayout.EAST);
		sizeLabel.setForeground(Color.LIGHT_GRAY);
	}

	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
		ProjectTreeNode node = (ProjectTreeNode) value;
		if (node == tree.getModel().getRoot()) {
			nameLabel.setIcon(rootIcon);
		} else if (node.file.getName().toLowerCase().endsWith("c") || node.file.getName().toLowerCase().endsWith("cpp")) {
			nameLabel.setIcon(fileCIcon);
		} else if (node.file.getName().toLowerCase().endsWith("h") || node.file.getName().toLowerCase().endsWith("hpp")) {
			nameLabel.setIcon(fileHIcon);
		} else {
			nameLabel.setIcon(fileIcon);
		}
		nameLabel.setText(node.toString());
		sizeLabel.setText(null);

		if (selected) {
			this.setBackground(UIManager.getColor("Tree.selectionBackground"));
			this.setBorder(new LineBorder(UIManager.getColor("Tree.selectionBorderColor"), 1));
		} else {
			this.setBackground(UIManager.getColor("Tree.background"));
			this.setBorder(new LineBorder(UIManager.getColor("Tree.background"), 1));
		}
		return this;
	}

	@Override
	public Dimension getPreferredSize() {
		Dimension nameLabelDimension = nameLabel.getPreferredSize();
		Dimension sizeLabelDimension = sizeLabel.getPreferredSize();

		return new Dimension(20 + nameLabelDimension.width + sizeLabelDimension.width, nameLabelDimension.height < sizeLabelDimension.height ? sizeLabelDimension.height
				: nameLabelDimension.height);
	}

}
