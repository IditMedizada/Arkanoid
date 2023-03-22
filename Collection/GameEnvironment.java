package Collection;

import BasicClasses.CollisionInfo;
import BasicShapes.Line;
import BasicShapes.Point;
import Interfaces.Collidable;

import java.util.ArrayList;
import java.util.List;

/**
 * GameEnvironment class.
 *
 * @author Idit Medizada iditm9@gmail.com
 */
public class GameEnvironment {
    private List<Collidable> collidableList;
    static final double EPS = 0.000001;

    /**
     * Constructor.
     */
    public GameEnvironment() {
        collidableList = new ArrayList<>();
    }

    /**
     * Add the given collidable to the environment.
     *
     * @param c Collidable
     */
    public void addCollidable(Collidable c) {
        this.collidableList.add(c);
    }

    /**
     * Removing the collidable from the environment.
     *
     * @param c Collidable
     */
    public void removeCollodable(Collidable c) {
        List<Collidable> tempList = new ArrayList<>(this.collidableList);
        for (Collidable collidable : tempList) {
            if (c.equals(collidable)) {
                this.collidableList.remove(c);

            }
        }
    }

    /**
     * getClosestCollision.
     * Assume an object moving from line.start() to line.end().
     *
     * @param trajectory Line
     * @return CollisionInfo
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<Collidable> tempList = new ArrayList<>(this.collidableList);

        Point temp = null;
        Integer index = null;
        for (int i = 0; i < tempList.size(); i++) {
            Point closestIntersection = trajectory.closestIntersectionToStartOfLine(tempList.get(i).
                    getCollisionRectangle());
            if (closestIntersection != null) {
                if (temp == null) {
                    temp = closestIntersection;
                    index = i;
                } else {
                    if (!getClosestPoint(temp, closestIntersection, trajectory).equals(temp)) {
                        temp = closestIntersection;
                        index = i;
                    }
                }
            }
        }
        if (temp == null) {
            return null;
        }
        return new CollisionInfo(temp, tempList.get(index));

    }

    /**
     * getClosestPoint.
     * now firstPoint is the closes point and in this function we check if the secondPoint is closer.
     *
     * @param firstPoint  the closes point in the beginning
     * @param secondPoint the other point that we want to check if it is closer
     * @param l           line
     * @return the closest point to the first point on the line
     */
    public Point getClosestPoint(Point firstPoint, Point secondPoint, Line l) {

        if (Math.abs(firstPoint.getX() - secondPoint.getX()) < EPS) {
            if (Math.abs(l.start().getY() - secondPoint.getY()) < Math.abs(l.
                    start().getY() - firstPoint.getY())) {
                return secondPoint;
            }
        } else {
            if (Math.abs(l.start().getX() - secondPoint.getX()) < Math.abs(l.
                    start().getX() - firstPoint.getX())) {
                return secondPoint;
            }
        }
        return firstPoint;
    }
}