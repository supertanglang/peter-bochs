package peter.sourceleveldebugger;

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

import com.petersoft.CommonLib;

public class ObjectFileTreeRenderer extends JPanel implements TreeCellRenderer {
	ImageIcon rootIcon = new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/script.png"));
	ImageIcon archiveIcon = new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/package.png"));
	ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/image.png"));
	ImageIcon objectsIcon = new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/images.png"));
	ImageIcon libraryIcon = new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/book.png"));
	ImageIcon functionIcon = new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/page_white_cplusplus.png"));

	JLabel nameLabel = new JLabel();
	JLabel sizeLabel = new JLabel();

	public ObjectFileTreeRenderer() {
		setLayout(new BorderLayout());
		add(nameLabel, BorderLayout.CENTER);
		add(sizeLabel, BorderLayout.EAST);
		sizeLabel.setForeground(Color.LIGHT_GRAY);
	}

	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
		try {
			if (value instanceof ObjectFileTreeNode) {
				ObjectFileTreeNode node = (ObjectFileTreeNode) value;
				nameLabel.setIcon(objectIcon);
				nameLabel.setText(node.toString());
				sizeLabel.setText("  " + CommonLib.convertFilesize(node.file.length()));
			} else if (value instanceof ArchiveFileTreeNode) {
				ArchiveFileTreeNode node = (ArchiveFileTreeNode) value;
				nameLabel.setIcon(archiveIcon);
				nameLabel.setText(node.toString());
				sizeLabel.setText("  " + CommonLib.convertFilesize(node.file.length()));
			} else if (value instanceof TextTreeNode) {
				TextTreeNode node = (TextTreeNode) value;
				if (node.name.toLowerCase().endsWith(".map")) {
					nameLabel.setIcon(rootIcon);
				} else if (node.name.toLowerCase().startsWith("archive")) {
					nameLabel.setIcon(archiveIcon);
				} else if (node.name.toLowerCase().startsWith("objects")) {
					nameLabel.setIcon(objectsIcon);
				} else {
					nameLabel.setIcon(null);
				}
				nameLabel.setText(node.toString());
				sizeLabel.setText(null);
			} else if (value instanceof FunctionTreeNode) {
				FunctionTreeNode node = (FunctionTreeNode) value;
				nameLabel.setIcon(functionIcon);
				nameLabel.setText(node.toString());
				Symbol symbol = MapStructure.findSymbolByFilenameOrObjectName(node.toString());
				if (symbol != null) {
					sizeLabel.setText("0x" + Long.toHexString(symbol.memoryOffset));
				}
			} else {
				nameLabel.setIcon(null);
				nameLabel.setText(null);
				sizeLabel.setText(null);
			}

			if (selected) {
				this.setBackground(UIManager.getColor("Tree.selectionBackground"));
				this.setBorder(new LineBorder(UIManager.getColor("Tree.selectionBorderColor"), 1));
			} else {
				this.setBackground(UIManager.getColor("Tree.background"));
				this.setBorder(new LineBorder(UIManager.getColor("Tree.background"), 1));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
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
