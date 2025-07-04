package bidder.api;

import bidder.Bidder;

public interface BidderRegistrator {
    Bidder register(String name, int governmentId, int taxId);
}
