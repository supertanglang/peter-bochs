package peter.instrument;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.media.opengl.GLCapabilities;
import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.ToolTipManager;

import net.masagroup.jzy3d.chart.Chart;
import net.masagroup.jzy3d.chart.controllers.ControllerEvent;
import net.masagroup.jzy3d.chart.controllers.ControllerEventListener;
import net.masagroup.jzy3d.chart.controllers.ControllerType;
import net.masagroup.jzy3d.chart.controllers.mouse.ChartMouseController;
import net.masagroup.jzy3d.colors.ColorMapper;
import net.masagroup.jzy3d.colors.colormaps.ColorMapRainbow;
import net.masagroup.jzy3d.maths.Coord3d;
import net.masagroup.jzy3d.maths.Scale;
import net.masagroup.jzy3d.plot3d.builder.Builder;
import net.masagroup.jzy3d.plot3d.primitives.Shape;
import net.masagroup.jzy3d.plot3d.primitives.faces.ColorbarFace;
import net.masagroup.jzy3d.plot3d.rendering.canvas.Quality;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.LookupPaintScale;
import org.jfree.chart.renderer.xy.XYBlockRenderer;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class InstrumentPanel extends JPanel {
	private JTabbedPane jTabbedPane1;
	private JPanel jSocketPanel;
	private JScrollPane jScrollPane1;
	private JPanel jMemoryPanel;
	private JTextArea jSocketTextArea;
	private ChartPanel jMemoryChartPanel;
	private JFreeChart jfcMemory;
	private JPanel jMemory3DPanel;

	public InstrumentPanel() {
		initGUI();
	}

	private void initGUI() {
		try {
			{
				BorderLayout thisLayout = new BorderLayout();
				this.setLayout(thisLayout);
				this.setPreferredSize(new java.awt.Dimension(329, 144));
				{
					jTabbedPane1 = new JTabbedPane();
					this.add(jTabbedPane1, BorderLayout.CENTER);
					jTabbedPane1.setTabPlacement(JTabbedPane.LEFT);
					jTabbedPane1.setPreferredSize(new java.awt.Dimension(329, 144));
					{
						jSocketPanel = new JPanel();
						GroupLayout jSocketPanelLayout = new GroupLayout((JComponent) jSocketPanel);
						jSocketPanel.setLayout(jSocketPanelLayout);
						jTabbedPane1.addTab("Socket", null, jSocketPanel, null);
						{
							jScrollPane1 = new JScrollPane();
							{
								jSocketTextArea = new JTextArea();
								jScrollPane1.setViewportView(jSocketTextArea);
							}
						}
						jSocketPanelLayout.setHorizontalGroup(jSocketPanelLayout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, 0, 249, Short.MAX_VALUE)
								.addContainerGap());
						jSocketPanelLayout.setVerticalGroup(jSocketPanelLayout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, 0, 115, Short.MAX_VALUE)
								.addContainerGap());
					}
					{
						jMemoryPanel = new JPanel();
						GroupLayout jMemoryPanelLayout = new GroupLayout((JComponent) jMemoryPanel);
						jMemoryPanel.setLayout(jMemoryPanelLayout);
						jTabbedPane1.addTab("Memory", null, jMemoryPanel, null);
						{
							// jfcMemory = ChartFactory.createLineChart("title",
							// "address", "count", null,
							// PlotOrientation.VERTICAL, true, true, true);
							jfcMemory = createChart(createDataset());
							// CategoryPlot pp = (CategoryPlot)
							// jfcMemory.getPlot();
							jMemoryChartPanel = new ChartPanel(jfcMemory);
						}
						jTabbedPane1.addTab("Memory 3D", null, getJMemory3DPanel(), null);
						jMemoryPanelLayout.setHorizontalGroup(jMemoryPanelLayout.createSequentialGroup().addContainerGap().addComponent(jMemoryChartPanel, 0, 227, Short.MAX_VALUE)
								.addContainerGap());
						jMemoryPanelLayout.setVerticalGroup(jMemoryPanelLayout.createSequentialGroup().addContainerGap().addComponent(jMemoryChartPanel, 0, 113, Short.MAX_VALUE)
								.addContainerGap());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ToolTipManager.sharedInstance().setInitialDelay(0);
	}

	private static JFreeChart createChart(XYZDataset dataset) {
		NumberAxis xAxis = new NumberAxis("address (" + Data.blockSize + " KB)");
		xAxis.setLowerMargin(0.0);
		xAxis.setUpperMargin(0.0);
		NumberAxis yAxis = new NumberAxis("address (" + Data.blockSize + " KB)");
		yAxis.setAutoRangeIncludesZero(false);
		yAxis.setInverted(true);
		yAxis.setLowerMargin(0.0);
		yAxis.setUpperMargin(0.0);
		yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		XYBlockRenderer renderer = new XYBlockRenderer();
		XYPlot plot = new XYPlot(dataset, xAxis, yAxis, renderer);

		// plot.setBackgroundPaint(Color.white);
		plot.setDomainGridlineStroke(new BasicStroke(1));
		plot.setDomainGridlinePaint(Color.black);

		plot.setRangeGridlineStroke(new BasicStroke(1));
		plot.setRangeGridlinePaint(Color.black);
		plot.setForegroundAlpha(0.8f);

		JFreeChart chart = new JFreeChart("Memory read/write hot zone", new Font("Serif", Font.PLAIN, 12), plot, true);
		chart.removeLegend();
		chart.setBackgroundPaint(Color.white);
		return chart;
	}

	public JTextArea getjSocketTextArea() {
		return jSocketTextArea;
	}

	private static XYZDataset createEmptyDataset() {
		DefaultXYZDataset dataset = new DefaultXYZDataset();
		return dataset;
	}

	private int findLargest(int data[]) {
		int largest = Integer.MIN_VALUE;
		for (int x = 0; x < data.length; x++) {
			if (data[x] > largest) {
				largest = data[x];
			}
		}
		return largest;
	}

	private static XYZDataset createDataset() {
		double[] xvalues = new double[Data.totalColumn * Data.totalRow];
		double[] yvalues = new double[Data.totalColumn * Data.totalRow];
		double[] zvalues = new double[Data.totalColumn * Data.totalRow];
		double[][] data = new double[][] { xvalues, yvalues, zvalues };

		// set the default z-value to zero throughout the data array.
		for (int y = 0; y < Data.totalRow; y++) {
			for (int x = 0; x < Data.totalColumn; x++) {
				setValue(data, x, y, 0.0);
			}
		}

		int dataB[] = Data.getData();
		for (int index = 0; index < dataB.length; index++) {
			int y = index / Data.totalColumn;
			int x = index - (y * Data.totalColumn);
			if (dataB[index] > 1000) {
				// System.out.println(x + "," + y + "=" + dataB[index]);
				setValue(data, x, y, dataB[index]);
			}
		}
		System.out.println("end");

		DefaultXYZDataset dataset = new DefaultXYZDataset();
		dataset.addSeries("read/write count", data);
		return dataset;
	}

	private static void setValue(double[][] data, int x, int y, double value) {
		data[0][y * Data.totalColumn + x] = x;
		data[1][y * Data.totalColumn + x] = y;
		data[2][y * Data.totalColumn + x] = value;
	}

	public void updateChart() {
		// jfcMemory.getCategoryPlot().setDataset(createMemoryDataset());
		jfcMemory.getXYPlot().setDataset(createDataset());
		XYBlockRenderer renderer = new XYBlockRenderer();
		int largest = findLargest(Data.getData());
		if (largest == 0) {
			largest = 1;
		}
		System.out.println("largest=" + largest);
		LookupPaintScale paintScale = new LookupPaintScale(0, largest, Color.darkGray);
		paintScale.add(1, Color.green);
		if (largest > 1) {
			paintScale.add(largest / 4, Color.yellow);
			paintScale.add(largest / 4 * 2, Color.orange);
			paintScale.add(largest / 4 * 3, Color.red);
		}
		renderer.setPaintScale(paintScale);
		jfcMemory.getXYPlot().setRenderer(renderer);
		System.out.println("largest end");
		// jfcMemory.getXYPlot()
	}

	private JPanel getJMemory3DPanel() {
		if (jMemory3DPanel == null) {
			jMemory3DPanel = new JPanel();
			GroupLayout jMemory3DPanelLayout = new GroupLayout((JComponent) jMemory3DPanel);
			jMemory3DPanel.setLayout(jMemory3DPanelLayout);

			try {
				Chart chart = getMemory3DChart();
				ChartMouseController mouse = new ChartMouseController();
				mouse.addControllerEventListener(new ControllerEventListener() {
					public void controllerEventFired(ControllerEvent e) {
						if (e.getType() == ControllerType.ROTATE) {
							// System.out.println("Mouse[ROTATE]:" +
							// (Coord3d)e.getValue());
						}
					}
				});
				chart.addController(mouse);

				jMemory3DPanelLayout.setHorizontalGroup(jMemory3DPanelLayout.createSequentialGroup().addContainerGap().addComponent((Component) chart.getCanvas(), 0, 220,
						Short.MAX_VALUE).addContainerGap());
				jMemory3DPanelLayout.setVerticalGroup(jMemory3DPanelLayout.createSequentialGroup().addContainerGap().addComponent((Component) chart.getCanvas(), 0, 116,
						Short.MAX_VALUE).addContainerGap());

				GLCapabilities glCapabilities = new GLCapabilities();
				glCapabilities.setHardwareAccelerated(true);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
		return jMemory3DPanel;
	}

	public static Chart getMemory3DChart() throws IOException {
		System.out.println(Data.totalColumn + "x" + Data.totalRow);
		List<Coord3d> coords = new ArrayList<Coord3d>();// SphereScatterGenerator.generate(new
		// Coord3d(10, 20, 30),
		// 10000, 20, true);

		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				coords.add(new Coord3d(x, y, Math.abs(100 * x * Math.sin(y))));
			}
		}

		// Create the object to represent the function over the given range.
		final Shape surface = (Shape) Builder.buildDelaunay(coords);
		surface.setColorMapper(new ColorMapper(new ColorMapRainbow(), surface.getBounds().getZmin(), surface.getBounds().getZmax(), new net.masagroup.jzy3d.colors.Color(1, 1, 1,
				.5f)));
		surface.setFaceDisplayed(true);
		surface.setWireframeDisplayed(true);
		surface.setWireframeColor(net.masagroup.jzy3d.colors.Color.BLACK);

		// Create a chart that updates the surface colormapper when scaling
		// changes
		Chart chart = new Chart(Quality.Intermediate) {
			public void setScale(Scale scale) {
				super.setScale(scale);
				ColorMapper cm = surface.getColorMapper();
				cm.setScale(scale);
				surface.setColorMapper(cm);
			}
		};
		chart.getScene().getGraph().add(surface);

		// Setup a colorbar for the surface object and add it to the scene
		surface.setFace(new ColorbarFace(surface, chart.getView().getAxe().getLayout().getZTickProvider(), chart.getView().getAxe().getLayout().getZTickRenderer()));
		surface.setFace2dDisplayed(true);

		return chart;
	}

}
