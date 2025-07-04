package issuer;

import company.Company;
import company.InMemoryCompanyRepository;
import company.RegisterACompany;
import company.api.CompanyRegistrator;
import company.spi.CompanyRepository;
import issuer.api.IssuerRegistrator;
import issuer.spi.IssuerRepository;
import org.junit.Assert;
import org.junit.Test;

public class IssuerRegistrationTest {
    @Test
    public void testIssuerRegistration(){
        IssuerRepository issuerRepository = new InMemoryIssuerRepository();
        IssuerRegistrator issuerRegistrator = new RegisterAnIssuer(issuerRepository);

        CompanyRepository companyRepository = new InMemoryCompanyRepository();
        CompanyRegistrator companyRegistrator = new RegisterACompany(companyRepository);

        Company company = companyRegistrator.register("OPT", 111111);
        Issuer issuer = issuerRegistrator.register("luqman", company.id());

        Assert.assertNotNull(issuer);
    }
}
