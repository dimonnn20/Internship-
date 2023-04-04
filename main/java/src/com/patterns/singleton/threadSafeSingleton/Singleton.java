package com.patterns.singleton.threadSafeSingleton;

import java.util.concurrent.atomic.AtomicReference;

public class Singleton{
    private Singleton(){}
    private static AtomicReference<Singleton> obj;

    public static synchronized Singleton getInstance(){
        if(obj==null){
            synchronized(Singleton.class){
                if(obj==null){
                    // устанавливаем значение объекта Singleton
                    obj = new AtomicReference<>();
                }
            }
        }
        return obj.get();
    }

}
