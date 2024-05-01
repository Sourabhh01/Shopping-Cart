package com.jsp.Shppingcart.helper;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.jsp.helper.ClassConfig;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
    	
		Class[] configClasses = {ConfigClass.class};
        return configClasses;
    }

    @Override
    protected String[] getServletMappings() {
        String [] urls = {"/"};
        return urls;
    }

}
