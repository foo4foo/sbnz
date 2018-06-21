package services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.JsonNode;
import io.ebean.Ebean;
import models.Role;
import models.User;
import org.mindrot.jbcrypt.BCrypt;
import play.libs.Json;

import java.io.UnsupportedEncodingException;

public class UserService {

    private Algorithm algorithm = Algorithm.HMAC256("secret");

    public UserService() throws UnsupportedEncodingException {
    }

    public String signIn(JsonNode jsonNode) {
        User user = findByEmail(jsonNode.findPath("email").textValue());

        if (user == null)
            return null;

        if (BCrypt.checkpw(jsonNode.findPath("password").textValue(), user.getPassword())) {

            String token = JWT.create()
                    .withClaim("username", user.getUsername())
                    .withClaim("email", user.getEmail())
                    .sign(this.algorithm);

            return token;
        }

        return null;
    }

    public boolean signUp(JsonNode jsonNode) {
        try {
            User user = Json.fromJson(jsonNode, User.class);

            user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10)));
            user.setRole(Role.Doctor);

            user.insert();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    private User findByEmail(String email) {
        return Ebean.find(User.class).where().eq("email", email).findOne();
    }

    private User findByUsername(String username) {
        return Ebean.find(User.class).where().eq("username", username).findOne();
    }
}
