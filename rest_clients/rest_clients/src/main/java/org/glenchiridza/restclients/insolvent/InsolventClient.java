package org.glenchiridza.restclients.insolvent;

import org.glenchiridza.restclients.util.InsolventCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "insolvent",path = "/api/insolvents")
public interface InsolventClient {

    @GetMapping("{patientId}")
    InsolventCheckResponse isInsolvent(
            @PathVariable("patientId") Integer patientId);

}
