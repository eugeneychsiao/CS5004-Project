/* Yu-chun(Eugene) Hsiao CS5004
 * Zhenning Yu CS5004
 *
 */

package cs5004.animator.view;

import cs5004.animator.model.ShapeSet;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Class of visual view.
 */
public class JFrameView extends JFrame implements IView {
  private JLabel display;
  private JFramePanel panel;

  /**
   * Constructs a JFrameView given x,y, width, height, a list of shapes, and a speed.
   */
  public JFrameView(int x, int y, int width, int height, List<ShapeSet> shapes, int speed) {
    super("Animation");
    setSize(width,height);
    setLocation(x,y);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.panel = new JFramePanel(x, y, width ,height, shapes);
    this.setVisible(true);
    this.add(this.panel);
    this.panel.setVisible(true);
  }

  /**
   * Generate the output of visual view.
   *
   * @param shapes shapes of the animation
   */
  @Override
  public void currentView(List<ShapeSet> shapes) {
    this.panel.setShapes(shapes);
    this.panel.repaint();
    this.panel.setVisible(true);
  }

  @Override
  public void setListener(ActionListener listener1, ActionListener listener2,
      ActionListener listener3, ActionListener listener4, ActionListener listener5,
      ActionListener listener6, ActionListener listener7) {
    throw new IllegalStateException();
  }

  /**
   * Return the output of svg view.
   *
   * @param s toString read
   * @return output
   */
  @Override
  public String showSVGString(String s) {
    throw new UnsupportedOperationException();
  }

  /**
   * Return the output of text view.
   *
   * @param s toString read
   * @return output
   */
  @Override
  public String showString(String s) {
    throw new UnsupportedOperationException();
  }
}
