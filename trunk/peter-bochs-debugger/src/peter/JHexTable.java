package peter;

import javax.swing.JTable;

public class JHexTable extends JTable {
	JHexTableModel model = new JHexTableModel();

	public JHexTableModel getModel() {
		return model;
	}

	public JHexTable() {
		 this.setModel(model);
//		 model.set(qw, row_count)
	}
}
