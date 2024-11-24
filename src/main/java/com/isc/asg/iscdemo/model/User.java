package com.isc.asg.iscdemo.model;

import lombok.Getter;
import lombok.Setter;
import utils.ShipmentStr;
import java.time.Instant;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Setter
@Getter
@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Setter
    @Getter
    private String firstname;
    @NotNull
    @Setter
    @Getter
    private String lastname;

    @Setter
    @Getter
    @NotNull
    @Size(min = 10, max = 10)
    private int accountNo;

    @Setter
    @Getter
    private String shippingAddress;

    @Setter
    @Getter
    private String uid;

    //TODO to be done followingly if VALIDATION is a priority
    //TODO violations and payload from
    //https://medium.com/@saiteja-erwa/spring-boot-dto-validation-using-groups-and-payload-attributes-e2c139f5b1ef
    @Getter
    @Setter
    @Size(message ="national code must be 10 digits" , min = 10, max = 10)
    private int NationalCode;

    @Setter
    @Getter
    @Size(min = 16, max = 16)
    private int cardNo;

    @Setter
    @Getter
    @NotNull
    private int phoneNo;

    private String authenticationToken;


    public User() {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNo = phoneNo;
        this.authenticationToken = authenticationToken;
        this.shippingAddress = shippingAddress;
        this.uid = uid;
    }

    public User(Long id, String firstname, String lastname, int phoneNo, String authenticationToken, String encryptedPassword, @Valid ShipmentStr shippingAddress) {
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }



    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$firstname = this.getFirstname();
        final Object other$firstname = other.getFirstname();
        if (this$firstname == null ? other$firstname != null : !this$firstname.equals(other$firstname)) return false;
        final Object this$lastname = this.getLastname();
        final Object other$lastname = other.getLastname();
        if (this$lastname == null ? other$lastname != null : !this$lastname.equals(other$lastname)) return false;
        final Object this$email = this.getPhoneNo();
        final Object other$email = other.getPhoneNo();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$authenticationToken = this.getAuthenticationToken();
        final Object other$authenticationToken = other.getAuthenticationToken();
        if (this$authenticationToken == null ? other$authenticationToken != null : !this$authenticationToken.equals(other$authenticationToken))
            return false;
        final Object this$shippingAddress = this.getShippingAddress();
        final Object other$shippingAddress = other.getShippingAddress();
        if (this$shippingAddress == null ? other$shippingAddress != null : !this$shippingAddress.equals(other$shippingAddress))
            return false;

        final Object this$uid = this.getUid();
        final Object other$uid = other.getUid();
        if (this$uid == null ? other$uid != null : !this$uid.equals(other$uid)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $firstname = this.getFirstname();
        result = result * PRIME + ($firstname == null ? 43 : $firstname.hashCode());
        final Object $lastname = this.getLastname();
        result = result * PRIME + ($lastname == null ? 43 : $lastname.hashCode());
        final Object $email = this.getPhoneNo();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $authenticationToken = this.getAuthenticationToken();
        result = result * PRIME + ($authenticationToken == null ? 43 : $authenticationToken.hashCode());
        final Object $shippingAddress = this.getShippingAddress();
        result = result * PRIME + ($shippingAddress == null ? 43 : $shippingAddress.hashCode());

        final Object $uid = this.getUid();
        result = result * PRIME + ($uid == null ? 43 : $uid.hashCode());
        return result;
    }

    public String toString() {
        return "User(id=" + this.getId() + ", firstname=" + this.getFirstname() + ", lastname=" + this.getLastname() + ", phoneNo=" + this.getPhoneNo() + ", authenticationToken=" + this.getAuthenticationToken() + ", shippingAddress=" + this.getShippingAddress() + ", uid=" + this.getUid() + ")";
    }

    public static class UserBuilder {
        private Long id;
        private String firstname;
        private String lastname;
        private int phoneNo;
        private String authenticationToken;
        private String encryptedPassword;
        private @Valid ShipmentStr shippingAddress;
        private String uid;

        UserBuilder() {
        }

        public UserBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public UserBuilder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }


        public UserBuilder authenticationToken(String authenticationToken) {
            this.authenticationToken = authenticationToken;
            return this;
        }

        public UserBuilder encryptedPassword(String encryptedPassword) {
            this.encryptedPassword = encryptedPassword;
            return this;
        }

        public UserBuilder shippingAddress(@Valid ShipmentStr shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }


        public UserBuilder uid(String uid) {
            this.uid = uid;
            return this;
        }


        public User build() {
            return new User(this.id, this.firstname, this.lastname, this.phoneNo, this.authenticationToken, this.encryptedPassword, this.shippingAddress );
        }

        public String toString() {
            return "User.UserBuilder(id=" + this.id + ", firstname=" + this.firstname + ", lastname=" + this.lastname + ", phoneNo=" + this.phoneNo + ", authenticationToken=" + this.authenticationToken + ", encryptedPassword=" + this.encryptedPassword +  ", shippingAddress=" + this.shippingAddress +  ")";
        }
    }

    /*public CrmContact toCrmContact(CrmContactSource crmSource) {
        CrmContactUserDetails userDetails = CrmContactUserDetails.builder()
                .birthDate(birthday)
                .countryCode(country)
                .firstName(firstname)
                .lastName(lastname)
                .emailAddress1(phoneNo)
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
        return User.builder().phoneNo(crmContact.getUserDetails().getEmailAddress1())
                .authentications(new ArrayList<>())
                .firstname(crmContact.getUserDetails().getFirstName())
                .lastname(crmContact.getUserDetails().getLastName())
                .authenticationToken(UUID.randomUUID().toString())
                .encryptedPassword(UUID.randomUUID().toString())
                .build();
    }*/
}
