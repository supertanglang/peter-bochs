package peter.sourceleveldebugger;

import java.util.Vector;

import javax.swing.tree.MutableTreeNode;

public interface MyMutableTreeNode extends MutableTreeNode {

	public boolean isVisible();
	public void setVisible(boolean b);
	public Vector<MyMutableTreeNode> getChildren();
	public String toString();
}
