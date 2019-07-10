package se.gocta.demo.core.user.service.model;

import java.time.Instant;

public class City {

    private final Integer cityId;
    private final Instant periodStart;
    private final Instant periodEnd;

    public City(final Integer cityId, final Instant periodStart, final Instant periodEnd) {
        this.cityId = cityId;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
    }

    public Integer getCityId() {
        return cityId;
    }

    public Instant getPeriodStart() {
        return periodStart;
    }

    public Instant getPeriodEnd() {
        return periodEnd;
    }
}
