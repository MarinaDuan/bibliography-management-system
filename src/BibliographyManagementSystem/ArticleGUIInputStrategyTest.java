package BibliographyManagementSystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticleGUIInputStrategyTest {
ArticleGUIInputStrategy articleGUIInputStrategy=new ArticleGUIInputStrategy();
    @Test
    void validEmptyDoi() {
        assertEquals(articleGUIInputStrategy.ValidDoi(""),false);
    }

    @Test
    void validDoiPrefix() {
        assertEquals(articleGUIInputStrategy.ValidDoi("https://"),false);
    }

    @Test
    void validDoiWithOnePart() {
        assertEquals(articleGUIInputStrategy.ValidDoi("https://doi.org/"),false);
    }

    @Test
    void validDoiWith1Part() {
        assertEquals(articleGUIInputStrategy.ValidDoi("https://doi.org/10."),false);
    }
    @Test
    void validDoiWith2Part() {
        assertEquals(articleGUIInputStrategy.ValidDoi("https://doi.org/10.100"),false);
    }

    @Test
    void validDoiWithoutFinalPart() {
        assertEquals(articleGUIInputStrategy.ValidDoi("https://doi.org/10.1007/"),false);
    }

    @Test
    void validDoiWithFinalPart() {
        assertEquals(articleGUIInputStrategy.ValidDoi("https://doi.org/10.1007"),false);
    }

    @Test
    void validDoiTotal() {
        assertEquals(articleGUIInputStrategy.ValidDoi("https://doi.org/10.1007/3-540-47910-4_21"),true);
    }
}