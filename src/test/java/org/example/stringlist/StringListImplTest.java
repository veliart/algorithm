package org.example.stringlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringListImplTest {
    private final StringListImpl stringList = new StringListImpl();
    @Test
    public void correctAddItemInStorage() {
        //given
        String expectedItem = "Test add item";
        //when
        String actualItem = stringList.add("Test add item");
        //then
        Assertions.assertEquals(expectedItem, actualItem);
    }
}
