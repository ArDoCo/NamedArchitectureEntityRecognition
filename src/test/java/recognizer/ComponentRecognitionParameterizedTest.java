package recognizer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.langchain4j.model.chat.ChatModel;
import edu.kit.kastel.mcse.ner_for_arch.recognizer.PromptType;
import edu.kit.kastel.mcse.ner_for_arch.util.ChatModelFactory;
import edu.kit.kastel.mcse.ner_for_arch.util.ModelProvider;
import kotlin.Pair;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Stream;

public class ComponentRecognitionParameterizedTest {
    private final Logger logger = LoggerFactory.getLogger(ComponentRecognitionParameterizedTest.class);

    static Stream<TestConfig> loadTestConfig() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS, true);
        InputStream is = ComponentRecognitionParameterizedTest.class.getResourceAsStream("test-config.json");
        List<TestConfig> configList = mapper.readValue(is, new TypeReference<>() {
        });
        return configList.stream();
    }

    @ParameterizedTest
    @MethodSource("loadTestConfig")
    void evaluateComponentRecognition(TestConfig testConfig) {
        logger.info("Evaluation with this configuration: {}", testConfig);

        //create the chat model (VDL is the default)
        ChatModel chatModel = ChatModelFactory.withProvider(testConfig.modelProvider != null ? testConfig.modelProvider : ModelProvider.VDL).modelName(testConfig.model()).temperature(testConfig.modelTemperature()).build();

        //get the test project from the config (jabref is the default)
        TestProject project = testConfig.testProject() != null ? testConfig.testProject() : TestProject.JABREF;

        Pair<String, String> p = testConfig.prompt != null ? new Pair<>(testConfig.prompt.first, testConfig.prompt.second) : null;
        TestProjectEvaluator evaluator = new TestProjectEvaluator(chatModel, p, testConfig.promptType);
        evaluator.evaluate(project);
    }

    public enum TestProject {
        BIGBLUEBUTTON, JABREF, MEDIASTORE, TEAMMATES, TEASTORE, ALL
    }

    //Config holder record matching the JSON structure:
    public record TestConfig(ModelProvider modelProvider, String model, double modelTemperature,
                             TestProject testProject, Prompt prompt, PromptType promptType) {
        // more parameters can be added above (if a param is not set in the config its simply null)
        public record Prompt(String first, String second) { //TODO überall nutzen und woanders hin legen
        }
    }

}
