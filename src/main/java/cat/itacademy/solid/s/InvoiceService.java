package cat.itacademy.solid.s;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.awt.SystemColor.text;

public class InvoiceService {

    private final TextFormatter formatter = new TextFormatter();

    public void saveToFile(Invoice invoice, Path destination) {

        String content = formatter.toText(invoice);

        try {
            Files.writeString(destination, content);
        } catch (IOException exception) {
            throw new UncheckedIOException(
                    "Could not save invoice: " + invoice.number(),
                    exception
            );
        }
    }

}
