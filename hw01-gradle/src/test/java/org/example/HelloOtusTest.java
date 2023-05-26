package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloOtusTest {

    @Test
    void main() {
        IOStreamServiceSpies ioStreamServiceSpies = new IOStreamServiceSpies();
        ioStreamServiceSpies.writeDown("Hello Otus");
        assertEquals("Hello Otus", ioStreamServiceSpies.getResultOfChecking());
    }
}