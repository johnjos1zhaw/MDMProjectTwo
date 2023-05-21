# MDMProjectTwo

Java-Webanwendung zur Verwendung des Modells "distilbert-base-cased-distilled-squad"
Diese Java-Webanwendung verwendet das Modell "distilbert-base-cased-distilled-squad" für Frage-Antwort-Aufgaben. Das Modell kann über den folgenden Link bezogen werden: [distilbert-base-cased-distilled-squad](https://huggingface.co/distilbert-base-cased-distilled-squad). Das Modell wurde auf dem Datensatz "SQuAD" trainiert, der unter folgendem Link verfügbar ist: [SQuAD](https://huggingface.co/datasets/squad).

## Abhängigkeiten
Die Abhängigkeiten der Anwendung werden in der pom.xml-Datei verwaltet. Bitte stellen Sie sicher, dass Sie alle erforderlichen Abhängigkeiten heruntergeladen haben, bevor Sie die Anwendung ausführen.

## Voraussetzungen
Um die Anwendung auszuführen, werden die Dateien tace_caed_distilbertqa.pt und distilbert_vocab.txt benötigt. Stellen Sie sicher, dass Sie diese Dateien bereitgestellt haben, bevor Sie die Anwendung starten. Alternativ können Sie auch das Dockerfile verwenden, um die Anwendung in einem Docker-Container auszuführen.

## Verwendung
Stellen Sie sicher, dass alle erforderlichen Abhängigkeiten heruntergeladen wurden.
Überprüfen Sie, ob die Dateien tace_caed_distilbertqa.pt und distilbert_vocab.txt vorhanden sind.
Führen Sie die Anwendung aus, indem Sie den entsprechenden Befehl in Ihrer Entwicklungsumgebung oder auf der Kommandozeile ausführen.
Die Anwendung wird auf einem lokalen Server gestartet. Öffnen Sie Ihren bevorzugten Webbrowser und navigieren Sie zur angegebenen Adresse.
Auf der Benutzeroberfläche können Sie eine Frage eingeben und die Anwendung wird versuchen, eine Antwort basierend auf dem Modell zu generieren.

## Verwendung mit Docker
Sie können die Anwendung auch mithilfe von Docker ausführen. Befolgen Sie dazu die folgenden Schritte:
Link zum Docker Repository mit den verschiedenen Tags: https://hub.docker.com/r/johnjos1/qa-distilbert-mdmtwo/tags

Stellen Sie sicher, dass Docker auf Ihrem System installiert ist.
Öffnen Sie eine Befehlszeilenschnittstelle und navigieren Sie zum Verzeichnis, das das Dockerfile enthält.
Erstellen Sie das Docker-Image, indem Sie den folgenden Befehl ausführen:
Copy code
docker build -t johnjos1/qa-distilbert-mdmtwo:0.0.3 . (bsp)
Ersetzen Sie "johnjos1/qa-distilbert-mdmtwo:0.0.3 ." durch den gewünschten Namen für das Docker-Image.
Sobald das Docker-Image erstellt wurde, können Sie den Docker-Container starten, indem Sie den folgenden Befehl ausführen:
arduino
Copy code
docker run -p 8080:8080 johnjos1/qa-distilbert-mdmtwo:0.0.3 (bsp)
Ersetzen Sie "johnjos1/qa-distilbert-mdmtwo:0.0.3" durch den Namen des Docker-Images, den Sie zuvor festgelegt haben.
Die Anwendung wird in einem Docker-Container gestartet. Öffnen Sie Ihren bevorzugten Webbrowser und navigieren Sie zur Adresse http://localhost:8080, um die Anwendung zu verwenden.##

## Benutzeroberfläche
Die Benutzeroberfläche wurde mit HTML, JavaScript und CSS erstellt. Sie ermöglicht es dem Benutzer, eine Frage einzugeben und die Antwort des Modells anzuzeigen. Die Oberfläche ist einfach und benutzerfreundlich gestaltet, um eine reibungslose Interaktion zu gewährleisten.
