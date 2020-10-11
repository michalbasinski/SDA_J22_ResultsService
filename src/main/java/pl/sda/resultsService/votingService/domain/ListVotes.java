package pl.sda.resultsService.votingService.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.sda.resultsService.votingService.dto.ListVotesDto;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class ListVotes {
    private Long listId;
    private Long votes;

    public ListVotesDto toDto() {
        return new ListVotesDto(listId, votes);
    }
}