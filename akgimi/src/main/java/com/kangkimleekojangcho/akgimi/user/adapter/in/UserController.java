package com.kangkimleekojangcho.akgimi.user.adapter.in;

import com.kangkimleekojangcho.akgimi.bank.application.GenerateWithdrawalAccountService;
import com.kangkimleekojangcho.akgimi.common.domain.application.SubtractUserIdFromAccessTokenService;
import com.kangkimleekojangcho.akgimi.global.exception.BadRequestException;
import com.kangkimleekojangcho.akgimi.global.exception.BadRequestExceptionCode;
import com.kangkimleekojangcho.akgimi.global.response.ResponseFactory;
import com.kangkimleekojangcho.akgimi.global.response.SuccessResponse;
import com.kangkimleekojangcho.akgimi.user.adapter.in.request.AddDataForPendingUserRequest;
import com.kangkimleekojangcho.akgimi.user.adapter.in.request.LoginRequest;
import com.kangkimleekojangcho.akgimi.user.adapter.in.request.SignUpRequest;
import com.kangkimleekojangcho.akgimi.user.application.*;
import com.kangkimleekojangcho.akgimi.user.application.response.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final LoginService loginService;
    private final SignUpService signUpService;
    private final AddDataForPendingUserService addDataForPendingUserService;
    private final GetIdTokenService getIdTokenService;
    private final CheckDuplicateNicknameService checkDuplicateNicknameService;
    private final InputNicknameService inputNicknameService;
    private final RecommendNicknamesService recommendNicknamesService;
    private final GenerateWithdrawalAccountService generateWithdrawalAccountService;
    private final SubtractUserIdFromAccessTokenService subtractUserIdFromAccessTokenService;

    @Value("${kakao.redirection-url}")
    String kakaoRedirectUrl;
    @Value("${kakao.rest-api-key}")
    String kakaoRestApiKey;
    @Value("${kakao.token-redirect-url}")
    String kakaoTokenRedirectUrl;

    @GetMapping("/kakao/loginurl")
    public ResponseEntity<SuccessResponse<String>> getKakaoLoginUrl() {
        String loginUrl = String.format("https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=%s&redirect_uri=%s",
                kakaoRestApiKey, kakaoRedirectUrl);
        return ResponseFactory.success(loginUrl);
    }


    @PostMapping("/kakao/login")
    public ResponseEntity<SuccessResponse<LoginServiceResponse>> login(@RequestBody @Valid LoginRequest request) {
        LoginServiceResponse response = loginService.login(request.getIdToken());
        return ResponseFactory.success(response);
    }


    @PostMapping("/kakao/signup")
    public ResponseEntity<SuccessResponse<SignUpServiceResponse>> signup(@RequestBody @Valid SignUpRequest request) {
        SignUpServiceResponse response = signUpService.signUp(request.getIdToken());
        return ResponseFactory.success(response);
    }

    @GetMapping("/user/nickname/duplicate")
    public ResponseEntity<SuccessResponse<Boolean>> checkDuplicateNickname(@RequestParam("nickname") String nickname) {
        boolean response = checkDuplicateNicknameService.check(nickname);
        return ResponseFactory.success(response);
    }

    @PostMapping("/user/nickname")
    public ResponseEntity<SuccessResponse<Boolean>> inputNickname(@RequestParam("nickname") String nickname, HttpServletRequest servletRequest) {
        Long userId = subtractUserIdFromAccessTokenService.subtract(servletRequest);
        if(nickname==null) throw new BadRequestException(BadRequestExceptionCode.INVALID_INPUT);
        inputNicknameService.input(userId, nickname);
        return ResponseFactory.success(true);
    }

    @GetMapping("/user/nickname/recommend")
    public ResponseEntity<SuccessResponse<RecommendNicknamesServiceResponse>> recommendNicknames(HttpServletRequest servletRequest) {
        Long userId = subtractUserIdFromAccessTokenService.subtract(servletRequest);
        RecommendNicknamesServiceResponse response = recommendNicknamesService.recommend(userId);
        return ResponseFactory.success(response);
    }

    @GetMapping("/user/generated-withdrawal-account")
    public ResponseEntity<SuccessResponse<GenerateWithdrawalAccountServiceResponse>> generateWithdrawalAccount(HttpServletRequest servletRequest) {
        Long userId = subtractUserIdFromAccessTokenService.subtract(servletRequest);
        GenerateWithdrawalAccountServiceResponse response = generateWithdrawalAccountService.generate(userId);
        return ResponseFactory.success(response);
    }
}