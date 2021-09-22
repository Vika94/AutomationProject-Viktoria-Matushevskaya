package pageObject.herokuapp;

public enum HomePageEnum {
    CONTEXT_MENU("Context Menu"),
    DYNAMIC_CONTROLS("Dynamic Controls");

    String link;

    HomePageEnum(String link) {
        this.link = link;
    }

    public String getLinkText() {
        return link;
    }
}
