package co.edu.icesi.JCStore.api;

import co.edu.icesi.JCStore.dto.LoginDTO;
import co.edu.icesi.JCStore.dto.TokenDTO;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public interface LoginAPI {
    @PostMapping
    TokenDTO login(@RequestBody LoginDTO loginDTO);
}
