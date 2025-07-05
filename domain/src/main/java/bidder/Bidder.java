package bidder;

import java.util.UUID;

public record Bidder(UUID id, String name, UUID companyId, String department){
}
