package com.paper.management.utils;

import org.springframework.beans.BeanUtils;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by liumengyao on 17/5/18.
 */
public abstract class BeanHelper  {

    public BeanHelper() {

    }

    public static <T> T copyProperties(Object srcObj, Class<T> destClass) {
        if(srcObj == null) {
            return null;
        } else {
            Object target = null;

            try {
                target = destClass.newInstance();
            } catch (InstantiationException var6) {
                var6.printStackTrace();
            } catch (IllegalAccessException var7) {
                var7.printStackTrace();
            }

            BeanUtils.copyProperties(target, srcObj);

            return (T) target;
        }
    }

}
