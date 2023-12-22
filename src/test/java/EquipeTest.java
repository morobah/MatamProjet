import com.MatamprojectTest.Model.Equipe;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Equipe.class)
public class EquipeTest {

    @Test
    public void testEquipeProperties() {

        Equipe equipe = new Equipe();
        equipe.setNomEquipe("Nice FC");
        equipe.setAcronyme("NFC");
        equipe.setBudget(1000000.0);
        assertEquals("Nice FC", equipe.getNomEquipe());
        assertEquals("NFC", equipe.getAcronyme());
        assertEquals(1000000.0, equipe.getBudget(), 0.001);
    }
}
