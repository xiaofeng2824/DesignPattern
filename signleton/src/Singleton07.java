/**
 * 静态内部类方式
 * JVM保证单例
 * 加载外部类时不会加载内部类，这样可以实现懒加载
 */
public class Singleton07 {
    private Singleton07(){}

    private static class SingletonHolder{
        private final static Singleton07 instance = new Singleton07();
    }

    public static Singleton07 getInstance(){
        return SingletonHolder.instance;
    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(Singleton07.getInstance().hashCode());
            }).start();
        }
    }
}
