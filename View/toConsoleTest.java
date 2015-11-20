package cs3500.music.View;

import org.junit.Test;

import java.io.IOException;

import cs3500.music.iMusic.Sheet;

import static org.junit.Assert.*;

/**
 * Created by Kathy on 11/14/2015.
 */

/**
 * Tests toConsole
 */
public class toConsoleTest {
  Sheet s1 = new Sheet.Builder().addNote(0, 5, 1, 60, 100)
          .addNote(5, 7, 1, 64, 100)
          .addNote(7, 10, 8, 70, 100)
          .addNote(3, 4, 4, 50, 100).build();


  @Test
  public void testToConsole() throws IOException {
    toConsole display = new toConsole(s1);
    StringBuilder builder = new StringBuilder("");
    display.toConsole(builder);
    assertEquals(builder.toString(), "    D3  D#3 E3  F3  F#3 G3  G#3 A3  A#3 B3  C4  C#4 " +
            "D4  D#4 E4  F4  F#4 G4  G#4 A4  A#4 \n" +
            "0                                           X                               " +
            "                                                                             " +
            "                               \n" +
            "1                                           |                                 " +
            "                                                                               " +
            "                           \n" +
            "2                                           |                                   " +
            "                                                                          " +
            "                              \n" +
            "3   X                                       |                           " +
            "                                                            " +
            "                                                    \n" +
            "4                                           |               " +
            "                                                            " +
            "                                                                \n" +
            "5                                                           X  " +
            "                                                                 " +
            "                                                        \n" +
            "6                                                           |    " +
            "                                                                     " +
            "                                                  \n" +
            "7                                                                    " +
            "               X                                                       " +
            "                                            \n" +
            "8                                                                      " +
            "             |                                                           " +
            "                                        \n" +
            "9                                                                       " +
            "            |                                                            " +
            "                                       \n" +
            "10                                                                       " +
            "                                                     " +
            "                                                          \n");
  }
}