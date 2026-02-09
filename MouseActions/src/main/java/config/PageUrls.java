package config;

public enum PageUrls {
    BUTTON("https://demoqa.com/buttons"),
    DROPPABLE("https://demoqa.com/droppable"),
    TEXTBOX("https://demoqa.com/text-box");

    private final String url;

    PageUrls(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}