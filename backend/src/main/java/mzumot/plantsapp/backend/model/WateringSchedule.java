package mzumot.plantsapp.backend.model;


public enum WateringSchedule {
    DAILY("DAILY"), WEEKLY("WEEKLY"), BI_WEEKLY("BI_WEEKLY"),AS_NEEDED("AS_NEEDED");

    private final String watering;

    WateringSchedule(String watering) {
        this.watering = watering;
    }


}
