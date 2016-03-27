package edu.sjsu.cmpe275.lab2.web;

import edu.sjsu.cmpe275.lab2.service.config.ServiceConfiguration;
import edu.sjsu.cmpe275.lab2.web.config.WebConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by yutao on 3/9/16.
 */
public class MyApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {ServiceConfiguration.class};
    }
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfiguration.class};
    }
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/", "/welcome"};
    }
}
