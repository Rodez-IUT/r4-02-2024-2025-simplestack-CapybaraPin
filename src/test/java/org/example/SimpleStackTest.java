package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test behaviour of a SimpleStack")
class SimpleStackTest {

    @Test
    @DisplayName("Test the state of a newly created slack")
    public void testCreateEmptyStack() { // Test case

        // When a freshly stack is created
        Stack stack = new SimpleStack();

        // Then… (oracle)
        assertTrue(stack.isEmpty(), "A new stack must be empty");
        assertEquals( 0, stack.getSize(), "A new stack has no element");
    }

    @Test
    @DisplayName("Test push operation on an empty stack")
    public void testPushOnEmptyStack() throws EmptyStackException {

        // Given an empty stack and an item
        Stack stack = new SimpleStack();
        Item item = new SimpleItem();

        // When the item is pushed onto the empty stack
        stack.push(item);

        // Then the stack should not be empty, size should be 1 and the top should be the pushed item
        assertFalse(stack.isEmpty(), "The stack should not be empty after pushing an item");
        assertEquals(1, stack.getSize(), "The stack should contain exactly 1 item after push");
        assertSame(item, stack.peek(), "The pushed item should be on top of the stack");

        // Now push a second item
        Item item2 = new SimpleItem();
        stack.push(item2);

        // Then
        assertFalse(stack.isEmpty(), "The stack should not be empty after second push");
        assertEquals(2, stack.getSize(), "The stack should contain exactly 2 items after second push");
        assertSame(item2, stack.peek(), "The last pushed item should be on top of the stack");
    }

    @Test
    @DisplayName("Test push operation on a non-empty stack")
    public void testPushOnStack() throws EmptyStackException {

    }

    @Test
    @DisplayName("Test limit when trying to pop an empty stack")
    public void testPopOnEmptyStack()  {
        // Given an empty stack
        Stack stack = new SimpleStack();

        // When we "pop" the stack, should throws an EmptyStackException.
        assertThrows(EmptyStackException.class, ()->stack.pop(), "EmptyStackException not thrown");
        assertThrows(EmptyStackException.class, stack::pop, "EmptyStackException not thrown");
    }

    @Test
    @DisplayName("Test the pop of items")
    public void testPopStack() throws EmptyStackException {
        // Given a stack with 2 items
        Stack stack = new SimpleStack();
        Item item = new SimpleItem();
        stack.push(item);

        // When we pop the stack
        assertSame(item, stack.pop(), "The popped item must be the last pushed item");

        // Then...
        assertTrue(stack.isEmpty(), "The stack must be empty");
    }

    @Test
    @DisplayName("Test the size of stack")
    public void testSizeStack() {
        // Given an empty stack
        Stack stack = new SimpleStack();

        // When we add 3 items
        stack.push(new SimpleItem());
        stack.push(new SimpleItem());
        stack.push(new SimpleItem());

        // Then the stack must contain 3 items
        assertEquals(3, stack.getSize(), "The stack must contain 3 items");
    }
}
