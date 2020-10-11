package pl.sda.resultsService.dHont.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.resultsService.dHont.dto.DHontResultDto;
import pl.sda.resultsService.dHont.dto.DHontResultsDto;
import pl.sda.resultsService.votingService.dto.ListVotesDto;
import pl.sda.resultsService.votingService.dto.VotingStatsDto;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DHontFacadeTest {

    @Autowired
    private DHotFacade facade;

    @Test
    void shouldReturnCorrectStatistics() {
        //given
        final VotingStatsDto parameters =
                new VotingStatsDto(Arrays.asList(new ListVotesDto(1L, 180L),
                        new ListVotesDto(2L, 500L),
                        new ListVotesDto(3L, 340L)));

        final DHontResultsDto expectedResult = new DHontResultsDto(Arrays.asList(new DHontResultDto(1L, 1L),
                new DHontResultDto(2L, 2L),
                new DHontResultDto(3L, 2L)));

        //when
        DHontResultsDto votingResults = facade.DHontSeats(parameters);

        //then
        assertEquals(expectedResult, votingResults);

    }

}