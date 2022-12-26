package guru.qa;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonTest {
    ObjectMapper mapper = new ObjectMapper();
    ClassLoader cl = JsonTest.class.getClassLoader();

    @Test
    void jsonParseTest() throws Exception{
        try(InputStream rsr = cl.getResourceAsStream("file_json.json");
        InputStreamReader zis = new InputStreamReader(rsr)){
            Person person = mapper.readValue(zis, Person.class);

            assertThat(person.getName()).isEqualTo("Alexs");
            assertThat(person.getAge()).isEqualTo(36);
            assertThat(person.getSkills().get(0)).isEqualTo("Java");
            assertThat(person.getSkills().get(1)).isEqualTo("Git");
            assertThat(person.getSkills().get(2)).isEqualTo("Jenkins");



        }
    }


}
