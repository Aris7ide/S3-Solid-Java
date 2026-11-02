package cat.itacademy.solid.s;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TextFormatterTest {

    @Test
    void shouldFormatInvoiceCorrectly() {
        Invoice invoice = new Invoice(
                "INV-2026-001",
                "Ada Lovelace",
                List.of(
                        new InvoiceLine("Mechanical keyboard", 2, new BigDecimal("50.00")),
                        new InvoiceLine("Wireless mouse", 1, new BigDecimal("25.00"))
                )
        );

        TextFormatter formatter = new TextFormatter();
        String lineSeparator = System.lineSeparator();

        String result = formatter.toText(invoice);

        String expected = "INVOICE" + lineSeparator +
                "Number: INV-2026-001" + lineSeparator +
                "Customer: Ada Lovelace" + lineSeparator +
                lineSeparator +
                "Mechanical keyboard - 2 x 50.00 = 100.00" + lineSeparator +
                "Wireless mouse - 1 x 25.00 = 25.00" + lineSeparator +
                lineSeparator +
                "TOTAL: 125.00";

        assertThat(result).isEqualTo(expected);
    }

}