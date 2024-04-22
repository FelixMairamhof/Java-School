package at.htlklu.fsst;

public abstract class Tier {
    private int alter;
    private String name;

    public Tier(int alter, String name) {
        this.alter = alter;
        this.name = name;
    }

    public void laufen() {
        System.out.println(this.getClass().getSimpleName()+": Ich laufe...");
    }

    public void essen() {
        System.out.println(this.getClass().getSimpleName()+": Ich esse...");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "alter=" + alter +
                ", name='" + name + '\'' +
                '}';
    }
}
