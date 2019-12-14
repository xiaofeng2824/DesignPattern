/**
 * 懒汉式 缩小锁的粒度
 * 然而并不能解决线程安全的问题
 */
public class Singleton05 {
    private static Singleton05 instance;

    private Singleton05(){}

    public static Singleton05 getInstance(){
        if (instance == null){
            // 企图通过减小同步代码块的方式提高效率，然后并不可行
            synchronized (Singleton05.class){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                instance = new Singleton05();
            }
        }
      return instance;
    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(Singleton05.getInstance().hashCode());
            }).start();
        }
    }
}
