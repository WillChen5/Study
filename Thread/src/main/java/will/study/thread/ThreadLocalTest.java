package will.study.thread;

import java.util.Random;

/**
 * Created by will on 16/8/29.
 */
public class ThreadLocalTest {

    private static ThreadLocal<Integer> x = new ThreadLocal<Integer>();
    private static ThreadLocal<MyThreadScopeData> myThreadScopeData= new ThreadLocal<MyThreadScopeData>();
    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                public void run() {
                    int data = new Random().nextInt();

                    System.out.println(Thread.currentThread().getName() + " get data : " + data);

                    x.set(data);
//                    MyThreadScopeData myData = new MyThreadScopeData();
//                    myData.setName("Will" + data);
//                    myData.setAge(data);
//                    myThreadScopeData.set(myData);
                    MyThreadScopeData.getThreadInstance().setName("Name" + data);
                    MyThreadScopeData.getThreadInstance().setName("Age" + data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    static class A{
        public void get(){
            int data = x.get();
            System.out.println("A from " + Thread.currentThread().getName() + " get data : " + data);

//            MyThreadScopeData myData = myThreadScopeData.get();
//            System.out.println("A from " + Thread.currentThread().getName() + " get myData : " + myData);

            MyThreadScopeData myData = MyThreadScopeData.getThreadInstance();
            System.out.println("A from " + Thread.currentThread().getName() + " get myData : " + myData);
        }
    }

    static class B{
        public void get(){
            int data = x.get();
            System.out.println("B from " + Thread.currentThread().getName() + " get data : " + data);

//            MyThreadScopeData myData = myThreadScopeData.get();
//            System.out.println("B from " + Thread.currentThread().getName() + " get myData : " + myData);
            MyThreadScopeData myData = MyThreadScopeData.getThreadInstance();
            System.out.println("B from " + Thread.currentThread().getName() + " get myData : " + myData);
        }
    }
}

class MyThreadScopeData{
    private MyThreadScopeData(){}
    public static MyThreadScopeData getThreadInstance(){
        MyThreadScopeData instance = map.get();
        if(instance == null){
            instance = new MyThreadScopeData();
            map.set(instance);
        }
        return instance;
    }

//    private static MyThreadScopeData instance = null;
    private static ThreadLocal<MyThreadScopeData> map = new ThreadLocal<MyThreadScopeData>();

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyThreadScopeData{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}