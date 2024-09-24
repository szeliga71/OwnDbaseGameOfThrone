package pl.wp.owndbasegameofthrone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wp.owndbasegameofthrone.model.CharacterGoT;

public interface CharacterRepository extends JpaRepository<CharacterGoT, Long> {
}
