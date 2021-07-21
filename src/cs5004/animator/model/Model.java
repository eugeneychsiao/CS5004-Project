/* Yu-chun(Eugene) Hsiao CS5004
 * Zhenning Yu CS5004
 *
 */

package cs5004.animator.model;

import java.awt.Color;
import java.util.List;

/**
 * Interface class of model.
 */
public interface Model {

  /**
   * Add a shape to the shape list.
   * @param identifier name of the shape
   * @param s shape object
   */
  void addShape(String identifier, Shape s);

  /**
   * Do the designated action implemented in the enum ActionType on a shape.
   *
   * @param name name of the shape
   * @param actionType type of the action
   * @param startTime start time of the action
   * @param endTime end time of the action
   */
  void action(String name, ActionType actionType, int startTime, int endTime);

  /**
   * Add an animation to the List of Animations. Animation must have a name,
   * type, move to point, and start/end time
   *
   */
  void action(String name, ActionType actionType, Point2D moveTo, int startTime, int endTime);

  /**
   * Add an animation to the List of Animations. Animation must have a name,
   * type, color to change to, and start/end time
   *
   */
  void action(String name,ActionType actionType, Color colorTo, int startTime, int endTime);

  /**
   * Add an animation to the List of Animations. Animation must have a name,
   * type, scaled factor, and start/end time
   *
   */
  void action(String name, ActionType actionType, double scaleBy1,
              double scaleBy2, int startTime, int endTime);

  /**
   * get the Shape given the identifier/name.
   *
   * @return ShapeSet with the given name
   */
  ShapeSet getShapeFromName(String name);

  /**
   * get the current state of the Shape given the identifier/name.
   *
   * @return current state ShapeSet with the given name
   */
  ShapeSet getCurrentShapeFromName(String name);

  /**
   * returns the list of shapes added through addShape.
   *
   * @return a list of ShapeSets
   */
  List<ShapeSet> getShapes();

  /**
   * returns the list of animations through the action method.
   *
   * @return a list of Animations
   */
  List<Animation> getAnimations();

  /**
   * returns the final animation time.
   *
   * @return the final animation time as an int
   */
  int getFinalTime();

  /**
   * returns the x bounds.
   *
   * @return the x bounds as int
   */
  int getBoundX();

  /**
   * returns the y bounds.
   *
   * @return the y bounds as int
   */
  int getBoundY();

  /**
   * returns the width bounds.
   *
   * @return the width bounds as int
   */
  int getBoundWidth();

  /**
   * returns the height bounds.
   *
   * @return the height bounds as int
   */
  int getBoundHeight();

  /**
   * returns List of Shapes at current time tick.
   *
   * @return a list of Shapes at given time
   */
  List<ShapeSet> getShapesAtTick(int time);

  /**
   * set the bounds given X.
   *
   */
  void setBoundX(int boundX);


  /**
   * set the bounds given Y.
   *
   */
  void setBoundY(int boundY);

  /**
   * set the bounds given width.
   *
   */
  void setBoundWidth(int boundWidth);

  /**
   * set the bounds given Height.
   *
   */
  void setBoundHeight(int boundHeight);

}
