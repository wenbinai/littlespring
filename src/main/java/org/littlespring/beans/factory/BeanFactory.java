package org.littlespring.beans.factory;

import org.littlespring.beans.BeanDefinition;

public interface BeanFactory {
    BeanDefinition getBeanDefinition(String beanID);

    Object getBean(String beanID);
}
