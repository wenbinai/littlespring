package org.littlespring.test.v1;

import org.junit.Test;
import org.littlespring.beans.BeanDefinition;
import org.littlespring.beans.factory.BeanFactory;
import org.littlespring.beans.factory.support.DefaultBeanFactory;
import org.littlespring.service.v1.PetStoreService;

import static org.junit.Assert.*;

public class BeanFactoryTest {

    @Test
    public void testGetBean() {
        BeanFactory factory = new DefaultBeanFactory("petstore-v1.xml");
        BeanDefinition bd = factory.getBeanDefinition("petStore");

        assertEquals("org.littlespring.service.v1.PetStoreService", bd.getBeanClassName());
        PetStoreService petStore = (PetStoreService) factory.getBean("petStore");

        assertNotNull(petStore);
    }
}
