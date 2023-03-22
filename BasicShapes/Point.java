

package BasicShapes;

/**
 * Point class.
 *
 * @author Idit Medizada iditm9@gmail.com
 * A class that represents a point in space.
 */
public class Point {

    private double x;
    private double y;
    static final double EPSILON = 0.000001;

    /**
     * Constructor function.
     *
     * @param x double
     * @param y double
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;

    }

    /**
     * Getter.
     *
     * @return the x  value of this point
     */
    public double getX() {
        return this.x;
    }

    /**
     * Getter.
     *
     * @return the y  value of this point
     */
    public double getY() {
        return this.y;
    }

    /**
     * Setter.
     *
     * @param x the x value of this point.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Setter.
     *
     * @param y the y value of this point.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Calculating the distance between two points.
     *
     * @param other Point
     * @return the distance of this point to the other point
     */
    public double distance(Point other) {
        double xDistance = this.x - other.getX();
        double yDistance = this.y - other.getY();
        return Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
    }

    /**
     * Checking if two points are equals.
     *
     * @param other Point
     * @return true if the points are equal, false otherwise
     */

    public boolean equals(Point other) {
        return ((Math.abs(this.x - other.getX()) < EPSILON && Math.abs(this.y - other.getY()) < EPSILON));

    }


}