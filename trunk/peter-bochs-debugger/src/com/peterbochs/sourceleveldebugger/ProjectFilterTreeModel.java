package com.peterbochs.sourceleveldebugger;

import javax.swing.tree.TreeModel;

import com.peterswing.FilterTreeModel;

public class ProjectFilterTreeModel extends FilterTreeModel {

	public boolean exactMatch;

	public ProjectFilterTreeModel(TreeModel delegate) {
		super(delegate);
	}

	@Override
	protected boolean isShown(Object node) {
		if (filter == null || filter.equals("")) {
			return true;
		}
		final ProjectTreeNode treeNode = (ProjectTreeNode) node;
		if (treeNode == null) {
			return false;
		} else if (!exactMatch && treeNode.toString().toLowerCase().contains(filter.toLowerCase())) {
			return true;
		} else if (exactMatch && treeNode.toString().toLowerCase().equals(filter.toLowerCase())) {
			return true;
		} else {
			return false;
		}
	}
}
