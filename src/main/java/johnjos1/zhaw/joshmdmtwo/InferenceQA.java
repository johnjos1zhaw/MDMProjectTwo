package johnjos1.zhaw.joshmdmtwo;

import ai.djl.ModelException;
import ai.djl.inference.Predictor;
import ai.djl.modality.nlp.qa.QAInput;
import ai.djl.repository.zoo.Criteria;
import ai.djl.repository.zoo.ZooModel;
import ai.djl.training.util.ProgressBar;
import ai.djl.translate.DeferredTranslatorFactory;
import ai.djl.translate.TranslateException;
import ai.djl.Application;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;


public class InferenceQA {
    public static void main(String[] args) throws IOException, TranslateException, ModelException {
        try (Scanner scanner = new Scanner(System.in)) {
            // Get paragraph from user
            System.out.print("Enter a paragraph: ");
            String paragraph = scanner.nextLine();
            // Get question from user
            System.out.print("Enter a question: ");
            String question = scanner.nextLine();
            
            QAInput input = new QAInput(question, paragraph);
            String answer = InferenceQA.qa_predict(input);
            
            System.out.println("The answer is: " + answer);
        }
    }

    public static String qa_predict(QAInput input) throws IOException, TranslateException, ModelException {
        DistilBertTranslator translator = new DistilBertTranslator();
        Criteria<QAInput, String> criteria = Criteria.builder()
                .setTypes(QAInput.class, String.class)
                .optModelPath(Paths.get("trace_cased_disitlbertqa.pt"))
                .optTranslator(translator)
                .optProgress(new ProgressBar()).build();
                
        ZooModel<QAInput, String> model = criteria.loadModel();
        try (Predictor<QAInput, String> predictor = model.newPredictor(translator)) {
            return predictor.predict(input);
        }
    }
}