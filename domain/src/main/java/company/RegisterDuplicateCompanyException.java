package company;

public class RegisterDuplicateCompanyException extends RuntimeException{
    public RegisterDuplicateCompanyException(String message){
        super(message);
    }
}
