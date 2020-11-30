package org.littlespring.beans.factory.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.littlespring.beans.factory.BeanDefinitionStoreException;
import org.littlespring.beans.factory.support.BeanDefinitionRegistry;
import org.littlespring.beans.factory.support.GenericBeanDefinition;
import org.littlespring.core.io.Resource;
import org.littlespring.util.ClassUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * 从XML文件中读取关于bean配置
 */
public class XmlBeanDefinitionReader {
    /**
     * xml 文件中对bean属性的描述
     */
    public static final String ID_ATTRIBUTE = "id";
    public static final String NAME_ATTRIBUTE = "class";
    public static final String SCOPE_ARRTIBUTE = "scope";

    BeanDefinitionRegistry registry;

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void loadBeanDefinitions(String configFile) {
        InputStream is = null;
        try {
            ClassLoader cl = ClassUtils.getDefaultClassLoader();
            is = cl.getResourceAsStream(configFile);
            SAXReader reader = new SAXReader();
            Document doc = reader.read(is);

            Element root = doc.getRootElement();
            Iterator<Element> iter = root.elementIterator();
            while (iter.hasNext()) {
                Element ele = iter.next();
                String id = ele.attributeValue(ID_ATTRIBUTE);
                String beanClassName = ele.attributeValue(NAME_ATTRIBUTE);
                GenericBeanDefinition bd = new GenericBeanDefinition(id, beanClassName);
                // 对scope节点进行解析
                if (ele.attribute(SCOPE_ARRTIBUTE) != null) {
                    bd.setScope(ele.attributeValue(SCOPE_ARRTIBUTE));
                }
                this.registry.registerBeanDefinition(id, bd);
            }
        } catch (DocumentException e) {
            throw new BeanDefinitionStoreException("parse xml exception");
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void loadBeanDefinitionsRefactor(Resource resource) {
        InputStream is = null;
        try {
            is = resource.getInputStream();
            SAXReader reader = new SAXReader();
            Document doc = reader.read(is);

            Element root = doc.getRootElement();
            Iterator<Element> iter = root.elementIterator();
            while (iter.hasNext()) {
                Element ele = iter.next();
                String id = ele.attributeValue(ID_ATTRIBUTE);
                String beanClassName = ele.attributeValue(NAME_ATTRIBUTE);
                GenericBeanDefinition bd = new GenericBeanDefinition(id, beanClassName);
                this.registry.registerBeanDefinition(id, bd);
            }
        } catch (Exception e) {
            throw new BeanDefinitionStoreException("parse xml exception");
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
