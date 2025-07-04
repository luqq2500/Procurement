package issuer;

import issuer.api.IssuerRegistrator;
import issuer.spi.IssuerRepository;

import java.util.UUID;

public class RegisterAnIssuer implements IssuerRegistrator {
    private final IssuerRepository issuerRepository;

    public RegisterAnIssuer(IssuerRepository issuerRepository) {
        this.issuerRepository = issuerRepository;
    }

    @Override
    public Issuer register(String name, UUID companyId) {
        Issuer issuer = new Issuer(UUID.randomUUID(), name, companyId);
        this.issuerRepository.add(issuer);
        return this.issuerRepository.findById(issuer.id()).orElse(null);
    }
}
