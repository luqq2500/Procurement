package procurement;

import java.util.Date;
import java.util.UUID;

public record Procurement(UUID id, String title, String description, Date issueDate, UUID issuerId){
}
