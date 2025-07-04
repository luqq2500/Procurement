package issuer;

import issuer.spi.IssuerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class InMemoryIssuerRepository implements IssuerRepository {
    List<Issuer> issuers = new ArrayList<>();
    @Override
    public List<Issuer> issuers() {
        return this.issuers;
    }

    @Override
    public void add(Issuer issuer) {
        this.issuers.add(issuer);
    }

    @Override
    public Optional<Issuer> findById(UUID id) {
        return this.issuers.stream()
                .filter(issuer -> issuer.id().equals(id))
                .findFirst();
    }

}
