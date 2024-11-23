package utils;


import javax.validation.constraints.NotNull;

public class ShipAddress {

        @NotNull
        private String country;
        @NotNull
        private String city;
        @NotNull
        private String strAdd;

        private String street;
        @NotNull
        private String zipCode;
    }

