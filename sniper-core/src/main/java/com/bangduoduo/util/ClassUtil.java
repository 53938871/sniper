package com.bangduoduo.util;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public final class ClassUtil {
    /**
     * 获取指定包名下的所有类
     */
    public static Set<Class> getClasses(String packageName) {
        Set<Class> classes = new HashSet<Class>();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            String path = packageName.replace('.', '/');
            Enumeration<URL> resources = classLoader.getResources(path);
            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                if (resource.getProtocol().equals("jar")) {
                    // inside a jar => read the jar files and check
                    findClassesJar(resource, path, classes);
                } else if (resource.getProtocol().equals("file")) {
                    // read subdirectories and find
                    findClassesFile(new File(resource.getFile()), packageName, classes);
                } else {
                    System.err.println("Unknown protocol connection: " + resource);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classes;
    }

    /**
     * Reads a jar file and checks all the classes inside it with the package
     * name specified.
     *
     * @param resource The resource url
     * @param path
     * @param classes
     * @return
     */
    private static Set<Class> findClassesJar(URL resource, String path, Set<Class> classes) {
        JarURLConnection jarConn = null;
        JarFile jar = null;
        try {
            jarConn = (JarURLConnection) resource.openConnection();
            jar = jarConn.getJarFile();
            Enumeration<JarEntry> e = jar.entries();
            while (e.hasMoreElements()) {
                JarEntry entry = e.nextElement();
                if ((entry.getName().startsWith(path + "/")
                        || entry.getName().startsWith(path + "."))
                        && entry.getName().endsWith(".class")) {
                    String name = entry.getName().replace('/', '.');
                    name = name.substring(0, name.length() - 6);
                    checkClass(name, classes);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                jar.close();
            } catch (IOException e) {
            }
        }
        return classes;
    }

    /**
     * Recursive method used to find all classes in a given file (file
     * or directory).
     *
     * @param file   The base directory
     * @param packageName The package name for classes found inside the base directory
     * @ classes The list of classes
     * @return The same classes
     * @throws ClassNotFoundException
     */
    private static Set<Class> findClassesFile(File file, String packageName, Set<Class> classes) {
        if (file.isFile() && file.getName().endsWith(".class")) {
            //classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            checkClass(packageName.substring(0, packageName.length() - 6), classes);
        } else {
            File[] files = file.listFiles();
            for (File f : files) {
                findClassesFile(f, packageName + "." + f.getName(), classes);
            }
        }
        return classes;
    }

    private static Set<Class> checkClass(String name, Set<Class> classes) {
        try {
            Class clazz = Class.forName(name);

                classes.add(clazz);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return classes;
    }

}
