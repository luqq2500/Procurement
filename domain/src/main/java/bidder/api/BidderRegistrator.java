package bidder.api;

import bidder.Bidder;
import company.Company;

import java.util.UUID;

public interface BidderRegistrator {
    Bidder register(String name, UUID companyId, String department);
}
