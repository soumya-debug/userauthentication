package com.simpli.userauthentication;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{UserauthenticationApplication.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null; // or provide your servlet configuration class if needed
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

