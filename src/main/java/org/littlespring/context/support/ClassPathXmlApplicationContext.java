package org.littlespring.context.support;


import org.littlespring.beans.factory.support.DefaultBeanFactory;
import org.littlespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.littlespring.context.ApplicationContext;
import org.littlespring.core.io.ClassPathResource;
import org.littlespring.core.io.Resource;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {
    public ClassPathXmlApplicationContext(String configFile) {
        super(configFile);
    }

//    private DefaultBeanFactory factory = null;
//
//    public ClassPathXmlApplicationContext(String configFile) {
//        factory = new DefaultBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//        Resource resource = new ClassPathResource(configFile);
////        reader.loadBeanDefinitions(configFile);
//        reader.loadBeanDefinitionsRefactor(resource);
//    }
//
//
//    @Override
//    public Object getBean(String beanID) {
//        return factory.getBean(beanID);
//    }

    @Override
    protected Resource getResourceByPath(String path) {
        Resource resource = new ClassPathResource(path, this.getBeanClassLoader());
        return resource;
    }
}
