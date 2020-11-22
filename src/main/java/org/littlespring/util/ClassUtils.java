package org.littlespring.util;

public class ClassUtils {
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable x) {
            // Cannot access thread context ClassLoader
        }

        if(cl == null) {
            // No thread context loader -> use class loader of this class
            cl = ClassUtils.class.getClassLoader();
            if(cl == null) {
                //getClassLoader() return null
                try {
                    cl = ClassLoader.getSystemClassLoader();
                } catch (Throwable ex) {
                    // Cannot access system classLoader ->
                }
            }
        }

        return cl;
    }
}
