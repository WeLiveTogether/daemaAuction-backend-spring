package mungsanbackend.daemaAuction.exception;

public class SubCategoryNotFoundException extends ElementNotFoundException{
    public SubCategoryNotFoundException() {
        super("SubCategory를 찾을 수 없습니다.");
    }
}
