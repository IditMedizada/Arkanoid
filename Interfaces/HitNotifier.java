package Interfaces;

/**
 * HitNotifier interface.
 *
 * @author Idit Medizada iditm9@gmail.com
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