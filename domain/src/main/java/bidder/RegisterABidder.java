package bidder;
import bidder.api.BidderRegistrator;
import bidder.spi.BidderRepository;
import java.util.UUID;

public class RegisterABidder implements BidderRegistrator {
    private final BidderRepository bidderRepository;

    public RegisterABidder(BidderRepository bidderRepository){
        this.bidderRepository = bidderRepository;
    }

    @Override
    public Bidder register(String name, UUID companyId, String department) {
        Bidder bidder = new Bidder(UUID.randomUUID(), name, companyId, department);
        this.bidderRepository.add(bidder);
        return bidder;
    }
}
