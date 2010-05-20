package peter.osdebuginformation;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.tree.DefaultMutableTreeNode;

public class FunctionTreeNode extends DefaultMutableTreeNode {
	String type;
	String text;
	Icon os = new ImageIcon(getClass().getClassLoader().getResource("images/OSDebug/os.png"));
	Icon kernel = new ImageIcon(getClass().getClassLoader().getResource("images/OSDebug/kernel.png"));
	Icon device = new ImageIcon(getClass().getClassLoader().getResource("images/OSDebug/device.png"));
	Icon fs = new ImageIcon(getClass().getClassLoader().getResource("images/OSDebug/fs.png"));
	Icon network = new ImageIcon(getClass().getClassLoader().getResource("images/OSDebug/network.png"));
	Icon process = new ImageIcon(getClass().getClassLoader().getResource("images/OSDebug/process.png"));
	Icon memory = new ImageIcon(getClass().getClassLoader().getResource("images/OSDebug/memory.png"));
	Icon table = new ImageIcon(getClass().getClassLoader().getResource("images/OSDebug/table.png"));
	Icon tag = new ImageIcon(getClass().getClassLoader().getResource("images/OSDebug/tag.png"));
	Icon library = new ImageIcon(getClass().getClassLoader().getResource("images/OSDebug/library.png"));

	public FunctionTreeNode(String text, String type) {
		this.text = text;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Icon getIcon() {
		if (type.equals("os")) {
			return os;
		} else if (type.equals("device")) {
			return device;
		} else if (type.equals("kernel")) {
			return kernel;
		} else if (type.equals("fs")) {
			return fs;
		} else if (type.equals("network")) {
			return network;
		} else if (type.equals("process")) {
			return process;
		} else if (type.equals("memory")) {
			return memory;
		} else if (type.equals("table")) {
			return table;
		} else if (type.equals("xml")) {
			return tag;
		} else if (type.equals("library")) {
			return library;
		} else {
			return null;
		}
	}

	public String toString() {
		return type;
	}

}
