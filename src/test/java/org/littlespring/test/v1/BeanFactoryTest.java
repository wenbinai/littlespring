package org.littlespring.test.v1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.littlespring.beans.BeanDefinition;
import org.littlespring.beans.factory.BeanCreationException;
import org.littlespring.beans.factory.BeanDefinitionStoreException;
import org.littlespring.beans.factory.support.DefaultBeanFactory;
import org.littlespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.littlespring.core.io.ClassPathResource;
import org.littlespring.service.v1.PetStoreService;

import static org.junit.Assert.assertEquals;
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

    DefaultBeanFactory factory = null;
    XmlBeanDefinitionReader reader = null;

    /**
     * 每个测试用例都运行一遍, 一般为配置代码
     */
    @Before
    public void setUP() {
        factory = new DefaultBeanFactory();
        reader = new XmlBeanDefinitionReader(factory);
    }


    /**
     * 对testGetBean()测试方法进行重构
     */
    @Test
    public void testGetBeanRefactor() {

//        reader.loadBeanDefinitions("petstore-v1.xml");

        reader.loadBeanDefinitionsRefactor(new ClassPathResource("petstore-v1.xml"));
        BeanDefinition bd = factory.getBeanDefinition("petStore");

        assertEquals("org.littlespring.service.v1.PetStoreService", bd.getBeanClassName());
        PetStoreService petStore = (PetStoreService) factory.getBean("petStore");

        assertNotNull(petStore);
    }

    /**
     * 测试对自己建立的异常类是否正确
     */
    @Test
    public void testInvalidBean() {

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

        try {
            reader.loadBeanDefinitions("xxx.xml");
        } catch (BeanDefinitionStoreException e) {
            return;
        }

        Assert.fail("fail");
    }


}
