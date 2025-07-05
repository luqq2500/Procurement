package company;

public class RegisterInvalidCompanyInformationException extends RuntimeException {
    public RegisterInvalidCompanyInformationException(String message) {
        super(message);
    }
}
