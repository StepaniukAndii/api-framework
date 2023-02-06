package request;

import builder.User;
import pojo.UserResponse;

public class UserRequest extends BaseRequest {

    private static final String END_POINT = "/api/items";

    public static UserResponse createUser(User user) {
        return post(END_POINT, user).as(UserResponse.class);
    }

    public static UserResponse deleteUser(int id) {
        return delete(END_POINT, id).as(UserResponse.class);
    }
}
