package com.brainmatics.trainingjee201801.struts2springjpa.config;

import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class KonfigAplikasiWeb implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext appContext
                = new AnnotationConfigWebApplicationContext();
        appContext.register(KonfigSpring.class);

        ContextLoaderListener contextLoaderListener = new ContextLoaderListener(appContext);
        servletContext.addListener(contextLoaderListener);

        FilterRegistration.Dynamic filter = servletContext.addFilter(
                "StrutsDispatcher", new StrutsPrepareAndExecuteFilter());
        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }

}
