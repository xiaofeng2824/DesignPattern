/**
 * 懒汉模式
 * 双重检查 判断
 * 解决05线程不安全的问题
 */
public class Singleton06 {
    private static volatile  Singleton06 instance;
    private Singleton06(){}

    public static Singleton06 getInstance(){
        if (instance == null){
            //双重检查
            synchronized (Singleton06.class){
                if (instance == null){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Singleton06();
                }
            }
        }
        return  instance;
    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(Singleton06.getInstance().hashCode());
            }).start();
        }
    }
}
