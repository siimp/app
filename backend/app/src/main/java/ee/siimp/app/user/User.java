package ee.siimp.app.user;

import ee.siimp.app.common.entity.BaseEntity;
import ee.siimp.app.client.Client;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_user")
public class User extends BaseEntity {

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
