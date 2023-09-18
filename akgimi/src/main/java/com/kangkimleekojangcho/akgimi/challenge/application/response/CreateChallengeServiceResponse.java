package com.kangkimleekojangcho.akgimi.challenge.application.response;

import com.kangkimleekojangcho.akgimi.challenge.domain.Challenge;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CreateChallengeServiceResponse {
    private final Long productId;
    private final Integer accumulatedAmount;
    private final boolean achievementState;
    private final Integer challengePeriod;
    private final LocalDate challengeStartDate;
    private final LocalDate challengeEndDate;
    private final boolean isInProgress;

    private CreateChallengeServiceResponse(Long productId, Integer accumulatedAmount, boolean achievementState, Integer challengePeriod, LocalDate challengeStartDate, LocalDate challengeEndDate, boolean isInProgress) {
        this.productId = productId;
        this.accumulatedAmount = accumulatedAmount;
        this.achievementState = achievementState;
        this.challengePeriod = challengePeriod;
        this.challengeStartDate = challengeStartDate;
        this.challengeEndDate = challengeEndDate;
        this.isInProgress = isInProgress;
    }

    public static CreateChallengeServiceResponse from(Challenge challenge) {
        return new CreateChallengeServiceResponse(challenge.getId(),
                challenge.getAccumulatedAmount(),
                challenge.isAchievementState(),
                challenge.getChallengePeriod(),
                challenge.getChallengeStartDate(),
                challenge.getChallengeEndDate(),
                challenge.isInProgress());
    }
}
