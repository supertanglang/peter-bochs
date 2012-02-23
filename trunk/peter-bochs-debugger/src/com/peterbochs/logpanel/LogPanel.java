package com.peterbochs.logpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;

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
public class LogPanel extends javax.swing.JPanel implements LogFileTailerListener {
	private JScrollPane jScrollPane1;
	private JTextArea jTextArea1;
	private LogFileTailer tailer;

	public LogPanel() {
		super();
		initGUI();
		tailer = new LogFileTailer(new File("peter-bochs.log"), 1000, false);
		tailer.addLogFileTailerListener(this);
		tailer.start();
	}

	private void initGUI() {
		try {
			BorderLayout thisLayout = new BorderLayout();
			this.setLayout(thisLayout);
			setPreferredSize(new Dimension(400, 300));
			{
				jScrollPane1 = new JScrollPane();
				this.add(jScrollPane1, BorderLayout.CENTER);
				{
					jTextArea1 = new JTextArea();
					jScrollPane1.setViewportView(jTextArea1);
					final JTextArea lines = new JTextArea("1");
					lines.setBackground(new Color(200, 230, 245));
					lines.setEditable(false);
					jScrollPane1.setRowHeaderView(lines);
					// jScrollPane1.getRowHeader().setPreferredSize(new
					// Dimension(30, 1));
					jTextArea1.getDocument().addDocumentListener(new DocumentListener() {
						public String getText() {
							int caretPosition = jTextArea1.getDocument().getLength();
							Element root = jTextArea1.getDocument().getDefaultRootElement();
							String text = "1" + System.getProperty("line.separator");
							for (int i = 2; i < root.getElementIndex(caretPosition) + 2; i++) {
								text += i + System.getProperty("line.separator");
							}
							return text;
						}

						@Override
						public void changedUpdate(DocumentEvent de) {
							lines.setText(getText());
						}

						@Override
						public void insertUpdate(DocumentEvent de) {
							lines.setText(getText());
						}

						@Override
						public void removeUpdate(DocumentEvent de) {
							lines.setText(getText());
						}

					});
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void newLogFileLine(String line) {
		jTextArea1.append(line + System.getProperty("line.separator"));
		jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
	}

}
