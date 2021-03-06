package org.littlespring.context.support;

import org.littlespring.beans.factory.support.DefaultBeanFactory;
import org.littlespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.littlespring.context.ApplicationContext;
import org.littlespring.core.io.FileSystemResource;
import org.littlespring.core.io.Resource;

public class FileSystemXmlApplicationContext extends AbstractApplicationContext {

    public FileSystemXmlApplicationContext(String configFile) {
        super(configFile);
    }

//    public FileSystemXmlApplicationContext(String configFile) {
//        factory = new DefaultBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//        Resource resource = new FileSystemResource(configFile);
////        reader.loadBeanDefinitions(resource);
//        reader.loadBeanDefinitionsRefactor(resource);
//    }
//
//    @Override
//    public Object getBean(String beanID) {
//        return factory.getBean(beanID);
//    }

    @Override
    protected Resource getResourceByPath(String path) {
        return new FileSystemResource(path);
    }
}
