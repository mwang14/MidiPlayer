package cs3500.music.View;

import org.junit.Test;

import cs3500.music.iMusic.Sheet;


public class ReceiverMockTest {
  Sheet s1 = new Sheet.Builder().addNote(0, 5, 1, 60, 100)
          .addNote(5, 7, 1, 64, 100)
          .addNote(7, 10, 8, 70, 100)
          .addNote(3, 4, 4, 50, 100).build();

  Sheet s2 = new Sheet.Builder().build();
  SynthesizerMock sMock = new SynthesizerMock();
  MidiViewImpl implementation = new MidiViewImpl(s1, sMock);
  MidiViewImpl implementation2 = new MidiViewImpl(s2, sMock);


  @Test
  public void test1() throws Exception {
    implementation.render();
    System.out.println(implementation.toString());
  }

  @Test
  public void test2() throws Exception {
    implementation.render();
    System.out.println(implementation2.toString());
  }
}