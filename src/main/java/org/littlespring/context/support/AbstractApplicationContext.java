package org.littlespring.context.support;

import org.littlespring.beans.factory.support.DefaultBeanFactory;
import org.littlespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.littlespring.context.ApplicationContext;
import org.littlespring.core.io.Resource;

public abstract class AbstractApplicationContext implements ApplicationContext {
    private DefaultBeanFactory factory = null;

    public AbstractApplicationContext(String configFile) {
        factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        Resource resource = this.getResourceByPath(configFile);
        reader.loadBeanDefinitionsRefactor(resource);
    }

    @Override
    public Object getBean(String beanID) {
        return factory.getBean(beanID);
    }

    protected abstract Resource getResourceByPath(String path);
}
