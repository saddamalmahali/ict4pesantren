/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenserver.exception;

/**
 *
 * @author Saddam
 */
public class RegisterException extends Exception {

    /**
     * Creates a new instance of
     * <code>RegisterException</code> without detail message.
     */
    public RegisterException() {
    }

    /**
     * Constructs an instance of
     * <code>RegisterException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public RegisterException(String msg) {
        super(msg);
    }
}
