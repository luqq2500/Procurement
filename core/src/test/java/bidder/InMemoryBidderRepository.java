package bidder;

import bidder.spi.BidderRepository;

import java.util.*;

public class InMemoryBidderRepository implements BidderRepository {
    private final List<Bidder> buyers = new ArrayList<>();
    @Override
    public void add(Bidder bidder) {
        this.buyers.add(bidder);
    }

    @Override
    public Optional<Bidder> findById(UUID id) {
        return this.buyers.stream()
                .filter(bidder -> bidder.id().equals(id))
                .findFirst();
    }
}
