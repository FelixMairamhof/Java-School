package at.htlklu.fsst;

public class Elefant extends Saeugetier{

    public Elefant(int alter, String name) {
        super(alter, name);
    }

    public void trompeten() {
        System.out.println(this.getClass().getSimpleName()+": Tröööööt!");
    }

    @Override
    public void essen() {
        super.essen();
        System.out.println("... mit dem Rüssel.");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
