package org.littlespring.test.v1;

import org.junit.Assert;
import org.junit.Test;
import org.littlespring.context.ApplicationContext;
import org.littlespring.context.support.ClassPathXmlApplicationContext;
import org.littlespring.context.support.FileSystemXmlApplicationContext;
import org.littlespring.service.v1.PetStoreService;

public class ApplicationContextTest {

    @Test
    public void testGetBean() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v1.xml");
        PetStoreService petStore = (PetStoreService) ctx.getBean("petStore");
        Assert.assertNotNull(petStore);
    }

    @Test
    public void testGetBeanFromFileSystemContext() {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("E:\\Study\\专题学习\\Little Spring\\mycode\\src\\test\\resources\\petstore-v1.xml");
        PetStoreService petStore = (PetStoreService) ctx.getBean("petStore");
        Assert.assertNotNull(petStore);
    }
}
