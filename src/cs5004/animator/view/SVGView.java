/* Yu-chun(Eugene) Hsiao CS5004
 * Zhenning Yu CS5004
 *
 */

package cs5004.animator.view;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cs5004.animator.model.ShapeSet;

/**
 * Class of SVG view.
 */
public class SVGView implements IView {
  private final int speed;

  /**
   * Constructor of the svg view.
   *
   * @param t speed of the animation
   */
  public SVGView(int t) {
    speed = 1000 / t;
  }

  /**
   * Return the output of text view.
   *
   * @param s toString read
   * @return output
   */
  @Override
  public String showString(String s) {
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
    StringBuilder output = new StringBuilder();
    Map<String, StringBuilder> dict = new HashMap<String, StringBuilder>();
    String[] lns = s.split("\n");
    int i;
    String[] background = lns[0].split(" ");
    output.append("<svg viewBox=\"").append(background[4]).append(" ").append(background[6]).append(" ").append(background[8]).append(" ").append(background[10]).append("\" xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\">\n\n");
    for (i = 1; i < lns.length; i++) {
      int j;
      String[] line = lns[i].split(" ");
      if (line.length > 0) {
        switch (line[0]) {
          case "Create":
            String[] p = line[7].substring(1, line[7].length() - 2).split(",");
            if (line[2].equals("oval")) {
              dict.put(line[3], new StringBuilder());
              dict.get(line[3]).append("<ellipse id=\"").append(line[3]).append("\" x=\"")
                  .append(p[0]).append("\" y=\"").append(p[1]).append("\" rx=\"").append(line[10])
                  .append("\" ry=\"").append(line[12]).append("\" fill=\"rgb").append(line[1])
                  .append("\" visibility=\"hidden\" >\n");
            } else if (line[2].equals("rectangle")) {
              dict.put(line[3], new StringBuilder());
              dict.get(line[3]).append("<rect id=\"").append(line[3]).append("\" x=\"")
                  .append(p[0]).append("\" y=\"").append(p[1]).append("\" width=\"")
                  .append(line[10]).append("\" height=\"").append(line[12]).append("\" fill=\"rgb")
                  .append(line[1]).append("\" visibility=\"hidden\" >\n");
            }
            break;
          case "Shape":
            switch (line[2]) {
              case "appears":
                dict.get(line[1]).append("    <set attributeName=\"visibility\" attributeTyp"
                    + "e=\"CSS\" to=\"visible\" begin=\"").append(Integer.parseInt(line[5]
                    .substring(2)) * speed).append("ms\" dur=\"")
                    .append((Integer.parseInt(line[10].substring(2))
                        - Integer.parseInt(line[5].substring(2)))
                        * speed).append("ms\" fill=\"freeze\" />\n");
                break;
              case "moves":
                dict.get(line[1]).append("    <set attributeName=\"visibility\" attributeTyp"
                    + "e=\"CSS\" to=\"visible\" begin=\"").append(Integer.parseInt(line[9]
                    .substring(2)) * speed).append("ms\" dur=\"")
                    .append((Integer.parseInt(line[12].substring(2))
                        - Integer.parseInt(line[9].substring(2)))
                        * speed).append("ms\" fill=\"freeze\" />\n");
                String[] f = line[4].substring(1, line[4].length() - 2).split(",");
                String[] t = line[6].substring(1, line[6].length() - 2).split(",");
                if (!f[0].equals(t[0])) {
                  dict.get(line[1]).append("    <animate attributeType=\"xml\" begin=\"")
                      .append(Integer.parseInt(line[9].substring(2)) * speed)
                      .append("ms\" dur=\"").append((Integer.parseInt(line[12].substring(2))
                      - Integer.parseInt(line[9].substring(2))) * speed)
                      .append("ms\" attributeName=\"x\" from=\"").append(f[0]).append("\" to=\"")
                      .append(t[0]).append("\" fill=\"freeze\" />\n");
                }
                if (!f[1].equals(t[1])) {
                  dict.get(line[1]).append("    <animate attributeType=\"xml\" begin=\"")
                      .append(Integer.parseInt(line[9].substring(2)) * speed)
                      .append("ms\" dur=\"").append((Integer.parseInt(line[12].substring(2))
                      - Integer.parseInt(line[9].substring(2))) * speed)
                      .append("ms\" attributeName=\"y\" from=\"").append(f[1]).append("\" to=\"")
                      .append(t[1]).append("\" fill=\"freeze\" />\n");
                }
                break;
              case "changes":
                if (line[3].equals("color")) {
                  dict.get(line[1]).append("    <animate attributeName=\"fill\" "
                      + "attributeType=\"CSS\" from=\"rgb").append(line[5])
                      .append("\" to=\"rgb").append(line[7]).append("\" />\n");
                }
                else if (line[3].equals("from")) {
                  dict.get(line[1]).append("    <set attributeName=\"visibility\" "
                      + "attributeType=\"CSS\" to=\"visible\" begin=\"")
                      .append(Integer.parseInt(line[15].substring(2)) * speed)
                      .append("ms\" dur=\"").append((Integer.parseInt(line[18].substring(2))
                      - Integer.parseInt(line[15].substring(2))) * speed)
                      .append("ms\" fill=\"freeze\" />\n");
                  if (dict.get(line[1]).toString().charAt(1) == 'r') {
                    dict.get(line[1]).append("    <animate attributeName=\"width\" "
                        + "attributeType=\"XML\" begin=\"").append(Integer.parseInt(line[15]
                        .substring(2)) * speed).append("s\" dur=\"")
                        .append((Integer.parseInt(line[18].substring(2))
                            - Integer.parseInt(line[15].substring(2))) * speed)
                        .append("s\" fill=\"freeze\" from=\"")
                        .append(line[5].substring(0, line[5].length() - 2))
                        .append("\" to=\"").append(line[10].substring(0, line[10].length() - 2))
                        .append("\" />\n");
                    dict.get(line[1]).append("    <animate attributeName=\"height\" "
                        + "attributeType=\"XML\" begin=\"").append(Integer
                        .parseInt(line[15].substring(2)) * speed).append("s\" dur=\"")
                        .append((Integer.parseInt(line[18].substring(2))
                            - Integer.parseInt(line[15].substring(2))) * speed)
                        .append("s\" fill=\"freeze\" from=\"").append(line[7])
                        .append("\" to=\"").append(line[12]).append("\" />\n");
                  }
                  else if (dict.get(line[1]).toString().charAt(1) == 'e') {
                    dict.get(line[1]).append("    <animate attributeName=\"rx\" "
                        + "attributeType=\"XML\" begin=\"")
                        .append(Integer.parseInt(line[15].substring(2)) * speed)
                        .append("s\" dur=\"").append((Integer.parseInt(line[18].substring(2))
                        - Integer.parseInt(line[15].substring(2))) * speed)
                        .append("s\" fill=\"freeze\" from=\"")
                        .append(line[5].substring(0, line[5].length() - 2))
                        .append("\" to=\"")
                        .append(line[10].substring(0, line[10].length() - 2)).append("\" />\n");
                    dict.get(line[1]).append("    <animate attributeName=\"ry\" "
                        + "attributeType=\"XML\" begin=\"")
                        .append(Integer.parseInt(line[15].substring(2)) * speed)
                        .append("s\" dur=\"").append((Integer.parseInt(line[18].substring(2))
                        - Integer.parseInt(line[15].substring(2))) * speed)
                        .append("s\" fill=\"freeze\" from=\"").append(line[7])
                        .append("\" to=\"").append(line[12]).append("\" />\n");
                  }
                }
                break;
              default:
                throw new IllegalArgumentException("Invalid action\n");
            }
            break;
          default:
            throw new IllegalStateException("Invalid arguments\n");
        }
      }
    }
    dict.forEach((k, v) -> {
      output.append(v);
      if (v.substring(1, 2).equals("r")) {
        output.append("</rect>\n\n");
      }
      else if (v.substring(1, 2).equals("e")) {
        output.append("</ellipse>\n\n");
      }
    });
    output.append("</svg>");
    return output.toString();
  }

  /**
   * Generate the output of visual view.
   *
   * @param shapes shapes of the animation
   */
  @Override
  public void currentView(List<ShapeSet> shapes) {
    throw new IllegalStateException();
  }

  @Override
  public void setListener(ActionListener listener1, ActionListener listener2,
      ActionListener listener3, ActionListener listener4, ActionListener listener5,
      ActionListener listener6, ActionListener listener7) {
    throw new IllegalStateException();
  }
}
