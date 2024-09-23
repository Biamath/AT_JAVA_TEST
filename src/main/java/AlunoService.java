import java.util.ArrayList;
import java.util.List;


public class AlunoService {
    private List<Aluno> alunos;

    public AlunoService() {
        alunos = new ArrayList<Aluno>();
        alunos.add(new Aluno(1, "João", 8.5));
        alunos.add(new Aluno(2, "Maria", 9.0));
        alunos.add(new Aluno(3, "Pedro", 7.0));
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public Aluno getAluno(int id) {
        for (Aluno aluno : alunos) {
            if (aluno.getId() == id) {
                return aluno;
            }

        }

        return null;
    }

    public void addAluno(Aluno aluno) {
        alunos.add(aluno);

    }

    public void editAluno(Aluno aluno, Aluno novoAluno) {
        aluno.setNome(novoAluno.getNome());
        //aluno.SetNota(novoAluno.getNota());
    }


    // public Aluno getAlunoById(int id) {
    //   return alunos.stream().filter(aluno -> aluno.getId() == id).findFirst().orElse(null);
    //  }

    // public void alterarAluno(int id, Aluno alunoAlterado) {
    //  Aluno aluno = getAlunoById(id);
    //  if (aluno != null) {
    //  aluno.setNome(alunoAlterado.getNome());
    //aluno.setNota(alunoAlterado.getNota());
    //  }
    //  }

    public void deleteAluno(int id) {
        alunos.removeIf(aluno -> aluno.getId() == id);
    }
}




