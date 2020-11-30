package org.littlespring.beans.factory.config;


public interface SingletonBeanRegistry {
    void registerSingleton(String beanName, Object singleObject);

    Object getSingleBean(String beanName);
}
