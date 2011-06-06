package peter;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.image.BufferedImage;
import java.util.EventListener;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ActionMapUIResource;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.InputMapUIResource;
import javax.swing.plaf.TabbedPaneUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import javax.swing.plaf.basic.BasicHTML;
import javax.swing.text.View;

import com.sun.java.swing.plaf.windows.WindowsIconFactory;

/**
 * A JTabbedPane with some added UI functionalities. A close and max/detach
 * icons are added to every tab, typically to let the user close or detach the
 * tab by clicking on these icons.
 * 
 * @version 1.1 06/07/04
 * @author David Bismut, davidou@mageos.com
 */

public class CloseAndMaxTabbedPane extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6820368997911791415L;

	private int overTabIndex = -1;

	private CloseTabPaneUI paneUI;

	/**
	 * Creates the <code>CloseAndMaxTabbedPane</code> with an enhanced UI if
	 * <code>enhancedUI</code> parameter is set to <code>true</code>.
	 * 
	 * @param enhancedUI
	 *            whether the tabbedPane should use an enhanced UI
	 */
	public CloseAndMaxTabbedPane(boolean enhancedUI) {
		super.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		if (enhancedUI)
			paneUI = new CloseTabPaneEnhancedUI();
		else
			paneUI = new CloseTabPaneUI();

		super.setUI(paneUI);
	}

	public CloseAndMaxTabbedPane(Icon close) {
		super.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		paneUI = new CloseTabPaneEnhancedUI();

		super.setUI(paneUI);
		paneUI.setCloseIcon(close);

	}

	/**
	 * Returns the index of the last tab on which the mouse did an action.
	 */
	public int getOverTabIndex() {
		return overTabIndex;
	}

	/**
	 * Returns <code>true</code> if the close icon is enabled.
	 */
	public boolean isCloseEnabled() {
		return paneUI.isCloseEnabled();
	}

	/**
	 * Returns <code>true</code> if the max/detach icon is enabled.
	 */
	public boolean isMaxEnabled() {
		return paneUI.isMaxEnabled();
	}

	/**
	 * Override JTabbedPane method. Does nothing.
	 */
	public void setTabLayoutPolicy(int tabLayoutPolicy) {
	}

	/**
	 * Override JTabbedPane method. Does nothing.
	 */
	public void setTabPlacement(int tabPlacement) {
	}

	/**
	 * Override JTabbedPane method. Does nothing.
	 */
	public void setUI(TabbedPaneUI ui) {
	}

	/**
	 * Sets whether the tabbedPane should have a close icon or not.
	 * 
	 * @param b
	 *            whether the tabbedPane should have a close icon or not
	 */
	public void setCloseIcon(boolean b) {
		paneUI.setCloseIcon(b);
	}

	/**
	 * Sets whether the tabbedPane should have a max/detach icon or not.
	 * 
	 * @param b
	 *            whether the tabbedPane should have a max/detach icon or not
	 */
	public void setMaxIcon(boolean b) {
		paneUI.setMaxIcon(b);
	}

	/**
	 * Detaches the <code>index</code> tab in a seperate frame. When the frame
	 * is closed, the tab is automatically reinserted into the tabbedPane.
	 * 
	 * @param index
	 *            index of the tabbedPane to be detached
	 */
	public void detachTab(int index) {

		if (index < 0 || index >= getTabCount())
			return;

		final JFrame frame = new JFrame();

		Window parentWindow = SwingUtilities.windowForComponent(this);

		final int tabIndex = index;
		final JComponent c = (JComponent) getComponentAt(tabIndex);

		final Icon icon = getIconAt(tabIndex);
		final String title = getTitleAt(tabIndex);
		final String toolTip = getToolTipTextAt(tabIndex);
		final Border border = c.getBorder();

		removeTabAt(index);

		c.setPreferredSize(c.getSize());

		frame.setTitle(title);
		frame.getContentPane().add(c);
		frame.setLocation(parentWindow.getLocation());
		frame.pack();

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				frame.dispose();

				insertTab(title, icon, c, toolTip, Math.min(tabIndex, getTabCount()));

				c.setBorder(border);
				setSelectedComponent(c);
			}

		});

		WindowFocusListener windowFocusListener = new WindowFocusListener() {
			long start;

			long end;

			public void windowGainedFocus(WindowEvent e) {
				start = System.currentTimeMillis();
			}

			public void windowLostFocus(WindowEvent e) {
				end = System.currentTimeMillis();
				long elapsed = end - start;
				// System.out.println(elapsed);
				if (elapsed < 100)
					frame.toFront();

				frame.removeWindowFocusListener(this);
			}
		};

		/*
		 * This is a small hack to avoid Windows GUI bug, that prevent a new
		 * window from stealing focus (without this windowFocusListener, most of
		 * the time the new frame would just blink from foreground to
		 * background). A windowFocusListener is added to the frame, and if the
		 * time between the frame beeing in foreground and the frame beeing in
		 * background is less that 100ms, it just brings the windows to the
		 * front once again. Then it removes the windowFocusListener. Note that
		 * this hack would not be required on Linux or UNIX based systems.
		 */

		frame.addWindowFocusListener(windowFocusListener);

		frame.show();
		frame.toFront();

	}

	/**
	 * Adds a <code>CloseListener</code> to the tabbedPane.
	 * 
	 * @param l
	 *            the <code>CloseListener</code> to add
	 * @see #fireCloseTabEvent
	 * @see #removeCloseListener
	 */
	public synchronized void addCloseListener(CloseListener l) {
		listenerList.add(CloseListener.class, l);
	}

	/**
	 * Adds a <code>MaxListener</code> to the tabbedPane.
	 * 
	 * @param l
	 *            the <code>MaxListener</code> to add
	 * @see #fireMaxTabEvent
	 * @see #removeMaxListener
	 */
	public synchronized void addMaxListener(MaxListener l) {
		listenerList.add(MaxListener.class, l);
	}

	/**
	 * Adds a <code>DoubleClickListener</code> to the tabbedPane.
	 * 
	 * @param l
	 *            the <code>DoubleClickListener</code> to add
	 * @see #fireDoubleClickTabEvent
	 * @see #removeDoubleClickListener
	 */
	public synchronized void addDoubleClickListener(DoubleClickListener l) {
		listenerList.add(DoubleClickListener.class, l);
	}

	/**
	 * Adds a <code>PopupOutsideListener</code> to the tabbedPane.
	 * 
	 * @param l
	 *            the <code>PopupOutsideListener</code> to add
	 * @see #firePopupOutsideTabEvent
	 * @see #removePopupOutsideListener
	 */
	public synchronized void addPopupOutsideListener(PopupOutsideListener l) {
		listenerList.add(PopupOutsideListener.class, l);
	}

	/**
	 * Removes a <code>CloseListener</code> from this tabbedPane.
	 * 
	 * @param l
	 *            the <code>CloseListener</code> to remove
	 * @see #fireCloseTabEvent
	 * @see #addCloseListener
	 */
	public synchronized void removeCloseListener(CloseListener l) {
		listenerList.remove(CloseListener.class, l);
	}

	/**
	 * Removes a <code>MaxListener</code> from this tabbedPane.
	 * 
	 * @param l
	 *            the <code>MaxListener</code> to remove
	 * @see #fireMaxTabEvent
	 * @see #addMaxListener
	 */
	public synchronized void removeMaxListener(MaxListener l) {
		listenerList.remove(MaxListener.class, l);
	}

	/**
	 * Removes a <code>DoubleClickListener</code> from this tabbedPane.
	 * 
	 * @param l
	 *            the <code>DoubleClickListener</code> to remove
	 * @see #fireDoubleClickTabEvent
	 * @see #addDoubleClickListener
	 */
	public synchronized void removeDoubleClickListener(DoubleClickListener l) {
		listenerList.remove(DoubleClickListener.class, l);
	}

	/**
	 * Removes a <code>PopupOutsideListener</code> from this tabbedPane.
	 * 
	 * @param l
	 *            the <code>PopupOutsideListener</code> to remove
	 * @see #firePopupOutsideTabEvent
	 * @see #addPopupOutsideListener
	 */
	public synchronized void removePopupOutsideListener(PopupOutsideListener l) {
		listenerList.remove(PopupOutsideListener.class, l);
	}

	/**
	 * Sends a <code>MouseEvent</code>, whose source is this tabbedpane, to
	 * every <code>CloseListener</code>. The method also updates the
	 * <code>overTabIndex</code> of the tabbedPane with a value coming from the
	 * UI. This method method is called each time a <code>MouseEvent</code> is
	 * received from the UI when the user clicks on the close icon of the tab
	 * which index is <code>overTabIndex</code>.
	 * 
	 * @param e
	 *            the <code>MouseEvent</code> to be sent
	 * @param overTabIndex
	 *            the index of a tab, usually the tab over which the mouse is
	 * 
	 * @see #addCloseListener
	 * @see EventListenerList
	 */
	public void fireCloseTabEvent(MouseEvent e, int overTabIndex) {
		this.overTabIndex = overTabIndex;

		EventListener closeListeners[] = getListeners(CloseListener.class);
		for (int i = 0; i < closeListeners.length; i++) {
			((CloseListener) closeListeners[i]).closeOperation(e);
		}
	}

	/**
	 * Sends a <code>MouseEvent</code>, whose source is this tabbedpane, to
	 * every <code>MaxListener</code>. The method also updates the
	 * <code>overTabIndex</code> of the tabbedPane with a value coming from the
	 * UI. This method method is called each time a <code>MouseEvent</code> is
	 * received from the UI when the user clicks on the max icon of the tab
	 * which index is <code>overTabIndex</code>.
	 * 
	 * @param e
	 *            the <code>MouseEvent</code> to be sent
	 * @param overTabIndex
	 *            the index of a tab, usually the tab over which the mouse is
	 * 
	 * @see #addMaxListener
	 * @see EventListenerList
	 */
	public void fireMaxTabEvent(MouseEvent e, int overTabIndex) {
		this.overTabIndex = overTabIndex;

		EventListener maxListeners[] = getListeners(MaxListener.class);
		for (int i = 0; i < maxListeners.length; i++) {
			((MaxListener) maxListeners[i]).maxOperation(e);
		}
	}

	/**
	 * Sends a <code>MouseEvent</code>, whose source is this tabbedpane, to
	 * every <code>DoubleClickListener</code>. The method also updates the
	 * <code>overTabIndex</code> of the tabbedPane with a value coming from the
	 * UI. This method method is called each time a <code>MouseEvent</code> is
	 * received from the UI when the user double-clicks on the tab which index
	 * is <code>overTabIndex</code>.
	 * 
	 * @param e
	 *            the <code>MouseEvent</code> to be sent
	 * @param overTabIndex
	 *            the index of a tab, usually the tab over which the mouse is
	 * 
	 * @see #addDoubleClickListener
	 * @see EventListenerList
	 */
	public void fireDoubleClickTabEvent(MouseEvent e, int overTabIndex) {
		this.overTabIndex = overTabIndex;

		EventListener dClickListeners[] = getListeners(DoubleClickListener.class);
		for (int i = 0; i < dClickListeners.length; i++) {
			((DoubleClickListener) dClickListeners[i]).doubleClickOperation(e);
		}
	}

	/**
	 * Sends a <code>MouseEvent</code>, whose source is this tabbedpane, to
	 * every <code>PopupOutsideListener</code>. The method also sets the
	 * <code>overTabIndex</code> to -1. This method method is called each time a
	 * <code>MouseEvent</code> is received from the UI when the user
	 * right-clicks on the inactive part of a tabbedPane.
	 * 
	 * @param e
	 *            the <code>MouseEvent</code> to be sent
	 * 
	 * @see #addPopupOutsideListener
	 * @see EventListenerList
	 */
	public void firePopupOutsideTabEvent(MouseEvent e) {
		this.overTabIndex = -1;

		EventListener popupListeners[] = getListeners(PopupOutsideListener.class);
		for (int i = 0; i < popupListeners.length; i++) {
			((PopupOutsideListener) popupListeners[i]).popupOutsideOperation(e);
		}
	}

}

