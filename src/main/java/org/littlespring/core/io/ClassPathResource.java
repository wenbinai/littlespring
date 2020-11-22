package org.littlespring.core.io;

import org.littlespring.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ClassPathResource implements Resource {
    private String path;
    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }

    @Override
    public InputStream getInputStream() throws IOException {
        //TODO 思考是否path错误
        InputStream is = this.classLoader.getResourceAsStream(path);

        if (is == null) {
            throw new FileNotFoundException(path + "cannot be  opened");
        }
        return is;
    }

    @Override
    public String getDescription() {
        return this.path;
    }
}
