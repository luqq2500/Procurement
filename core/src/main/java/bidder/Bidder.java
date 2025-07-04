package bidder;

import java.util.UUID;

public record Bidder(UUID id, String name, int businessId, int tinId){
}
