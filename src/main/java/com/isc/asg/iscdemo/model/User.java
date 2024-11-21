package com.isc.asg.iscdemo.model;

/*import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;*/
import java.time.Instant;
import java.util.List;

//import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;

/** A DTO representing a user, with his authorities.
 **/

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
//@TypeDef(
//        name = "enum",
//        typeClass = PostgreSQLEnumType.class
//)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;

    private String lastname;

    private String email;

    private String authenticationToken;

    private String encryptedPassword;


    private Instant birthday;

    private String country;

    private String province;

    private String city;

    private String address;

    private String zip;

    private String avatarUrl;

    private String uid;


/*    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
    private List<Authentication> authentications;*/

    private Boolean privacyPolicy;

    private Boolean marketingCommunication;

    private Boolean thirdPartyCommunication;

    /*public CrmContact toCrmContact(CrmContactSource crmSource) {
        CrmContactUserDetails userDetails = CrmContactUserDetails.builder()
                .birthDate(birthday)
                .countryCode(country)
                .firstName(firstname)
                .lastName(lastname)
                .emailAddress1(email)
                .build();

        if (privacyPolicy != null) {
            userDetails.setPrivacy(privacyPolicy);
        }

        if (marketingCommunication != null) {
            userDetails.setPrivacyGroup(marketingCommunication);
        }

        if (thirdPartyCommunication != null) {
            userDetails.setPrivacyThird(thirdPartyCommunication);
        }

        return CrmContact.builder()
                .source(crmSource)
                .address1(CrmContactAddress.builder()
                        .addressType(CrmContactAddress.ContactAddressType.FIRST)
                        .addressCity(city)
                        .addressPostalCode(zip)
                        .addressStateOrProvince(province)
                        .build())
                .userDetails(userDetails).build();
    }*/

    /*public static User getUser(CrmContact crmContact) {
        return User.builder().email(crmContact.getUserDetails().getEmailAddress1())
                .authentications(new ArrayList<>())
                .firstname(crmContact.getUserDetails().getFirstName())
                .lastname(crmContact.getUserDetails().getLastName())
                .authenticationToken(UUID.randomUUID().toString())
                .encryptedPassword(UUID.randomUUID().toString())
                .build();
    }*/
}
