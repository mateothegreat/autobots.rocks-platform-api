package autobots.platform.api.modules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/modules")
public class ModulesController {

    private final ModulesService modulesService;

    @Autowired
    public ModulesController(final ModulesService modulesService) {

        this.modulesService = modulesService;

    }

    @GetMapping
    public ResponseEntity<Page<Module>> getPageable(Pageable pageable) {

        return new ResponseEntity<>(modulesService.getPageable(pageable), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Module> create(@RequestBody Module module, Principal principal) {

        Optional<Module> optionalModule = modulesService.create(module);

        return optionalModule.map(c -> new ResponseEntity<>(c, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.FORBIDDEN));

    }

    @PutMapping
    public ResponseEntity<Module> update(@RequestBody Module module, Principal principal) {

        Optional<Module> optionalModule = modulesService.updateByName(module);

        return optionalModule.map(c -> new ResponseEntity<>(c, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.FORBIDDEN));

    }

}
