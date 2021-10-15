package pattern.builder;

public class LoginBuilderHerokuapp {
    private String userName = "tomsmith";
    private String password = "SuperSecretPassword!";
    private String verifyText = "You logged into a secure area!\n" + "×";

    public String getVerifyText() {
        return verifyText;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public static class Builder{
        private LoginBuilderHerokuapp loginBuilder;

        public Builder() {
            loginBuilder = new LoginBuilderHerokuapp();
        }

        public Builder withUserName(String userName){
            loginBuilder.userName = userName;
            return this;
        }

        public Builder withPassword(String password){
            loginBuilder.password = password;
            return this;
        }

        public Builder withVerifyText(String verifyText){
            loginBuilder.verifyText = verifyText;
            return this;
        }

        public LoginBuilderHerokuapp build(){
            return loginBuilder;
        }
    }
}
