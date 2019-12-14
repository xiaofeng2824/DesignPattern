/**
 * 懒汉式
 * 虽然达到了按需初始化的目的，却带来了线程安全的问题
 */
public class Singleton03 {

    private static Singleton03 instance;
    private Singleton03(){};

    public static Singleton03 getInstance(){
        if ( instance == null){

            //线程沉睡一毫秒，只是扩大并发的情况
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Singleton03();
        }
        return instance;
    }

    // 起100 个线程 测试线程安全的问题
    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(Singleton03.getInstance().hashCode());
            }).start();
        }
    }
}
