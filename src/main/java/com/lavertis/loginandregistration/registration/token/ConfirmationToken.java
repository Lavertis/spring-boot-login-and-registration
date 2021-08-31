package com.lavertis.loginandregistration.registration.token;

import com.lavertis.loginandregistration.appuser.AppUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {

    @Id
    @SequenceGenerator(name = "confirmation_token_sequence", sequenceName = "confirmation_token_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "confirmation_token_sequence")
    private Long id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime creationTime;
    @Column(nullable = false)
    private LocalDateTime expirationTime;
    private LocalDateTime confirmationTime;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "app_user_id",
            foreignKey = @ForeignKey(name = "app_user_fk")
    )
    private AppUser appUser;

    public ConfirmationToken(String token,
                             LocalDateTime creationTime,
                             LocalDateTime expirationTime,
                             AppUser appUser) {
        this.token = token;
        this.creationTime = creationTime;
        this.expirationTime = expirationTime;
        this.appUser = appUser;
    }
}
