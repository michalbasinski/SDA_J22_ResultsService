package pl.sda.resultsService.api;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.resultsService.dHont.domain.DHotFacade;
import pl.sda.resultsService.dHont.dto.DHontResultsDto;
import pl.sda.resultsService.votingService.domain.VotingServiceFacade;
import pl.sda.resultsService.votingService.dto.VotingStatsDto;

import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
class ResultsController {

    private DHotFacade resultsFacade;
    private VotingServiceFacade serviceFacade;

    @GetMapping("/results/{id}")
    VotingResultsResponse get(@PathVariable Long id) {
        VotingStatsDto votingResults = serviceFacade.getVotingResults(id);
        DHontResultsDto dHontResultsDto = resultsFacade.DHontSeats(votingResults);

        return new VotingResultsResponse(dHontResultsDto.getResults()
                .stream()
                .map(x -> new VotingResult(x.getListId(),x.getSeats()))
                .collect(Collectors.toList()));
    }

}
