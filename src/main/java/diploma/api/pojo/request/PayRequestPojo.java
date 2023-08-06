package diploma.api.pojo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class PayRequestPojo {

    @JsonProperty("number")
    private String number;

    @JsonProperty("cvc")
    private String cvc;

    @JsonProperty("month")
    private String month;

    @JsonProperty("year")
    private String year;

    @JsonProperty("holder")
    private String holder;

}