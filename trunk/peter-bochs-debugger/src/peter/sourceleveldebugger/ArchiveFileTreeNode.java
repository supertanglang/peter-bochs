package peter.sourceleveldebugger;

import java.io.File;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import com.petersoft.CommonLib;

public class ArchiveFileTreeNode implements MyMutableTreeNode {
	File file;
	Vector<MyMutableTreeNode> children = new Vector<MyMutableTreeNode>();
	public MutableTreeNode parent;
	boolean visible = true;

	public ArchiveFileTreeNode(File file) {
		this.file = file;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		int count = -1;
		for (MyMutableTreeNode node : children) {
			if (node.isVisible()) {
				count++;
			}
			if (count == childIndex) {
				return node;
			}

		}
		return null;
	}

	@Override
	public int getChildCount() {
		int count = 0;
		for (MyMutableTreeNode node : children) {
			if (node.isVisible()) {
				count++;
			}
		}
		return count;
	}

	@Override
	public TreeNode getParent() {
		return parent;
	}

	@Override
	public int getIndex(TreeNode node) {
		for (int x = 0; x < children.size(); x++) {
			if (children.get(x) == node) {
				return x;
			}
		}
		return -1;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public boolean isLeaf() {
		return children.size() == 0 || visible == false ? true : false;
	}

	@Override
	public Enumeration children() {
		return CommonLib.makeEnumeration(children.toArray());
	}

	@Override
	public void insert(MutableTreeNode child, int index) {
	}

	@Override
	public void remove(int indfileex) {
	}

	@Override
	public void remove(MutableTreeNode node) {
	}

	@Override
	public void setUserObject(Object object) {

	}

	@Override
	public void removeFromParent() {

	}

	@Override
	public void setParent(MutableTreeNode newParent) {

	}

	public String toString() {
		if (file != null) {
			return file.getName();
		} else {
			return "";
		}
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

	@Override
	public void setVisible(boolean b) {
		visible = b;
	}

	@Override
	public Vector<MyMutableTreeNode> getChildren() {
		return children;
	}

}
