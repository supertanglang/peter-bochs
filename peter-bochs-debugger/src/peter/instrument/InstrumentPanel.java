package peter.instrument;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeSet;

import javax.media.opengl.GLCapabilities;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import net.masagroup.jzy3d.chart.Chart;
import net.masagroup.jzy3d.chart.controllers.ControllerEvent;
import net.masagroup.jzy3d.chart.controllers.ControllerEventListener;
import net.masagroup.jzy3d.chart.controllers.ControllerType;
import net.masagroup.jzy3d.chart.controllers.mouse.ChartMouseController;
import net.masagroup.jzy3d.colors.ColorMapper;
import net.masagroup.jzy3d.colors.colormaps.ColorMapRainbow;
import net.masagroup.jzy3d.maths.Coord3d;
import net.masagroup.jzy3d.plot3d.builder.Builder;
import net.masagroup.jzy3d.plot3d.primitives.Drawable;
import net.masagroup.jzy3d.plot3d.primitives.Shape;
import net.masagroup.jzy3d.plot3d.rendering.canvas.Quality;

import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.event.ChartChangeEvent;
import org.jfree.chart.event.ChartChangeListener;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.LookupPaintScale;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;

import peter.CommonLib;
import peter.Setting;
import peter.instrument.jfreechart.MyXYBlockRenderer;
import peter.instrument.jfreechart.MyXYToolTipGenerator;

import com.petersoft.advancedswing.searchtextfield.JSearchTextField;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used commercially (ie, by a
 * corporation, company or business for any purpose whatever) then you should purchase a license for each developer using Jigloo. Please visit www.cloudgarden.com for details. Use
 * of Jigloo implies acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR ANY
 * CORPORATE OR COMMERCIAL PURPOSE.
 */
public class InstrumentPanel extends JPanel implements ChartChangeListener, ChartMouseListener {
	private JTabbedPane jTabbedPane1;
	private JPanel jSocketPanel;
	private JScrollPane jScrollPane1;
	private JPanel jMemoryPanel;
	private JButton jDeleteZoneButton;
	private JButton jAddZoneButton;
	private JScrollPane jScrollPane2;
	private JTable jProfilingTable;
	private JComboBox jProfilingToComboBox;
	private JLabel jLabel9;
	private JComboBox jProfilingFromComboBox;
	private JLabel jLabel8;
	private JLabel jLabel7;
	private JPanel jMemoryProfilingPanel;
	private JTabbedPane jTabbedPane2;
	private JLabel jLabel4;
	public static JComboBox jFromComboBox;
	private JButton jZoomInButton;
	private JButton jZoomOutButton;
	private JTextArea jSocketTextArea;
	private ChartPanel jMemoryChartPanel;
	private JFreeChart jfcMemory;
	private JPanel jMemory3DPanel;
	private JButton jZoomOutAutoRangeButton;
	private JLabel jRWCountLabel;
	private JLabel jAddressLabel;
	private JSearchTextField jSearchTextField;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JTable jHotestAddressTable;
	private JScrollPane jHostestAddressScrollPane;
	private JLabel jLabel1;
	public static JComboBox jBlockSizeComboBox;
	private JLabel jLabel5;
	public static JComboBox jToComboBox;
	private JLabel jLabel6;
	private JPanel jPanel1;
	Color background = new Color(250, 250, 250);
	static Chart chart;

	public InstrumentPanel() {
		initGUI();
	}

