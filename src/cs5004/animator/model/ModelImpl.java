/* Yu-chun(Eugene) Hsiao CS5004
 * Zhenning Yu CS5004
 *
 */

package cs5004.animator.model;

import cs5004.animator.util.AnimationBuilder;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Class implementing model interface.
 */
public class ModelImpl implements Model {

  private final List<ShapeSet> shapes;
  private final List<Animation> animations;
  private final List<ShapeSet> CurrentState;
  private int boundX;
  private int boundY;
  private int boundWidth;
  private int boundHeight;

  /**
   * Constructor that create an empty list of shapes.
   */
  public ModelImpl() {
    shapes = new ArrayList<ShapeSet>();
    animations = new ArrayList<Animation>();
    CurrentState = new ArrayList<ShapeSet>();
    this.boundX = 0;
    this.boundY = 0;
    this.boundWidth = 0;
    this.boundHeight = 0;

  }

  /**
   * Add shape and a given name to list.
   *
   */
  public void addShape(String name, Shape s) {
    if (name == null || s == null || name.equals("")) {
      throw new IllegalArgumentException("invalid name or shape");
    }
    for (ShapeSet shapes: shapes) {
      if (name.equals(shapes.getIdentifier())) {
        throw new IllegalArgumentException("name is taken");
      }
    }
    shapes.add(new ShapeSet(name, s));
    CurrentState.add(new ShapeSet(name, s.copy()));
  }

  /**
   * Add an animation to the List of Animations. Animation must have a name,
   * type, and start/end time
   *
   */
  @Override
  public void action(String name, ActionType actionType, int startTime, int endTime) {
    if (name == null || actionType == null || startTime < 0 || endTime < 0 || endTime < startTime) {
      throw new IllegalArgumentException("invalid input");
    }
    for (Animation a : animations) {
      if (a.getShapeAndName().getIdentifier().equals(name) && a.getActionType() == actionType) {
        if ((endTime > a.getStartTime() && endTime < a.getEndTime())
            || (startTime < a.getEndTime() && startTime > a.getStartTime())) {
          throw new IllegalArgumentException("overlapping time intervals");
        }
      }
    }
    for (ShapeSet s : CurrentState) {
      if (s.getIdentifier().equals(name) && actionType == ActionType.AppearDisappear) {
        animations.add(new Animation(s.copy(), actionType, startTime, endTime));
      }
    }
  }

  /**
   * Add an animation to the List of Animations. Animation must have a name,
   * type, move to point, and start/end time
   *
   */
  public void action(String name, ActionType actionType,
      Point2D moveTo, int startTime, int endTime) {
    if (name == null || actionType == null || moveTo == null || startTime < 0 || endTime < 0) {
      throw new IllegalArgumentException("invalid input");
    }
    for (Animation a : animations) {
      if (a.getShapeAndName().getIdentifier().equals(name) && a.getActionType() == actionType) {
        if ((endTime > a.getStartTime() && endTime < a.getEndTime())
            || (startTime < a.getEndTime() && startTime > a.getStartTime())) {
          throw new IllegalArgumentException("overlapping time intervals");
        }
      }
    }
    for (ShapeSet s : CurrentState) {
      if (s.getIdentifier().equals(name) && actionType == ActionType.Move) {
        animations.add(new Animation(s.copy(), actionType, moveTo, startTime, endTime));
        s.getShape().updateReference(moveTo);
      }
    }
  }

  /**
   * Add an animation to the List of Animations. Animation must have a name,
   * type, color to change to, and start/end time
   *
   */
  public void action(String name,ActionType actionType, Color colorTo, int startTime, int endTime) {
    if (name == null || actionType == null || colorTo == null || startTime < 0 || endTime < 0) {
      throw new IllegalArgumentException("invalid input");
    }
    for (Animation a : animations) {
      if (a.getShapeAndName().getIdentifier().equals(name) && a.getActionType() == actionType) {
        if ((endTime > a.getStartTime() && endTime < a.getEndTime())
            || (startTime < a.getEndTime() && startTime > a.getStartTime())) {
          throw new IllegalArgumentException("overlapping time intervals");
        }
      }
    }
    for (ShapeSet s : CurrentState) {
      if (s.getIdentifier().equals(name) && actionType == ActionType.Color) {
        animations.add(new Animation(s.copy(), actionType, colorTo, startTime, endTime));
        s.getShape().updateColor(colorTo);
      }
    }
  }

