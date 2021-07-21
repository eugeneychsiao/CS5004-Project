/* Yu-chun(Eugene) Hsiao CS5004
 * Zhenning Yu CS5004
 *
 */

package cs5004.animator;

import cs5004.animator.controller.Controller;
import cs5004.animator.model.Model;
import cs5004.animator.model.ModelImpl.AnimationBuilderImpl;
import cs5004.animator.model.ShapeSet;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.ButtonJFrameView;
import cs5004.animator.view.IView;
import cs5004.animator.view.JFrameView;
import cs5004.animator.view.SVGView;
import cs5004.animator.view.TextView;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Main class of the animator.
 */
public final class EasyAnimator {

  /**
   * Read arguments from command line and generate the output.
   *
   * @param args command line arguments
   * @throws FileNotFoundException throws if there is no such input file
   */
  public static void main(String []args) throws FileNotFoundException {
    int i;
    String input = "";
    String typeOfView = "";
    String output = "SO";
    int speed = 1;

    for (i = 0; i < args.length; i = i + 2) {
      String arg = args[i];
      switch (arg) {
        case "-in":
          input = args[i + 1];
          break;
        case "-view":
          if (args[i + 1].equalsIgnoreCase("text")) {
            typeOfView = "text";
          } else if (args[i + 1].equalsIgnoreCase("svg")) {
            typeOfView = "svg";
          } else if (args[i + 1].equalsIgnoreCase("visual")) {
            typeOfView = "visual";
          } else if (args[i + 1].equalsIgnoreCase("playback")) {
            typeOfView = "playback";
          }
          break;
        case "-speed":
          speed = Integer.parseInt(args[i + 1]);
          break;
        case "-out":
          output = args[i + 1];
          break;
        default:
          JOptionPane.showMessageDialog(null,
                                "Invalid command line argument.\n");
          break;
      }
    }

    if (typeOfView.equals("") || input.equals("")) {
      JOptionPane.showMessageDialog(null,
                            "Must include input file and view types.\n");
    }

    Model m = AnimationReader.parseFile(
        new FileReader(input),
        new AnimationBuilderImpl());

    switch (typeOfView) {
      case "text":
        if (output.equals("SO")) {
          IView textview = new TextView();
          System.out.print(textview.showString(m.toString()));
        } else {
          try {
            IView textview = new TextView();
            Files.writeString(Path.of(output), textview.showString(m.toString()));
          } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Cannot generate output.\n");
          }
        }
        break;
      case "svg":
        if (output.equals("SO")) {
          IView svg = new SVGView(speed);
          System.out.print(svg.showSVGString(m.toString()));
        } else {
          try {
            IView svg = new SVGView(speed);
            Files.writeString(Path.of(output), svg.showSVGString(m.toString()));
          } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Cannot generate output.\n");
          }
        }
        break;
      case "visual":
        List<ShapeSet> s = new ArrayList<ShapeSet>();
        int count = 0;
        IView newAnimation = new JFrameView(m.getBoundX(), m.getBoundY(),
            m.getBoundWidth(), m.getBoundHeight(), s, speed);
        while (count < m.getFinalTime()) {
          newAnimation.currentView(m.getShapesAtTick(count));
          count += 1;
          try {
            Thread.sleep(50);
          } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
          }
        }
        break;
      case "playback":
        List<ShapeSet> ss = new ArrayList<ShapeSet>();
        int c = 0;
        IView newAnimations = new ButtonJFrameView(m.getBoundX(), m.getBoundY(),
            m.getBoundWidth(), m.getBoundHeight(), ss, speed);
        Controller controller = new Controller(m, newAnimations);
        controller.setActions();
        while (c < m.getFinalTime()) {
          newAnimations.currentView(m.getShapesAtTick(c));
          c += 1;
          try {
            Thread.sleep(50);
          } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
          }
        }
        break;
      default:
        break;

    }
  }
}
