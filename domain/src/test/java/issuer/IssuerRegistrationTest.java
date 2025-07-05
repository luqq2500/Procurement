package issuer;

import company.Company;
import company.InMemoryCompanyRepository;
import company.RegisterACompany;
import company.api.CompanyRegistrator;
import company.spi.CompanyRepository;
import issuer.api.IssuerRegistrator;
import issuer.spi.IssuerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class IssuerRegistrationTest {
    private IssuerRegistrator issuerRegistrator;
    private CompanyRegistrator companyRegistrator;

    @Before
    public void setUp(){
        IssuerRepository issuerRepository = new InMemoryIssuerRepository();
        this.issuerRegistrator = new RegisterAnIssuer(issuerRepository);
        CompanyRepository companyRepository = new InMemoryCompanyRepository();
        this.companyRegistrator = new RegisterACompany(companyRepository);
    }

    @Test
    public void registerOneIssuerTest(){
        Company company = companyRegistrator.register("OPT", 1111, 2222);
        Issuer issuer = issuerRegistrator.register("luqman", company.id(), "finance");
        Assert.assertNotNull(issuer);
        System.out.println(company.toString());
        System.out.println(issuer.toString());
    }
}
