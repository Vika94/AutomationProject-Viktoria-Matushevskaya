package PageFactory.Builder;

public class PersonBuilder {
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getZipCode() {
        return zipCode;
    }

    private String lastName;
    private String zipCode;

    public static class Builder{
        private PersonBuilder personBuilder;

        public Builder() {
             personBuilder = new PersonBuilder();
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

        public PersonBuilder build(){
            return personBuilder;
        }

    }
}
