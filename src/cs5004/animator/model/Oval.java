/* Yu-chun(Eugene) Hsiao CS5004
 * Zhenning Yu CS5004
 *
 */

package cs5004.animator.model;

import java.awt.Color;

/**
 * Class of oval shape.
 */
public class Oval extends AbstractShape {

  private  int radiusX;
  private  int radiusY;

  /**
   * Constructor of oval shape.
   *
   * @param reference position of the shape center
   * @param radiusX radius of the x coordinate
   * @param radiusY radius of the y coordinate
   * @param color color of the shape
   */
  public Oval(Point2D reference, int radiusX, int radiusY, Color color) {
    super(reference,color);
    this.radiusX = radiusX;
    this.radiusY = radiusY;
    typeOfShape = ShapeType.oval;
  }

  /**
   * Constructor for AnimationBuilder.
   *
   */
  public Oval() {
    super();
    typeOfShape = ShapeType.oval;
  }

  /**
   * Resize the shape based on input factors.
   *
   * @return return a new shape based on reshape transformation
   */
  @Override
  public Shape resize(double radiusXFactor, double radiusYFactor) {
    Shape s =  new Oval(this.reference, (int)(radiusXFactor * radiusX),
              (int)(radiusYFactor * radiusY), this.color);
    this.radiusX = (int)(radiusXFactor * radiusX);
    this.radiusY = (int)(radiusYFactor * radiusY);
    return s;
  }

  /**
   * Return the x coordinate value of the shape.
   *
   * @return return the x coordinate value of the shape
   */
  @Override
  public int getUniqueIdentifierOne() {
    return this.radiusX;
  }

  /**
   * Return the y coordinate value of the shape.
   *
   * @return return the y coordinate value of the shape
   */
  @Override
  public int getUniqueIdentifierTwo() {
    return this.radiusY;
  }

  /**
   * Return a copy of the shape.
   *
   * @return cope of shape
   */
  @Override
  public Oval copy() {
    return new Oval(this.reference,this.radiusX,this.radiusY,this.color);
  }

  /**
   * updates IdentifierOne.
   *
   */
  @Override
  public void updateIdentifierOne(int updateIdentifierOne) {
    this.radiusX = updateIdentifierOne;
  }

  /**
   * updates IdentifierTwo.
   *
   */
  @Override
  public void updateIdentifierTwo(int updateIdentifierTwo) {
    this.radiusY = updateIdentifierTwo;
  }
}
