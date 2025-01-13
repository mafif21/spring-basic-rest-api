package muhammadafif.restapi.controller;

import muhammadafif.restapi.model.dto.LoginUserRequest;
import muhammadafif.restapi.model.dto.LoginUserResponse;
import muhammadafif.restapi.model.dto.WebResponse;
import muhammadafif.restapi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping(path = "/api/auth/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<LoginUserResponse> login(@RequestBody LoginUserRequest request) {
        LoginUserResponse loginResponse = authService.login(request);
        return WebResponse.<LoginUserResponse>builder().data(loginResponse).build();
    }
}
