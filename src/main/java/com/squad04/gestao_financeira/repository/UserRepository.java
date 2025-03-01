package Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository <User, UUID>{
}
