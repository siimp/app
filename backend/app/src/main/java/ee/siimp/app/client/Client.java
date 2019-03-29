package ee.siimp.app.client;

import ee.siimp.app.common.entity.BaseEntity;
import ee.siimp.app.country.Country;
import ee.siimp.app.user.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client extends BaseEntity {

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, updatable = false)
    private User user;

    @NotBlank
    @Column(nullable = false)
    private String firstName;

    @NotBlank
    @Column(nullable = false)
    private String lastName;

    @NotBlank
    @Column(nullable = false)
    private String username;

    @Email
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String address;

    @NotNull
    @ManyToOne(optional = false)
    private Country country;
}
