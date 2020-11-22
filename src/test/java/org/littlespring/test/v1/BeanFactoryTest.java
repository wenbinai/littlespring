package org.littlespring.test.v1;

import org.junit.Assert;
import org.junit.Test;
import org.littlespring.beans.BeanDefinition;
import org.littlespring.beans.factory.BeanCreationException;
import org.littlespring.beans.factory.BeanDefinitionStoreException;
import org.littlespring.beans.factory.support.DefaultBeanFactory;
import org.littlespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.littlespring.service.v1.PetStoreService;

import static org.junit.Assert.assertNotNull;

public class BeanFactoryTest {

//    /**
//     * 测试从xml文件中创建bean的过程是否正确
//     */
//    @Test
//    public void testGetBean() {
//        BeanFactory factory = new DefaultBeanFactory("petstore-v1.xml");
//        BeanDefinition bd = factory.getBeanDefinition("petStore");
//
//        assertEquals("org.littlespring.service.v1.PetStoreService", bd.getBeanClassName());
//        PetStoreService petStore = (PetStoreService) factory.getBean("petStore");
//
//        assertNotNull(petStore);
//    }



    /**
     * 对testGetBean()测试方法进行重构
     */
    @Test
    public void testGetBeanRefactor() {
        DefaultBeanFactory factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions("petstore-v1.xml");

        BeanDefinition bd = factory.getBeanDefinition("petStore");

//        assertEquals("org.littlespring.service.v1.PetStoreService", bd.getBeanClassName());
        PetStoreService petStore = (PetStoreService) factory.getBean("petStore");

        assertNotNull(petStore);
    }

    /**
     * 测试对自己建立的异常类是否正确
     */
    @Test
    public void testInvalidBean() {
        DefaultBeanFactory factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions("petstore-v1.xml");

        try {
            factory.getBean("invalidBean");
        } catch (BeanCreationException e) {
            return;
        }

        Assert.fail("expect BeanCreationException");
    }


    /**
     * 测试xml文件不存在的情况
     */
    @Test
    public void testInvalidXML() {
        DefaultBeanFactory factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        try {
            reader.loadBeanDefinitions("xxx.xml");
        } catch (BeanDefinitionStoreException e) {
            return;
        }

        Assert.fail("fail");
    }


}
