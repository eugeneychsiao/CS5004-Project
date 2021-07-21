/* Yu-chun(Eugene) Hsiao CS5004
 * Zhenning Yu CS5004
 *
 */

package cs5004.animator.model;

/**
 * Class generate a set with a shape and its name.
 */
public class ShapeSet {

  private final String name;
  private final Shape s;

  /**
   * Constructor of the shape set class.
   *
   * @param name name of the shape
   * @param s shape object
   */
  public ShapeSet(String name, Shape s) {
    this.name = name;
    this.s = s;
  }

  /**
   * Return the name of the shape.
   *
   * @return return the name of the shape
   */
  public String getIdentifier() {
    return this.name;
  }

  /**
   * Return the current shape object.
   *
   * @return return the current shape object
   */
  public Shape getShape() {
    return this.s;
  }

  /**
   * Return copy of ShapeSet.
   *
   * @return return a copy of the ShapeSet
   */
  public ShapeSet copy() {
    return new ShapeSet(this.name,s.copy());
  }

}
