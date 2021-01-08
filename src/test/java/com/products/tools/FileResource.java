package com.products.tools;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

import static java.nio.charset.Charset.defaultCharset;

public abstract class FileResource {

    public static InputStream streamOf(final String fileName) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
    }

    public static String contentOf(final String fileName) throws IOException {
        return IOUtils.toString(streamOf(fileName), defaultCharset());
    }

}
