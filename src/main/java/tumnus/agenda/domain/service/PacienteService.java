/*A camada service é responsável pela implementação da lógica de negócios da aplicação.
Ela coordena as ações entre as camadas de apresentação e persistência, validando dados,
aplicando regras de negócio e orquestrando as operações.*/
package tumnus.agenda.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tumnus.agenda.domain.entity.Paciente;
import tumnus.agenda.domain.repository.PacienteRepository;

import java.util.List;
import java.util.Optional;

/*@Service é uma anotação do Spring Framework que indica que uma classe é um componente
de serviço, ou seja, uma classe que fornece algum tipo de funcionalidade de negócio para
outras classes em um aplicativo. Essa anotação permite que a classe seja facilmente gerenciada
pelo contêiner de injeção de dependência (IoC) do Spring, tornando-a disponível para outras classes
que dependem dela. Além disso, ela ajuda a separar as preocupações de negócio do restante da aplicação,
seguindo o princípio de responsabilidade única, pois indica que uma classe é responsável por fornecer
um serviço específico, como por exemplo, realizar cálculos, validar dados ou interagir com um sistema
externo. Dessa forma, as classes de serviço contêm a lógica de negócios do aplicativo, enquanto outras
classes, como controladores e repositórios, lidam com outras preocupações, como lidar com as requisições
HTTP ou interagir com o banco de dados. Isso ajuda a manter a aplicação organizada, modular e fácil de manter.*/

/*@Transactional é uma anotação do Spring Framework usada para marcar um método ou classe como transacional.
Isso significa que as operações de persistência de dados executadas dentro do escopo transacional são tratadas
como uma única transação de banco de dados, que pode ser confirmada ou revertida em caso de falhas. Essa
anotação ajuda a garantir a integridade dos dados e a consistência do banco de dados, mantendo as operações
de banco de dados atômicas e consistentes.*/
@Service
@Transactional
@RequiredArgsConstructor
public class PacienteService {

    /*@Autowired é uma anotação do Spring Framework usada para injetar dependências automaticamente
    em um componente gerenciado pelo Spring. Isso significa que, em vez de criar manualmente as
    instâncias de classes dependentes e configurar as dependências, o Spring cuida da resolução
    e injeção das dependências em tempo de execução, tornando o código mais simples e fácil de
    manter. A anotação @Autowired pode ser usada em construtores, métodos ou propriedades de classe.*/
    private final PacienteRepository repository;

    /*A instanciação acima "private final PacienteRepository repository;" permite que os métodos da interface
    PacienteRepository sejam chamados aqui nessa classe. A anotação "@RequiredArgsConstructor" elimina a necessidade
    da anotação "@Autowired" sob o objeto acima. Pois a injeção de dependência é feita pelo construtor*/
    public Paciente salvar (Paciente paciente) {
        return repository.save(paciente);
    }

    /*O código abaixo é um método que retorna uma lista de todos os objetos Paciente armazenados em um
    repositório, usando o método findAll() da classe JpaRepository. É uma operação básica de leitura de
    dados, que pode ser usada para obter uma lista de objetos Paciente do banco de dados.*/
    public List<Paciente> listarTodos() {
        return repository.findAll();
    }

    /*O código abaixo é um método que retorna um objeto Paciente específico com base no seu ID,
    usando o método findById() da classe JpaRepository. Ele retorna um Optional<Paciente>, que é uma
    classe do Java que representa um valor opcional e pode ser nulo. Isso significa que, se o objeto
    Paciente com o ID fornecido não existir no banco de dados, o método retorna um Optional vazio,
    evitando assim possíveis erros de NullPointer. O método precisa dos argumentos Long e id para identificar
    o objeto Paciente desejado no banco de dados, já que o ID é um campo único e pode ser usado como chave
    primária para recuperar o registro correto.*/
    public Optional<Paciente> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }





}
