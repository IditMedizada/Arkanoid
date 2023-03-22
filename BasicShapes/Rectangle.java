package BasicShapes;

import java.util.ArrayList;
import java.util.List;

/**
 * Rectangle class.
 *
 * @author Idit Medizada iditm9@gmail.com
 */
public class Rectangle {
    private Point upperLeft;
    private double width, height;

    /**
     * Constructor.
     * Create a new rectangle with location and width/height.
     *
     * @param upperLeft Point of rectangle
     * @param width     of rectangle
     * @param height    of rectangle
     */
    public Rectangle(Point upperLeft, double width, double height) {
        setHeight(height);
        setUpperLeft(upperLeft);
        setWidth(width);
    }

    /**
     * Setter.
     *
     * @param height of rectangle
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Setter.
     *
     * @param upperLeft of rectangle
     */
    public void setUpperLeft(Point upperLeft) {
        this.upperLeft = upperLeft;
    }

    /**
     * Setter.
     *
     * @param width of rectangle
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * intersectionPoints.
     *
     * @param line specific line for comparison
     * @return a (possibly empty) List of intersection points with the specified line.
     */

    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> pointList = new ArrayList<>();
        double upperX = this.upperLeft.getX();
        double upperY = this.upperLeft.getY();
        Line[] lineList = new Line[4];
        lineList[0] = new Line(upperX, upperY, upperX + this.width, upperY);
        lineList[1] = new Line(upperX, upperY + this.height, upperX + this.width, upperY + this.height);
        lineList[2] = new Line(upperX, upperY, upperX, upperY + this.height);
        lineList[3] = new Line(upperX + this.width, upperY, upperX + this.width, upperY + this.height);
        for (Line value : lineList) {
            Point tempPoint = value.intersectionWith(line);
            if (tempPoint != null) {
                pointList.add(tempPoint);
            }
        }
        return pointList;
    }

    /**
     * Getter.
     *
     * @return the width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Getter.
     *
     * @return the height of the rectangle
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Getter.
     *
     * @return upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
}