	private void initGUI() {
		try {
			{
				BorderLayout thisLayout = new BorderLayout();
				this.setLayout(thisLayout);
				this.setPreferredSize(new java.awt.Dimension(808, 448));
				{
					jTabbedPane1 = new JTabbedPane();
					this.add(jTabbedPane1, BorderLayout.CENTER);
					jTabbedPane1.setTabPlacement(JTabbedPane.LEFT);
					jTabbedPane1.setPreferredSize(new java.awt.Dimension(661, 419));
					{
						jMemoryPanel = new JPanel();
						GroupLayout jMemoryPanelLayout = new GroupLayout((JComponent) jMemoryPanel);
						jMemoryPanel.setLayout(jMemoryPanelLayout);
						jTabbedPane1.addTab("Memory", null, jMemoryPanel, null);
						jTabbedPane1.addTab("Profiling", null, getJMemoryProfilingPanel(), null);
						jMemoryPanelLayout.setVerticalGroup(jMemoryPanelLayout.createSequentialGroup().addContainerGap().addGroup(
								jMemoryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(getJFromComboBox(), GroupLayout.Alignment.BASELINE,
										GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE).addComponent(getJLabel4x(), GroupLayout.Alignment.BASELINE,
										GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(getJLabel6(),
										GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(
										getJToComboBox(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE).addComponent(getJLabel5x(),
										GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(
										getJBlockSizeComboBox(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE).addComponent(
										getJLabel3(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(getJSearchTextField(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(getJTabbedPane2(), 0, 224, Short.MAX_VALUE).addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED).addGroup(
										jMemoryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(getJLabel1(), GroupLayout.Alignment.BASELINE,
												GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(getJLabel2(),
												GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(
										jMemoryPanelLayout.createParallelGroup().addComponent(getJHostestAddressScrollPane(), GroupLayout.Alignment.LEADING,
												GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE).addGroup(
												GroupLayout.Alignment.LEADING,
												jMemoryPanelLayout.createSequentialGroup().addComponent(getJLabel4(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE,
														GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(getJLabel5(),
														GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE).addGap(74))).addComponent(getJPanel1(),
										GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE).addContainerGap());
						jMemoryPanelLayout.linkSize(SwingConstants.VERTICAL,
								new Component[] { getJSearchTextField(), getJFromComboBox(), getJToComboBox(), getJBlockSizeComboBox() });
						jMemoryPanelLayout.setHorizontalGroup(jMemoryPanelLayout.createSequentialGroup().addContainerGap().addGroup(
								jMemoryPanelLayout.createParallelGroup().addGroup(
										jMemoryPanelLayout.createSequentialGroup().addGroup(
												jMemoryPanelLayout.createParallelGroup().addGroup(
														GroupLayout.Alignment.LEADING,
														jMemoryPanelLayout.createSequentialGroup().addComponent(getJLabel3(), GroupLayout.PREFERRED_SIZE, 70,
																GroupLayout.PREFERRED_SIZE).addComponent(getJSearchTextField(), GroupLayout.PREFERRED_SIZE, 151,
																GroupLayout.PREFERRED_SIZE)).addGroup(
														GroupLayout.Alignment.LEADING,
														jMemoryPanelLayout.createSequentialGroup().addComponent(getJLabel2(), GroupLayout.PREFERRED_SIZE, 96,
																GroupLayout.PREFERRED_SIZE).addGap(125)).addGroup(
														GroupLayout.Alignment.LEADING,
														jMemoryPanelLayout.createSequentialGroup().addComponent(getJPanel1(), GroupLayout.PREFERRED_SIZE, 182,
																GroupLayout.PREFERRED_SIZE).addGap(39)).addGroup(
														jMemoryPanelLayout.createSequentialGroup().addPreferredGap(getJLabel2(), getJLabel4(),
																LayoutStyle.ComponentPlacement.INDENT).addGroup(
																jMemoryPanelLayout.createParallelGroup().addComponent(getJLabel4(), GroupLayout.Alignment.LEADING,
																		GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE).addComponent(getJLabel5(),
																		GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)).addGap(49)))
												.addGroup(
														jMemoryPanelLayout.createParallelGroup().addComponent(getJHostestAddressScrollPane(), GroupLayout.Alignment.LEADING, 0,
																498, Short.MAX_VALUE).addGroup(
																GroupLayout.Alignment.LEADING,
																jMemoryPanelLayout.createSequentialGroup().addGroup(
																		jMemoryPanelLayout.createParallelGroup().addGroup(
																				GroupLayout.Alignment.LEADING,
																				jMemoryPanelLayout.createSequentialGroup().addPreferredGap(getJLabel1(), getJLabel4x(),
																						LayoutStyle.ComponentPlacement.INDENT).addComponent(getJLabel4x(),
																						GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(getJFromComboBox(),
																								GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)).addGroup(
																				GroupLayout.Alignment.LEADING,
																				jMemoryPanelLayout.createSequentialGroup().addComponent(getJLabel1(), GroupLayout.PREFERRED_SIZE,
																						112, GroupLayout.PREFERRED_SIZE).addGap(80))).addComponent(getJLabel6(),
																		GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE).addComponent(getJToComboBox(),
																		GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE).addPreferredGap(
																		LayoutStyle.ComponentPlacement.RELATED, 0, GroupLayout.PREFERRED_SIZE).addComponent(getJLabel5x(),
																		GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE).addComponent(getJBlockSizeComboBox(),
																		GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE).addGap(0, 9, Short.MAX_VALUE)))).addComponent(
										getJTabbedPane2(), GroupLayout.Alignment.LEADING, 0, 719, Short.MAX_VALUE)).addContainerGap());
						jMemoryPanelLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] { getJFromComboBox(), getJToComboBox() });
					}
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
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ToolTipManager.sharedInstance().setInitialDelay(0);
	}

	private static JFreeChart createChart(XYZDataset dataset) {
		NumberAxis xAxis = new NumberAxis("address (" + jBlockSizeComboBox.getSelectedItem() + ")");
		xAxis.setLowerMargin(0.0);
		xAxis.setUpperMargin(0.0);
		xAxis.setAxisLinePaint(Color.cyan);
		xAxis.setTickMarkPaint(Color.cyan);
		// xAxis.setAutoTickUnitSelection(false);
		// xAxis.setTickUnit(new NumberTickUnit(1));
		// NumberFormat nf = NumberFormat.getPercentInstance();
		// xAxis.setNumberFormatOverride(nf);
		// xAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		NumberAxis yAxis = new NumberAxis("address (" + jBlockSizeComboBox.getSelectedItem() + " KB)");
		// yAxis.setAutoRangeIncludesZero(true);
		// yAxis.setInverted(false);
		yAxis.setLowerMargin(0.0);
		yAxis.setUpperMargin(0.0);
		yAxis.setAxisLinePaint(Color.pink);
		yAxis.setTickMarkPaint(Color.pink);
		// yAxis.setTickUnit(new NumberTickUnit(10));
		// yAxis.setTickLabelFont(new Font("Dialog", 0, 7));
		// yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		MyXYBlockRenderer renderer = new MyXYBlockRenderer();
		XYPlot plot = new XYPlot(dataset, xAxis, yAxis, renderer);

		// plot.setBackgroundPaint(Color.white);
		// plot.setDomainGridlineStroke(new BasicStroke(1));
		plot.setDomainGridlinePaint(Color.white);

		// plot.setRangeGridlineStroke(new BasicStroke(1));
		plot.setRangeGridlinePaint(Color.white);

		// JFreeChart chart = new JFreeChart("Memory read/write hot zone", new
		// Font("Serif", Font.PLAIN, 12), plot, true);
		JFreeChart chart = new JFreeChart("Memory read/write hot zone", plot);
		chart.removeLegend();
		chart.setBackgroundPaint(Color.white);

		return chart;
	}

	public JTextArea getjSocketTextArea() {
		return jSocketTextArea;
	}

	private static JFreeChart createEmptyChart(XYZDataset dataset) {
		NumberAxis xAxis = new NumberAxis("address");
		xAxis.setLowerMargin(0.0);
		xAxis.setUpperMargin(0.0);
		NumberAxis yAxis = new NumberAxis("address");
		yAxis.setAutoRangeIncludesZero(false);
		yAxis.setInverted(false);
		yAxis.setLowerMargin(0.0);
		yAxis.setUpperMargin(0.0);
		// yAxis.setAxisLinePaint(Color.pink);
		// yAxis.setTickMarkPaint(Color.white);
		yAxis.setTickLabelFont(new Font("Dialog", 0, 7));
		yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		MyXYBlockRenderer renderer = new MyXYBlockRenderer();
		XYPlot plot = new XYPlot(dataset, xAxis, yAxis, renderer);

		// plot.setBackgroundPaint(Color.white);
		// plot.setDomainGridlineStroke(new BasicStroke(1));
		plot.setDomainGridlinePaint(Color.white);

		// plot.setRangeGridlineStroke(new BasicStroke(1));
		plot.setRangeGridlinePaint(Color.white);

		JFreeChart chart = new JFreeChart("Memory read/write hot zone", new Font("Serif", Font.PLAIN, 12), plot, true);
		chart.removeLegend();
		chart.setBackgroundPaint(Color.white);

		return chart;
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
		long rowCount = Data.getRowCount(CommonLib.convertFilesize((String) jFromComboBox.getSelectedItem()), CommonLib.convertFilesize((String) jToComboBox.getSelectedItem()),
				CommonLib.convertFilesize((String) jBlockSizeComboBox.getSelectedItem()));
		long columnCount = Data.getColumnCount(CommonLib.convertFilesize((String) jFromComboBox.getSelectedItem()), CommonLib.convertFilesize((String) jToComboBox
				.getSelectedItem()), CommonLib.convertFilesize((String) jBlockSizeComboBox.getSelectedItem()));
		double[] xvalues = new double[(int) (columnCount * rowCount)];
		double[] yvalues = new double[(int) (columnCount * rowCount)];
		double[] zvalues = new double[(int) (columnCount * rowCount)];
		double[][] data = new double[][] { xvalues, yvalues, zvalues };

		// set the default z-value to zero throughout the data array.
		for (int y = 0; y < rowCount; y++) {
			for (int x = 0; x < columnCount; x++) {
				setValue(data, x, y, 0.0);
			}
		}

		int dataB[] = Data.getChartData(CommonLib.convertFilesize((String) jFromComboBox.getSelectedItem()), CommonLib.convertFilesize((String) jToComboBox.getSelectedItem()),
				CommonLib.convertFilesize((String) jBlockSizeComboBox.getSelectedItem()));
		for (int index = 0; index < dataB.length; index++) {
			int y = (int) (index / columnCount);
			int x = (int) (index - (y * columnCount));
			setValue(data, x, y, dataB[index]);
		}

		DefaultXYZDataset dataset = new DefaultXYZDataset();
		dataset.addSeries("read/write count", data);
		return dataset;
	}

	private static void setValue(double[][] data, int x, int y, double value) {
		long columnCount = Data.getColumnCount(CommonLib.convertFilesize((String) jFromComboBox.getSelectedItem()), CommonLib.convertFilesize((String) jToComboBox
				.getSelectedItem()), CommonLib.convertFilesize((String) jBlockSizeComboBox.getSelectedItem()));
		data[0][(int) (y * columnCount + x)] = x;
		data[1][(int) (y * columnCount + x)] = y;
		data[2][(int) (y * columnCount + x)] = value;
	}

	public void updateChart() {
		update2DChart();
		update3DChart();
	}

	public void update2DChart() {
		// jfcMemory.getCategoryPlot().setDataset(createMemoryDataset());
		jfcMemory.getXYPlot().setDataset(createDataset());
		MyXYBlockRenderer renderer = (MyXYBlockRenderer) jfcMemory.getXYPlot().getRenderer();
		int largest = findLargest(Data.getChartData(CommonLib.convertFilesize((String) jFromComboBox.getSelectedItem()), CommonLib.convertFilesize((String) jToComboBox
				.getSelectedItem()), CommonLib.convertFilesize((String) jBlockSizeComboBox.getSelectedItem())));
		if (largest == 0) {
			largest = 1;
		}
		LookupPaintScale paintScale = new LookupPaintScale(0, largest, background);
		if (largest > 1) {
			// int mean =
			// medianWithoutZero(Data.getChartData(CommonLib.convertFilesize((String)
			// jFromComboBox.getSelectedItem()),
			// CommonLib.convertFilesize((String) jToComboBox
			// .getSelectedItem())));
			int m[] = Data.getChartData(CommonLib.convertFilesize((String) jFromComboBox.getSelectedItem()), CommonLib.convertFilesize((String) jToComboBox.getSelectedItem()),
					CommonLib.convertFilesize((String) jBlockSizeComboBox.getSelectedItem()));
			TreeSet<Integer> data = new TreeSet<Integer>();
			for (int x = 0; x < m.length; x++) {
				if (m[x] > 0) {
					data.add(m[x]);
				}
			}

			// paintScale.add(0, Color.white);
			ArrayList<Color> allColors = allColors();
			Object iData[] = data.toArray();
			paintScale.add(1, allColors.get(0));
			for (int x = 1; x < iData.length - 1; x++) {
				paintScale.add((int) (Integer) iData[x], allColors.get(allColors.size() / iData.length * x));
			}
			paintScale.add((int) (Integer) iData[iData.length - 1], allColors.get(allColors.size() - 1));
		}
		renderer.setPaintScale(paintScale);
		renderer.setBaseToolTipGenerator(new MyXYToolTipGenerator());
		jfcMemory.getXYPlot().setForegroundAlpha(1f);
		jZoomOutAutoRangeButtonActionPerformed(null);
	}

	public void update3DChart() {
		long rowCount = Data.getRowCount(CommonLib.convertFilesize((String) jFromComboBox.getSelectedItem()), CommonLib.convertFilesize((String) jToComboBox.getSelectedItem()),
				CommonLib.convertFilesize((String) jBlockSizeComboBox.getSelectedItem()));
		long columnCount = Data.getColumnCount(CommonLib.convertFilesize((String) jFromComboBox.getSelectedItem()), CommonLib.convertFilesize((String) jToComboBox
				.getSelectedItem()), CommonLib.convertFilesize((String) jBlockSizeComboBox.getSelectedItem()));

		List<Coord3d> coords = new ArrayList<Coord3d>();// SphereScatterGenerator.generate(new
		int dataB[] = Data.getChartData(CommonLib.convertFilesize((String) jFromComboBox.getSelectedItem()), CommonLib.convertFilesize((String) jToComboBox.getSelectedItem()),
				CommonLib.convertFilesize((String) jBlockSizeComboBox.getSelectedItem()));

		Random r = new Random();
		System.out.println(columnCount + "==" + rowCount);
		for (int x = 0; x < columnCount; x++) {
			for (int y = 0; y < rowCount; y++) {
				int index = (int) (x + y * columnCount);
				if (index < dataB.length) {
					coords.add(new Coord3d(x, y, dataB[index]));
				}
				// coords.add(new Coord3d(x, y, r.nextInt(100)));
			}
		}

		// Create the object to represent the function over the given range.
		final Shape surface = (Shape) Builder.buildDelaunay(coords);
		surface.setColorMapper(new ColorMapper(new ColorMapRainbow(), surface.getBounds().getZmin(), surface.getBounds().getZmax(), new net.masagroup.jzy3d.colors.Color(1, 1, 1,
				.5f)));
		surface.setFaceDisplayed(true);
		surface.setWireframeDisplayed(true);
		surface.setWireframeColor(net.masagroup.jzy3d.colors.Color.BLACK);

		for (Iterator<Drawable> it = chart.getScene().getGraph().getAll().iterator(); it.hasNext();) {
			it.next();
			it.remove();
		}
		chart.getScene().getGraph().add(surface);
	}

	public ArrayList<Color> allColors() {
		ArrayList<Color> allColors = new ArrayList<Color>();
		for (int b = 0; b <= 255; b++) {
			allColors.add(new Color(b, 0, 255 - b));
		}
		// for (int b = 0; b <= 255; b++) {
		// allColors.add(new Color(0, 255, b));
		// }
		// for (int g = 255; g >= 0; g--) {
		// allColors.add(new Color(255, g, 255));
		// }
		// for (int r = 0; r <= 255; r++) {
		// allColors.add(new Color(r, 0, 255));
		// }
		// for (int b = 255; b >= 0; b--) {
		// allColors.add(new Color(255, 0, b));
		// }
		return allColors;
	}

	public static int median(int[] m) {
		int middle = m.length / 2; // subscript of middle element
		if (m.length % 2 == 1) {
			// Odd number of elements -- return the middle one.
			return m[middle];
		} else {
			// Even number -- return average of middle two
			// Must cast the numbers to double before dividing.
			return (m[middle - 1] + m[middle]) / 2;
		}
	}

	public static int medianWithoutZero(int[] m) {
		ArrayList<Integer> data = new ArrayList<Integer>();
		for (int x = 0; x < m.length; x++) {
			if (m[x] > 0) {
				data.add(m[x]);
			}
		}
		int middle = data.size() / 2; // subscript of middle element
		if (data.size() % 2 == 1) {
			// Odd number of elements -- return the middle one.
			return data.get(middle);
		} else {
			// Even number -- return average of middle two
			// Must cast the numbers to double before dividing.
			return (data.get(middle - 1) + data.get(middle)) / 2;
		}
	}

	private JPanel getJMemory3DPanel() {
		if (jMemory3DPanel == null) {
			jMemory3DPanel = new JPanel();
			GroupLayout jMemory3DPanelLayout = new GroupLayout((JComponent) jMemory3DPanel);
			jMemory3DPanel.setLayout(jMemory3DPanelLayout);
			jMemory3DPanel.setPreferredSize(new java.awt.Dimension(890, 242));

			try {
				Chart chart = createEmptyMemory3DChart();
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

	public static Chart createEmptyMemory3DChart() throws IOException {
		chart = new Chart(Quality.Fastest);
		return chart;
	}

	private JButton getJZoomOutButton() {
		if (jZoomOutButton == null) {
			jZoomOutButton = new JButton();
			jZoomOutButton.setText("out");
			jZoomOutButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/zoom_out.png")));
			jZoomOutButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jZoomOutButtonActionPerformed(evt);
				}
			});
		}
		return jZoomOutButton;
	}

	private void jZoomOutButtonActionPerformed(ActionEvent evt) {
		jMemoryChartPanel.zoomOutBoth(2, 2);
	}

	private JButton getJButton1() {
		if (jZoomInButton == null) {
			jZoomInButton = new JButton();
			jZoomInButton.setText("in");
			jZoomInButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/zoom_in.png")));
			jZoomInButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jZoomInButtonActionPerformed(evt);
				}
			});
		}
		return jZoomInButton;
	}

	private void jZoomInButtonActionPerformed(ActionEvent evt) {
		jMemoryChartPanel.zoomInBoth(2, 2);
	}

	private JButton getJZoomOutAutoRangeButton() {
		if (jZoomOutAutoRangeButton == null) {
			jZoomOutAutoRangeButton = new JButton();
			jZoomOutAutoRangeButton.setText("fit");
			jZoomOutAutoRangeButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/zoom.png")));
			jZoomOutAutoRangeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jZoomOutAutoRangeButtonActionPerformed(evt);
				}
			});
		}
		return jZoomOutAutoRangeButton;
	}

	private void jZoomOutAutoRangeButtonActionPerformed(ActionEvent evt) {
		jMemoryChartPanel.restoreAutoBounds();
	}

	@Override
	public void chartChanged(ChartChangeEvent event) {

	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Hotest address:");
		}
		return jLabel1;
	}

	private JScrollPane getJHostestAddressScrollPane() {
		if (jHostestAddressScrollPane == null) {
			jHostestAddressScrollPane = new JScrollPane();
			jHostestAddressScrollPane.setViewportView(getJHotestAddressTable());
		}
		return jHostestAddressScrollPane;
	}

	private JTable getJHotestAddressTable() {
		if (jHotestAddressTable == null) {
			DefaultTableModel jHotestAddressTableModel = new DefaultTableModel(new String[][] {}, new String[] { "Address", "Hit count" });
			jHotestAddressTable = new JTable();
			jHotestAddressTable.setModel(jHotestAddressTableModel);
		}
		return jHotestAddressTable;
	}

	private JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Informations:");
		}
		return jLabel2;
	}

	private JLabel getJLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("Mem addr :");
		}
		return jLabel3;
	}

	private JSearchTextField getJSearchTextField() {
		if (jSearchTextField == null) {
			jSearchTextField = new JSearchTextField();
			jSearchTextField.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent evt) {
					jSearchTextFieldKeyPressed(evt);
				}
			});
		}
		return jSearchTextField;
	}

	private JLabel getJLabel4() {
		if (jAddressLabel == null) {
			jAddressLabel = new JLabel();
			jAddressLabel.setText("Address = ");
		}
		return jAddressLabel;
	}

	private JLabel getJLabel5() {
		if (jRWCountLabel == null) {
			jRWCountLabel = new JLabel();
			jRWCountLabel.setText("Read write count =");
		}
		return jRWCountLabel;
	}

	private void jSearchButtonActionPerformed(ActionEvent evt) {
		System.out.println("jSearchButton.actionPerformed, event=" + evt);
		// TODO add your code for jSearchButton.actionPerformed
	}

	@Override
	public void chartMouseClicked(ChartMouseEvent event) {
		try {
			// System.out.println(event.getTrigger().getX());
			JFreeChart chart = event.getChart();
			XYPlot xyplot = chart.getXYPlot();
			MyXYBlockRenderer renderer = (MyXYBlockRenderer) xyplot.getRenderer();

			XYZDataset dataset = (XYZDataset) xyplot.getDataset();
			XYItemEntity entity = (XYItemEntity) event.getEntity();
			int series = entity.getSeriesIndex();
			int item = entity.getItem();

			int i = event.getTrigger().getX();
			int j = event.getTrigger().getY();
			Point2D point2d = jMemoryChartPanel.translateScreenToJava2D(new Point(i, j));
			ChartRenderingInfo chartrenderinginfo = jMemoryChartPanel.getChartRenderingInfo();
			Rectangle2D rectangle2d = chartrenderinginfo.getPlotInfo().getDataArea();
			double x = xyplot.getDomainAxis().java2DToValue(point2d.getX(), rectangle2d, xyplot.getDomainAxisEdge());
			double y = xyplot.getRangeAxis().java2DToValue(point2d.getY(), rectangle2d, xyplot.getRangeAxisEdge());
			int realX = (int) Math.round(x);
			int realY = (int) Math.round(y);
			renderer.setSelectedXY(realX, realY);
			long blockSize = CommonLib.convertFilesize((String) jBlockSizeComboBox.getSelectedItem());
			long columnCount = Data.getColumnCount(CommonLib.convertFilesize((String) jFromComboBox.getSelectedItem()), CommonLib.convertFilesize((String) jToComboBox
					.getSelectedItem()), blockSize);
			Long address = ((realY * columnCount) + realX) * blockSize;

			updateHotestTable(address, blockSize);

			this.jAddressLabel.setText("Address=0x" + Long.toHexString(address));
			this.jRWCountLabel.setText("R/W count=" + (int) dataset.getZValue(series, item));
		} catch (Exception ex) {

		}
	}

	private void updateHotestTable(long address, long blockSize) {
		DefaultTableModel jHotestAddressTableModel = (DefaultTableModel) jHotestAddressTable.getModel();
		while (jHotestAddressTableModel.getRowCount() > 0) {
			jHotestAddressTableModel.removeRow(0);
		}
		HashMap<String, Integer> map = Data.getHotestAddressCount(address, blockSize);
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			jHotestAddressTableModel.addRow(new String[] { entry.getKey().toString(), entry.getValue().toString() });
		}
	}

	@Override
	public void chartMouseMoved(ChartMouseEvent event) {
		// System.out.println("chartMouseMoved");

	}

	private JComboBox getJFromComboBox() {
		if (jFromComboBox == null) {
			ComboBoxModel jFromComboBoxModel = new DefaultComboBoxModel(new String[] { "0MB" });
			jFromComboBox = new JComboBox();
			jFromComboBox.setModel(jFromComboBoxModel);
			jFromComboBox.setEditable(true);
			jFromComboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jFromComboBoxActionPerformed(evt);
				}
			});
		}
		return jFromComboBox;
	}

	private JLabel getJLabel4x() {
		if (jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("From");
		}
		return jLabel4;
	}

	private JLabel getJLabel5x() {
		if (jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("Block Size");
		}
		return jLabel5;
	}

	private JComboBox getJBlockSizeComboBox() {
		if (jBlockSizeComboBox == null) {
			ComboBoxModel jToComboBoxModel = new DefaultComboBoxModel(new String[] { "100MB", "10MB", "1MB", "100KB", "32KB" });
			jBlockSizeComboBox = new JComboBox();
			jBlockSizeComboBox.setModel(jToComboBoxModel);
			jBlockSizeComboBox.setEditable(true);
			jBlockSizeComboBox.setSelectedItem("100KB");
			jBlockSizeComboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jBlockSizeComboBoxActionPerformed(evt);
				}
			});
		}
		return jBlockSizeComboBox;
	}

	private void jFromComboBoxActionPerformed(ActionEvent evt) {
		updateChart();
	}

	private void jBlockSizeComboBoxActionPerformed(ActionEvent evt) {
		updateChart();
	}

	private JLabel getJLabel6() {
		if (jLabel6 == null) {
			jLabel6 = new JLabel();
			jLabel6.setText("To");
			jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return jLabel6;
	}

	private JComboBox getJToComboBox() {
		if (jToComboBox == null) {
			ComboBoxModel jToComboBoxModel = new DefaultComboBoxModel(new String[] { "1GB", "100MB", "10MB", "1MB" });
			jToComboBox = new JComboBox();
			jToComboBox.setModel(jToComboBoxModel);
			jToComboBox.setEditable(true);
			jToComboBoxModel.setSelectedItem("100MB");
			jToComboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jToComboBoxActionPerformed(evt);
				}
			});
		}
		return jToComboBox;
	}

	private void jToComboBoxActionPerformed(ActionEvent evt) {
		updateChart();
	}

	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			FlowLayout jPanel1Layout = new FlowLayout();
			jPanel1Layout.setHgap(0);
			jPanel1Layout.setVgap(0);
			jPanel1Layout.setAlignment(FlowLayout.LEFT);
			jPanel1.setLayout(jPanel1Layout);
			jPanel1.add(getJZoomOutAutoRangeButton());
			jPanel1.add(getJZoomOutButton());
			jPanel1.add(getJButton1());
		}
		return jPanel1;
	}

	private void jSearchTextFieldKeyPressed(KeyEvent evt) {
		if ((evt.getKeyCode() == KeyEvent.VK_ENTER)) {
			ValueAxis xAxis = this.jfcMemory.getXYPlot().getDomainAxis();
			// Double max = jfcMemory.getMax(jfcMemory.getXYPlot().getDataset(),
			// xAxis.getRange());

			long columnCount = Data.getColumnCount(CommonLib.convertFilesize((String) jFromComboBox.getSelectedItem()), CommonLib.convertFilesize((String) jToComboBox
					.getSelectedItem()), CommonLib.convertFilesize((String) jBlockSizeComboBox.getSelectedItem()));
			long address = CommonLib.convertFilesize(jSearchTextField.getText());
			long blockSize = CommonLib.convertFilesize((String) jBlockSizeComboBox.getSelectedItem());
			long blockNo = address / blockSize;
			long x = blockNo % columnCount;
			long y = blockNo / columnCount;
			MyXYBlockRenderer renderer = (MyXYBlockRenderer) jfcMemory.getXYPlot().getRenderer();
			renderer.setRealX((int) x);
			renderer.setRealY((int) y);
			System.out.println(x + "," + y);
			updateHotestTable(address, blockSize);
			jfcMemory.fireChartChanged();
			// ((DefaultXYZDataset)
			// jfcMemory.getXYPlot().getDataset()).addSeries(null, null);
			// jMemoryChartPanel.repaint();
		}
	}

	private JTabbedPane getJTabbedPane2() {
		if (jTabbedPane2 == null) {
			jTabbedPane2 = new JTabbedPane();
			{
				jfcMemory = createEmptyChart(createEmptyDataset());
				jMemoryChartPanel = new ChartPanel(jfcMemory);
				jTabbedPane2.addTab("Chart", null, jMemoryChartPanel, null);
				jTabbedPane2.addTab("Memory 3D", null, getJMemory3DPanel(), null);
				jMemoryChartPanel.setDisplayToolTips(true);
				jfcMemory.addChangeListener(this);
				jMemoryChartPanel.addChartMouseListener(this);
			}
		}
		return jTabbedPane2;
	}

	private JPanel getJMemoryProfilingPanel() {
		if (jMemoryProfilingPanel == null) {
			jMemoryProfilingPanel = new JPanel();
			GroupLayout jMemoryProfilingPanelLayout = new GroupLayout((JComponent) jMemoryProfilingPanel);
			jMemoryProfilingPanel.setLayout(jMemoryProfilingPanelLayout);
			jMemoryProfilingPanelLayout.setHorizontalGroup(jMemoryProfilingPanelLayout.createSequentialGroup().addContainerGap().addGroup(
					jMemoryProfilingPanelLayout.createParallelGroup().addGroup(
							GroupLayout.Alignment.LEADING,
							jMemoryProfilingPanelLayout.createSequentialGroup().addGroup(
									jMemoryProfilingPanelLayout.createParallelGroup().addGroup(
											GroupLayout.Alignment.LEADING,
											jMemoryProfilingPanelLayout.createSequentialGroup().addGroup(
													jMemoryProfilingPanelLayout.createParallelGroup().addGroup(
															GroupLayout.Alignment.LEADING,
															jMemoryProfilingPanelLayout.createSequentialGroup().addComponent(getJLabel8(), GroupLayout.PREFERRED_SIZE, 39,
																	GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																	.addComponent(getJProfilingFromComboBox(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE,
																			GroupLayout.PREFERRED_SIZE)).addGroup(
															GroupLayout.Alignment.LEADING,
															jMemoryProfilingPanelLayout.createSequentialGroup().addComponent(getJDeleteZoneButton(), GroupLayout.PREFERRED_SIZE,
																	62, GroupLayout.PREFERRED_SIZE).addGap(108))).addGap(7).addComponent(getJLabel9(), GroupLayout.PREFERRED_SIZE,
													23, GroupLayout.PREFERRED_SIZE).addGap(7).addComponent(getJProfilingToComboBox(), GroupLayout.PREFERRED_SIZE,
													GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)).addGroup(
											GroupLayout.Alignment.LEADING,
											jMemoryProfilingPanelLayout.createSequentialGroup().addComponent(getJLabel7(), GroupLayout.PREFERRED_SIZE, 292,
													GroupLayout.PREFERRED_SIZE).addGap(34))).addComponent(getJAddZoneButton(), GroupLayout.PREFERRED_SIZE, 62,
									GroupLayout.PREFERRED_SIZE).addGap(0, 331, Short.MAX_VALUE)).addComponent(getJScrollPane2(), GroupLayout.Alignment.LEADING, 0, 719,
							Short.MAX_VALUE)).addContainerGap());
			jMemoryProfilingPanelLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] { getJProfilingFromComboBox(), getJProfilingToComboBox() });
			jMemoryProfilingPanelLayout.setVerticalGroup(jMemoryProfilingPanelLayout.createSequentialGroup().addContainerGap().addComponent(getJLabel7(),
					GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(
					jMemoryProfilingPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(getJProfilingFromComboBox(), GroupLayout.Alignment.BASELINE,
							GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(getJLabel8(), GroupLayout.Alignment.BASELINE,
							GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(getJLabel9(), GroupLayout.Alignment.BASELINE,
							GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(getJProfilingToComboBox(),
							GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(getJAddZoneButton(),
							GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(
					LayoutStyle.ComponentPlacement.UNRELATED).addComponent(getJScrollPane2(), 0, 337, Short.MAX_VALUE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0,
					GroupLayout.PREFERRED_SIZE).addComponent(getJDeleteZoneButton(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap());
			jMemoryProfilingPanelLayout.linkSize(SwingConstants.VERTICAL, new Component[] { getJProfilingFromComboBox(), getJProfilingToComboBox() });
		}
		return jMemoryProfilingPanel;
	}

	private JLabel getJLabel7() {
		if (jLabel7 == null) {
			jLabel7 = new JLabel();
			jLabel7.setText("Enter the memory zone that you want to profile");
		}
		return jLabel7;
	}

	private JLabel getJLabel8() {
		if (jLabel8 == null) {
			jLabel8 = new JLabel();
			jLabel8.setText("From");
		}
		return jLabel8;
	}

	private JComboBox getJProfilingFromComboBox() {
		if (jProfilingFromComboBox == null) {
			ComboBoxModel jComboBox1Model = new DefaultComboBoxModel(new String[] {});
			jProfilingFromComboBox = new JComboBox();
			jProfilingFromComboBox.setModel(jComboBox1Model);
			jProfilingFromComboBox.setEditable(true);

			new Thread() {
				public void run() {
					LinkedList<Long> vector = Setting.getInstance().getProfileMemoryFromAddress();
					Iterator<Long> iterator = vector.iterator();
					while (iterator.hasNext()) {
						addProfileMemoryFromComboBox(iterator.next());
					}
				}
			}.start();
		}
		return jProfilingFromComboBox;
	}

	private JLabel getJLabel9() {
		if (jLabel9 == null) {
			jLabel9 = new JLabel();
			jLabel9.setText("To");
			jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return jLabel9;
	}

	private JComboBox getJProfilingToComboBox() {
		if (jProfilingToComboBox == null) {
			ComboBoxModel jComboBox2Model = new DefaultComboBoxModel(new String[] {});
			jProfilingToComboBox = new JComboBox();
			jProfilingToComboBox.setModel(jComboBox2Model);
			jProfilingToComboBox.setEditable(true);

			new Thread() {
				public void run() {
					LinkedList<Long> vector = Setting.getInstance().getProfileMemoryToAddress();
					Iterator<Long> iterator = vector.iterator();
					while (iterator.hasNext()) {
						addProfileMemoryToComboBox(iterator.next());
					}
				}
			}.start();
		}
		return jProfilingToComboBox;
	}

	private JTable getJProfilingTable() {
		if (jProfilingTable == null) {
			jProfilingTable = new JTable();
			ProfilingTableModel profilingTableModel = new ProfilingTableModel();
			jProfilingTable.setModel(profilingTableModel);
			Data.memoryProfilingZone = profilingTableModel;

			try {
				LinkedList<Long> fromVector = Setting.getInstance().getProfileMemoryFromAddress();
				LinkedList<Long> toVector = Setting.getInstance().getProfileMemoryToAddress();
				Iterator<Long> fromIterator = fromVector.iterator();
				Iterator<Long> toIterator = toVector.iterator();
				while (fromIterator.hasNext()) {
					((ProfilingTableModel) this.jProfilingTable.getModel()).addZone(fromIterator.next(), toIterator.next());
				}
			} catch (Exception ex) {

			}
		}
		return jProfilingTable;
	}

	private JScrollPane getJScrollPane2() {
		if (jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setViewportView(getJProfilingTable());
		}
		return jScrollPane2;
	}

	private JButton getJAddZoneButton() {
		if (jAddZoneButton == null) {
			jAddZoneButton = new JButton();
			jAddZoneButton.setText("Add");
			jAddZoneButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jAddZoneButtonActionPerformed(evt);
				}
			});
		}
		return jAddZoneButton;
	}

	private void jAddZoneButtonActionPerformed(ActionEvent evt) {
		try {
			long from = CommonLib.convertFilesize(jProfilingFromComboBox.getSelectedItem().toString());
			long to = CommonLib.convertFilesize(jProfilingToComboBox.getSelectedItem().toString());
			if (from > to) {
				long x = to;
				to = from;
				from = x;
			}
			((ProfilingTableModel) this.jProfilingTable.getModel()).addZone(from, to);
			jProfilingFromComboBox.setSelectedItem("");
			jProfilingToComboBox.setSelectedItem("");

			Setting.getInstance().getProfileMemoryFromAddress().add(from);
			Setting.getInstance().getProfileMemoryToAddress().add(to);
			Setting.getInstance().save();
		} catch (Exception ex) {

		}
	}

	private void addProfileMemoryFromComboBox(Long l) {
		for (int x = 0; x < jProfilingFromComboBox.getItemCount(); x++) {
			if (jProfilingFromComboBox.getItemAt(x).toString().trim().equals(l.toString().trim())) {
				return;
			}
		}
		jProfilingFromComboBox.addItem("0x" + Long.toHexString(l));
	}

	private void addProfileMemoryToComboBox(Long l) {
		for (int x = 0; x < jProfilingToComboBox.getItemCount(); x++) {
			if (jProfilingToComboBox.getItemAt(x).toString().trim().equals(l.toString().trim())) {
				return;
			}
		}
		jProfilingToComboBox.addItem("0x" + Long.toHexString(l));
	}

	private JButton getJDeleteZoneButton() {
		if (jDeleteZoneButton == null) {
			jDeleteZoneButton = new JButton();
			jDeleteZoneButton.setText("Delete");
			jDeleteZoneButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jDeleteZoneButtonActionPerformed(evt);
				}
			});
		}
		return jDeleteZoneButton;
	}

	private void jDeleteZoneButtonActionPerformed(ActionEvent evt) {
		System.out.println("jDeleteZoneButton.actionPerformed, event=" + evt);
		// TODO add your code for jDeleteZoneButton.actionPerformed
	}

}
