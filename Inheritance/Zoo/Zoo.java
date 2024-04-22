package at.htlklu.fsst;

public class Zoo {
    public static void main(String[] args) {
        Elefant e1 = new Elefant(99, "Herbert");
        Flamingo f1 = new Flamingo(12, "Juliane");
        Fledermaus f2 = new Fledermaus(3, "Gerda");
        Loewe l1 = new Loewe(24, "Gerald");
        Pelikan p1 = new Pelikan(62, "Hubert");

        e1.trompeten();
        e1.essen();
        f1.laufen();
        f2.laufen();
        l1.essen();
        p1.eierlegen();
        

    }
}
