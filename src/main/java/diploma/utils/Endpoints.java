package diploma.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Endpoints {

    public static final String BASE_URL = "http://localhost";
    public static final String PAY = "/api/v1/pay";
    public static final String CREDIT = "/api/v1/credit";

}
