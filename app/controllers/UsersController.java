package controllers;

import com.google.inject.Inject;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import services.UserService;

import java.util.Optional;

public class UsersController extends Controller {

    @Inject
    private UserService userService;

    @BodyParser.Of(BodyParser.Json.class)
    public Result signIn() {
        return Optional.ofNullable(userService.signIn(request().body().asJson())).map(token ->
            ok(token)
        ).orElse(unauthorized());
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result signUp() {
        return userService.signUp(request().body().asJson()) ? created() : notAcceptable();
    }
}
