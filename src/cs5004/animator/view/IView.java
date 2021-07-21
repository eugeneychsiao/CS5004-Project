/* Yu-chun(Eugene) Hsiao CS5004
 * Zhenning Yu CS5004
 *
 */

package cs5004.animator.view;

import cs5004.animator.model.ShapeSet;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Interface of view.
 */
public interface IView {

  /**
   * Return the output of text view.
   *
   * @param s toString read
   * @return output
   */
  String showString(String s);

  /**
   * Return the output of svg view.
   *
   * @param s toString read
   * @return output
   */
  String showSVGString(String s);

  /**
   * Generate the output of visual view.
   *
   * @param shapes shapes of the animation
   */
  void currentView(List<ShapeSet> shapes);

  void setListener(ActionListener listener1,ActionListener listener2,ActionListener listener3,
                  ActionListener listener4,ActionListener listener5,ActionListener listener6,
                  ActionListener listener7);

}
