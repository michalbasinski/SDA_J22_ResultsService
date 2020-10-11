package pl.sda.resultsService.dHont.domain;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.resultsService.dHont.dto.DHontResultsDto;
import pl.sda.resultsService.votingService.dto.VotingStatsDto;

@Component
@AllArgsConstructor
public class DHotFacade {

    private DHontCalculator calculator;

    public DHontResultsDto DHontSeats(VotingStatsDto dto) {
        return calculator.calculate(dto);
    }
}
