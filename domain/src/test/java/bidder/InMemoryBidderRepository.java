package bidder;

import bidder.spi.BidderRepository;

import java.util.*;

public class InMemoryBidderRepository implements BidderRepository {
    private final List<Bidder> bidders = new ArrayList<>();

    @Override
    public void add(Bidder bidder) {
        this.bidders.add(bidder);
    }

    @Override
    public Optional<Bidder> findByCompanyId(UUID companyId) {
        return this.bidders.stream()
                .filter(bidder -> bidder.companyId() == companyId)
                .findFirst();
    }
}
