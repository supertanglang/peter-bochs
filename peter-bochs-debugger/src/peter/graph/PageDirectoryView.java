package peter.graph;

import java.awt.Component;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

import javax.swing.JButton;

import org.jgraph.JGraph;
import org.jgraph.graph.CellView;
import org.jgraph.graph.CellViewRenderer;
import org.jgraph.graph.EdgeView;
import org.jgraph.graph.VertexView;

public class PageDirectoryView extends VertexView {
	protected static MyRenderer renderer = new MyRenderer();

	public PageDirectoryView(Object arg0) {
		super(arg0);
	}

	public CellViewRenderer getRenderer() {
		return renderer;
	}

	public Point2D getPerimeterPoint(EdgeView edge, Point2D source, Point2D p) {
		if (getRenderer() instanceof MyRenderer)
			return ((MyRenderer) getRenderer()).getPerimeterPoint(this, source, p);
		return super.getPerimeterPoint(edge, source, p);
	}

	public static class MyRenderer extends JButton implements CellViewRenderer, Serializable {
		public Component getRendererComponent(JGraph graph, CellView view, boolean sel, boolean focus, boolean preview) {
			this.setText(view.getCell().toString());
			return this;
		}

		public Point2D getPerimeterPoint(VertexView view, Point2D source, Point2D p) {
			Rectangle2D bounds = view.getBounds();
			double x = bounds.getX();
			double y = bounds.getY();
			double width = bounds.getWidth();
			double height = bounds.getHeight();
			double xCenter = x + width / 2;
			double yCenter = y + height / 2;
			double dx = p.getX() - xCenter; // Compute Angle
			double dy = p.getY() - yCenter;
			double alpha = Math.atan2(dy, dx);
			double xout = 0, yout = 0;
			double pi = Math.PI;
			double pi2 = Math.PI / 2.0;
			double beta = pi2 - alpha;
			double t = Math.atan2(height, width);
			if (alpha < -pi + t || alpha > pi - t) { // Left edge
				xout = x;
				yout = yCenter - width * Math.tan(alpha) / 2;
			} else if (alpha < -t) { // Top Edge
				yout = y;
				xout = xCenter - height * Math.tan(beta) / 2;
			} else if (alpha < t) { // Right Edge
				xout = x + width;
				yout = yCenter + width * Math.tan(alpha) / 2;
			} else { // Bottom Edge
				yout = y + height;
				xout = xCenter + height * Math.tan(beta) / 2;
			}
			return new Point2D.Double(xout, yout);
		}

	}

}