class CloseTabPaneUI extends com.petersoft.white.TabbedPaneUI {

	// Instance variables initialized at installation

	private ContainerListener containerListener;

	private Vector<View> htmlViews;

	private Hashtable mnemonicToIndexMap;

	/**
	 * InputMap used for mnemonics. Only non-null if the JTabbedPane has
	 * mnemonics associated with it. Lazily created in initMnemonics.
	 */
	private InputMap mnemonicInputMap;

	// For use when tabLayoutPolicy = SCROLL_TAB_LAYOUT
	protected ScrollableTabSupport tabScroller;

	private int tabCount;

	protected MyMouseMotionListener motionListener;

	// UI creation

	private static final int INACTIVE = 0;

	private static final int OVER = 1;

	private static final int PRESSED = 2;

	protected static final int BUTTONSIZE = 15;

	protected static final int WIDTHDELTA = 5;

	private static final Border PRESSEDBORDER = new SoftBevelBorder(SoftBevelBorder.LOWERED);

	private static final Border OVERBORDER = new SoftBevelBorder(SoftBevelBorder.RAISED);

	private BufferedImage closeImgB;

	private BufferedImage maxImgB;

	private BufferedImage closeImgI;

	private BufferedImage maxImgI;

	private JButton closeB;

	private JButton maxB;

	private int overTabIndex = -1;

	private int closeIndexStatus = INACTIVE;

	private int maxIndexStatus = INACTIVE;

	private boolean mousePressed = false;

	private boolean isCloseButtonEnabled = true;

	private boolean isMaxButtonEnabled = false;

	protected JPopupMenu actionPopupMenu;

	protected JMenuItem maxItem;

	protected JMenuItem closeItem;

	// private static final ImageIcon tabClose = new
	// ImageIcon("pixmaps/tab_close.png");

