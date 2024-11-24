package utils;


import javax.validation.constraints.NotNull;

public class ShipmentStr {

        @NotNull
        private String country;
        @NotNull
        private String city;
        @NotNull
        private String address;
        @NotNull
        private String zipCode;

        private String street;
}

