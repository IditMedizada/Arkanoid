// 318879293 Idit Medizada
package BasicClasses;


import BasicShapes.Point;

/**
 * Velocity class.
 *
 * @author Idit Medizada iditm9@gmail.com
 * @version 1.3 (current version number of program).
 * @since 2022-03-22 (the version of the package this class was first added to).
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * Constructor function.
     *
     * @param dx value
     * @param dy value
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Getter.
     *
     * @return double dx
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * Getter.
     *
     * @return double dy
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * Setter.
     *
     * @param dx set the dx value.
     */
    public void setDx(double dx) {
        this.dx = dx;
    }

    /**
     * Setter.
     *
     * @param dy set the dy value.
     */
    public void setDy(double dy) {
        this.dy = dy;
    }

    /**
     * Calculating velocity from angle and speed to dx/dy.
     *
     * @param angle of the object
     * @param speed of object
     * @return Velocity argument
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        //Transition from degrees to radians
        angle = angle % 360;
        angle = Math.toRadians(angle);
        double dx = speed * Math.sin(angle);
        double dy = speed * Math.cos(angle) * -1;
        return new Velocity(dx, dy);
    }

    /**
     * calculating speed.
     * @param velocity Velocity
     * @return double speed
     */
    public double speed(Velocity velocity) {
        double dx = velocity.getDx() * velocity.getDx();
        double dy = velocity.getDy() * velocity.getDy();
        return Math.sqrt(dx + dy);
    }

    /**
     * Take a point with position (x,y) and return a new point.
     * with position (x+dx, y+dy)
     *
     * @param p Point value.
     * @return Point
     */

    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }
}