package pl.sda.resultsService.votingService.domain;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.resultsService.votingService.dto.VotingStatsDto;

@Component
@AllArgsConstructor
public class VotingServiceFacade {
    private VotingServiceClient service;

    public VotingStatsDto getVotingResults(Long votingId) {

        return service.getVotingData(votingId).toDto();
    }

}
