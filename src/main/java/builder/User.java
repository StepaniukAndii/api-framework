package builder;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    @Builder.Default
    private String name = String.valueOf(System.currentTimeMillis());
    @Builder.Default
    private String content = String.valueOf(System.currentTimeMillis());
}
