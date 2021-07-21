/* Yu-chun(Eugene) Hsiao CS5004
 * Zhenning Yu CS5004
 *
 */

package cs5004.animator.view;

import cs5004.animator.model.ShapeSet;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Class of text view.
 */
public class TextView implements IView {

  public TextView() {
    //creates empty textview
  }

  /**
   * Return the output of text view.
   *
   * @param s toString read
   * @return output
   */
  @Override
  public String showString(String s) {
    return s;
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
   * Generate the output of visual view.
   *
   * @param shapes shapes of the animation
   */
  @Override
  public void currentView(List<ShapeSet> shapes) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void setListener(ActionListener listener1, ActionListener listener2,
      ActionListener listener3, ActionListener listener4, ActionListener listener5,
      ActionListener listener6, ActionListener listener7) {
    throw new IllegalStateException();
  }
}
