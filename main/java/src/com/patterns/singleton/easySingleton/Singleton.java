package com.patterns.singleton.easySingleton;

class Singleton{
    private Singleton(){}
    private static Singleton obj;

    public static Singleton getInstance(){
        if(obj==null){
            obj = new Singleton();
        }
        return obj;
    }
}