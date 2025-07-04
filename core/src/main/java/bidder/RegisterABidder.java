package bidder;
import bidder.api.BidderRegistrator;
import bidder.spi.BidderRepository;
import java.lang.module.FindException;
import java.util.UUID;

public class RegisterABidder implements BidderRegistrator {
    private final BidderRepository bidderRepository;

    public RegisterABidder(BidderRepository bidderRepository){
        this.bidderRepository = bidderRepository;
    }

    @Override
    public Bidder register(String name, int governmentId, int taxId) {
        Bidder bidder = new Bidder(UUID.randomUUID(), name, governmentId, taxId);
        this.bidderRepository.add(bidder);
        return this.bidderRepository.findById(bidder.id()).orElse(null);
    }
}
