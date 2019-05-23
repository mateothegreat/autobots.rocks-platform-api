package autobots.platform.api.modules;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "modules")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Range(max = 4294967295L)
    @Column(nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(name = "uuid", updatable = false, nullable = false, unique = true, columnDefinition = "BINARY(16)")
    private UUID uuid;

    @CreationTimestamp
    private LocalDateTime stampCreated;

    private String name;
    private String description;
    private String npmInstallCommand;
    private String githubUrl;

}
