// 318879293 Idit Medizada
package Interfaces;

/**
 * HitNotifier interface.
 *
 * @author Idit Medizada iditm9@gmail.com
 * @version 1.2 (current version number of program).
 * @since 2022-04-13 (the version of the package this class was first added to).
 */
public interface HitNotifier {
    /**
     * Add hl as a listener to hit events.
     * @param hl HitListener
     */
    void addHitListener(HitListener hl);

    /**
     *  Remove hl from the list of listeners to hit events.
     * @param hl HitListener
     */
    void removeHitListener(HitListener hl);
}