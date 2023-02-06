package order;

import builder.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import request.OrderRequest;
import pojo.UserResponse;

public class TestOrder {

    @Test
    public void checkCreateOrder() {
        User user = User.builder().build();

        UserResponse userResponse = OrderRequest.createUser(user);

        assertUser(user, userResponse);
    }

    public void assertUser(User user, UserResponse userResponse) {
        Assert.assertEquals(user.getContent(), userResponse.getContent());
        Assert.assertEquals(user.getName(), userResponse.getName());
        Assert.assertFalse(userResponse.getId().isEmpty());
    }
}
