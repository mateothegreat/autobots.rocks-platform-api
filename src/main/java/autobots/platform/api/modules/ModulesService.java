package autobots.platform.api.modules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ModulesService {

    private final ModulesRepository modulesRepository;

    @Autowired
    public ModulesService(final ModulesRepository modulesRepository) {

        this.modulesRepository = modulesRepository;

    }

    public Page<Module> getPageable(Pageable pageable) {

        return modulesRepository.findAll(pageable);

    }

    public Optional<Module> getByName(String name) {

        return modulesRepository.getByName(name);

    }

    public Optional<Module> create(Module module) {

        module.setUuid(UUID.randomUUID());

        return Optional.of(modulesRepository.save(module));

    }

    public Optional<Module> updateByName(Module module) {

        Optional<Module> optionalModule = getByName(module.getName());

        if (optionalModule.isPresent()) {

            optionalModule.get().setName(module.getName());
            optionalModule.get().setDescription(module.getDescription());

            return Optional.of(modulesRepository.save(module));

        }

        return Optional.empty();

    }

}
