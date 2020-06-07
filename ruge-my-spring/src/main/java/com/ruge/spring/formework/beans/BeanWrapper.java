package com.ruge.spring.formework.beans;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:  IOC容器中的实例的包装类
 * @date 2020/6/7 19:41
 */
public class BeanWrapper {

    private Object wrappedInstance;
    private Class<?> wrappedClass;

    public BeanWrapper(Object wrappedInstance){
        this.wrappedInstance = wrappedInstance;
    }

    public Object getWrappedInstance(){
        return this.wrappedInstance;
    }

    // 返回代理以后的Class
    // 可能会是这个 $Proxy0
    public Class<?> getWrappedClass(){
        return this.wrappedInstance.getClass();
    }

}
