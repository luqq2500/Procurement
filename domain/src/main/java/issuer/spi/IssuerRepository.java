package issuer.spi;

import issuer.Issuer;

import java.util.Optional;
import java.util.UUID;

public interface IssuerRepository {
    void add(Issuer issuer);
    Optional<Issuer> findByCompanyId(UUID companyId);
}
