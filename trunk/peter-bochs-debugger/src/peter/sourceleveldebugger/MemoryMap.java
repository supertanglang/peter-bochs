package peter.sourceleveldebugger;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import com.petersoft.CommonLib;

public class MemoryMap extends JLabel {
	public MapDataTableModel model;

	public void paint(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(0, 0, getWidth(), getHeight());

		if (model != null) {
			double fourGb = (double) 4 * 1024 * 1024 * 1024;
			double addressUnit = fourGb / this.getWidth();
			for (int x = 0; x < model.locations.size(); x++) {
				try {
					int pixelX = (int) (CommonLib.string2decimal(model.locations.get(x)) / addressUnit);
					g.setColor(Color.blue);
					int width = (int) (CommonLib.string2decimal(model.lengths.get(x)) / addressUnit);
					if (width == 0) {
						width = 1;
					}
					g.fillRect(pixelX, 0, width, getHeight());
				} catch (Exception ex) {
				}
			}
		}
	}
}
