package com.bangduoduo.helper;

import com.bangduoduo.util.ClassUtil;

import java.util.HashSet;
import java.util.Set;

public final class ClassHelper {
    private static final Set<Class<?>> CLASS_SET;

    static {
        CLASS_SET = new HashSet<Class<?>>(); //也可以将所有的注解的类加进来，再根据annotation去过滤
    }

    /**
     * 获取应用包名下所有 Entity 类
     */
    public static Set<Class<?>> getBeanClassSet(String packageName) {
        Set<Class<?>> entityClassSet = new HashSet<Class<?>>();
        ClassUtil.getClasses(packageName);
        return null;
    }
}
