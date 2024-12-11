import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        DocumentManager manager = new DocumentManager();

        // Створення автора
        DocumentManager.Author author = DocumentManager.Author.builder()
                .id("1")
                .name("John Doe")
                .build();

        // Створення документа
        DocumentManager.Document document = DocumentManager.Document.builder()
                .title("First Document")
                .content("This is a test document.")
                .author(author)
                .build();

        // Збереження документа
        manager.save(document);

        // Пошук документа
        List<DocumentManager.Document> results = manager.search(
                DocumentManager.SearchRequest.builder()
                        .titlePrefixes(Collections.singletonList("First"))
                        .build()
        );

        System.out.println("Found documents: " + results);

        // Пошук за ID
        Optional<DocumentManager.Document> foundById = manager.findById(document.getId());
        foundById.ifPresent(doc -> System.out.println("Document found by ID: " + doc));
    }

}