  /**
   * Add an animation to the List of Animations. Animation must have a name,
   * type, scaled factor, and start/end time
   *
   */
  public void action(String name, ActionType actionType,
      double scaleBy1, double scaleBy2, int startTime, int endTime) {
    if (name == null || actionType == null || scaleBy1 < 0
        || scaleBy2 < 0 || startTime < 0 || endTime < 0 ) {
      throw new IllegalArgumentException("invalid input");
    }
    for (Animation a : animations) {
      if (a.getShapeAndName().getIdentifier().equals(name) && a.getActionType() == actionType) {
        if ((endTime > a.getStartTime() && endTime < a.getEndTime())
            || (startTime < a.getEndTime() && startTime > a.getStartTime())) {
          throw new IllegalArgumentException("overlapping time intervals");
        }
      }
    }
    for (ShapeSet s : CurrentState) {
      if (s.getIdentifier().equals(name) && actionType == ActionType.Scale) {
        ShapeSet copied = s.copy();
        animations.add(new Animation(copied, actionType, new ShapeSet(s.getIdentifier(),
                      s.getShape().resize(scaleBy1,scaleBy2)), startTime, endTime));
      }
    }
  }

  /**
   * returns a list of created shapes and list of animations in text form.
   *
   * @return a string of shapes and animations created
   */
  public String toString() {
    String s = "";
    s += "Create canvas with X: " + this.getBoundX() + " Y: " + this.getBoundY() + " Width: "
        + this.getBoundWidth() + " Height: " + this.getBoundHeight() + "\n";
    for (ShapeSet shape: shapes) {
      switch (shape.getShape().getType()) {
        case rectangle:
          s += "Create " + shape.getShape().getColorToString() + " rectangle "
                  + shape.getIdentifier() + " with corner at " + shape.getShape().getReference()
                  + " , width " + shape.getShape().getUniqueIdentifierOne() + " and height "
                  + shape.getShape().getUniqueIdentifierTwo() + "\n";
          break;
        case oval:
          s +=  "Create " + shape.getShape().getColorToString() + " oval "
              + shape.getIdentifier() + " with center at " + shape.getShape().getReference()
              + " , radius " + shape.getShape().getUniqueIdentifierOne()
              + " and " + shape.getShape().getUniqueIdentifierTwo() + "\n";
          break;
        default:
          s += "";
      }
    }
    for (Animation a: animations) {
      switch (a.getActionType()) {
        case AppearDisappear:
          s += "Shape " + a.getShapeAndName().getIdentifier() + " appears at time t="
              + a.getStartTime() + " and disappears at time t=" + a.getEndTime() + "\n";
          break;
        case Move:
          s += "Shape " + a.getShapeAndName().getIdentifier() + " moves from "
              + a.getShapeAndName().getShape().getReference().toString() + " to "
              + a.getMoveTo().toString() + " from time t=" + a.getStartTime() + " to time t="
              + a.getEndTime() + "\n";
          break;
        case Color:
          s += "Shape " + a.getShapeAndName().getIdentifier() + " changes color from "
              + a.getShapeAndName().getShape().getColorToString()
              + " to " + "(" + a.getColorTo().getRed() + "," + a.getColorTo().getGreen()
              + "," + a.getColorTo().getBlue() + ")" + " from time t=" + a.getStartTime()
              + " to time t=" + a.getEndTime() + "\n";
          break;
        case Scale:
          switch (a.getShapeAndName().getShape().getType()) {
            case rectangle:
              s +=  "Shape " + a.getShapeAndName().getIdentifier() + " changes from Width: "
                  + a.getShapeAndName().getShape().getUniqueIdentifierOne()
                  + ", Height: " + a.getShapeAndName().getShape().getUniqueIdentifierTwo()
                  + " to Width: " + a.getScaledShape().getShape().getUniqueIdentifierOne()
                  + ", Height: " + a.getScaledShape().getShape().getUniqueIdentifierTwo()
                  + " from time t=" + a.getStartTime() + " to time t=" + a.getEndTime() + "\n";
              break;
            case oval:
              s += "Shape " + a.getShapeAndName().getIdentifier() + " changes from X Radius: "
                  + a.getShapeAndName().getShape().getUniqueIdentifierOne()
                  + ", Y Radius: " + a.getShapeAndName().getShape().getUniqueIdentifierTwo()
                  + " to X Radius: " + a.getScaledShape().getShape().getUniqueIdentifierOne()
                  + ", Y Radius: " + a.getScaledShape().getShape().getUniqueIdentifierTwo()
                  + " from time t=" + a.getStartTime() + " to time t=" + a.getEndTime() + "\n";
              break;
            default:
              break;
          }
          break;
        default:
          break;
      }
    }
    return s;
  }

