/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boaboa.org.butic.model;

import java.io.Serializable;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author frubilar
 */
public class BaseBean implements Serializable {

    private static final long serialVersionUID = -5747159829033690039L;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(
                this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
