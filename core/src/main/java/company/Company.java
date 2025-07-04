package company;

import java.util.UUID;

public record Company(UUID id, String name, int registrationId) {
}
