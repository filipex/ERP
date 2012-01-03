
package br.system.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 25/12/2011 13:30
 */

public class MyFormatException {

    public static String format(Throwable thw) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        thw.printStackTrace(pw);
        
        return sw.toString();
    }
}