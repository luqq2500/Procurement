package bidder;
import company.Company;
import company.InMemoryCompanyRepository;
import company.RegisterACompany;
import company.api.CompanyRegistrator;
import company.spi.CompanyRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import bidder.api.BidderRegistrator;
import bidder.spi.BidderRepository;


public class BidderRegistrationFunctionalTest {
    private BidderRegistrator bidderRegistrator;
    private CompanyRegistrator companyRegistrator;

    @Before
    public void setUp(){
        BidderRepository bidderRepository = new InMemoryBidderRepository();
        this.bidderRegistrator = new RegisterABidder(bidderRepository);
        CompanyRepository companyRepository = new InMemoryCompanyRepository();
        this.companyRegistrator = new RegisterACompany(companyRepository);
    }

    @Test
    public void registerABidder(){
        Company company = this.companyRegistrator.register("OPT", 1111, 2222);
        Bidder bidder = this.bidderRegistrator.register("Luqman", company.id(), "finance");
        Assert.assertNotNull(bidder);
        System.out.println(bidder);
    }
}
