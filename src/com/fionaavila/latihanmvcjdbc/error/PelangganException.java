/*
 * NAMA  : Fiona Avila Putri
 * NIM   : 10119013
 * KELAS : IF1 2019/2020 (PBO1)
 */
package com.fionaavila.latihanmvcjdbc.error;

/**
 *
 * @author Fiona Avila
 */
public class PelangganException extends Exception {

    /**
     * Creates a new instance of <code>pelangganException</code> without detail
     * message.
     */
    public PelangganException() {
    }

    /**
     * Constructs an instance of <code>pelangganException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PelangganException(String msg) {
        super(msg);
    }
}
