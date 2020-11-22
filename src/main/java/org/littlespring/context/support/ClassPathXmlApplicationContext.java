package org.littlespring.context.support;


import org.littlespring.beans.factory.support.DefaultBeanFactory;
import org.littlespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.littlespring.context.ApplicationContext;

public class ClassPathXmlApplicationContext implements ApplicationContext {

    private DefaultBeanFactory factory = null;

    public ClassPathXmlApplicationContext(String configFile) {
        factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(configFile);
    }


    @Override
    public Object getBean(String beanID) {
        return factory.getBean(beanID);
    }
}