	public CloseTabPaneUI() {

		super();

		closeImgB = new BufferedImage(BUTTONSIZE, BUTTONSIZE, BufferedImage.TYPE_4BYTE_ABGR);

		maxImgB = new BufferedImage(BUTTONSIZE, BUTTONSIZE, BufferedImage.TYPE_4BYTE_ABGR);

		closeImgI = new BufferedImage(BUTTONSIZE, BUTTONSIZE, BufferedImage.TYPE_4BYTE_ABGR);

		maxImgI = new BufferedImage(BUTTONSIZE, BUTTONSIZE, BufferedImage.TYPE_4BYTE_ABGR);

		closeB = new JButton("X");
		closeB.setSize(BUTTONSIZE, BUTTONSIZE);
		// closeB.setIcon(tabClose);
		maxB = new JButton("=");
		maxB.setSize(BUTTONSIZE, BUTTONSIZE);

		// WindowsIconFactory.createFrameCloseIcon().paintIcon(closeB,
		// closeImgI.createGraphics(), 0, 0);

		WindowsIconFactory.createFrameMaximizeIcon().paintIcon(maxB, maxImgI.createGraphics(), 0, 0);

		actionPopupMenu = new JPopupMenu();

		maxItem = new JMenuItem("Detach");
		closeItem = new JMenuItem("Close");

		maxItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("max now");
				((CloseAndMaxTabbedPane) tabPane).fireMaxTabEvent(null, tabPane.getSelectedIndex());
			}
		});

		closeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CloseAndMaxTabbedPane) tabPane).fireCloseTabEvent(null, tabPane.getSelectedIndex());

			}
		});

		setPopupMenu();
	}

	public void setCloseIcon(Icon icon) {
		closeB.setIcon(icon);
		isCloseButtonEnabled = true;
		setPopupMenu();
	}

	protected boolean isOneActionButtonEnabled() {
		return isCloseButtonEnabled || isMaxButtonEnabled;
	}

	public boolean isCloseEnabled() {
		return isCloseButtonEnabled;
	}

	public boolean isMaxEnabled() {
		return isMaxButtonEnabled;
	}

	public void setCloseIcon(boolean b) {
		isCloseButtonEnabled = b;
		setPopupMenu();
	}

	public void setMaxIcon(boolean b) {
		isMaxButtonEnabled = b;
		setPopupMenu();
	}

	private void setPopupMenu() {
		actionPopupMenu.removeAll();
		if (isMaxButtonEnabled)
			actionPopupMenu.add(maxItem);
		if (isMaxButtonEnabled && isCloseButtonEnabled)
			actionPopupMenu.addSeparator();
		if (isCloseButtonEnabled)
			actionPopupMenu.add(closeItem);
	}

	protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
		int delta = 2;
		if (!isOneActionButtonEnabled())
			delta += 6;
		else {
			if (isCloseButtonEnabled)
				delta += BUTTONSIZE + WIDTHDELTA;
			if (isMaxButtonEnabled)
				delta += BUTTONSIZE + WIDTHDELTA;
		}

		return super.calculateTabWidth(tabPlacement, tabIndex, metrics) + delta;
	}

	protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {

		return super.calculateTabHeight(tabPlacement, tabIndex, fontHeight) + 5;
	}

	protected void layoutLabel(int tabPlacement, FontMetrics metrics, int tabIndex, String title, Icon icon, Rectangle tabRect, Rectangle iconRect, Rectangle textRect, boolean isSelected) {
		textRect.x = textRect.y = iconRect.x = iconRect.y = 0;

		View v = getTextViewForTab(tabIndex);
		if (v != null) {
			tabPane.putClientProperty("html", v);
		}

		SwingUtilities.layoutCompoundLabel((JComponent) tabPane, metrics, title, icon, SwingUtilities.CENTER, SwingUtilities.LEFT, SwingUtilities.CENTER, SwingUtilities.CENTER, tabRect, iconRect,
				textRect, textIconGap);

		tabPane.putClientProperty("html", null);

		iconRect.x = tabRect.x + 8;
		textRect.x = iconRect.x + iconRect.width + textIconGap;
	}

	protected MouseListener createMouseListener() {
		return new MyMouseHandler();
	}

	protected ScrollableTabButton createScrollableTabButton(int direction) {
		return new ScrollableTabButton(direction);
	}

	protected Rectangle newCloseRect(Rectangle rect) {
		int dx = rect.x + rect.width;
		int dy = (rect.y + rect.height) / 2 - 6;
		return new Rectangle(dx - BUTTONSIZE - WIDTHDELTA, dy, BUTTONSIZE, BUTTONSIZE);
	}

	protected Rectangle newMaxRect(Rectangle rect) {
		int dx = rect.x + rect.width;
		int dy = (rect.y + rect.height) / 2 - 6;
		if (isCloseButtonEnabled)
			dx -= BUTTONSIZE;

		return new Rectangle(dx - BUTTONSIZE - WIDTHDELTA, dy, BUTTONSIZE, BUTTONSIZE);
	}

	protected void updateOverTab(int x, int y) {
		if (overTabIndex != (overTabIndex = getTabAtLocation(x, y)))
			tabScroller.tabPanel.repaint();

	}

	protected void updateCloseIcon(int x, int y) {

		if (overTabIndex != -1) {
			int newCloseIndexStatus = INACTIVE;

			Rectangle closeRect = newCloseRect(rects[overTabIndex]);
			if (closeRect.contains(x, y))
				newCloseIndexStatus = mousePressed ? PRESSED : OVER;

			if (closeIndexStatus != (closeIndexStatus = newCloseIndexStatus))
				tabScroller.tabPanel.repaint();
		}
	}

	protected void updateMaxIcon(int x, int y) {
		if (overTabIndex != -1) {
			int newMaxIndexStatus = INACTIVE;

			Rectangle maxRect = newMaxRect(rects[overTabIndex]);

			if (maxRect.contains(x, y))
				newMaxIndexStatus = mousePressed ? PRESSED : OVER;

			if (maxIndexStatus != (maxIndexStatus = newMaxIndexStatus))
				tabScroller.tabPanel.repaint();
		}
	}

	private void setTabIcons(int x, int y) {
		// if the mouse isPressed
		if (!mousePressed) {
			updateOverTab(x, y);
		}

		if (isCloseButtonEnabled)
			updateCloseIcon(x, y);
		if (isMaxButtonEnabled)
			updateMaxIcon(x, y);
	}

	public static ComponentUI createUI(JComponent c) {
		return new CloseTabPaneUI();
	}

	/**
	 * Invoked by <code>installUI</code> to create a layout manager object to
	 * manage the <code>JTabbedPane</code>.
	 * 
	 * @return a layout manager object
	 * 
	 * @see TabbedPaneLayout
	 * @see javax.swing.JTabbedPane#getTabLayoutPolicy
	 */
	protected LayoutManager createLayoutManager() {

		return new TabbedPaneScrollLayout();

	}

	/*
	 * In an attempt to preserve backward compatibility for programs which have
	 * extended BasicTabbedPaneUI to do their own layout, the UI uses the
	 * installed layoutManager (and not tabLayoutPolicy) to determine if
	 * scrollTabLayout is enabled.
	 */

	/**
	 * Creates and installs any required subcomponents for the JTabbedPane.
	 * Invoked by installUI.
	 * 
	 * @since 1.4
	 */
	protected void installComponents() {

		if (tabScroller == null) {
			tabScroller = new ScrollableTabSupport(tabPane.getTabPlacement());
			tabPane.add(tabScroller.viewport);
			tabPane.add(tabScroller.scrollForwardButton);
			tabPane.add(tabScroller.scrollBackwardButton);
		}

	}

	/**
	 * Removes any installed subcomponents from the JTabbedPane. Invoked by
	 * uninstallUI.
	 * 
	 * @since 1.4
	 */
	protected void uninstallComponents() {

		tabPane.remove(tabScroller.viewport);
		tabPane.remove(tabScroller.scrollForwardButton);
		tabPane.remove(tabScroller.scrollBackwardButton);
		tabScroller = null;

	}

	protected void installListeners() {
		if ((propertyChangeListener = createPropertyChangeListener()) != null) {
			tabPane.addPropertyChangeListener(propertyChangeListener);
		}
		if ((tabChangeListener = createChangeListener()) != null) {
			tabPane.addChangeListener(tabChangeListener);
		}
		if ((mouseListener = createMouseListener()) != null) {
			tabScroller.tabPanel.addMouseListener(mouseListener);
		}

		if ((focusListener = createFocusListener()) != null) {
			tabPane.addFocusListener(focusListener);
		}

		// PENDING(api) : See comment for ContainerHandler
		if ((containerListener = new ContainerHandler()) != null) {
			tabPane.addContainerListener(containerListener);
			if (tabPane.getTabCount() > 0) {
				htmlViews = createHTMLVector();
			}
		}

		if ((motionListener = new MyMouseMotionListener()) != null) {
			tabScroller.tabPanel.addMouseMotionListener(motionListener);
		}

	}

	protected void uninstallListeners() {
		if (mouseListener != null) {
			tabScroller.tabPanel.removeMouseListener(mouseListener);
			mouseListener = null;
		}

		if (motionListener != null) {
			tabScroller.tabPanel.removeMouseMotionListener(motionListener);
			motionListener = null;
		}

		if (focusListener != null) {
			tabPane.removeFocusListener(focusListener);
			focusListener = null;
		}

		// PENDING(api): See comment for ContainerHandler
		if (containerListener != null) {
			tabPane.removeContainerListener(containerListener);
			containerListener = null;
			if (htmlViews != null) {
				htmlViews.removeAllElements();
				htmlViews = null;
			}
		}
		if (tabChangeListener != null) {
			tabPane.removeChangeListener(tabChangeListener);
			tabChangeListener = null;
		}
		if (propertyChangeListener != null) {
			tabPane.removePropertyChangeListener(propertyChangeListener);
			propertyChangeListener = null;
		}

	}

	protected ChangeListener createChangeListener() {
		return new TabSelectionHandler();
	}

	protected void installKeyboardActions() {
		InputMap km = getMyInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

		SwingUtilities.replaceUIInputMap(tabPane, JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT, km);
		km = getMyInputMap(JComponent.WHEN_FOCUSED);
		SwingUtilities.replaceUIInputMap(tabPane, JComponent.WHEN_FOCUSED, km);

		ActionMap am = createMyActionMap();

		SwingUtilities.replaceUIActionMap(tabPane, am);

		tabScroller.scrollForwardButton.setAction(am.get("scrollTabsForwardAction"));
		tabScroller.scrollBackwardButton.setAction(am.get("scrollTabsBackwardAction"));

	}

	InputMap getMyInputMap(int condition) {
		if (condition == JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT) {
			return (InputMap) UIManager.get("TabbedPane.ancestorInputMap");
		} else if (condition == JComponent.WHEN_FOCUSED) {
			return (InputMap) UIManager.get("TabbedPane.focusInputMap");
		}
		return null;
	}

	ActionMap createMyActionMap() {
		ActionMap map = new ActionMapUIResource();
		map.put("navigateNext", new NextAction());
		map.put("navigatePrevious", new PreviousAction());
		map.put("navigateRight", new RightAction());
		map.put("navigateLeft", new LeftAction());
		map.put("navigateUp", new UpAction());
		map.put("navigateDown", new DownAction());
		map.put("navigatePageUp", new PageUpAction());
		map.put("navigatePageDown", new PageDownAction());
		map.put("requestFocus", new RequestFocusAction());
		map.put("requestFocusForVisibleComponent", new RequestFocusForVisibleAction());
		map.put("setSelectedIndex", new SetSelectedIndexAction());
		map.put("scrollTabsForwardAction", new ScrollTabsForwardAction());
		map.put("scrollTabsBackwardAction", new ScrollTabsBackwardAction());
		return map;
	}

	protected void uninstallKeyboardActions() {
		SwingUtilities.replaceUIActionMap(tabPane, null);
		SwingUtilities.replaceUIInputMap(tabPane, JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT, null);
		SwingUtilities.replaceUIInputMap(tabPane, JComponent.WHEN_FOCUSED, null);
	}

	/**
	 * Reloads the mnemonics. This should be invoked when a memonic changes,
	 * when the title of a mnemonic changes, or when tabs are added/removed.
	 */
	private void updateMnemonics() {
		resetMnemonics();
		for (int counter = tabPane.getTabCount() - 1; counter >= 0; counter--) {
			int mnemonic = tabPane.getMnemonicAt(counter);

			if (mnemonic > 0) {
				addMnemonic(counter, mnemonic);
			}
		}
	}

	/**
	 * Resets the mnemonics bindings to an empty state.
	 */
	private void resetMnemonics() {
		if (mnemonicToIndexMap != null) {
			mnemonicToIndexMap.clear();
			mnemonicInputMap.clear();
		}
	}

	/**
	 * Adds the specified mnemonic at the specified index.
	 */
	private void addMnemonic(int index, int mnemonic) {
		if (mnemonicToIndexMap == null) {
			initMnemonics();
		}
		mnemonicInputMap.put(KeyStroke.getKeyStroke(mnemonic, Event.ALT_MASK), "setSelectedIndex");
		mnemonicToIndexMap.put(new Integer(mnemonic), new Integer(index));
	}

	/**
	 * Installs the state needed for mnemonics.
	 */
	private void initMnemonics() {
		mnemonicToIndexMap = new Hashtable();
		mnemonicInputMap = new InputMapUIResource();
		mnemonicInputMap.setParent(SwingUtilities.getUIInputMap(tabPane, JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT));
		SwingUtilities.replaceUIInputMap(tabPane, JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT, mnemonicInputMap);
	}

	// UI Rendering

	public void paint(Graphics g, JComponent c) {
		int tc = tabPane.getTabCount();

		if (tabCount != tc) {
			tabCount = tc;
			updateMnemonics();
		}

		int selectedIndex = tabPane.getSelectedIndex();
		int tabPlacement = tabPane.getTabPlacement();

		ensureCurrentLayout();

		// Paint content border
		paintContentBorder(g, tabPlacement, selectedIndex);

	}

	protected void paintTab(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect) {
		Rectangle tabRect = rects[tabIndex];
		int selectedIndex = tabPane.getSelectedIndex();
		boolean isSelected = selectedIndex == tabIndex;
		boolean isOver = overTabIndex == tabIndex;
		Graphics2D g2 = null;
		Shape save = null;
		boolean cropShape = false;
		int cropx = 0;
		int cropy = 0;

		if (g instanceof Graphics2D) {
			g2 = (Graphics2D) g;

			// Render visual for cropped tab edge...
			Rectangle viewRect = tabScroller.viewport.getViewRect();
			int cropline;

			cropline = viewRect.x + viewRect.width;
			if ((tabRect.x < cropline) && (tabRect.x + tabRect.width > cropline)) {

				cropx = cropline - 1;
				cropy = tabRect.y;
				cropShape = true;
			}

			if (cropShape) {
				save = g2.getClip();
				g2.clipRect(tabRect.x, tabRect.y, tabRect.width, tabRect.height);

			}
		}

		paintTabBackground(g, tabPlacement, tabIndex, tabRect.x, tabRect.y, tabRect.width, tabRect.height, isSelected);

		paintTabBorder(g, tabPlacement, tabIndex, tabRect.x, tabRect.y, tabRect.width, tabRect.height, isSelected);

		String title = tabPane.getTitleAt(tabIndex);
		Font font = tabPane.getFont();
		FontMetrics metrics = g.getFontMetrics(font);
		Icon icon = getIconForTab(tabIndex);

		layoutLabel(tabPlacement, metrics, tabIndex, title, icon, tabRect, iconRect, textRect, isSelected);

		paintText(g, tabPlacement, font, metrics, tabIndex, title, textRect, isSelected);

		paintIcon(g, tabPlacement, tabIndex, icon, iconRect, isSelected);

		paintFocusIndicator(g, tabPlacement, rects, tabIndex, iconRect, textRect, isSelected);

		if (cropShape) {
			paintCroppedTabEdge(g, tabPlacement, tabIndex, isSelected, cropx, cropy);
			g2.setClip(save);

		} else if (isOver || isSelected) {

			int dx = tabRect.x + tabRect.width - BUTTONSIZE - WIDTHDELTA;
			int dy = (tabRect.y + tabRect.height) / 2 - 6;

			if (isCloseButtonEnabled)
				paintCloseIcon(g2, dx, dy, isOver);
			if (isMaxButtonEnabled)
				paintMaxIcon(g2, dx, dy, isOver);
		}

	}

	protected void paintCloseIcon(Graphics g, int dx, int dy, boolean isOver) {
		paintActionButton(g, dx, dy, closeIndexStatus, isOver, closeB, closeImgB);
		g.drawImage(closeImgI, dx, dy + 1, null);
	}

	protected void paintMaxIcon(Graphics g, int dx, int dy, boolean isOver) {
		if (isCloseButtonEnabled)
			dx -= BUTTONSIZE;

		paintActionButton(g, dx, dy, maxIndexStatus, isOver, maxB, maxImgB);
		g.drawImage(maxImgI, dx, dy + 1, null);
	}

	protected void paintActionButton(Graphics g, int dx, int dy, int status, boolean isOver, JButton button, BufferedImage image) {

		button.setBorder(null);

		if (isOver) {
			switch (status) {
			case OVER:
				button.setBorder(OVERBORDER);
				break;
			case PRESSED:
				button.setBorder(PRESSEDBORDER);
				break;
			}
		}

		button.setBackground(tabScroller.tabPanel.getBackground());
		button.paint(image.getGraphics());
		g.drawImage(image, dx, dy, null);
	}

	/*
	 * This method will create and return a polygon shape for the given tab
	 * rectangle which has been cropped at the specified cropline with a torn
	 * edge visual. e.g. A "File" tab which has cropped been cropped just after
	 * the "i": ------------- | ..... | | . | | ... . | | . . | | . . | | . . |
	 * --------------
	 * 
	 * The x, y arrays below define the pattern used to create a "torn" edge
	 * segment which is repeated to fill the edge of the tab. For tabs placed on
	 * TOP and BOTTOM, this righthand torn edge is created by line segments
	 * which are defined by coordinates obtained by subtracting xCropLen[i] from
	 * (tab.x + tab.width) and adding yCroplen[i] to (tab.y). For tabs placed on
	 * LEFT or RIGHT, the bottom torn edge is created by subtracting xCropLen[i]
	 * from (tab.y + tab.height) and adding yCropLen[i] to (tab.x).
	 */

	private static final int CROP_SEGMENT = 12;

	private void paintCroppedTabEdge(Graphics g, int tabPlacement, int tabIndex, boolean isSelected, int x, int y) {

		g.setColor(shadow);
		g.drawLine(x, y, x, y + rects[tabIndex].height);

	}

	private void ensureCurrentLayout() {
		if (!tabPane.isValid()) {
			tabPane.validate();
		}
		/*
		 * If tabPane doesn't have a peer yet, the validate() call will silently
		 * fail. We handle that by forcing a layout if tabPane is still invalid.
		 * See bug 4237677.
		 */
		if (!tabPane.isValid()) {
			TabbedPaneLayout layout = (TabbedPaneLayout) tabPane.getLayout();
			layout.calculateLayoutInfo();
		}
	}

	/**
	 * Returns the bounds of the specified tab in the coordinate space of the
	 * JTabbedPane component. This is required because the tab rects are by
	 * default defined in the coordinate space of the component where they are
	 * rendered, which could be the JTabbedPane (for WRAP_TAB_LAYOUT) or a
	 * ScrollableTabPanel (SCROLL_TAB_LAYOUT). This method should be used
	 * whenever the tab rectangle must be relative to the JTabbedPane itself and
	 * the result should be placed in a designated Rectangle object (rather than
	 * instantiating and returning a new Rectangle each time). The tab index
	 * parameter must be a valid tabbed pane tab index (0 to tab count - 1,
	 * inclusive). The destination rectangle parameter must be a valid
	 * <code>Rectangle</code> instance. The handling of invalid parameters is
	 * unspecified.
	 * 
	 * @param tabIndex
	 *            the index of the tab
	 * @param dest
	 *            the rectangle where the result should be placed
	 * @return the resulting rectangle
	 * 
	 * @since 1.4
	 */

	protected Rectangle getTabBounds(int tabIndex, Rectangle dest) {
		dest.width = rects[tabIndex].width;
		dest.height = rects[tabIndex].height;

		Point vpp = tabScroller.viewport.getLocation();
		Point viewp = tabScroller.viewport.getViewPosition();
		dest.x = rects[tabIndex].x + vpp.x - viewp.x;
		dest.y = rects[tabIndex].y + vpp.y - viewp.y;

		return dest;
	}

	private int getTabAtLocation(int x, int y) {
		ensureCurrentLayout();

		int tabCount = tabPane.getTabCount();
		for (int i = 0; i < tabCount; i++) {
			if (rects[i].contains(x, y)) {
				return i;
			}
		}
		return -1;
	}

	public int getOverTabIndex() {
		return overTabIndex;
	}

	/**
	 * Returns the index of the tab closest to the passed in location, note that
	 * the returned tab may not contain the location x,y.
	 */
	private int getClosestTab(int x, int y) {
		int min = 0;
		int tabCount = Math.min(rects.length, tabPane.getTabCount());
		int max = tabCount;
		int tabPlacement = tabPane.getTabPlacement();
		boolean useX = (tabPlacement == TOP || tabPlacement == BOTTOM);
		int want = (useX) ? x : y;

		while (min != max) {
			int current = (max + min) / 2;
			int minLoc;
			int maxLoc;

			if (useX) {
				minLoc = rects[current].x;
				maxLoc = minLoc + rects[current].width;
			} else {
				minLoc = rects[current].y;
				maxLoc = minLoc + rects[current].height;
			}
			if (want < minLoc) {
				max = current;
				if (min == max) {
					return Math.max(0, current - 1);
				}
			} else if (want >= maxLoc) {
				min = current;
				if (max - min <= 1) {
					return Math.max(current + 1, tabCount - 1);
				}
			} else {
				return current;
			}
		}
		return min;
	}

	/**
	 * Returns a point which is translated from the specified point in the
	 * JTabbedPane's coordinate space to the coordinate space of the
	 * ScrollableTabPanel. This is used for SCROLL_TAB_LAYOUT ONLY.
	 */
	private Point translatePointToTabPanel(int srcx, int srcy, Point dest) {
		Point vpp = tabScroller.viewport.getLocation();
		Point viewp = tabScroller.viewport.getViewPosition();
		dest.x = srcx + vpp.x + viewp.x;
		dest.y = srcy + vpp.y + viewp.y;
		return dest;
	}

	// BasicTabbedPaneUI methods

	// Tab Navigation methods

	// REMIND(aim,7/29/98): This method should be made
	// protected in the next release where
	// API changes are allowed
	//
	boolean requestMyFocusForVisibleComponent() {
		Component visibleComponent = getVisibleComponent();
		if (visibleComponent.isFocusable()) {
			visibleComponent.requestFocus();
			return true;
		} else if (visibleComponent instanceof JComponent) {
			if (((JComponent) visibleComponent).requestDefaultFocus()) {
				return true;
			}
		}
		return false;
	}

	private static class RightAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			JTabbedPane pane = (JTabbedPane) e.getSource();
			CloseTabPaneUI ui = (CloseTabPaneUI) pane.getUI();
			ui.navigateSelectedTab(EAST);
		}
	};

	private static class LeftAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			JTabbedPane pane = (JTabbedPane) e.getSource();
			CloseTabPaneUI ui = (CloseTabPaneUI) pane.getUI();
			ui.navigateSelectedTab(WEST);
		}
	};

	private static class UpAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			JTabbedPane pane = (JTabbedPane) e.getSource();
			CloseTabPaneUI ui = (CloseTabPaneUI) pane.getUI();
			ui.navigateSelectedTab(NORTH);
		}
	};

	private static class DownAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			JTabbedPane pane = (JTabbedPane) e.getSource();
			CloseTabPaneUI ui = (CloseTabPaneUI) pane.getUI();
			ui.navigateSelectedTab(SOUTH);
		}
	};

	private static class NextAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			JTabbedPane pane = (JTabbedPane) e.getSource();
			CloseTabPaneUI ui = (CloseTabPaneUI) pane.getUI();
			ui.navigateSelectedTab(NEXT);
		}
	};

	private static class PreviousAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			JTabbedPane pane = (JTabbedPane) e.getSource();
			CloseTabPaneUI ui = (CloseTabPaneUI) pane.getUI();
			ui.navigateSelectedTab(PREVIOUS);
		}
	};

	private static class PageUpAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			JTabbedPane pane = (JTabbedPane) e.getSource();
			CloseTabPaneUI ui = (CloseTabPaneUI) pane.getUI();
			int tabPlacement = pane.getTabPlacement();
			if (tabPlacement == TOP || tabPlacement == BOTTOM) {
				ui.navigateSelectedTab(WEST);
			} else {
				ui.navigateSelectedTab(NORTH);
			}
		}
	};

	private static class PageDownAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			JTabbedPane pane = (JTabbedPane) e.getSource();
			CloseTabPaneUI ui = (CloseTabPaneUI) pane.getUI();
			int tabPlacement = pane.getTabPlacement();
			if (tabPlacement == TOP || tabPlacement == BOTTOM) {
				ui.navigateSelectedTab(EAST);
			} else {
				ui.navigateSelectedTab(SOUTH);
			}
		}
	};

	private static class RequestFocusAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			JTabbedPane pane = (JTabbedPane) e.getSource();
			pane.requestFocus();
		}
	};

	private static class RequestFocusForVisibleAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			JTabbedPane pane = (JTabbedPane) e.getSource();
			CloseTabPaneUI ui = (CloseTabPaneUI) pane.getUI();
			ui.requestMyFocusForVisibleComponent();
		}
	};

	/**
	 * Selects a tab in the JTabbedPane based on the String of the action
	 * command. The tab selected is based on the first tab that has a mnemonic
	 * matching the first character of the action command.
	 */
	private static class SetSelectedIndexAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			JTabbedPane pane = (JTabbedPane) e.getSource();

			if (pane != null && (pane.getUI() instanceof CloseTabPaneUI)) {
				CloseTabPaneUI ui = (CloseTabPaneUI) pane.getUI();
				String command = e.getActionCommand();

				if (command != null && command.length() > 0) {
					int mnemonic = (int) e.getActionCommand().charAt(0);
					if (mnemonic >= 'a' && mnemonic <= 'z') {
						mnemonic -= ('a' - 'A');
					}
					Integer index = (Integer) ui.mnemonicToIndexMap.get(new Integer(mnemonic));
					if (index != null && pane.isEnabledAt(index.intValue())) {
						pane.setSelectedIndex(index.intValue());
					}
				}
			}
		}
	};

	private static class ScrollTabsForwardAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			JTabbedPane pane = null;
			Object src = e.getSource();
			if (src instanceof JTabbedPane) {
				pane = (JTabbedPane) src;
			} else if (src instanceof ScrollableTabButton) {
				pane = (JTabbedPane) ((ScrollableTabButton) src).getParent();
			} else {
				return; // shouldn't happen
			}
			CloseTabPaneUI ui = (CloseTabPaneUI) pane.getUI();

			ui.tabScroller.scrollForward(pane.getTabPlacement());

		}
	}

	private static class ScrollTabsBackwardAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			JTabbedPane pane = null;
			Object src = e.getSource();
			if (src instanceof JTabbedPane) {
				pane = (JTabbedPane) src;
			} else if (src instanceof ScrollableTabButton) {
				pane = (JTabbedPane) ((ScrollableTabButton) src).getParent();
			} else {
				return; // shouldn't happen
			}
			CloseTabPaneUI ui = (CloseTabPaneUI) pane.getUI();

			ui.tabScroller.scrollBackward(pane.getTabPlacement());

		}
	}

	/**
	 * This inner class is marked &quot;public&quot; due to a compiler bug. This
	 * class should be treated as a &quot;protected&quot; inner class.
	 * Instantiate it only within subclasses of BasicTabbedPaneUI.
	 */

	private class TabbedPaneScrollLayout extends TabbedPaneLayout {

		protected int preferredTabAreaHeight(int tabPlacement, int width) {
			return calculateMaxTabHeight(tabPlacement);
		}

		protected int preferredTabAreaWidth(int tabPlacement, int height) {
			return calculateMaxTabWidth(tabPlacement);
		}

		public void layoutContainer(Container parent) {
			int tabPlacement = tabPane.getTabPlacement();
			int tabCount = tabPane.getTabCount();
			Insets insets = tabPane.getInsets();
			int selectedIndex = tabPane.getSelectedIndex();
			Component visibleComponent = getVisibleComponent();

			calculateLayoutInfo();

			if (selectedIndex < 0) {
				if (visibleComponent != null) {
					// The last tab was removed, so remove the component
					setVisibleComponent(null);
				}
			} else {
				Component selectedComponent = tabPane.getComponentAt(selectedIndex);
				boolean shouldChangeFocus = false;

				// In order to allow programs to use a single component
				// as the display for multiple tabs, we will not change
				// the visible compnent if the currently selected tab
				// has a null component. This is a bit dicey, as we don't
				// explicitly state we support this in the spec, but since
				// programs are now depending on this, we're making it work.
				//
				if (selectedComponent != null) {
					if (selectedComponent != visibleComponent && visibleComponent != null) {
						if (SwingUtilities.findFocusOwner(visibleComponent) != null) {
							shouldChangeFocus = true;
						}
					}
					setVisibleComponent(selectedComponent);
				}
				int tx, ty, tw, th; // tab area bounds
				int cx, cy, cw, ch; // content area bounds
				Insets contentInsets = getContentBorderInsets(tabPlacement);
				Rectangle bounds = tabPane.getBounds();
				int numChildren = tabPane.getComponentCount();

				if (numChildren > 0) {

					// calculate tab area bounds
					tw = bounds.width - insets.left - insets.right;
					th = calculateTabAreaHeight(tabPlacement, runCount, maxTabHeight);
					tx = insets.left;
					ty = insets.top;

					// calculate content area bounds
					cx = tx + contentInsets.left;
					cy = ty + th + contentInsets.top;
					cw = bounds.width - insets.left - insets.right - contentInsets.left - contentInsets.right;
					ch = bounds.height - insets.top - insets.bottom - th - contentInsets.top - contentInsets.bottom;

					for (int i = 0; i < numChildren; i++) {
						Component child = tabPane.getComponent(i);

						if (child instanceof ScrollableTabViewport) {
							JViewport viewport = (JViewport) child;
							Rectangle viewRect = viewport.getViewRect();
							int vw = tw;
							int vh = th;

							int totalTabWidth = rects[tabCount - 1].x + rects[tabCount - 1].width;
							if (totalTabWidth > tw) {
								// Need to allow space for scrollbuttons
								vw = Math.max(tw - 36, 36);
								;
								if (totalTabWidth - viewRect.x <= vw) {
									// Scrolled to the end, so ensure the
									// viewport size is
									// such that the scroll offset aligns with a
									// tab
									vw = totalTabWidth - viewRect.x;
								}
							}

							child.setBounds(tx, ty, vw, vh);

						} else if (child instanceof ScrollableTabButton) {
							ScrollableTabButton scrollbutton = (ScrollableTabButton) child;
							Dimension bsize = scrollbutton.getPreferredSize();
							int bx = 0;
							int by = 0;
							int bw = bsize.width;
							int bh = bsize.height;
							boolean visible = false;

							int totalTabWidth = rects[tabCount - 1].x + rects[tabCount - 1].width;

							if (totalTabWidth > tw) {
								int dir = scrollbutton.scrollsForward() ? EAST : WEST;
								scrollbutton.setDirection(dir);
								visible = true;
								bx = dir == EAST ? bounds.width - insets.left - bsize.width : bounds.width - insets.left - 2 * bsize.width;
								by = (tabPlacement == TOP ? ty + th - bsize.height : ty);
							}

							child.setVisible(visible);
							if (visible) {
								child.setBounds(bx, by, bw, bh);
							}

						} else {
							// All content children...
							child.setBounds(cx, cy, cw, ch);
						}
					}
					if (shouldChangeFocus) {
						if (!requestMyFocusForVisibleComponent()) {
							tabPane.requestFocus();
						}
					}
				}
			}
		}

		protected void calculateTabRects(int tabPlacement, int tabCount) {
			FontMetrics metrics = getFontMetrics();
			Dimension size = tabPane.getSize();
			Insets insets = tabPane.getInsets();
			Insets tabAreaInsets = getTabAreaInsets(tabPlacement);
			int fontHeight = metrics.getHeight();
			int selectedIndex = tabPane.getSelectedIndex();
			int i, j;

			int x = tabAreaInsets.left - 2;
			int y = tabAreaInsets.top;
			int totalWidth = 0;
			int totalHeight = 0;

			//
			// Calculate bounds within which a tab run must fit
			//

			maxTabHeight = calculateMaxTabHeight(tabPlacement);

			runCount = 0;
			selectedRun = -1;

			if (tabCount == 0) {
				return;
			}

			selectedRun = 0;
			runCount = 1;

			// Run through tabs and lay them out in a single run
			Rectangle rect;
			for (i = 0; i < tabCount; i++) {
				rect = rects[i];

				if (i > 0) {
					rect.x = rects[i - 1].x + rects[i - 1].width - 1;
				} else {
					tabRuns[0] = 0;
					maxTabWidth = 0;
					totalHeight += maxTabHeight;
					rect.x = x;
				}
				rect.width = calculateTabWidth(tabPlacement, i, metrics);
				totalWidth = rect.x + rect.width;
				maxTabWidth = Math.max(maxTabWidth, rect.width);

				rect.y = y;
				rect.height = maxTabHeight /* - 2 */;

			}

			// tabPanel.setSize(totalWidth, totalHeight);
			tabScroller.tabPanel.setPreferredSize(new Dimension(totalWidth, totalHeight));
		}
	}

	private class ScrollableTabSupport implements ChangeListener {
		public ScrollableTabViewport viewport;

		public ScrollableTabPanel tabPanel;

		public ScrollableTabButton scrollForwardButton;

		public ScrollableTabButton scrollBackwardButton;

		public int leadingTabIndex;

		private Point tabViewPosition = new Point(0, 0);

		ScrollableTabSupport(int tabPlacement) {
			viewport = new ScrollableTabViewport();
			tabPanel = new ScrollableTabPanel();
			viewport.setView(tabPanel);
			viewport.addChangeListener(this);

			scrollForwardButton = createScrollableTabButton(EAST);
			scrollBackwardButton = createScrollableTabButton(WEST);
			// scrollForwardButton = new ScrollableTabButton(EAST);
			// scrollBackwardButton = new ScrollableTabButton(WEST);
		}

		public void scrollForward(int tabPlacement) {
			Dimension viewSize = viewport.getViewSize();
			Rectangle viewRect = viewport.getViewRect();

			if (tabPlacement == TOP || tabPlacement == BOTTOM) {
				if (viewRect.width >= viewSize.width - viewRect.x) {
					return; // no room left to scroll
				}
			} else { // tabPlacement == LEFT || tabPlacement == RIGHT
				if (viewRect.height >= viewSize.height - viewRect.y) {
					return;
				}
			}
			setLeadingTabIndex(tabPlacement, leadingTabIndex + 1);
		}

		public void scrollBackward(int tabPlacement) {
			if (leadingTabIndex == 0) {
				return; // no room left to scroll
			}
			setLeadingTabIndex(tabPlacement, leadingTabIndex - 1);
		}

		public void setLeadingTabIndex(int tabPlacement, int index) {
			leadingTabIndex = index;
			Dimension viewSize = viewport.getViewSize();
			Rectangle viewRect = viewport.getViewRect();

			tabViewPosition.x = leadingTabIndex == 0 ? 0 : rects[leadingTabIndex].x;

			if ((viewSize.width - tabViewPosition.x) < viewRect.width) {
				// We've scrolled to the end, so adjust the viewport size
				// to ensure the view position remains aligned on a tab boundary
				Dimension extentSize = new Dimension(viewSize.width - tabViewPosition.x, viewRect.height);
				viewport.setExtentSize(extentSize);
			}

			viewport.setViewPosition(tabViewPosition);
		}

		public void stateChanged(ChangeEvent e) {
			JViewport viewport = (JViewport) e.getSource();
			int tabPlacement = tabPane.getTabPlacement();
			int tabCount = tabPane.getTabCount();
			Rectangle vpRect = viewport.getBounds();
			Dimension viewSize = viewport.getViewSize();
			Rectangle viewRect = viewport.getViewRect();

			leadingTabIndex = getClosestTab(viewRect.x, viewRect.y);

			// If the tab isn't right aligned, adjust it.
			if (leadingTabIndex + 1 < tabCount) {

				if (rects[leadingTabIndex].x < viewRect.x) {
					leadingTabIndex++;
				}

			}
			Insets contentInsets = getContentBorderInsets(tabPlacement);

			tabPane.repaint(vpRect.x, vpRect.y + vpRect.height, vpRect.width, contentInsets.top);
			scrollBackwardButton.setEnabled(viewRect.x > 0);
			scrollForwardButton.setEnabled(leadingTabIndex < tabCount - 1 && viewSize.width - viewRect.x > viewRect.width);

		}

		public String toString() {
			return new String("viewport.viewSize=" + viewport.getViewSize() + "\n" + "viewport.viewRectangle=" + viewport.getViewRect() + "\n" + "leadingTabIndex=" + leadingTabIndex + "\n"
					+ "tabViewPosition=" + tabViewPosition);
		}

	}

	private class ScrollableTabViewport extends JViewport implements UIResource {
		public ScrollableTabViewport() {
			super();
			setScrollMode(SIMPLE_SCROLL_MODE);
		}
	}

	private class ScrollableTabPanel extends JPanel implements UIResource {
		public ScrollableTabPanel() {
			setLayout(null);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			CloseTabPaneUI.this.paintTabArea(g, tabPane.getTabPlacement(), tabPane.getSelectedIndex());

		}
	}

	protected class ScrollableTabButton extends BasicArrowButton implements UIResource, SwingConstants {
		public ScrollableTabButton(int direction) {
			super(direction, UIManager.getColor("TabbedPane.selected"), UIManager.getColor("TabbedPane.shadow"), UIManager.getColor("TabbedPane.darkShadow"), UIManager
					.getColor("TabbedPane.highlight"));

		}

		public boolean scrollsForward() {
			return direction == EAST || direction == SOUTH;
		}

	}

	/**
	 * This inner class is marked &quot;public&quot; due to a compiler bug. This
	 * class should be treated as a &quot;protected&quot; inner class.
	 * Instantiate it only within subclasses of BasicTabbedPaneUI.
	 */
	public class TabSelectionHandler implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			JTabbedPane tabPane = (JTabbedPane) e.getSource();
			tabPane.revalidate();
			tabPane.repaint();

			if (tabPane.getTabLayoutPolicy() == JTabbedPane.SCROLL_TAB_LAYOUT) {
				int index = tabPane.getSelectedIndex();
				if (index < rects.length && index != -1) {
					tabScroller.tabPanel.scrollRectToVisible(rects[index]);
				}
			}
		}
	}

	/**
	 * This inner class is marked &quot;public&quot; due to a compiler bug. This
	 * class should be treated as a &quot;protected&quot; inner class.
	 * Instantiate it only within subclasses of BasicTabbedPaneUI.
	 */

	/*
	 * GES 2/3/99: The container listener code was added to support HTML
	 * rendering of tab titles.
	 * 
	 * Ideally, we would be able to listen for property changes when a tab is
	 * added or its text modified. At the moment there are no such events
	 * because the Beans spec doesn't allow 'indexed' property changes (i.e. tab
	 * 2's text changed from A to B).
	 * 
	 * In order to get around this, we listen for tabs to be added or removed by
	 * listening for the container events. we then queue up a runnable (so the
	 * component has a chance to complete the add) which checks the tab title of
	 * the new component to see if it requires HTML rendering.
	 * 
	 * The Views (one per tab title requiring HTML rendering) are stored in the
	 * htmlViews Vector, which is only allocated after the first time we run
	 * into an HTML tab. Note that this vector is kept in step with the number
	 * of pages, and nulls are added for those pages whose tab title do not
	 * require HTML rendering.
	 * 
	 * This makes it easy for the paint and layout code to tell whether to
	 * invoke the HTML engine without having to check the string during
	 * time-sensitive operations.
	 * 
	 * When we have added a way to listen for tab additions and changes to tab
	 * text, this code should be removed and replaced by something which uses
	 * that.
	 */

	private class ContainerHandler implements ContainerListener {
		public void componentAdded(ContainerEvent e) {
			JTabbedPane tp = (JTabbedPane) e.getContainer();
			Component child = e.getChild();
			if (child instanceof UIResource) {
				return;
			}
			int index = tp.indexOfComponent(child);
			String title = tp.getTitleAt(index);
			boolean isHTML = BasicHTML.isHTMLString(title);
			if (isHTML) {
				if (htmlViews == null) { // Initialize vector
					htmlViews = createHTMLVector();
				} else { // Vector already exists
					View v = BasicHTML.createHTMLView(tp, title);
					htmlViews.insertElementAt(v, index);
				}
			} else { // Not HTML
				if (htmlViews != null) { // Add placeholder
					htmlViews.insertElementAt(null, index);
				} // else nada!
			}
		}

		public void componentRemoved(ContainerEvent e) {
			JTabbedPane tp = (JTabbedPane) e.getContainer();
			Component child = e.getChild();
			if (child instanceof UIResource) {
				return;
			}

			// NOTE 4/15/2002 (joutwate):
			// This fix is implemented using client properties since there is
			// currently no IndexPropertyChangeEvent. Once
			// IndexPropertyChangeEvents have been added this code should be
			// modified to use it.
			Integer indexObj = (Integer) tp.getClientProperty("__index_to_remove__");
			if (indexObj != null) {
				int index = indexObj.intValue();
				if (htmlViews != null && htmlViews.size() >= index) {
					htmlViews.removeElementAt(index);
				}
			}
		}
	}

	private Vector<View> createHTMLVector() {
		Vector<View> htmlViews = new Vector<View>();
		int count = tabPane.getTabCount();
		if (count > 0) {
			for (int i = 0; i < count; i++) {
				String title = tabPane.getTitleAt(i);
				if (BasicHTML.isHTMLString(title)) {
					htmlViews.addElement(BasicHTML.createHTMLView(tabPane, title));
				} else {
					htmlViews.addElement(null);
				}
			}
		}
		return htmlViews;
	}

	class MyMouseHandler extends MouseHandler {
		public MyMouseHandler() {
			super();
		}

		public void mousePressed(MouseEvent e) {
			if (closeIndexStatus == OVER) {
				closeIndexStatus = PRESSED;
				tabScroller.tabPanel.repaint();
				return;
			}

			if (maxIndexStatus == OVER) {
				maxIndexStatus = PRESSED;
				tabScroller.tabPanel.repaint();
				return;
			}

		}

		public void mouseClicked(MouseEvent e) {
			super.mousePressed(e);
			if (e.getClickCount() > 1 && overTabIndex != -1) {
				((CloseAndMaxTabbedPane) tabPane).fireDoubleClickTabEvent(e, overTabIndex);
			}
		}

		public void mouseReleased(MouseEvent e) {

			updateOverTab(e.getX(), e.getY());

			if (overTabIndex == -1) {
				if (e.isPopupTrigger())
					((CloseAndMaxTabbedPane) tabPane).firePopupOutsideTabEvent(e);
				return;
			}

			if (isOneActionButtonEnabled() && e.isPopupTrigger()) {
				super.mousePressed(e);

				closeIndexStatus = INACTIVE; // Prevent undesired action when
				maxIndexStatus = INACTIVE; // right-clicking on icons

				actionPopupMenu.show(tabScroller.tabPanel, e.getX(), e.getY());
				return;
			}

			if (closeIndexStatus == PRESSED) {
				closeIndexStatus = OVER;
				tabScroller.tabPanel.repaint();
				((CloseAndMaxTabbedPane) tabPane).fireCloseTabEvent(e, overTabIndex);
				return;
			}

			if (maxIndexStatus == PRESSED) {
				maxIndexStatus = OVER;
				tabScroller.tabPanel.repaint();
				((CloseAndMaxTabbedPane) tabPane).fireMaxTabEvent(e, overTabIndex);
				return;
			}

		}

		public void mouseExited(MouseEvent e) {
			if (!mousePressed) {
				overTabIndex = -1;
				tabScroller.tabPanel.repaint();
			}
		}

	}

	class MyMouseMotionListener implements MouseMotionListener {

		public void mouseMoved(MouseEvent e) {
			if (actionPopupMenu.isVisible())
				return; // No updates when popup is visible
			mousePressed = false;
			setTabIcons(e.getX(), e.getY());
		}

		public void mouseDragged(MouseEvent e) {
			if (actionPopupMenu.isVisible())
				return; // No updates when popup is visible
			mousePressed = true;
			setTabIcons(e.getX(), e.getY());
		}
	}

}

