package org.littlespring.beans.factory.support;

import org.littlespring.beans.BeanDefinition;
import org.littlespring.beans.factory.BeanCreationException;
import org.littlespring.beans.factory.BeanFactory;
import org.littlespring.beans.factory.config.ConfigurableBeanFactory;
import org.littlespring.util.ClassUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultBeanFactory extends DefaultSingletonBeanRegistry
        implements BeanFactory, BeanDefinitionRegistry, ConfigurableBeanFactory {

    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    private ClassLoader beanClassLoader;

    public DefaultBeanFactory() {

    }

    @Override
    public void registerBeanDefinition(String beanID, BeanDefinition bd) {
        this.beanDefinitionMap.put(beanID, bd);
    }


//    public DefaultBeanFactory(String configFile) {
////        loadBeanDefinition(configFile);
//    }

//    private void loadBeanDefinition(String configFile) {
//        InputStream is = null;
//        try {
//            ClassLoader cl = ClassUtils.getDefaultClassLoader();
//            is = cl.getResourceAsStream(configFile);
//            SAXReader reader = new SAXReader();
//            Document doc = reader.read(is);
//
//            Element root = doc.getRootElement(); //root
//            Iterator<Element> iter = root.elementIterator();
//            while (iter.hasNext()) {
//                Element ele = iter.next();
//                String id = ele.attributeValue(ID_ATTRIBUTE);
//                String beanClassName = ele.attributeValue(CLASS_ATTRIBUTE);
//                BeanDefinition bd = new GenericBeanDefinition(id, beanClassName);
//                this.beanDefinitionMap.put(id, bd);
//            }
//        } catch (DocumentException e) {
//            throw new BeanDefinitionStoreException("parse xml error");
//        } finally {
//            if (is != null) {
//                try {
//                    is.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    public BeanDefinition getBeanDefinition(String beanID) {
        return this.beanDefinitionMap.get(beanID);
    }


    @Override
    public Object getBean(String beanID) {
        BeanDefinition bd = this.getBeanDefinition(beanID);
        if (bd == null) {
            throw new BeanCreationException("create bean error");
        }

        if (bd.isSingleton()) {
            Object bean = this.getSingleBean(beanID);
            if (bean == null) {
                bean = createBean(bd);
                this.registerSingleton(beanID, bean);
            }
            return bean;
        }

        return createBean(bd);

//        ClassLoader cl = this.getBeanClassLoader();
//        String beanClassName = bd.getBeanClassName();
//        try {
//            Class<?> clz = cl.loadClass(beanClassName);
//            return clz.newInstance();
//        } catch (Exception e) {
//            throw new BeanCreationException("create bean error", e);
//        }
    }

    private Object createBean(BeanDefinition bd) {
        ClassLoader cl = this.getBeanClassLoader();
        String beanClassName = bd.getBeanClassName();
        try {
            Class<?> clz = cl.loadClass(beanClassName);
            return clz.newInstance();
        } catch (Exception e) {
            throw new BeanCreationException("create bean for " + beanClassName + " failed", e);
        }
    }

    @Override
    public void setBeanClassLoader(ClassLoader beanClassLoader) {
        this.beanClassLoader = beanClassLoader;
    }

    @Override
    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader != null ? this.beanClassLoader : ClassUtils.getDefaultClassLoader();
    }
}
