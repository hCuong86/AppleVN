package poly.edu.asmjava5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.edu.asmjava5.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
}
