//import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import static spark.Spark.*;

public class AlunoController {

    public static void main(String[] args) {
        port(8081);
        AlunoService as = new AlunoService();
        ObjectMapper mapper = new ObjectMapper();

        get("/", (req, res) -> "Bem-vindo à aplicação Spark!");

        // Endpoint para retornar todos os alunos:
        get("/alunos", (request, response) -> {
            List<Aluno> alunos = as.getAlunos();
            String json = mapper.writeValueAsString(alunos);
            response.type("application/json");
            response.status(200);
            return json;
        });

        // Endpoint para retornar um aluno específico
        get("/alunos/:id", ((request, response) -> {
            String idParam = request.params(":id");
            int id = Integer.parseInt(idParam);
            Aluno aluno = as.getAluno(id);
            if (aluno == null) {
                response.status(404);
                return "Aluno não encontrado";

            }

            List<Aluno> alunos = as.getAlunos();
            String json = mapper.writeValueAsString(alunos);
            response.type("application/json");
            response.status(200);
            return json;
        }));

        // Endpoint para incluir um novo aluno
        post("/alunos", (request, response) -> {

            //String json =request.body();
            Aluno aluno = mapper.readValue(request.body(), Aluno.class);
            as.addAluno(aluno);
            response.status(201);
            return "Aluno adicionado com sucesso";
        });


        // Endpoint para alterar um aluno específico
        put("/alunos/:id", (request, response) -> {
            String idParam = request.params(":id");
            int id = Integer.parseInt(idParam);
            Aluno aluno = as.getAluno(id);

            Aluno novoAluno = mapper.readValue(request.body(), Aluno.class);
            as.editAluno(aluno, novoAluno);
            response.status(201);
            return "Aluno alterado com sucesso";


        });

        // Endpoint para excluir um aluno específico:
        delete("/alunos/:id", (request, response) -> {
            String idParam = request.params(":id");
            int id = Integer.parseInt(idParam);
            Aluno aluno = as.getAluno(id);
            if (aluno == null) {
                response.status(404);
                return "Erro: aluno não encontrado";

            }
            as.deleteAluno(id);
            return "Aluno deletado com sucesso";
        });

    }
}





