package com.bangduoduo.monkey.model;

import com.bangduoduo.helper.ClassHelper;
import com.bangduoduo.orm.EntityScanner;
import com.bangduoduo.orm.annotation.EntityScan;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@HandlesTypes({EntityScanner.class})
public class WebInitializer implements ServletContainerInitializer {
    public void onStartup(Set<Class<?>> entityScannerSet, ServletContext servletContext) throws ServletException {
        List<EntityScanner> entityScanners = new ArrayList<EntityScanner>();
        if(entityScannerSet != null) {
            for(Class<?> waitClass : entityScannerSet) {
                if (!waitClass.isInterface() && !Modifier.isAbstract(waitClass.getModifiers()) &&
                        EntityScanner.class.isAssignableFrom(waitClass)) {
                    for(Annotation annotation : waitClass.getAnnotations()) {
                        if (waitClass.isAnnotationPresent(EntityScan.class)) {
                            EntityScan entityScan = (EntityScan)annotation;
                            System.out.println(entityScan.value());
                            ClassHelper.getBeanClassSet(entityScan.value());
                        }
                    }

                }
            }
        }
    }
}
