public abstract class Animal {
    private int age;
    private String name;

    public void laufen(){
        System.out.println(this.getClass().getSimpleName() + " ich laufe...");
    }
    public void essen(){
        System.out.println(this.getClass().getSimpleName() + " ich essen...");
    }

    @java.lang.Override
    public java.lang.String toString() {
        return this.getClass().getSimpleName()  +" {" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

}