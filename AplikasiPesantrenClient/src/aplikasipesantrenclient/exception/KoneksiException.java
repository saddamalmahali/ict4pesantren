/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenclient.exception;

/**
 *
 * @author Saddam
 */
public class KoneksiException extends Exception {

    /**
     * Creates a new instance of
     * <code>KoneksiException</code> without detail message.
     */
    public KoneksiException() {
    }

    /**
     * Constructs an instance of
     * <code>KoneksiException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public KoneksiException(String msg) {
        super(msg);
    }
}