  /**
   * get the Shape given the identifier/name.
   *
   * @return ShapeSet with the given name
   */
  public ShapeSet getShapeFromName(String name) {
    for (ShapeSet s : shapes) {
      if (name.equals(s.getIdentifier())) {
        return s;
      }
    }
    throw new IllegalArgumentException("name does not exist");
  }

  /**
   * get the current state of the Shape given the identifier/name.
   *
   * @return current state ShapeSet with the given name
   */
  public ShapeSet getCurrentShapeFromName(String name) {
    for (ShapeSet s : CurrentState) {
      if (name.equals(s.getIdentifier())) {
        return s;
      }
    }
    throw new IllegalArgumentException("name does not exist");
  }

  /**
   * returns the list of shapes added through addShape.
   *
   * @return a list of ShapeSets
   */
  public List<ShapeSet> getShapes() {
    return shapes;
  }

  /**
   * returns the list of animations through the action method.
   *
   * @return a list of Animations
   */
  public List<Animation> getAnimations() {
    return animations;
  }

  /**
   * returns the final animation time.
   *
   * @return the final animation time as an int
   */
  public int getFinalTime() {
    int last = 0;
    for (Animation a: animations) {
      if (a.getEndTime() > last) {
        last = a.getEndTime();
      }
    }
    return last;
  }

  /**
   * returns the x bounds.
   *
   * @return the x bounds as int
   */
  public int getBoundX() {
    return this.boundX;
  }

  /**
   * returns the y bounds.
   *
   * @return the y bounds as int
   */
  public int getBoundY() {
    return this.boundY;
  }

  /**
   * returns the width bounds.
   *
   * @return the width bounds as int
   */
  public int getBoundWidth() {
    return this.boundWidth;
  }

  /**
   * returns the height bounds.
   *
   * @return the height bounds as int
   */
  public int getBoundHeight() {
    return this.boundHeight;
  }

  /**
   * return the list of shapes at a given time tick.
   *
   * @return a list of shapes at given time tick
   */
  @Override
  public List<ShapeSet> getShapesAtTick(int time) {
    List<ShapeSet> s = new ArrayList<ShapeSet>();
    for (ShapeSet shape : shapes) {
      boolean hasAnimation = false;
      boolean hasDisappeared = false;
      Point2D tickPosition = shape.getShape().getReference();
      Color tickColor = shape.getShape().getColor();
      int tickIdentifierOne = shape.getShape().getUniqueIdentifierOne();
      int tickIdentifierTwo = shape.getShape().getUniqueIdentifierTwo();
      int red;
      int green;
      int blue;
      for (Animation a : animations) {
        if (a.getShapeAndName().getIdentifier().equals(shape.getIdentifier())
            && time >= a.getStartTime() && time <= a.getEndTime()) {
          hasAnimation = true;
          if (a.getActionType() == ActionType.AppearDisappear) {
            if (time == a.getEndTime()) {
              hasDisappeared = true;
            }
          }
          if (a.getActionType() == ActionType.Move) {
            tickPosition = new Point2D(shape.getShape().getReference().getX()
                + (a.getMoveTo().getX() - shape.getShape().getReference().getX())
                / (a.getEndTime() - a.getStartTime()) * (time - a.getStartTime()),
                shape.getShape().getReference().getY()
                    + (a.getMoveTo().getY() - shape.getShape().getReference().getY())
                    / (a.getEndTime() - a.getStartTime()) * (time - a.getStartTime()));
          }
          if (a.getActionType() == ActionType.Color) {
            red = shape.getShape().getColor().getRed() + (a.getColorTo().getRed()
                - shape.getShape().getColor().getRed()) / (a.getEndTime() - a.getStartTime())
                * (time - a.getStartTime());
            green = shape.getShape().getColor().getGreen() + (a.getColorTo().getGreen()
                - shape.getShape().getColor().getGreen()) / (a.getEndTime()
                - a.getStartTime()) * (time - a.getStartTime());
            blue = shape.getShape().getColor().getBlue() + (a.getColorTo().getBlue()
                - shape.getShape().getColor().getBlue()) / (a.getEndTime()
                - a.getStartTime()) * (time - a.getStartTime());
            tickColor = new Color(red,green,blue);
          }
          if (a.getActionType() == ActionType.Scale) {
            tickIdentifierOne = shape.getShape().getUniqueIdentifierOne()
                                + (a.getScaledShape().getShape().getUniqueIdentifierOne()
                                - shape.getShape().getUniqueIdentifierOne()) / (a.getEndTime()
                                - a.getStartTime()) * (time - a.getStartTime());
            tickIdentifierTwo = shape.getShape().getUniqueIdentifierTwo()
                                + (a.getScaledShape().getShape().getUniqueIdentifierTwo()
                                - shape.getShape().getUniqueIdentifierTwo()) / (a.getEndTime()
                                - a.getStartTime()) * (time - a.getStartTime());
          }
        }
      }
      if (!hasAnimation) {
        s.add(shape);
      } else if (hasDisappeared) {
        //do nothing if shape has already disappeared.
      } else {
        if (shape.getShape().getType() == ShapeType.oval) {
          s.add(new ShapeSet(shape.getIdentifier(),
                new Oval(tickPosition,tickIdentifierOne,tickIdentifierTwo,tickColor)));
        }
        if (shape.getShape().getType() == ShapeType.rectangle) {
          s.add(new ShapeSet(shape.getIdentifier(),
                new Rectangle(tickPosition,tickIdentifierOne,tickIdentifierTwo,tickColor)));
        }
      }
    }
    return s;
  }

