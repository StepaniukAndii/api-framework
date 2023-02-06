package request;

import builder.User;
import pojo.UserResponse;

public class OrderRequest extends BaseRequest {

    private static final String END_POINT = "/api/items";

    public static UserResponse createUser(User user) {
        return post(END_POINT, user).as(UserResponse.class);
    }
}
