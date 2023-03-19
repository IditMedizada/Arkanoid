//318879293 Idit Medizada

package BasicClasses;

/**
 * Counter class.
 *
 * @author Idit Medizada iditm9@gmail.com
 * @version 1.6 (current version number of program).
 * @since 2022-05-21 (the version of the package this class was first added to).
 */
public class Counter {
    private int counter;

    /**
     * Constructor.
     */
    public Counter() {
        this.counter = 0;
    }


    /**
     * add number to current count.
     *
     * @param number int
     */
    public void increase(int number) {
        this.counter += number;
    }

    /**
     * subtract number from current count.
     *
     * @param number int
     */
    public void decrease(int number) {
        this.counter -= number;
    }

    /**
     * Getter.
     *
     * @return counter value
     */
    public int getValue() {
        return this.counter;
    }
}