package Pattern.Builder;

public class PersonBuilderSaucedemo {
    private String firstName;
    private String lastName;
    private String zipCode;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getZipCode() {
        return zipCode;
    }


    public static class Builder{
        private PersonBuilderSaucedemo personBuilder;

        public Builder() {
             personBuilder = new PersonBuilderSaucedemo();
        }

        public Builder withFirstName(String firstName){
            personBuilder.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName){
            personBuilder.lastName = lastName;
            return this;
        }

        public Builder withZipCode(String zipCode){
            personBuilder.zipCode = zipCode;
            return this;
        }

        public PersonBuilderSaucedemo build(){
            return personBuilder;
        }

    }
}
