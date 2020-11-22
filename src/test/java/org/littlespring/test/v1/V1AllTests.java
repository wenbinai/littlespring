package org.littlespring.test.v1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 整合多个测试
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ApplicationContextTest.class,
        BeanFactoryTest.class,
        ResourceTest.class})
public class V1AllTests {
}
