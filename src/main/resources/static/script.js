function submitForm() {
    var questions = document.getElementsByName("question");
    var paragraph = document.getElementById("paragraph").value;
    var answerContainer = document.getElementById("answer");

    // Clear the answer container
    answerContainer.innerHTML = "";

    // Loop through each question and make an AJAX request to the server
    for (var i = 0; i < questions.length; i++) {
        var question = questions[i].value;

        // Make an AJAX request to the server
        var xhr = new XMLHttpRequest();
        xhr.open("GET", "/answer?question=" + question + "&paragraph=" + paragraph, true);
        xhr.onreadystatechange = createResponseHandler(xhr, i + 1);
        xhr.send();
    }
}

function resetForm() {
    var questionContainer = document.getElementById("question-container");
    questionContainer.innerHTML = "";

    var paragraph = document.getElementById("paragraph");
    paragraph.value = "";

    var answerContainer = document.getElementById("answer");
    answerContainer.innerHTML = "";

    // Add the title "Questions:"
    var questionLabel = document.createElement("label");
    questionLabel.className = "form-label";
    questionLabel.innerText = "Questions:";

    // Add a new question field
    var newQuestion = document.createElement("input");
    newQuestion.type = "text";
    newQuestion.name = "question";
    newQuestion.className = "form-control mb-3";
    newQuestion.placeholder = "Question 1";

    // Append the title and new question field to the question container
    questionContainer.appendChild(questionLabel);
    questionContainer.appendChild(newQuestion);
}

function createResponseHandler(xhr, index) {
    return function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // Update the answer container with the response
            var response = xhr.responseText;
            var answerContainer = document.getElementById("answer");
            var answerElement = document.createElement("div");
            answerElement.className = "answer-container";
            answerElement.innerHTML = "<h3>A" + index + ": </h3><p>" + response + "</p>";

            // Insert the answer element at the correct index
            var existingAnswers = answerContainer.getElementsByClassName("answer-container");
            if (existingAnswers.length === 0 || index > existingAnswers.length) {
                // If the current index is greater than existing answers, append the new answer
                answerContainer.appendChild(answerElement);
            } else {
                // Insert the new answer at the correct position
                var insertIndex = index - 1;
                answerContainer.insertBefore(answerElement, existingAnswers[insertIndex]);
            }
        }
    };
}

function addQuestion() {
    var questionContainer = document.getElementById("question-container");
    var questionCount = questionContainer.getElementsByClassName("form-control").length;
    // Create a new question input field
    var newQuestion = document.createElement("input");
    newQuestion.type = "text";
    newQuestion.name = "question";
    newQuestion.className = "form-control mb-3";
    newQuestion.placeholder = "Question " + (questionCount + 1);

    // Append the new question input field to the question container
    questionContainer.appendChild(newQuestion);
}
