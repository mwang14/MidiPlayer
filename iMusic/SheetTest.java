package cs3500.music.iMusic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kathy on 11/14/2015.
 */
public class SheetTest {
  Note c1 = new Note(0, 1, 0, 5, 1, 100);
  Note c2 = new Note(0, 2, 5, 6, 4, 100);
  Note cs3 = new Note(1, 7, 2, 10, 1, 100);
  Note d1 = new Note(2, 4, 5, 10, 2, 100);
  Note b1 = new Note(11, 8, 8, 9, 1, 100);
  Note as1 = new Note(10, 1, 0, 5, 1, 100);
  Note sameC1 = new Note(0, 1, 0, 5, 1, 100);
  Note example2C1 = new Note(0, 1, 0, 5, 2, 100);
  Note example3C1 = new Note(0, 1, 1, 5, 1, 100);

  Sheet s1 = new Sheet();


  //Tests for changeNote
  @Test
  public void testChangeNote1() {
    s1.addNote(0, 1, 0, 5, 1, 100);
    Note n = new Note(0, 1, 0, 5, 1, 100);
    assertTrue(s1.notesStartPlayingAtRow(0).get(0).equals(n));
    s1.changeNote(0, 1, 0, 5, 1, 100, 1, 1, 10, 15, 1, 100);

    assertEquals(s1.notesPlayingAtRowAsString(10), "Note: C#1, starting beat at: 10, ending " +
            "beat at: 15, played using instrument number: 1 STARTS playing");

  }

  @Test
  public void testChangeNote2() {
    s1.addNote(3, 1, 1, 5, 1, 100);
    s1.changeNote(3, 1, 1, 5, 1, 100, 2, 1, 1, 5, 1, 100);
    assertEquals(s1.notesPlayingAtRowAsString(1), "Note: D1, starting beat at: 1, " +
            "ending beat at: 5, played using instrument number: 1 STARTS playing");
    s1.changeNote(2, 1, 1, 5, 1, 100, 3, 1, 1, 5, 1, 100);
    assertEquals(s1.notesPlayingAtRowAsString(1), "Note: D#1, starting beat at: 1, " +
            "ending beat at: 5, played using instrument number: 1 STARTS playing");
  }


  // Tests changeNoteExceptions
  @Test(expected = IllegalArgumentException.class)
  public void testChangeIllegalNote() {
    s1.addNote(0, 1, 0, 5, 1, 100);
    s1.changeNote(3, 1, 1, 5, 1, 100, 2, 1, 1, 5, 1, 100);
  }


  // Tests removeNote
  @Test
  public void testRemoveNote1() {
    s1.addNote(0, 1, 0, 5, 1, 100);
    s1.addNote(2, 2, 0, 4, 1, 100);

    assertEquals(s1.notesPlayingAtRowAsString(0), "Note: D2, starting beat at: 0, " +
            "ending beat at: 4, played using instrument number: 1 STARTS playing, " +
            "Note: C1, starting beat at: 0, ending beat at: 5, played using " +
            "instrument number: 1 STARTS playing");

    s1.removeNote(2, 2, 0, 4, 1, 100);
    assertEquals(s1.notesPlayingAtRowAsString(0), "Note: C1, starting beat at: 0, " +
            "ending beat at: 5, played using instrument number: 1 STARTS playing");

  }


  // Tests getLowestOctave
  @Test
  public void testGetLowestOctave1() {
    s1.addNote(0, 2, 5, 50, 1, 100);
    s1.addNote(0, 7, 5, 5, 2, 100);
    assertEquals(s1.getLowestOctave(), 2);
  }

  @Test
  public void testGetLowestOctave2() {
    s1.addNote(0, 2, 5, 50, 1, 100);
    s1.addNote(5, 7, 5, 5, 2, 100);
    assertEquals(s1.getLowestOctave(), 2);
    s1.addNote(0, 1, 10, 12, 1, 100);
    assertEquals(s1.getLowestOctave(), 1);
  }

  @Test
  public void testGetLowestOctave3() {
    s1.addNote(0, 2, 5, 50, 1, 100);
    s1.addNote(5, 7, 5, 5, 2, 100);
    assertEquals(s1.getLowestOctave(), 2);
    s1.changeNote(0, 2, 5, 50, 1, 100, 0, 0, 10, 12, 1, 100);
    assertEquals(s1.getLowestOctave(), 0);
  }

  @Test
  public void testGetLowestOctave4() {
    s1.addNote(0, 2, 5, 50, 1, 100);
    s1.addNote(5, 7, 5, 5, 2, 100);
    assertEquals(s1.getLowestOctave(), 2);
    s1.removeNote(0, 2, 5, 50, 1, 100);
    assertEquals(s1.getLowestOctave(), 7);
  }

  // Test testGetLowestOctaveExceptions
/*  @Test(expected = IllegalArgumentException.class)
  public void testIllegalLowestOctave() {
    s1.getLowestOctave();
  }
*/
  // Tests getHighestOctave
  @Test
  public void testGetHighestOctave1() {
    s1.addNote(0, 2, 5, 50, 1, 100);
    s1.addNote(0, 7, 5, 5, 2, 100);
    assertEquals(s1.getHighestOctave(), 7);
  }

  @Test
  public void testGetHighestOctave2() {
    s1.addNote(0, 2, 5, 50, 1, 100);
    s1.addNote(5, 7, 5, 5, 2, 100);
    assertEquals(s1.getHighestOctave(), 7);
    s1.addNote(0, 8, 10, 12, 1, 100);
    assertEquals(s1.getHighestOctave(), 8);
  }

  @Test
  public void testGetHighestOctave3() {
    s1.addNote(0, 2, 5, 50, 1, 100);
    s1.addNote(5, 7, 5, 5, 2, 100);
    assertEquals(s1.getHighestOctave(), 7);
    s1.changeNote(0, 2, 5, 50, 1, 100, 0, 8, 10, 12, 1, 100);
    assertEquals(s1.getHighestOctave(), 8);
  }

  @Test
  public void testGetHighestOctave4() {
    s1.addNote(0, 2, 5, 50, 1, 100);
    s1.addNote(5, 7, 5, 5, 2, 100);
    assertEquals(s1.getHighestOctave(), 7);
    s1.removeNote(5, 7, 5, 5, 2, 100);
    assertEquals(s1.getHighestOctave(), 2);
  }


}