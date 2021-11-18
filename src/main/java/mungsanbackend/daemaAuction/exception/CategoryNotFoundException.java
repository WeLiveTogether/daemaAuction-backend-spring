package mungsanbackend.daemaAuction.exception;

public class CategoryNotFoundException extends ElementNotFoundException{
    public CategoryNotFoundException() {
        super("Category를 찾을 수 없습니다.");
    }
}
