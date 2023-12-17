package ma.ehtp.projet_geoinfo.repository;

import ma.ehtp.projet_geoinfo.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role getRoleById(Long id);

}
