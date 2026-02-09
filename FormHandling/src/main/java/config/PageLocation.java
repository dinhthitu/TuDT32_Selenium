package config;

public enum PageLocation {
    FORM("https://demoqa.com/forms"),
    PRACTICE_FORM("https://demoqa.com/automation-practice-form");

    private final String url;

    PageLocation(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
