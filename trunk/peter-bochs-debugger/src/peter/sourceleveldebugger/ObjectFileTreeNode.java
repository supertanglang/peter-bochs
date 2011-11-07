package peter.sourceleveldebugger;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import com.petersoft.CommonLib;

public class ObjectFileTreeNode implements MutableTreeNode {
	File file;
	String name;
	Vector<ObjectFileTreeNode> children = new Vector<ObjectFileTreeNode>();

	public ObjectFileTreeNode(File file) {
		this.file = file;
	}

	public ObjectFileTreeNode(String name) {
		this.name = name;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return this.children.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return children.size();
	}

	@Override
	public TreeNode getParent() {
		// return new ObjectFileTreeNode(file.getParentFile());
		return null;
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
		return children.size() == 0 ? true : false;
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
		if (name != null) {
			return name;
		}
		return file.getName();
	}

}
