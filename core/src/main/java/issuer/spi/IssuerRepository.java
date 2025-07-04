package issuer.spi;

import issuer.Issuer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IssuerRepository {
    List<Issuer> issuers();
    void add(Issuer issuer);
    Optional<Issuer> findById(UUID id);
}
