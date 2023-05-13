/*A camada repository é responsável por lidar com a persistência dos dados da aplicação,fornecendo
um conjunto de operações básicas para acessá-los e manipulá-los. Ela abstrai o acesso ao banco de dados
e permite que a lógica de negócios da aplicação trabalhe com objetos de domínio em vez de SQL puro.*/
package tumnus.agenda.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tumnus.agenda.domain.entity.Paciente;


/*@Repository é uma anotação do Spring Framework que marca uma classe como um componente
gerenciado pelo contêiner de injeção de dependência (IoC). Ela indica que a classe é um
repositório, ou seja, que é responsável pelo acesso e manipulação de dados do banco de dados,
e permite que ela seja facilmente injetada em outras classes que dependem dela.*/
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
/*Essa linha de código define uma interface de repositório do Spring Data JPA chamada
"PacienteRepository" que extende a interface "JpaRepository". Essa interface de repositório
será usada para executar operações de CRUD (create, read, update, delete) no banco de dados
relacionado à entidade "Paciente", que é especificada como o primeiro argumento genérico.
O segundo argumento genérico é o tipo de dado da chave primária da entidade "Paciente".*/

}
