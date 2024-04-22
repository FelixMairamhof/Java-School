package at.htlklu.fsst;

public abstract class Vogel extends Tier {

    public Vogel(int alter, String name) {
        super(alter, name);
    }

    public void eierlegen() {
        System.out.println(this.getClass().getSimpleName()+": Ich lege ein Ei...");
    }

    @Override
    public void laufen() {
        System.out.println(this.getClass().getSimpleName()+": Ich hopse...");
    }
}
