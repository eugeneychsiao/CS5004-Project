/* Yu-chun(Eugene) Hsiao CS5004
 * Zhenning Yu CS5004
 *
 */

package cs5004.animator.model;

/**
 * Class implementing a 2D coordinate system.
 */
public class Point2D {

  private final int x;
  private final int y;

  /**
   * Constructor of the class.
   *
   * @param x x coordinate of the point
   * @param y y coordinate of the point
   */
  public Point2D(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Return the distance of the point to the origin point(0, 0).
   *
   * @return return the distance of the point to the origin point
   */
  public double distToOrigin() {
    return Math.sqrt(x * x + y * y);
  }

  /**
   * Return the x coordinate value of the point.
   *
   * @return return the x value of the point
   */
  public int getX() {
    return this.x;
  }

  /**
   * Return the y coordinate value of the point.
   *
   * @return return the y value of the point
   */
  public int getY() {
    return this.y;
  }

  /**
   * Return the point in String format.
   *
   * @return return the String format of the point
   */
  public String toString() {
    return "(" + getX() + "," + getY() + ")";
  }
}
