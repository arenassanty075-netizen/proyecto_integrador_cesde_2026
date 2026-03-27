package co.edu.cesde.ga.model;

public class Period {

    private long periodId;
    private String name;
    private String startDate;
    private String endDate;

    // Constructor vacío
    public Period() {}

    // Constructor con parámetros
    public Period(long periodId, String name, String startDate, String endDate) {
        this.periodId = periodId;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getter y setter para periodId
    public long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(long periodId) {
        this.periodId = periodId;
    }

    // Getter y setter para name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter y setter para startDate
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    // Getter y setter para endDate
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}