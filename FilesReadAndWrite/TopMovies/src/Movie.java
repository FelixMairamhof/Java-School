import java.time.LocalDate;

public class Movie {

    private int moneyGenerated;
    private int viewersUS;
    private LocalDate startTime;
    private int budget;
    private String title;
    private String regie;

    public Movie(int moneyGenerated, int viewersUS, LocalDate startTime, int budget, String title, String regie) {
        this.moneyGenerated = moneyGenerated;
        this.viewersUS = viewersUS;
        this.startTime = startTime;
        this.budget = budget;
        this.title = title;
        this.regie = regie;
    }

    @Override
    public String toString() {
        return "Tiltle: " + this.title +
                ", Regie: " + this.regie +
                ", Einnahmen: " + this.moneyGenerated +
                ",Besucher: " + this.viewersUS +
                ", Budget: " + this.budget +
                ", Kinostart: " + this.startTime;
    }

    public int getMoneyGenerated() {
        return moneyGenerated;
    }

    public void setMoneyGenerated(int moneyGenerated) {
        this.moneyGenerated = moneyGenerated;
    }

    public int getViewersUS() {
        return viewersUS;
    }

    public void setViewersUS(int viewersUS) {
        this.viewersUS = viewersUS;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRegie() {
        return regie;
    }

    public void setRegie(String regie) {
        this.regie = regie;
    }
}
