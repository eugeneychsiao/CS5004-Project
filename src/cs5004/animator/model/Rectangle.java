/* Yu-chun(Eugene) Hsiao CS5004
 * Zhenning Yu CS5004
 *
 */

package cs5004.animator.model;

import java.awt.Color;

/**
 * Class of rectangle shape.
 */
public class Rectangle extends AbstractShape {

  private  int width;
  private  int height;

  /**
   * Constructor of rectangle shape.
   *
   * @param reference position of the shape center
   * @param width width of the shape
   * @param height height of the shape
   * @param color color of the shape
   */
  public Rectangle(Point2D reference, int width, int height, Color color) {
    super(reference,color);
    this.width = width;
    this.height = height;
    typeOfShape = ShapeType.rectangle;
  }

  /**
   * Constructor for AnimationBuilder.
   *
   */
  public Rectangle() {
    super();
    typeOfShape = ShapeType.rectangle;
  }

  /**
   * Resize the shape based on input factors.
   *
   * @return return a new shape based on reshape transformation
   */
  @Override
  public Shape resize(double widthFactor, double heightFactor) {
    Shape s =  new Rectangle(this.reference,(int)(widthFactor * width),
              (int)(heightFactor * height), this.color);
    this.width = (int)(widthFactor * width);
    this.height = (int)(heightFactor * height);
    return s;
  }

  /**
   * Return the width of the shape.
   *
   * @return return the width of the shape
   */
  @Override
  public int getUniqueIdentifierOne() {
    return this.width;
  }

  /**
   * Return the height of the shape.
   *
   * @return return the height of the shape
   */
  @Override
  public int getUniqueIdentifierTwo() {
    return this.height;
  }

  /**
   * Return a copy of the shape.
   *
   * @return cope of shape
   */
  @Override
  public Rectangle copy() {
    return new Rectangle(this.reference,this.width,this.height,this.color);
  }

  /**
   * updates IdentifierOne.
   *
   */
  @Override
  public void updateIdentifierOne(int updateIdentifierOne) {
    this.width = updateIdentifierOne;
  }

  /**
   * updates IdentifierTwo.
   *
   */
  @Override
  public void updateIdentifierTwo(int updateIdentifierTwo) {
    this.height = updateIdentifierTwo;
  }
}
