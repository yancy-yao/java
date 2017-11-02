package com.yancy.reflect;

import java.lang.reflect.*;

/**
 * Created by yancy on 2017/11/1.
 */
public class MyProxy {

    public interface  IHello {
        void sayHello();
    }

    static class Hello implements IHello {
        @Override
        public void sayHello() {
            System.out.println("hello world.");
        }
    }

    //自定义InvocationHandler
    static class HWInvocationHandler implements InvocationHandler{
        //目标对象
        private Object target;

        public HWInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("before...");
            //
            Object rs = method.invoke(target, args);
            System.out.println("after ...");
            return rs;
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        //demo1
        //生成$Proxy0的class文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //获取动态代理类
        Class proxyClazz = Proxy.getProxyClass(IHello.class.getClassLoader(),IHello.class);
        //获得代理类的构造函数，并传入参数类型InvocationHandler.class
        Constructor constructor = proxyClazz.getConstructor(InvocationHandler.class);
        //通过构造函数来创建动态代理对象，将自定义的InvocationHandler实例传入
        IHello iHello = (IHello) constructor.newInstance(new HWInvocationHandler(new Hello()));
        //通过代理对象调用目标方法
        iHello.sayHello();

        //demo 2
        //生成$Proxy0的class文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        IHello  ihello = (IHello) Proxy.newProxyInstance(IHello.class.getClassLoader(),  //加载接口的类加载器
                new Class[]{IHello.class},      //一组接口
                new HWInvocationHandler(new Hello())); //自定义的InvocationHandler
        ihello.sayHello();
    }
}
