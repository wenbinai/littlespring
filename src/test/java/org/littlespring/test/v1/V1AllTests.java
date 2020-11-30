package org.littlespring.test.v1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.littlespring.beans.factory.BeanFactory;

/**
 * 整合多个测试
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        BeanFactoryTest.class,
        ApplicationContextTest.class,
        ResourceTest.class})
public class V1AllTests {
}
