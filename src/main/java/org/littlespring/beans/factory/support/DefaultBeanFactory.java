package org.littlespring.beans.factory.support;

import org.littlespring.beans.BeanDefinition;
import org.littlespring.beans.factory.BeanCreationException;
import org.littlespring.beans.factory.BeanFactory;
import org.littlespring.util.ClassUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultBeanFactory implements BeanFactory, BeanDefinitionRegistry {

    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();


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
        ClassLoader cl = ClassUtils.getDefaultClassLoader();
        String beanClassName = bd.getBeanClassName();
        try {
            Class<?> clz = cl.loadClass(beanClassName);
            return clz.newInstance();
        } catch (Exception e) {
            throw new BeanCreationException("create bean error", e);
        }
    }
}
