package com.xyu.common.utlis;

import org.apache.commons.lang3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.lang.reflect.*;

/**
 * @author Xiang.Yu
 * @version 0.0.1
 * @date 2015/10/11
 * @description ReflectionHelper 反射操作类
 */
public class ReflectionHelper {


    private static final String SETTER_PREFIX = "set";

    private static final String GETTER_PREFIX = "get";

    private static final String CGLIB_CLASS_SEPARATOR = "$$";

    private static Logger logger = LoggerFactory.getLogger(ReflectionHelper.class);

    /**
     * 执行getter方法
     *
     * @param obj          执行实体
     * @param propertyName 属性名称
     * @return 方法结果
     */
    public static Object invokeGetter(Object obj, String propertyName) {
        Object object = obj;
        for (String name : org.apache.commons.lang3.StringUtils.split(propertyName, ".")) {
            String getterMethodName = GETTER_PREFIX + org.apache.commons.lang3.StringUtils.capitalize(name);
            object = invokeMethod(object, getterMethodName, new Class[]{}, new Object[]{});
        }
        return object;
    }

    /**
     * 执行setter方法
     *
     * @param obj          执行实体
     * @param propertyName 属性
     * @param value        参数值
     */
    public static void invokeSetter(Object obj, String propertyName, Object value) {
        Object object = obj;
        String[] names = org.apache.commons.lang3.StringUtils.split(propertyName, ".");
        for (int i = 0; i < names.length; i++) {
            if (i < names.length - 1) {
                String getterMethodName = GETTER_PREFIX + org.apache.commons.lang3.StringUtils.capitalize(names[i]);
                object = invokeMethod(object, getterMethodName, new Class[]{}, new Object[]{});
            } else {
                String setterMethodName = SETTER_PREFIX + org.apache.commons.lang3.StringUtils.capitalize(names[i]);
                invokeMethodByName(object, setterMethodName, new Object[]{value});
            }
        }
    }

    /**
     * 获取属性值
     * @param obj 执行实体
     * @param fieldName 属性名称
     * @return 值
     */
    public static Object getFieldValue(final Object obj, final String fieldName) {
        Field field = getAccessibleField(obj, fieldName);

        if (field == null) {
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + obj + "]");
        }

