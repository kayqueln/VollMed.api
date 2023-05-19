package med.voll.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalTime;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            select m from Medico m
            where
            m.ativo = 1
            and
            m.especialidade = :especialidade
            and
            m.id not in(
                    select c.medico.id from Consulta c
                    where
                    c.data = :data
                    and
                    c.hora = :hora
                    and
                    c.cancelamento is null
            )
            order by rand()
            limit 1
            """)
    Medico escolherMedicoLivre(Especialidade especialidade, LocalDate data, LocalTime hora);

    @Query("""
            select m.ativo
            from Medico m
            where
            m.id = :IdMedico
            """)
    Boolean findAtivoById(Long IdMedico);
}
