package pl.sda.resultsService.dHont.domain;

import org.springframework.stereotype.Component;
import pl.sda.resultsService.dHont.dto.DHontResultDto;
import pl.sda.resultsService.dHont.dto.DHontResultsDto;
import pl.sda.resultsService.votingService.dto.ListVotesDto;
import pl.sda.resultsService.votingService.dto.VotingStatsDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
class DHontCalculator {

    private static final Double SEATS = 5D;

    public DHontResultsDto calculate(VotingStatsDto dto) {
        List<ListVotesDto> results = dto.getResults();

        List<Quotient> quotients = new ArrayList<>();

        for (ListVotesDto result : results) {
            for (Double i = 1D; i <= SEATS; i++) {
                quotients.add(new Quotient(result.getId(), result.getVotes() / i));
            }
        }

        quotients.sort((x, y) -> {
            if (x.getValue() == y.getValue()) {
                return 0;
            } else if (x.getValue() > y.getValue()) {
                return -1;
            } else return 1;
        });


        return getSeatsFromQuotientList(quotients);
    }

    private DHontResultsDto getSeatsFromQuotientList(List<Quotient> quotients) {

        Map<Long, Long> temp = new HashMap<>();

        int index = 1;
        for (Quotient quotient : quotients) {
            Long seatsForList = temp.get(quotient.getListId());
            if (seatsForList == null ) {
                seatsForList = 0L;
            }
            seatsForList++;
            temp.put(quotient.getListId(),seatsForList);

            if (index == SEATS) {
                break;
            }
            index++;
        }
        List<DHontResultDto> collect =
                temp.entrySet().stream()
                        .map(x -> new DHontResultDto(x.getKey(), x.getValue()))
                        .collect(Collectors.toList());
        return new DHontResultsDto(collect);
    }
}
