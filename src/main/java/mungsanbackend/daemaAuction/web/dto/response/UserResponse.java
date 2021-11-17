package mungsanbackend.daemaAuction.web.dto.response;

import lombok.AllArgsConstructor;
import mungsanbackend.daemaAuction.domain.User;
import mungsanbackend.daemaAuction.oauth.entity.ProviderType;
import mungsanbackend.daemaAuction.oauth.entity.RoleType;

@AllArgsConstructor
public class UserResponse {

    private String userId;
    private String username;
    private String email;
    private String profileImageUrl;
    private ProviderType providerType;
    private RoleType roleType;

    public static UserResponse of(User user) {
        return new UserResponse(user.getUserId(), user.getUsername(), user.getEmail(), user.getProfileImageUrl(), user.getProviderType(), user.getRoleType());
    }
}
