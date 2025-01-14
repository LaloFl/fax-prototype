package fax.fax_prototype.apiservice.dailysummary;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Controller;

import fax.fax_prototype.persistence.fax.Fax;
import fax.fax_prototype.persistence.fax.FaxService;

@Controller
public class GetDailySummaryController {

    FaxService faxService;

    public GetDailySummaryController(FaxService faxService) {
        this.faxService = faxService;
    }

    public GetDailySummaryResponse getDailySummary() {
        Iterable<Fax> faxes = faxService.getAllFaxes();
        // SEPARATE FAXES INTO COMPLETED AND INCOMPLETED
        // THEN CALCULATE THE TOTAL NUMBER OF FAXES OF EACH GROUP FOR EACH DAY
        List<Fax> faxList = StreamSupport.stream(faxes.spliterator(), false).collect(Collectors.toList());

        Map<String, Map<String, Long>> dailySummary = faxList.stream().collect(Collectors.groupingBy(fax -> {
            // get day from createdAt
            return fax.getCreatedAt().toString().substring(0, 10);
        }, Collectors.groupingBy(fax -> {
            // get status is completed if completedAt is not null
            return fax.getCompletedAt() != null ? "completed" : "incompleted";
        }, Collectors.counting())));

        return new GetDailySummaryResponse(dailySummary);
    }
}
