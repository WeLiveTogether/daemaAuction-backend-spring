package mungsanbackend.daemaAuction.exception;

public class UserNotFoundException extends ElementNotFoundException{
    public UserNotFoundException() {
        super("User를 찾을 수 없습니다.");
    }
}
