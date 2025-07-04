package bidder.spi;

import bidder.Bidder;

import java.util.Optional;
import java.util.UUID;

public interface BidderRepository {
    void add(Bidder bidder);
    Optional<Bidder> findById(UUID id);
}
