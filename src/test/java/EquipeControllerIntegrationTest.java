import com.MatamprojectTest.DTO.EquipeDTO;
import com.MatamprojectTest.Model.Equipe;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest(classes = Equipe.class)
@AutoConfigureMockMvc
public class EquipeControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    EquipeDTO equipeDTO;

    @Test
    public void testAddEquipe() throws Exception {
        EquipeDTO equipeDTO = EquipeDTO.builder()
                .nomEquipe("Nice FC")
                .acronyme("NFC")
                .budget(10000000.0)
                .build();

        String equipeJson = "{ \"nomEquipe\": \"Nice FC\", \"acronyme\": \"NFC\", \"budget\": 10000000.0 }";

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/equipes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(equipeJson))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    }
