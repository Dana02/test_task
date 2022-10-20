package data;

public enum Endpoint {
    USER_BY_ID("/users/{user_id}");

    private final String endpoint;

    Endpoint(final String endpoint) {
        this.endpoint = endpoint;
    }

    public String getValue() {
        return endpoint;
    }
}
