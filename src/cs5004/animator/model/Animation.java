/* Yu-chun(Eugene) Hsiao CS5004
 * Zhenning Yu CS5004
 *
 */

package cs5004.animator.model;

import java.awt.Color;

/**
 * Class implementing animations.
 */
public class Animation {

  private final ShapeSet shapeAndName;
  private final int startTime;
  private final int endTime;
  private final ActionType actionType;
  private final Point2D moveTo;
  private final Color colorTo;
  private final ShapeSet scaledShape;

  /**
   * Constructor of default animation.
   *
   * @param shapeAndName set with a shape and its name
   * @param actionType type of the action
   * @param startTime start time of the action
   * @param endTime end time of the action
   */
  public Animation(ShapeSet shapeAndName, ActionType actionType, int startTime, int endTime) {
    if (shapeAndName == null || actionType == null || startTime < 0 || endTime < 0) {
      throw new IllegalArgumentException("invalid input");
    }
    this.shapeAndName = shapeAndName;
    this.startTime = startTime;
    this.endTime = endTime;
    this.actionType = actionType;
    this.moveTo = null;
    this.colorTo = null;
    this.scaledShape = null;
  }

  /**
   * Constructor for moving animation.
   *
   * @param shapeAndName set with a shape and its name
   * @param actionType type of the action
   * @param moveTo destination of the move
   * @param startTime start time of the action
   * @param endTime end time of the action
   */
  public Animation(ShapeSet shapeAndName, ActionType actionType, Point2D moveTo,
      int startTime, int endTime) {
    if (shapeAndName == null || actionType == null
        || moveTo == null || startTime < 0 || endTime < 0) {
      throw new IllegalArgumentException("invalid input");
    }
    this.shapeAndName = shapeAndName;
    this.startTime = startTime;
    this.endTime = endTime;
    this.actionType = actionType;
    this.moveTo = moveTo;
    this.colorTo = null;
    this.scaledShape = null;
  }

  /**
   * Constructor for animation changing the color.
   *
   * @param shapeAndName set with a shape and its name
   * @param actionType type of the action
   * @param colorTo the color want to change to
   * @param startTime start time of the action
   * @param endTime end time of the action
   */
  public Animation(ShapeSet shapeAndName, ActionType actionType,
      Color colorTo, int startTime, int endTime) {
    if (shapeAndName == null || actionType == null
        || colorTo == null || startTime < 0 || endTime < 0) {
      throw new IllegalArgumentException("invalid input");
    }
    this.shapeAndName = shapeAndName;
    this.startTime = startTime;
    this.endTime = endTime;
    this.actionType = actionType;
    this.moveTo = null;
    this.colorTo = colorTo;
    this.scaledShape = null;
  }

  /**
   * Constructor for scaling animation.
   *
   * @param shapeAndName set with a shape and its name
   * @param actionType type of the action
   * @param scaledShape set with a resized shape and its name
   * @param startTime start time of the action
   * @param endTime end time of the action
   */
  public Animation(ShapeSet shapeAndName, ActionType actionType,
      ShapeSet scaledShape, int startTime, int endTime) {
    if (shapeAndName == null || actionType == null
        || scaledShape == null || startTime < 0 || endTime < 0) {
      throw new IllegalArgumentException("invalid input");
    }
    this.shapeAndName = shapeAndName;
    this.startTime = startTime;
    this.endTime = endTime;
    this.actionType = actionType;
    this.moveTo = null;
    this.colorTo = null;
    this.scaledShape = scaledShape;
  }

  /**
   * Return the shape and its name.
   *
   * @return return the shape and its name
   */
  public ShapeSet getShapeAndName() {
    return this.shapeAndName;
  }

  /**
   * Return the start time of the animation.
   *
   * @return return the start time of the animation
   */
  public int getStartTime() {
    return this.startTime;
  }

  /**
   * Return the end time of the animation.
   *
   * @return return the end time of the animation
   */
  public int getEndTime() {
    return this.endTime;
  }

  /**
   * Return the type of action.
   *
   * @return return the action type
   */
  public ActionType getActionType() {
    return this.actionType;
  }

  /**
   * Return the destination of moving.
   *
   * @return return the destination of moving
   */
  public Point2D getMoveTo() {
    return this.moveTo;
  }

  /**
   * Return the color that will changed to.
   *
   * @return return the color that will changed to
   */
  public Color getColorTo() {
    return this.colorTo;
  }

  /**
   * Return the scaled shape.
   *
   * @return return the scaled shape
   */
  public ShapeSet getScaledShape() {
    return this.scaledShape;
  }
}
