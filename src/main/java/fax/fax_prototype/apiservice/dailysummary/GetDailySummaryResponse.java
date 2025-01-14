package fax.fax_prototype.apiservice.dailysummary;

import java.util.Map;

public class GetDailySummaryResponse {
    private Map<String, Map<String, Long>> dailySummary;

    public GetDailySummaryResponse(Map<String, Map<String, Long>> dailySummary) {
        this.dailySummary = dailySummary;
    }

    public Map<String, Map<String, Long>> getDailySummary() {
        return dailySummary;
    }

    public void setDailySummary(Map<String, Map<String, Long>> dailySummary) {
        this.dailySummary = dailySummary;
    }
}
