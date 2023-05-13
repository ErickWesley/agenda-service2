package tumnus.agenda.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/*@Entity é uma anotação usada em JPA para indicar que uma classe é uma entidade persistente,
enquanto @Table é uma anotação opcional que permite definir o nome da tabela que será mapeada
para a entidade. Enquanto a primeira está diretamente relacionada ao mapeamento objeto-relacional,
a segunda está mais focada na estruturação do banco de dados.*/
@Getter
@Setter
@Entity
@Table(name = "paciente")
public class Paciente {

    /*@Id é uma anotação usada para indicar o atributo da classe que será a chave primária
    da tabela correspondente no banco de dados.
    A chave primária é um campo (ou conjunto de campos) que identifica de forma exclusiva cada
    registro em uma tabela de banco de dados relacional.
    @GeneratedValue com a estratégia GenerationType.IDENTITY é uma anotação usada em JPA para indicar
    que a chave primária de uma entidade será gerada automaticamente pelo banco de dados ao inserir
    um novo registro na tabela, utilizando um esquema de numeração incremental.*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;

}
