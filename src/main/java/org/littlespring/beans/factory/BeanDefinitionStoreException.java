package org.littlespring.beans.factory;

import org.littlespring.beans.BeansException;

public class BeanDefinitionStoreException extends BeansException {
    public BeanDefinitionStoreException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BeanDefinitionStoreException(String msg) {
        super(msg);
    }
}
