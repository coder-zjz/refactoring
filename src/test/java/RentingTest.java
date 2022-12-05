import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ResourceBundle;

import static org.assertj.core.api.Assertions.assertThat;

public class RentingTest {

    @Test
    void should_generate_statement_correctly() throws IOException {

        Customer customer = new Customer("Toms");
        Movie romanHoliday = new Movie("罗马假日", Movie.REGULAR);
        customer.addRental(new Rental(romanHoliday, 5));

        Movie hero = new Movie("英雄", Movie.NEW_RELEASE);
        customer.addRental(new Rental(hero, 6));

        Movie iceAge = new Movie("冰河世纪", Movie.CHILDRENS);
        customer.addRental(new Rental(iceAge, 7));

        String file = new File(getClass().getClassLoader().getResource("expected").getFile()).getPath();
        String content = Files.readString(Path.of(file));
        assertThat(customer.statement()).isEqualTo(content);
    }
}
