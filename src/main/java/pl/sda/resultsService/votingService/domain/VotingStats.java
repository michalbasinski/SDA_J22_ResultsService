package pl.sda.resultsService.votingService.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.sda.resultsService.votingService.dto.VotingStatsDto;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class VotingStats {
    private Long electionId;

    @JsonProperty("listVotes")
    private List<ListVotes> listVotes;

    VotingStatsDto toDto() {
        return new VotingStatsDto(listVotes.stream().map(x -> x.toDto()).collect(Collectors.toList()));
    }
}