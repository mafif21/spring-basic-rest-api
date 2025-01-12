package muhammadafif.restapi.controller;

import muhammadafif.restapi.model.dto.RegisterUserRequest;
import muhammadafif.restapi.model.dto.WebResponse;
import muhammadafif.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/api/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<String> Register(@RequestBody RegisterUserRequest request){
     userService.Register(request);
     return WebResponse.<String>builder().data("OK").build();
    }
}
