package mungsanbackend.daemaAuction.web;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import mungsanbackend.daemaAuction.domain.User;
import mungsanbackend.daemaAuction.service.UserService;
import mungsanbackend.daemaAuction.web.dto.response.ApiResponse;
import mungsanbackend.daemaAuction.web.dto.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "유저 정보 받아오기")
    @GetMapping("/users")
    public ApiResponse getUser() {
        User userInfo = userService.getUserInfo();
        UserResponse userResponse = UserResponse.of(userInfo);

        return ApiResponse.success("user", userResponse);
    }

    @Operation(summary = "마이페이지")
    @GetMapping("/mypage")
    public ResponseEntity<List<MyPageResponse>> myPage() {
        return ResponseEntity.ok(userService.myPage());
    }
}
