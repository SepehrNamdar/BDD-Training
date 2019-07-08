package model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

// TODO : This class is to ensure that your environment is testable.
// TODO : Remove this class if you can run your tests successfully
public class ApplicationShould {

    @Test
    public void doSomething() {
        // Given
        Application app = new Application();
        // When
        boolean isDoing = app.doSomething();
        // Then
        assertTrue(isDoing);
    }
}
