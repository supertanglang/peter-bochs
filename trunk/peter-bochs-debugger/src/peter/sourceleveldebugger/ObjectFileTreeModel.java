package peter.sourceleveldebugger;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class ObjectFileTreeModel implements TreeModel {
	ObjectFileTreeNode root;

	public ObjectFileTreeModel(ObjectFileTreeNode root) {
		this.root = root;
	}

	public void setRoot(ObjectFileTreeNode root) {
		this.root = root;
	}

	@Override
	public Object getRoot() {
		return root;
	}

	@Override
	public Object getChild(Object parent, int index) {
		return ((ObjectFileTreeNode) parent).getChildAt(index);
	}

	@Override
	public int getChildCount(Object parent) {
		return ((ObjectFileTreeNode) parent).getChildCount();
	}

	@Override
	public boolean isLeaf(Object node) {
		return ((ObjectFileTreeNode) node).isLeaf();
	}

	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {

	}

	@Override
	public int getIndexOfChild(Object parent, Object child) {
		return ((ObjectFileTreeNode) parent).getIndex((TreeNode) child);
	}

	@Override
	public void addTreeModelListener(TreeModelListener l) {
	}

	@Override
	public void removeTreeModelListener(TreeModelListener l) {

	}

}