        Object result = null;
        try {
            result = field.get(obj);
        } catch (IllegalAccessException e) {
            logger.error("�������׳����쳣{}", e.getMessage());
        }
        return result;
    }

    /**
     * 设置属性值
     * @param obj 执行实体
     * @param fieldName 属性名称
     * @param value 属性值
     */
    public static void setFieldValue(final Object obj, final String fieldName, final Object value) {
        Field field = getAccessibleField(obj, fieldName);

        if (field == null) {
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + obj + "]");
        }

        try {
            field.set(obj, value);
        } catch (IllegalAccessException e) {
            logger.error("cannot access this field", e.getMessage());
        }
    }

    /**
     * 执行实体方法
     * @param obj 执行实体
     * @param methodName 方法名称
     * @param parameterTypes 方法参数类型
     * @param args 参数
     * @return 执行结果
     */
    public static Object invokeMethod(final Object obj, final String methodName, final Class<?>[] parameterTypes,
                                      final Object[] args) {
        Method method = getAccessibleMethod(obj, methodName, parameterTypes);
        if (method == null) {
            throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + obj + "]");
        }

        try {
            return method.invoke(obj, args);
        } catch (Exception e) {
            throw convertReflectionExceptionToUnchecked(e);
        }
    }

    /**
     * 执行实体方法
     * @param obj 执行实体
     * @param methodName 方法名称
     * @param args 方法参数
     * @return 执行结果
     */
    public static Object invokeMethodByName(final Object obj, final String methodName, final Object[] args) {
        Method method = getAccessibleMethodByName(obj, methodName);
        if (method == null) {
            throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + obj + "]");
        }

        try {
            return method.invoke(obj, args);
        } catch (Exception e) {
            throw convertReflectionExceptionToUnchecked(e);
        }
    }

    /**
     * 获取可访问的属性
     * @param obj 执行实体
     * @param fieldName 属性名称
     * @return 属性
     */
    public static Field getAccessibleField(final Object obj, final String fieldName) {
        Validate.notNull(obj, "object can't be null");
        Validate.notBlank(fieldName, "fieldName can't be blank");
        for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                Field field = superClass.getDeclaredField(fieldName);
                makeAccessible(field);
                return field;
            } catch (NoSuchFieldException e) {//NOSONAR
                //向上递归查询从父类继承的属性
                continue;// new add
            }
        }
        return null;
    }

    /**
     * 获取可访问的方法
     * @param obj 实体
     * @param methodName 方法名称
     * @param parameterTypes 参数类型
     * @return 方法
     */
    public static Method getAccessibleMethod(final Object obj, final String methodName,
                                             final Class<?>... parameterTypes) {
        Validate.notNull(obj, "object can't be null");
        Validate.notBlank(methodName, "methodName can't be blank");

        for (Class<?> searchType = obj.getClass(); searchType != Object.class; searchType = searchType.getSuperclass()) {
            try {
                Method method = searchType.getDeclaredMethod(methodName, parameterTypes);
                makeAccessible(method);
                return method;
            } catch (NoSuchMethodException e) {
                //继续查询父类方法
                continue;// new add
            }
        }
        return null;
    }

    /**
     * 通过名称获取方法
     * @param obj 实体
     * @param methodName 方法名称
     * @return 方法
     */
    public static Method getAccessibleMethodByName(final Object obj, final String methodName) {
        Validate.notNull(obj, "object can't be null");
        Validate.notBlank(methodName, "methodName can't be blank");

        for (Class<?> searchType = obj.getClass(); searchType != Object.class; searchType = searchType.getSuperclass()) {
            Method[] methods = searchType.getDeclaredMethods();
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    makeAccessible(method);
                    return method;
                }
            }
        }
        return null;
    }

    /**
     * 修改方法的访问修饰符
     * @param method 方法
     */
    public static void makeAccessible(Method method) {
        if ((!Modifier.isPublic(method.getModifiers()) || !Modifier.isPublic(method.getDeclaringClass().getModifiers()))
                && !method.isAccessible()) {
            method.setAccessible(true);
        }
    }

    /**
     * 修改属性private 修饰符为public
     * @param field 属性
     */
    public static void makeAccessible(Field field) {
        if ((!Modifier.isPublic(field.getModifiers()) || !Modifier.isPublic(field.getDeclaringClass().getModifiers()) || Modifier
                .isFinal(field.getModifiers())) && !field.isAccessible()) {
            field.setAccessible(true);
        }
    }

    /**
     * ͨ������, ���Class�����������ķ��Ͳ���������, ע�ⷺ�ͱ��붨���ڸ��ദ
     * ���޷��ҵ�, ����Object.class.
     * eg.
     * public UserDao extends HibernateDao<User>
     *
     * @param clazz The class to introspect
     * @return the first generic declaration, or Object.class if cannot be determined
     */
    @SuppressWarnings("unchecked")
    public static <T> Class<T> getClassGenricType(final Class clazz) {
        return getClassGenricType(clazz, 0);
    }

    /**
     * ͨ������, ���Class�����������ĸ���ķ��Ͳ���������.
     * ���޷��ҵ�, ����Object.class.
     * <p>
     * ��public UserDao extends HibernateDao<User,Long>
     *
     * @param clazz clazz The class to introspect
     * @param index the Index of the generic ddeclaration,start from 0.
     * @return the index generic declaration, or Object.class if cannot be determined
     */
    public static Class getClassGenricType(final Class clazz, final int index) {

        Type genType = clazz.getGenericSuperclass();

        if (!(genType instanceof ParameterizedType)) {
            logger.warn(clazz.getSimpleName() + "'s superclass not ParameterizedType");
            return Object.class;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        if (index >= params.length || index < 0) {
            logger.warn("Index: " + index + ", Size of " + clazz.getSimpleName() + "'s Parameterized Type: "
                    + params.length);
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            logger.warn(clazz.getSimpleName() + " not set the actual class on superclass generic parameter");
            return Object.class;
        }

        return (Class) params[index];
    }

    public static Class<?> getUserClass(Object instance) {
        Assert.notNull(instance, "Instance must not be null");
        Class clazz = instance.getClass();
        if (clazz != null && clazz.getName().contains(CGLIB_CLASS_SEPARATOR)) {
            Class<?> superClass = clazz.getSuperclass();
            if (superClass != null && !Object.class.equals(superClass)) {
                return superClass;
            }
        }
        return clazz;

    }

    /**
     * 将反射异常捕获处理成unchecked exception
     * @param e 异常
     * @return
     */
    public static RuntimeException convertReflectionExceptionToUnchecked(Exception e) {
        if (e instanceof IllegalAccessException || e instanceof IllegalArgumentException
                || e instanceof NoSuchMethodException) {
            return new IllegalArgumentException(e);
        } else if (e instanceof InvocationTargetException) {
            return new RuntimeException(((InvocationTargetException) e).getTargetException());
        } else if (e instanceof RuntimeException) {
            return (RuntimeException) e;
        }
        return new RuntimeException("Unexpected Checked Exception.", e);
    }
}

