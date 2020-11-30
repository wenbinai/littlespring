package org.littlespring.beans.factory.support;

import org.littlespring.beans.factory.config.SingletonBeanRegistry;
import org.littlespring.util.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    @Override
    public void registerSingleton(String beanName, Object singleObject) {
        Assert.notNull(beanName, "beanName must not be null");
        Object oldObject = this.singletonObjects.get(beanName);
        if (oldObject != null) {
            throw new IllegalStateException("Could not register object, there is already object");
        }
        this.singletonObjects.put(beanName, singleObject);
    }

    @Override
    public Object getSingleBean(String beanName) {
        return this.singletonObjects.get(beanName);
    }
}
