package com.kangkimleekojangcho.akgimi.sns.adapter.in;

import com.kangkimleekojangcho.akgimi.sns.application.request.GetBunchOfFeedWrittenByFollowerRequestServiceRequest;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

@Builder
public record GetBunchOfFeedWrittenByFollowerRequest(
        @NotNull
        Long lastFeedId,
        @Positive
        Integer numberOfFeed
) {

    public GetBunchOfFeedWrittenByFollowerRequestServiceRequest toServiceRequest() {
        return GetBunchOfFeedWrittenByFollowerRequestServiceRequest.builder()
                .lastFeedId(lastFeedId)
                .numberOfFeed(numberOfFeed)
                .build();
    }
}
