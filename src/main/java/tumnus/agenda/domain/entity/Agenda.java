package tumnus.agenda.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "agenda")
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*@Column é uma anotação JPA usada para mapear um atributo de uma entidade para
    uma coluna em uma tabela do banco de dados relacional.*/
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "data_hora")
    private LocalDateTime horario;
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    /*@ManyToOne é uma anotação JPA usada para indicar que uma entidade tem um
    relacionamento muitos-para-um com outra entidade. Isso significa que várias instâncias
    da classe podem se relacionar com uma única instância da outra classe e que a classe
    referenciada será uma entidade separada, com sua própria tabela no banco de dados.
    A anotação também define a cardinalidade do relacionamento e permite especificar como
    o relacionamento será carregado.*/
    @ManyToOne
    private Paciente paciente;

}
