package com.peterbochs;

import javax.swing.JTable;

public class HexTable extends JTable {
	HexTableModel model = new HexTableModel();

	public HexTableModel getModel() {
		return model;
	}

	public HexTable() {
		this.setModel(model);

		// model.set(qw, row_count)
	}

	public boolean isCellSelected(int row, int column) {
		if (column == 0 || column == 9) {
			return false;
		} else {
			return super.isCellSelected(row, column);
		}
	}

}
