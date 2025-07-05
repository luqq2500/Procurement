package company;

import company.api.CompanyRegistrator;
import company.spi.CompanyRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CompanyRegistrationFunctionalTest{
    private CompanyRegistrator companyRegistrator;

    @Before
    public void setUp(){
        CompanyRepository companyRepository = new InMemoryCompanyRepository();
        this.companyRegistrator = new RegisterACompany(companyRepository);
    }

    @Test
    public void registerACompany(){
        Company company = this.companyRegistrator.register("OPT", 1111, 2222);
        Assert.assertNotNull(company);
        System.out.println(company);
    }

    @Test
    public void throwExceptionIfCompanyAlreadyExists() throws Exception{
        this.companyRegistrator.register("OPT", 1111, 2222);
        Assert.assertThrows(RegisterInvalidCompanyInformationException.class, ()->{this.companyRegistrator.register("OPT", 1111, 2222);});
    }

    @Test
    public void throwExceptionIfBusinessIdAndTaxIdIsInvalid() throws Exception{
        Assert.assertThrows(RegisterInvalidCompanyInformationException.class,
                () -> this.companyRegistrator.register("OPT", 555, 555));
        Assert.assertThrows(RegisterInvalidCompanyInformationException.class,
                () -> this.companyRegistrator.register("OPT", -1, 0));
    }

}
