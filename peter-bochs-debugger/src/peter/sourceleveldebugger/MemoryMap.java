package peter.sourceleveldebugger;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

public class MemoryMap extends JLabel {
	public MapDataTableModel model;

	public void paint(Graphics g) {
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, getWidth(), getHeight());

		if (model != null) {
			double max = (double) MapStructure.symbols.get(MapStructure.symbols.size() - 1).memoryOffset;
			double min = (double) MapStructure.symbols.get(0).memoryOffset;
			double addressUnit = (max - min + 1) / this.getWidth();
			for (int x = 0; x < MapStructure.symbols.size(); x++) {
				try {
					int pixelX = (int) ((MapStructure.symbols.get(x).memoryOffset - min) / addressUnit);
					if (MapStructure.symbols.get(x).segment.equals(".text")) {
						g.setColor(Color.blue);
					} else if (MapStructure.symbols.get(x).segment.equals(".data")) {
						g.setColor(Color.red);
					} else if (MapStructure.symbols.get(x).segment.equals(".bss")) {
						g.setColor(Color.orange);
					} else if (MapStructure.symbols.get(x).segment.equals(".rodata")) {
						g.setColor(Color.yellow);
					} else if (MapStructure.symbols.get(x).segment.equals(".fill")) {
						g.setColor(Color.darkGray);
					}
					int width = (int) (MapStructure.symbols.get(x).length / addressUnit);
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
