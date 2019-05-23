package autobots.platform.api.modules;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ModulesRepository extends PagingAndSortingRepository<Module, Long> {

    Optional<Module> getByUuid(UUID uuid);

    Optional<Module> getByName(String name);


}
