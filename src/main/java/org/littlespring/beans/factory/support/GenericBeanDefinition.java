package org.littlespring.beans.factory.support;

import org.littlespring.beans.BeanDefinition;

/**
 * 一般Bean的描述
 */
public class GenericBeanDefinition implements BeanDefinition {
    private String id;
    private String beanClassName;
    public GenericBeanDefinition(String id, String beanClassName) {
        this.id = id;
        this.beanClassName = beanClassName;
    }

    @Override
    public String getBeanClassName() {
        return this.beanClassName;
    }
}
