/* Yu-chun(Eugene) Hsiao CS5004
 * Zhenning Yu CS5004
 *
 */

package cs5004.animator.model;

import java.awt.Color;

/**
 * Abstract class of shape interface.
 */
public abstract class AbstractShape implements Shape {

  protected Point2D reference;
  protected ShapeType typeOfShape;
  protected Color color;

  /**
   * Constructor of abstract class.
   *
   * @param reference center of the shape
   * @param color color of the shape
   */
  public AbstractShape(Point2D reference, Color color) {
    this.reference = reference;
    this.color = color;
  }

  /**
   * Constructor for AnimationBuilder.
   *
   */
  public AbstractShape() {
    //creates empty Shape; fields to be defined later.
  }

  /**
   * calculates the distance of shape reference point to origin.
   *
   * @return the distance as a double
   */
  public double distanceFromOrigin() {
    return this.reference.distToOrigin();
  }

  /**
   * returns the reference point.
   *
   * @return a Point2D reference point
   */
  public Point2D getReference() {
    return this.reference;
  }

  /**
   * returns the Color of the shape.
   *
   * @return the color as a Color class
   */
  public Color getColor() {
    return this.color;
  }

  /**
   * gets the type of the shape.
   *
   * @return the shape type as an enum
   */
  public ShapeType getType() {
    return typeOfShape;
  }

  /**
   * Return the RGB color in string format.
   *
   * @return string format of the color
   */
  public String getColorToString() {
    return "(" + this.color.getRed() + ","
          + this.color.getGreen() + "," + this.color.getBlue() + ")";
  }

  /**
   * updates the reference with new reference point.
   *
   */
  public void updateReference(Point2D newPoint) {
    this.reference = newPoint;
  }

  /**
   * updates the color with new color.
   *
   */
  public void updateColor(Color newColor) {
    this.color = newColor;
  }


}
