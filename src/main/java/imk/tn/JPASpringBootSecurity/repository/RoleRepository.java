package imk.tn.JPASpringBootSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import imk.tn.JPASpringBootSecurity.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByAuthority(String authority);

}