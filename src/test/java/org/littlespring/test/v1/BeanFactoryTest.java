//package org.littlespring.test.v1;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.littlespring.beans.BeanDefinition;
//import org.littlespring.beans.factory.BeanCreationException;
//import org.littlespring.beans.factory.BeanDefinitionStoreException;
//import org.littlespring.beans.factory.BeanFactory;
//import org.littlespring.beans.factory.support.DefaultBeanFactory;
//import org.littlespring.service.v1.PetStoreService;
//
//import static org.junit.Assert.*;
//
//public class BeanFactoryTest {
//
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
//
//    /**
//     * 测试对自己建立的异常类是否正确
//     */
//    @Test
//    public void testInvalidBean() {
//        BeanFactory factory = new DefaultBeanFactory("petstore-v1.xml");
//        try {
//            factory.getBean("invalidBean");
//        } catch (BeanCreationException e) {
//            return;
//        }
//
//        Assert.fail("expect BeanCreationException");
//    }
//
//
//    /**
//     * 测试xml文件不存在的情况
//     */
//    @Test
//    public void testInvalidXML() {
//        try {
//            new DefaultBeanFactory("xxx.xml");
//        } catch (BeanDefinitionStoreException e) {
//            return;
//        }
//
//        Assert.fail("fail");
//    }
//
//
//}
