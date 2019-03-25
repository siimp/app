package ee.siimp.app.appuser;

import ee.siimp.app.common.entity.BaseEntity;
import ee.siimp.app.client.Client;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppUser extends BaseEntity {

    @NotBlank
    @Column(nullable = false)
    private String username;

    @NotBlank
    @Column(nullable = false)
    private String encryptedPassword;

    @OneToMany
    @Singular
    private List<Client> clients;
}
