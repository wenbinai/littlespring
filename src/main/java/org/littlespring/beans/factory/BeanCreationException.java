package org.littlespring.beans.factory;

import org.littlespring.beans.BeansException;

public class BeanCreationException extends BeansException {
    public BeanCreationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BeanCreationException(String msg) {
        super(msg);
    }
}