class CloseTabPaneEnhancedUI extends CloseTabPaneUI {

	private static final Color whiteColor = Color.white;

	private static final Color transparent = new Color(0, 0, 0, 0);

	private static final Color lightBlue = new Color(130, 200, 250, 50);

	private static final Color lightWhite = new Color(200, 200, 200, 50);

	private static final Color selectedColor = new Color(15, 70, 180);

	public static ComponentUI createUI(JComponent c) {
		return new CloseTabPaneEnhancedUI();
	}

	protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect, boolean isSelected) {
	}

	protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
		g.setColor(shadow);

		g.drawLine(x, y + 2, x, y + h - 1); // left highlight
		g.drawLine(x + 1, y + 1, x + 1, y + 1); // top-left highlight
		g.drawLine(x + 2, y, x + w - 3, y); // top highlight
		g.drawLine(x + w - 1, y + 2, x + w - 1, y + h - 1);
		g.drawLine(x + w - 2, y + 1, x + w - 2, y + 1); // top-right shadow

		if (isSelected) {
			// Do the highlights
			g.setColor(lightHighlight);
			g.drawLine(x + 2, y + 2, x + 2, y + h - 1);
			g.drawLine(x + 3, y + 1, x + w - 3, y + 1);
			g.drawLine(x + w - 3, y + 2, x + w - 3, y + 2);
			g.drawLine(x + w - 2, y + 2, x + w - 2, y + h - 1);

		}

	}

	protected void paintContentBorderTopEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {

		if (tabPane.getTabCount() < 1)
			return;

		g.setColor(shadow);
		g.drawLine(x, y, x + w - 2, y);
	}

	protected void paintContentBorderLeftEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {

		if (tabPane.getTabCount() < 1)
			return;

		g.setColor(shadow);

		g.drawLine(x, y, x, y + h - 3);
	}

	protected void paintContentBorderBottomEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {

		if (tabPane.getTabCount() < 1)
			return;

		g.setColor(shadow);
		g.drawLine(x + 1, y + h - 3, x + w - 2, y + h - 3);
		g.drawLine(x + 1, y + h - 2, x + w - 2, y + h - 2);
		g.setColor(shadow.brighter());
		g.drawLine(x + 2, y + h - 1, x + w - 1, y + h - 1);

	}

	protected void paintContentBorderRightEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {

		if (tabPane.getTabCount() < 1)
			return;

		g.setColor(shadow);

		g.drawLine(x + w - 3, y + 1, x + w - 3, y + h - 3);
		g.drawLine(x + w - 2, y + 1, x + w - 2, y + h - 3);
		g.setColor(shadow.brighter());
		g.drawLine(x + w - 1, y + 2, x + w - 1, y + h - 2);

	}

	protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
		if (isSelected) {

			GradientPaint leftGradient;
			GradientPaint rightGradient;

			int delta = 10;
			int delta2 = 8;

			if (isCloseEnabled()) {
				delta += BUTTONSIZE + WIDTHDELTA;
				delta2 += BUTTONSIZE;
			}

			if (isMaxEnabled()) {
				delta += BUTTONSIZE + WIDTHDELTA;
				delta2 += BUTTONSIZE;
			}

			if (tabPane.isEnabledAt(tabIndex)) {
				leftGradient = new GradientPaint(x, y, selectedColor, x + w / 2, y, lightBlue);

				rightGradient = new GradientPaint(x + w / 2, y, lightBlue, x + w + delta, y, transparent);
			} else {
				leftGradient = new GradientPaint(x, y, shadow, x + w / 2, y, lightWhite);

				rightGradient = new GradientPaint(x + w / 2, y, lightWhite, x + w + delta, y, transparent);
			}

			Graphics2D g2 = (Graphics2D) g;
			g2.setPaint(leftGradient);
			g2.fillRect(x + 2, y + 2, w / 2, h - 2);
			g2.setPaint(rightGradient);
			g2.fillRect(x + 2 + w / 2, y + 2, w / 2 - delta2, h - 2);
		}
	}

	protected void paintText(Graphics g, int tabPlacement, Font font, FontMetrics metrics, int tabIndex, String title, Rectangle textRect, boolean isSelected) {

		g.setFont(font);

		View v = getTextViewForTab(tabIndex);
		if (v != null) {
			// html
			v.paint(g, textRect);
		} else {
			// plain text
			int mnemIndex = tabPane.getDisplayedMnemonicIndexAt(tabIndex);

			if (tabPane.isEnabled() && tabPane.isEnabledAt(tabIndex)) {
				if (isSelected)
					g.setColor(whiteColor);
				else
					g.setColor(tabPane.getForegroundAt(tabIndex));

				BasicGraphicsUtils.drawStringUnderlineCharAt(g, title, mnemIndex, textRect.x, textRect.y + metrics.getAscent());

			} else { // tab disabled
				g.setColor(tabPane.getBackgroundAt(tabIndex).brighter());
				BasicGraphicsUtils.drawStringUnderlineCharAt(g, title, mnemIndex, textRect.x, textRect.y + metrics.getAscent());
				g.setColor(tabPane.getBackgroundAt(tabIndex).darker());
				BasicGraphicsUtils.drawStringUnderlineCharAt(g, title, mnemIndex, textRect.x - 1, textRect.y + metrics.getAscent() - 1);

			}
		}
	}

	protected class ScrollableTabButton extends CloseTabPaneUI.ScrollableTabButton {

		/**
		 * 
		 */
		private static final long serialVersionUID = 3567430829823456216L;

		public ScrollableTabButton(int direction) {
			super(direction);
			setRolloverEnabled(true);
		}

		public Dimension getPreferredSize() {
			return new Dimension(16, calculateMaxTabHeight(0));
		}

		public void paint(Graphics g) {
			Color origColor;
			boolean isPressed, isRollOver, isEnabled;
			int w, h, size;

			w = getSize().width;
			h = getSize().height;
			origColor = g.getColor();
			isPressed = getModel().isPressed();
			isRollOver = getModel().isRollover();
			isEnabled = isEnabled();

			g.setColor(getBackground());
			g.fillRect(0, 0, w, h);

			g.setColor(shadow);
			// Using the background color set above
			if (direction == WEST) {
				g.drawLine(0, 0, 0, h - 1); // left
				g.drawLine(w - 1, 0, w - 1, 0); // right
			} else
				g.drawLine(w - 2, h - 1, w - 2, 0); // right

			g.drawLine(0, 0, w - 2, 0); // top

			if (isRollOver) {
				// do highlights or shadows

				Color color1;
				Color color2;

				if (isPressed) {
					color2 = whiteColor;
					color1 = shadow;
				} else {
					color1 = whiteColor;
					color2 = shadow;
				}

				g.setColor(color1);

				if (direction == WEST) {
					g.drawLine(1, 1, 1, h - 1); // left
					g.drawLine(1, 1, w - 2, 1); // top
					g.setColor(color2);
					g.drawLine(w - 1, h - 1, w - 1, 1); // right
				} else {
					g.drawLine(0, 1, 0, h - 1);
					g.drawLine(0, 1, w - 3, 1); // top
					g.setColor(color2);
					g.drawLine(w - 3, h - 1, w - 3, 1); // right
				}

			}

			// g.drawLine(0, h - 1, w - 1, h - 1); //bottom

			// If there's no room to draw arrow, bail
			if (h < 5 || w < 5) {
				g.setColor(origColor);
				return;
			}

			if (isPressed) {
				g.translate(1, 1);
			}

			// Draw the arrow
			size = Math.min((h - 4) / 3, (w - 4) / 3);
			size = Math.max(size, 2);
			paintTriangle(g, (w - size) / 2, (h - size) / 2, size, direction, isEnabled);

			// Reset the Graphics back to it's original settings
			if (isPressed) {
				g.translate(-1, -1);
			}
			g.setColor(origColor);

		}

	}

	protected CloseTabPaneUI.ScrollableTabButton createScrollableTabButton(int direction) {
		return new ScrollableTabButton(direction);
	}

}

interface CloseListener extends EventListener {
	public void closeOperation(MouseEvent e);
}

interface MaxListener extends EventListener {
	public void maxOperation(MouseEvent e);
}

interface PopupOutsideListener extends EventListener {
	public void popupOutsideOperation(MouseEvent e);
}

interface DoubleClickListener extends EventListener {
	public void doubleClickOperation(MouseEvent e);
}
