package com.peterbochs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

public class MyGlassPane extends JComponent implements ItemListener {
	Point point;
	JLabel jLabel1 = new JLabel();

	public MyGlassPane(JMenuBar menuBar, Container contentPane) {
		URL url = getClass().getClassLoader().getResource("com/peterbochs/images/ajax-loader.gif");
		jLabel1.setText("<html><center><font color=white>Bochs is running, click the pause button to pause it !!!<br><br><img src=\"" + url
				+ "\" /></font><br><br></center></html>");

		this.setLayout(new BorderLayout());
		this.add(jLabel1, BorderLayout.CENTER);

		jLabel1.setBackground(new Color(0, 0, 0, 180));
		jLabel1.setOpaque(true);
		CBListener listener = new CBListener(menuBar, this, contentPane);
//		 addMouseListener(listener);
//		 addMouseMotionListener(listener);
	}

	// React to change button clicks.
	public void itemStateChanged(ItemEvent e) {
		setVisible(e.getStateChange() == ItemEvent.SELECTED);
	}

	protected void paintComponent(Graphics g) {
	}

	public void setPoint(Point p) {
		point = p;
	}

}

class CBListener extends MouseInputAdapter {
	Toolkit toolkit;
	Component liveButton;
	JMenuBar menuBar;
	MyGlassPane glassPane;
	Container contentPane;

	public CBListener(JMenuBar menuBar, MyGlassPane glassPane, Container contentPane) {
		toolkit = Toolkit.getDefaultToolkit();
		this.liveButton = liveButton;
		this.menuBar = menuBar;
		this.glassPane = glassPane;
		this.contentPane = contentPane;
	}

	public void mouseMoved(MouseEvent e) {
		redispatchMouseEvent(e, false);
	}

	public void mouseDragged(MouseEvent e) {
		redispatchMouseEvent(e, false);
	}

	public void mouseClicked(MouseEvent e) {
		redispatchMouseEvent(e, false);
	}

	public void mouseEntered(MouseEvent e) {
		redispatchMouseEvent(e, false);
	}

	public void mouseExited(MouseEvent e) {
		redispatchMouseEvent(e, false);
	}

	public void mousePressed(MouseEvent e) {
		redispatchMouseEvent(e, false);
	}

	public void mouseReleased(MouseEvent e) {
		redispatchMouseEvent(e, true);
	}

	// A basic implementation of redispatching events.
	private void redispatchMouseEvent(MouseEvent e, boolean repaint) {
		Point glassPanePoint = e.getPoint();
		Container container = contentPane;
		Point containerPoint = SwingUtilities.convertPoint(glassPane, glassPanePoint, contentPane);
		if (containerPoint.y < 0) { // we're not in the content pane
			System.out.println("menu");
			if (containerPoint.y + menuBar.getHeight() >= 0) {
				// The mouse event is over the menu bar.
				// Could handle specially.
			} else {
				// The mouse event is over non-system window
				// decorations, such as the ones provided by
				// the Java look and feel.
				// Could handle specially.
			}
		} else {
			// The mouse event is probably over the content pane.
			// Find out exactly which component it's over.
			Component component = SwingUtilities.getDeepestComponentAt(container, containerPoint.x, containerPoint.y);

			if (component != null) {
				if (component.equals(liveButton) || component.equals(menuBar)) {
					// Forward events over the check box.
//					Point componentPoint = SwingUtilities.convertPoint(glassPane, glassPanePoint, component);
//					component.dispatchEvent(new MouseEvent(component, e.getID(), e.getWhen(), e.getModifiers(), componentPoint.x, componentPoint.y, e.getClickCount(), e
//							.isPopupTrigger()));
				}
			}
		}

		// Update the glass pane if requested.
		if (repaint) {
			glassPane.setPoint(glassPanePoint);
			glassPane.repaint();
		}
	}
}