  /**
   * set the bounds given X.
   *
   */
  @Override
  public void setBoundX(int boundX) {
    this.boundX = boundX;
  }

  /**
   * set the bounds given Y.
   *
   */
  @Override
  public void setBoundY(int boundY) {
    this.boundY = boundY;
  }

  /**
   * set the bounds given width.
   *
   */
  @Override
  public void setBoundWidth(int boundWidth) {
    this.boundWidth = boundWidth;
  }

  /**
   * set the bounds given Height.
   *
   */
  @Override
  public void setBoundHeight(int boundHeight) {
    this.boundHeight = boundHeight;
  }



  /**
   * AnimationBuilderImpl class that implements the AnimationBuilder.
   *
   */
  public static class AnimationBuilderImpl implements AnimationBuilder<Model> {

    Model m = new ModelImpl();

    @Override
    public Model build() {
      return m;
    }

    @Override
    public AnimationBuilder<Model> setBounds(int x, int y, int width, int height) {
      m.setBoundX(x);
      m.setBoundY(y);
      m.setBoundWidth(width);
      m.setBoundHeight(height);
      return this;
    }

    @Override
    public AnimationBuilder<Model> declareShape(String name, String type) {
      if (type.equalsIgnoreCase("ellipse")) {
        m.addShape(name,new Oval());
      } else if (type.equalsIgnoreCase("rectangle")) {
        m.addShape(name,new Rectangle());
      }
      return this;
    }


    @Override
    public AnimationBuilder<Model> addMotion(String name, int t1, int x1, int y1, int w1,
        int h1, int r1, int g1, int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2,
        int b2) {
      if (m.getShapeFromName(name).getShape().getReference() == null) {
        m.getShapeFromName(name).getShape().updateReference(new Point2D(x1,y1));
      }
      if (m.getShapeFromName(name).getShape().getColor() == null) {
        m.getShapeFromName(name).getShape().updateColor(new Color(r1,g1,b1));
      }
      if (m.getShapeFromName(name).getShape().getUniqueIdentifierOne() == 0) {
        m.getShapeFromName(name).getShape().updateIdentifierOne(w1);
      }
      if (m.getShapeFromName(name).getShape().getUniqueIdentifierTwo() == 0) {
        m.getShapeFromName(name).getShape().updateIdentifierTwo(h1);
      }
      m.getCurrentShapeFromName(name).getShape().updateReference(new Point2D(x1,y1));
      m.getCurrentShapeFromName(name).getShape().updateColor(new Color(r1,g1,b1));
      m.getCurrentShapeFromName(name).getShape().updateIdentifierOne(w1);
      m.getCurrentShapeFromName(name).getShape().updateIdentifierTwo(h1);

      if (x1 == x2 && y1 == y2 && w1 == w2 && h1 == h2 && r1 == r2 && g1 == g2 && b1 == b2) {
        m.action(name, ActionType.AppearDisappear, t1, t2);
      }
      if (x1 != x2 || y1 != y2) {
        m.action(name, ActionType.Move, new Point2D(x2, y2), t1, t2);
      }
      if (r1 != r2 || g1 != g2 || b1 != b2) {
        m.action(name,ActionType.Color,new Color(r2,g2,b2),t1,t2);
      }
      if (w1 != w2 || h1 != h2) {


        m.action(name,ActionType.Scale, (double)w2 / w1,(double)h2 / h1,t1,t2);
      }
      return this;
    }
  }
}

