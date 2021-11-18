package mungsanbackend.daemaAuction.web.dto.response.mypage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class MyPageResponse {
    // user
    private String userName;
    private String email;
    private String profileImageUrl;
    private List<MyProductResponse> productResponseList;
}