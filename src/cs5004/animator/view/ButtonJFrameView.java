/* Yu-chun(Eugene) Hsiao CS5004
 * Zhenning Yu CS5004
 *
 */

package cs5004.animator.view;

import cs5004.animator.model.ShapeSet;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * Class of button view.
 */
public class ButtonJFrameView extends JFrame implements IView {
  private JButton loopButton;
  private JButton startButton;
  private JButton pauseButton;
  private JButton resumeButton;
  private JButton restartButton;
  private JButton incSpeedButton;
  private JButton decSpeedButton;
  private JFramePanel panel;

  /**
   * Constructs a JFrameView given x,y, width, height, a list of shapes, and a speed.
   */
  public ButtonJFrameView(int x, int y, int width, int height, List<ShapeSet> shapes, int speed) {
    super("Animation");
    setSize(width,height);
    setLocation(x,y);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.panel = new JFramePanel(x, y, width ,height, shapes);
    this.add(this.panel);
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout());
    loopButton = new JButton("Loop Animation");
    loopButton.setActionCommand("loop");
    buttonPanel.add(loopButton);
    startButton = new JButton("Start Animation");
    startButton.setActionCommand("start");
    buttonPanel.add(startButton);
    pauseButton = new JButton("Pause Animation");
    pauseButton.setActionCommand("pause");
    buttonPanel.add(pauseButton);
    resumeButton = new JButton("Resume Animation");
    resumeButton.setActionCommand("resume");
    buttonPanel.add(resumeButton);
    restartButton = new JButton("Restart Animation");
    restartButton.setActionCommand("restart");
    buttonPanel.add(restartButton);
    incSpeedButton = new JButton("Increase speed of Animation");
    incSpeedButton.setActionCommand("increase");
    buttonPanel.add(incSpeedButton);
    decSpeedButton = new JButton("Decrease speed of Animation");
    decSpeedButton.setActionCommand("decrease");
    buttonPanel.add(decSpeedButton);
    panel.add(buttonPanel);
    pack();
    setVisible(true);
  }

  @Override
  public void currentView(List<ShapeSet> shapes) {
    this.panel.setShapes(shapes);
    this.panel.repaint();
    this.panel.setVisible(true);
  }

  @Override
  public String showSVGString(String s) {
    throw new UnsupportedOperationException();
  }

  @Override
  public String showString(String s) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void setListener(ActionListener listener1,ActionListener listener2,
      ActionListener listener3,ActionListener listener4,
      ActionListener listener5,ActionListener listener6,
      ActionListener listener7) {
    loopButton.addActionListener(listener1);
    startButton.addActionListener(listener2);
    pauseButton.addActionListener(listener3);
    resumeButton.addActionListener(listener4);
    restartButton.addActionListener(listener5);
    incSpeedButton.addActionListener(listener6);
    decSpeedButton.addActionListener(listener7);
  }
}
