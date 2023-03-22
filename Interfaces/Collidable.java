
package Interfaces;

import BasicClasses.Velocity;
import BasicShapes.Point;
import BasicShapes.Rectangle;
import SpriteAndCollidable.Ball;

/**
 * Collidable interface.
 *
 * @author Idit Medizada iditm9@gmail.com
 */
public interface Collidable {

    /**
     * getCollisionRectangle.
     *
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     *
     * @param collisionPoint collision point between 2 objects.
     * @param currentVelocity the velocity before the hitting.
     * @param hitter Ball type.
     * @return the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}