package johnjos1.zhaw.joshmdmtwo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ai.djl.modality.nlp.qa.QAInput;

@Controller
@SpringBootApplication
public class JoshmdmtwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JoshmdmtwoApplication.class, args);
    }

    @GetMapping("/")
    public ResponseEntity<Resource> index() throws IOException {
        Resource resource = new ClassPathResource("static/index.html");
        if (resource.exists()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.TEXT_HTML)
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/answer")
    @ResponseBody
    public String getAnswer(@RequestParam("question") String question, @RequestParam("paragraph") String paragraph) {
        try {
            return InferenceQA.qa_predict(new QAInput(question, paragraph));
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred during prediction.";
        }
    }

    @ResponseBody
    @PostMapping("/predict")
    public String postQuestionAnswer(@RequestParam("question") String question, @RequestParam("paragraph") String paragraph) {
        try {
            return InferenceQA.qa_predict(new QAInput(question, paragraph));
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred during prediction.";
        }
    }
}
