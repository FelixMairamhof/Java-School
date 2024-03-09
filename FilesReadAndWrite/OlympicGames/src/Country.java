public class Country {
    private int rank;
    private String name;
    private int countGold;
    private int countSilver;
    private int countBronze;

    public Country(int rank, String name, int countGold, int countSilver, int countBronze) {
        this.rank = rank;
        this.name = name;
        this.countGold = countGold;
        this.countSilver = countSilver;
        this.countBronze = countBronze;
    }

    public int getMedaillenGesamt(){
        return this.countBronze + this.countSilver +this.countGold;
    }
    public String toString(){
        return "Rang: " + this.rank + ", Land: " + this.name +
                ", Medaillen: " +this.countGold + "/" + this.countSilver + "/" + this.countBronze +
                ", Gesamt: " + getMedaillenGesamt();
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountGold() {
        return countGold;
    }

    public void setCountGold(int countGold) {
        this.countGold = countGold;
    }

    public int getCountSilver() {
        return countSilver;
    }

    public void setCountSilver(int countSilver) {
        this.countSilver = countSilver;
    }

    public int getCountBronze() {
        return countBronze;
    }

    public void setCountBronze(int countBronze) {
        this.countBronze = countBronze;
    }
}
