/* Yu-chun(Eugene) Hsiao CS5004
 * Zhenning Yu CS5004
 *
 */

package cs5004.animator.controller;

import cs5004.animator.model.Model;
import cs5004.animator.view.IView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * Controller class for the animator.
 */
public class Controller implements ActionListener {
  private Model model;
  private IView view;
  private Timer timer;
  private int tick;
  private boolean doLoop;

  /**
   * Constructor of the controller.
   *
   * @param m model object of the animation
   * @param v view object of the animation
   */
  public Controller(Model m, IView v) {
    this.model = m;
    this.view = v;
    tick = 0;
    doLoop = false;
    timer = new Timer(100, new ActionListener() {


      @Override
      public void actionPerformed(ActionEvent e) {
        if (tick < m.getFinalTime()) {
          view.currentView(m.getShapesAtTick(tick));
          tick += 1;
          }
        if (doLoop && tick >= m.getFinalTime()) {
          tick = 0;
        }
      }
    });
  }

  /**
   * Implement the actions controlled the animation.
   */
  public void setActions() {
    ActionListener start = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (tick >= model.getFinalTime()) {
          tick = 0;
        }
        timer.start();
      }
    };
    ActionListener loop = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        doLoop = true;
      }
    };
    ActionListener pause = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        timer.stop();
      }
    };
    ActionListener resume = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        timer.start();
      }
    };
    ActionListener restart = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        tick = 0;
        timer.restart();
      }
    };
    ActionListener increaseSpeed = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        timer.setDelay(timer.getDelay() / 2);
      }
    };
    ActionListener decreaseSpeed = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        timer.setDelay(timer.getDelay() * 2);
      }
    };
    view.setListener(loop, start,pause, resume,restart,increaseSpeed,decreaseSpeed);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    //required for extending actionListener
  }
}
