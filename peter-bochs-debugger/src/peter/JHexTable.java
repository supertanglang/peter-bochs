package peter;

import javax.swing.JTable;

public class JHexTable extends JTable {
	JHexTableModel model = new JHexTableModel();

	public JHexTableModel getModel() {
		return model;
	}

	public JHexTable() {
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
