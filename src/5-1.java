class storage {
    int a;
    String b;

    void set (int a) {
        this.a = a;
    }
    void set (String b) {
        this.b = b;
    }
}

public class generic {
    public static void main(String[] args) {
        storage<Integer> a = new storage<>();
        storage<String> b = new storage<>();

        a.set(1);
        b.set("hello");
        System.out.println(a.get());
        System.out.println(b.get());
    }
}
