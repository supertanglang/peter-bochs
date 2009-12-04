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

public class JButtonView extends VertexView {
	MyRenderer2 renderer = new MyRenderer2();
	int portBorder = 0;

	public JButtonView(Object arg0, int portBorder) {
		super(arg0);
		this.portBorder = portBorder;
	}

	public CellViewRenderer getRenderer() {
		return renderer;
	}

	public Point2D getPerimeterPoint(EdgeView edge, Point2D source, Point2D p) {
		if (getRenderer() instanceof MyRenderer2)
			return ((MyRenderer2) getRenderer()).getPerimeterPoint(this, source, p);
		return super.getPerimeterPoint(edge, source, p);
	}

	public class MyRenderer2 extends JButton implements CellViewRenderer, Serializable {
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
			if (portBorder == 0) {
				return new Point2D.Double(x + width, y + (height / 2));
			} else {
				return new Point2D.Double(x, y + (height / 2));
			}
		}

	}

}
