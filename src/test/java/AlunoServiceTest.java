//import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;

public class AlunoServiceTest {
    AlunoService as;

    @BeforeEach
    public void setUp() {
        as = new AlunoService();

    }


    @Test
    public void getAlunoEncontradoTest() {
        int id = 1;

        Aluno aluno = as.getAluno(id);
        Assertions.assertEquals(id, aluno.getId());
    }

    @Test
    public void getAlunoNaoEncontradoTest() {
        int id = 0;
        Aluno aluno = as.getAluno(id);
        Assertions.assertNull(aluno);

    }

    @AfterEach
    public void tearDown() {
        as = null;
    }
}





