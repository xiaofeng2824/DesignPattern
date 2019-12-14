/**
 * 懒汉式加锁写法
 * 通过synchronized加锁解决线程不安全的问题
 * 但是锁会带来效率的下降
 */

public class Singleton04 {
    private static Singleton04 instance ;
    private Singleton04(){}

    public static synchronized  Singleton04 getInstance(){
        if (instance == null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            instance = new Singleton04();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(Singleton04.getInstance().hashCode());
            }).start();
        }
    }
}
