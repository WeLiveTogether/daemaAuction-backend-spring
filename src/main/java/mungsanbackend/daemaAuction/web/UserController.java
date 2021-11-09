package mungsanbackend.daemaAuction.web;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import mungsanbackend.daemaAuction.service.UserService;
import mungsanbackend.daemaAuction.web.dto.response.ApiResponse;
import mungsanbackend.daemaAuction.web.dto.response.MyPageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        mungsanbackend.daemaAuction.domain.User user = userService.getUser(principal.getUsername());

        return ApiResponse.success("user", user);
    }
}
