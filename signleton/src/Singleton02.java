/**
 * 与01 是一个意思
 * 只是把new出实例放到静态代码块中
 */
public class Singleton02 {
    private static final Singleton02 instance;
    static {
        instance = new Singleton02();
    }

    private Singleton02(){};

    public static Singleton02 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        Singleton02 instance1 = Singleton02.getInstance();
        Singleton02 instance2 = Singleton02.getInstance();
        System.out.println(instance1 == instance2);
    }
}
