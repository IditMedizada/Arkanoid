//318879293 Idit Medizada
package BasicClasses;

import BasicShapes.Point;
import Interfaces.Collidable;

/**
 * CollisionInfo class.
 *
 * @author Idit Medizada iditm9@gmail.com
 * @version 1.2 (current version number of program).
 * @since 2022-04-13 (the version of the package this class was first added to).
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * Constructor.
     *
     * @param collisionPoint  Point
     * @param collisionObject Collidable
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionObject = collisionObject;
        this.collisionPoint = collisionPoint;
    }

    /**
     * collisionPoint.
     *
     * @return the point at which the collision occurs
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * collisionObject.
     *
     * @return the collidable object involved in the collision.
     */

    public Collidable collisionObject() {
        return this.collisionObject;
    }
}