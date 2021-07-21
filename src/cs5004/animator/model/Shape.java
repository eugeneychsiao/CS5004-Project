/* Yu-chun(Eugene) Hsiao CS5004
 * Zhenning Yu CS5004
 *
 */

package cs5004.animator.model;

import java.awt.Color;

/**
 * Interface class of shapes.
 */
public interface Shape {

  /**
   * Get the distance of the reference point to the origin point (0, 0).
   *
   * @return return the distance value
   */
  double distanceFromOrigin();

  /**
   * Change the size of current shape.
   *
   * @param factor1 UniqueIdentifierOne
   * @param factor2 UniqueIdentifierTwo
   * @return return the changed shape
   */
  Shape resize(double factor1, double factor2);

  /**
   * Return the type of current shape.
   *
   * @return return the type of current shape
   */
  Point2D getReference();

  /**
   * Return the type of the shape.
   *
   * @return return the type of the shape
   */
  ShapeType getType();

  /**
   * Return the first unique identifier.
   *
   * @return return the first unique identifier
   */
  int getUniqueIdentifierOne();

  /**
   * Return the second unique identifier.
   *
   * @return return the second unique identifier
   */
  int getUniqueIdentifierTwo();

  /**
   * Return the color of current shape.
   *
   * @return return the color of current shape
   */
  Color getColor();

  /**
   * Return the RGB color in string format.
   *
   * @return string format of the color
   */
  String getColorToString();

  /**
   * updates the reference with new reference point.
   *
   */
  void updateReference(Point2D newPoint);

  /**
   * updates the color with new color.
   *
   */
  void updateColor(Color newColor);

  /**
   * updates IdentifierOne.
   *
   */
  void updateIdentifierOne(int newIdentifierOne);

  /**
   * updates IdentifierTwo.
   *
   */
  void updateIdentifierTwo(int newIdentifierTwo);

  /**
   * Return a copy of the shape.
   *
   * @return cope of shape
   */
  Shape copy();

}
