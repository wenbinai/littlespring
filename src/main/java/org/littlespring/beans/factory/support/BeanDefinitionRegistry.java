package org.littlespring.beans.factory.support;

import org.littlespring.beans.BeanDefinition;

public interface BeanDefinitionRegistry {
    /**
     * 将XML文件中关于bean的描述转换为BeanDefinition类
     *
     * @param beanID
     * @return
     */
    BeanDefinition getBeanDefinition(String beanID);

    void registerBeanDefinition(String beanID, BeanDefinition bd);
}
