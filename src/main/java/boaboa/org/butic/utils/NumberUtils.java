/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boaboa.org.butic.utils;

import java.io.Serializable;
import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;

/**
 *
 * @author frubilar
 */
public abstract class NumberUtils implements Serializable {
    
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(NumberUtils.class);
    
    public static Integer NumberUtils(String numero) {
        Integer numeroInt = null;
        try {
            if (StringUtils.isNotEmpty(numero)) {
             numeroInt = Integer.parseInt(numero);
            }
        } catch (Exception e) {
            numeroInt = null;
            logger.debug("Error al intentar parsear un string a numero: {}",e.toString(),e);
            logger.error("Error al intentar parsear un string a numero: {}",e.toString());
        }
        return numeroInt;
    }
}
