package engine;

public class ApiBase {


    public static final String BASE_URL = getSelectedEnv();
    public static long expectedResponseTime = 800;

    public enum StatusCode {
        SUCCESS(200), CREATED(201), ACCEPTED(202), NO_CONTENT(204), BAD_REQUEST(400), UNAUTHORIZED(401), FORBIDDEN(403), NOT_FOUND(404), METHOD_NOT_ALLOWED(405), NOT_ACCEPTABLE(406), CONFLICT(409), INTERNAL_SERVER_ERROR(500), NOT_IMPLEMENTED(501), BAD_GATEWAY(502), SERVICE_UNAVAILABLE(503), GATEWAY_TIMEOUT(504);
        private final int code;

        StatusCode(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

    public enum Status {
        SUCCESS("Done"), PASS("Success"), FAIL("Fail");
        private final String status;

        Status(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }
    }

    public enum Message {
        SUCCESS(""), UPDATED(""), DELETED(""), ERROR("");
        private final String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    private static String getSelectedEnv() {
        String env = System.getProperty("env");
        return switch (env) {
            case "qa" -> System.getProperty("qaApiUrl");
            case "dev" -> System.getProperty("devApiUrl");
            case "prod" -> System.getProperty("prodApiUrl");
            default -> throw new IllegalArgumentException("Invalid environment: [ " + env + " ]");
        };
    }
}
