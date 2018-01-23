package com.service.impl;

public class InitializeDemo {  
    private static int k = 1;  
    private static InitializeDemo t1 = new InitializeDemo("t1");  
    private static InitializeDemo t2 = new InitializeDemo("t2");  
    private static int i = print("i");  
    private static int n = 99;  
    static {  
        print("静态块");  
    }  
    private int j = print("j");  
    {  
        print("构造块");  
    }  
    public InitializeDemo(String str) {  
        System.out.println((k++) + ":" + str + "   i=" + i + "    n=" + n);  
        ++i;  
        ++n;  
    }  
    public static int print(String str) {  
        System.out.println((k++) + ":" + str + "   i=" + i + "    n=" + n);  
        ++n;  
        return ++i;  
    }  
    public static void main(String args[]) {  
        new InitializeDemo("init");  
    }  
    /*
     * .运行main方法的时候，JVM会调用ClassLoader来加载InitializeDemo类，那么一起源于这次加载。  
2.上面有四个静态属性，所以会按顺序逐一初始化这四个静态属性。  
3.private static int k = 1; 此时将k初始化为1。  
4.private static InitializeDemo t1 = new InitializeDemo("t1");创建InitializeDemo对象，  
  那么按照核心理念中的顺序，先执行private int j = print("j");，打印出j，然后执行构造  
  块，最后执行构造方法。  
5.private static InitializeDemo t2 = new InitializeDemo("t2");同步骤4。  
6.private static int i = print("i");打印i。  
7.private static int n = 99;直到这一步，n才被赋值为99，之前是从默认的0开始++的。  
8.静态属性初始化完毕，代码走到静态块，打印出静态块，此时n=99。  
9.静态属性和静态块执行完毕，然后执行main方法中的代码new InitializeDemo("init");  
10.main方法中创建对象，先初始化非静态属性，private int j = print("j");打印j，  
   然后执行构造块，最后执行构造方法。  
     */
}  