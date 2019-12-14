/**
 * 使用枚举使用单例
 */
public enum Singleton08 {
    instance;

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(Singleton08.instance.hashCode());
            }).start();
        }
    }
}
