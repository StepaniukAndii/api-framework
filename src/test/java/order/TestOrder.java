package order;

import baseTest.BaseTest;
import builder.User;
import lombok.Builder;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import request.UserRequest;
import pojo.UserResponse;

import java.util.ArrayList;
import java.util.List;

public class TestOrder extends BaseTest {
    private List<Integer> usersId;

    @BeforeMethod
    private void createUser() {
        usersId = new ArrayList<>();
        User user = User.builder().build();
        UserResponse userResponse = UserRequest.createUser(user);
        usersId.add(userResponse.getId());
    }

    @AfterTest
    private void deleteUser() {
        usersId.forEach(UserRequest::deleteUser);
    }

    @Test
    public void checkCreateOrder() {
        User user = User.builder().build();

        UserResponse userResponse = UserRequest.createUser(user);

        assertUser(user, userResponse);
    }

    @Test
    public void checkDeleteUser() {
        UserRequest.deleteUser(usersId.get(0));
    }

    public void assertUser(User user, UserResponse userResponse) {
        Assert.assertEquals(user.getContent(), userResponse.getContent());
        Assert.assertEquals(user.getName(), userResponse.getName());
        Assert.assertFalse(userResponse.getId().toString().isEmpty());
    }
}
