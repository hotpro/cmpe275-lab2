package edu.sjsu.cmpe275.lab2.web;

import edu.sjsu.cmpe275.lab2.dao.config.JpaConfig;
import edu.sjsu.cmpe275.lab2.service.config.ServiceConfig;
import edu.sjsu.cmpe275.lab2.web.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Annotation based configuration
 */
public class MyApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {ServiceConfig.class, JpaConfig.class};
    }
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/", "/welcome"};
    }
}
