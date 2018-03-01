package crud.backend;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Property_aRepository extends JpaRepository<Property_a, Long> {

	List<Property_a> findByPName(String pName);
}
