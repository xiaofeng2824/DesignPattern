/**
 * 饿汉式
 * 类加载到内存中，就实例一个单例。JVM保证安全
 * 简单实用 推荐实用
 * 缺点：不用用不用都用实例它
 *
 *知识点：static 保证了在类变量中，只有一份
 * 构造方法私有，保证不能 new 出实例
 */
public class Singleton01 {
    private static  final Singleton01 instance = new Singleton01();

    private  Singleton01(){};

    // getInstance() 方法
    public static Singleton01 getInstance(){
        return instance;
    }

    //test
    public static void main(String[] args) {
        Singleton01 instance1 = Singleton01.getInstance();
        Singleton01 instance2 = Singleton01.getInstance();
        System.out.println(instance1 == instance2);
    }

}
