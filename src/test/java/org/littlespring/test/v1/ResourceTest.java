package org.littlespring.test.v1;

import org.junit.Assert;
import org.junit.Test;
import org.littlespring.core.io.ClassPathResource;
import org.littlespring.core.io.FileSystemResource;
import org.littlespring.core.io.Resource;

import java.io.InputStream;

public class ResourceTest {
    @Test
    public void testClassPathResource() throws Exception {
        Resource r = new ClassPathResource("petstore-v1.xml");

        InputStream is = null;

        try {
            is = r.getInputStream();
            Assert.assertNotNull(is);
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    @Test
    public void testFileSystemResource() throws Exception {
        Resource r = new FileSystemResource("E:\\Study\\专题学习\\Little Spring\\mycode\\src\\test\\resources\\petstore-v1.xml");

        InputStream is = null;

        try {
            is = r.getInputStream();
            Assert.assertNotNull(is);
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }
}
