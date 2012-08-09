package com.peterbochs.instrument.jfreechart;

import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYZDataset;

import com.peterbochs.instrument.Data;
import com.peterbochs.instrument.InstrumentPanel;
import com.peterswing.CommonLib;

public class MyXYToolTipGenerator implements XYToolTipGenerator {
	@Override
	public String generateToolTip(XYDataset dataset, int series, int item) {
		XYZDataset xyzDataset = (XYZDataset) dataset;
		double x = xyzDataset.getXValue(series, item);
		double y = xyzDataset.getYValue(series, item);
		double z = xyzDataset.getZValue(series, item);
		long blockSize = CommonLib.convertFilesize((String) InstrumentPanel.jBlockSizeComboBox.getSelectedItem());
		long columnCount = Data.getColumnCount(CommonLib.convertFilesize((String) InstrumentPanel.jFromComboBox.getSelectedItem()), CommonLib
				.convertFilesize((String) InstrumentPanel.jToComboBox.getSelectedItem()), blockSize);
		long address = (long) (((y * columnCount) + x) * blockSize);
		return ("0x" + Long.toHexString(address) + ",count=" + (int) z);
	}
}