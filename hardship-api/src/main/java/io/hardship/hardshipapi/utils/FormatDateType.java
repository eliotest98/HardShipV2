package io.hardship.hardshipapi.utils;
public enum FormatDateType {
    DDMMYYYY_SLASH("dd/MM/yyyy"),
    DDMMYYY_SCORE("dd-MM-yyyy");

    private final String text;

    /**
     * @param text
     */
    FormatDateType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}