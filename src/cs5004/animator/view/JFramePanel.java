/* Yu-chun(Eugene) Hsiao CS5004
 * Zhenning Yu CS5004
 *
 */

package cs5004.animator.view;

import cs5004.animator.model.ShapeSet;
import cs5004.animator.model.ShapeType;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * JFramePanel class. Draws panels based on list of shapes.
 */
public class JFramePanel extends JPanel {

  private List<ShapeSet> shapes;

  /**
   * Constructs a JFramePanel given x,y, width, height and a list of shapes.
   */
  public JFramePanel(int x, int y, int width, int height, List<ShapeSet> shapes) {
    super(true);
    this.shapes = shapes;
    setSize(width, height);
    setLocation(x,y);
    setBackground(Color.white);
    setBorder(new LineBorder(Color.BLACK,3));

  }

  /**
   * Constructs a JFramePanel given only shapes.
   */
  public JFramePanel(List<ShapeSet> shapes) {
    super(true);
    this.shapes = shapes;
    setBackground(Color.white);
    setBorder(new LineBorder(Color.BLACK,3));
  }

  /**
   * Draws the shape using the Graphics class.
   */
  @Override
  protected void paintComponent(Graphics g) {
    //System.out.println("paintComponent is called");
    // never forget to call super.paintComponent!
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    if (this.shapes == null) {
      return;
    }
    for (ShapeSet s: this.shapes) {
      g2d.setColor(s.getShape().getColor());
      if (s.getShape().getType() == ShapeType.rectangle ) {
        g2d.drawRect(s.getShape().getReference().getX(), s.getShape().getReference().getY(),
            s.getShape().getUniqueIdentifierOne(), s.getShape().getUniqueIdentifierTwo());
        g2d.fillRect(s.getShape().getReference().getX(), s.getShape().getReference().getY(),
            s.getShape().getUniqueIdentifierOne(), s.getShape().getUniqueIdentifierTwo());
      } else if (s.getShape().getType() == ShapeType.oval) {
        g2d.drawOval(s.getShape().getReference().getX(),s.getShape().getReference().getY(),
            s.getShape().getUniqueIdentifierOne(),s.getShape().getUniqueIdentifierTwo());
        g2d.fillOval(s.getShape().getReference().getX(),s.getShape().getReference().getY(),
            s.getShape().getUniqueIdentifierOne(),s.getShape().getUniqueIdentifierTwo());
      }
    }
  }

  public void setShapes(List<ShapeSet> s) {
    this.shapes = s;
  }
}
