package bidder;
import org.junit.Assert;
import org.junit.Test;
import bidder.api.BidderRegistrator;
import bidder.spi.BidderRepository;


public class BidderRegistrationTest {
    @Test
    public void registerABidderTest(){
        BidderRepository bidderRepository = new InMemoryBidderRepository();
        BidderRegistrator bidderRegistrator = new RegisterABidder(bidderRepository);
        String name = "OptoCom";
        int businessId = 1111;
        int tinId = 2222;
        Bidder bidder = bidderRegistrator.register(name, businessId, tinId);
        Assert.assertNotNull(bidder);
        System.out.println(bidder);
    }
}
