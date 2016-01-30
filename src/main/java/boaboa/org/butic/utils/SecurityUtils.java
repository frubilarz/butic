/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boaboa.org.butic.utils;

import java.io.Serializable;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author frubilar
 */
public class SecurityUtils implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(SecurityUtils.class);

    private SecurityUtils() {
        throw new AssertionError();
    }
    
    public static String sha256(String texto) {
        String resultado = "";
        try {
            if (!StringUtils.isEmpty(texto)) {
                resultado = DigestUtils.sha256Hex(texto);
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return resultado;
    }

    public static String sha1(String texto) {
        String resultado = "";
        try {
            if (!StringUtils.isEmpty(texto)) {
                resultado = DigestUtils.shaHex(texto);
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return resultado;
    }
}
