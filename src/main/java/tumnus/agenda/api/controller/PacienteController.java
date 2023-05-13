/*A camada controller é responsável por receber as requisições do cliente, mapeá-las para
métodos e/ou serviços apropriados, gerar as respostas HTTP e enviar as informações de volta
para o cliente. Em outras palavras, ela controla o fluxo de informações entre o cliente e o servidor.*/
package tumnus.agenda.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tumnus.agenda.domain.entity.Paciente;
import tumnus.agenda.domain.service.PacienteService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
/*A anotação @RestController é usada no Spring para marcar uma classe como controlador REST, ou seja,
uma classe que manipula as solicitações HTTP enviadas pelo cliente e retorna respostas em
formato JSON ou XML. Ela combina as anotações @Controller e @ResponseBody em uma única anotação,
simplificando a criação de APIs REST no Spring.
A anotação @RequestMapping é usada no Spring para mapear solicitações HTTP a métodos de controlador
específicos com base em sua URI, método HTTP e outros atributos de solicitação. Ela é usada para
definir o caminho da URL e outros parâmetros de solicitação, como método HTTP, tipo de conteúdo
e outros detalhes necessários para manipular a solicitação HTTP.*/
@RestController
@RequestMapping("/paciente")
/*A anotação @RequestMapping("/paciente") acima indica que quando o caminho localhost:8080/paciente
for buscado ele será retornado para essa controller*/
public class PacienteController {

    private final PacienteService service;

    /*A anotação @PostMapping é usada em um método de um controlador Spring para mapear uma solicitação HTTP POST
    para um determinado endpoint. Isso significa que o método com a anotação @PostMapping será executado sempre que
    uma solicitação POST for feita para o endpoint especificado. Ele pode ser usado em conjunto com a anotação
    @RequestMapping para especificar o endpoint completo e outras opções, como o tipo de mídia que o endpoint aceita.*/
    @PostMapping
    /*ResponseEntity é uma classe do Spring que representa toda a resposta HTTP enviada de volta ao cliente em uma
    solicitação. Ele encapsula o corpo da resposta, os cabeçalhos HTTP e o status de resposta. É frequentemente usado
    em controladores do Spring para retornar respostas personalizadas com diferentes status e cabeçalhos HTTP.
    O ResponseEntity é responsável por encapsular a resposta HTTP que será enviada ao cliente (navegador ou outro
    aplicativo que esteja consumindo a API). No caso, o ResponseEntity<Paciente> significa que a resposta incluirá
    um objeto Paciente no corpo da mensagem. Isso indica que o método está retornando o Paciente após salvá-lo no banco
    de dados ou em outra fonte de armazenamento. O ResponseEntity permite controlar outros aspectos da resposta HTTP,
    como o código de status e os cabeçalhos da mensagem.
    O requestbody realiza uma requisição que no caso é um objeto paciente, o método salvar recebe esse objeto e
    retorna uma resposta HTTP com o status e o corpo da resposta encapsulados em um objeto responseentity<Paciente>.
    O @RequestBody é responsável por receber um objeto no formato JSON enviado em uma requisição HTTP e transformá-lo
    em um objeto Java do tipo Paciente para que possa ser usado pelo método salvar. Em seguida, o ResponseEntity é
    utilizado para encapsular a resposta HTTP que será enviada de volta ao cliente, incluindo o status da resposta
    e o corpo da resposta, que é novamente um objeto do tipo Paciente.*/
    public ResponseEntity<Paciente> salvar(@RequestBody Paciente paciente) {
        /*A linha de código abaixo chama o método salvar da classe service, passando como parâmetro o objeto paciente.
        O retorno desse método é atribuído à variável pacienteSalvo. Ou seja, o método salvar é responsável por salvar
        o objeto paciente e retornar uma instância atualizada do mesmo. Essa instância atualizada é armazenada na
        variável pacienteSalvo.*/
        Paciente pacienteSalvo = service.salvar(paciente);
        /*HttpStatus é uma enumeração que representa os códigos de status HTTP, usados em respostas de solicitações HTTP.
        Ela fornece valores constantes para representar códigos de status como OK, CREATED, NOT_FOUND, BAD_REQUEST,
        INTERNAL_SERVER_ERROR, entre outros. É comumente usada em conjunto com a classe ResponseEntity para retornar
        uma resposta HTTP com um código de status específico.
        A linha de código ".status(HttpStatus.CREATED)" define o status HTTP da resposta como "CREATED" (código 201)
        que significa que a solicitação foi bem-sucedida e que um novo recurso foi criado. Já ".body(pacienteSalvo)"
        define o corpo da resposta HTTP como o objeto "pacienteSalvo", que foi criado pelo serviço e contém os dados
        do paciente que acabou de ser salvo.*/
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteSalvo);
        /*Resumo do método: Recebe um objeto paciente no corpo da requisição HTTP e chama o método salvar da classe service.
        O paciente salvo é armazenado em uma variável pacienteSalvo. Retorna uma resposta HTTP com status 201 CREATED
        e o corpo da resposta contendo o paciente salvo.*/
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> procurarTodos () {
        List<Paciente> pacientes = service.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(pacientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId (@PathVariable Long id) {
        Optional<Paciente> optPaciente = service.buscarPorId(id);
        if (optPaciente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Paciente paciente = optPaciente.get();
        return ResponseEntity.status(HttpStatus.OK).body(paciente);
    }

}
