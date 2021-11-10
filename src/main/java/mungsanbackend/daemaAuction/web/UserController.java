package mungsanbackend.daemaAuction.web;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import mungsanbackend.daemaAuction.domain.User;
import mungsanbackend.daemaAuction.service.UserService;
import mungsanbackend.daemaAuction.web.dto.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "유저 정보 받아오기")
    @GetMapping("/users")
    public ApiResponse getUser() {
        User user = userService.getUserInfo();

        return ApiResponse.success("user", user);
    }
}
