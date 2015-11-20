package cs3500.music;

import cs3500.music.Util.MusicReader;
import cs3500.music.View.ConcreteGuiViewPanel;
import cs3500.music.View.MidiViewImpl;
import cs3500.music.View.SynthesizerMock;
import cs3500.music.iMusic.Sheet;
import cs3500.music.View.toConsole;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;

public class MusicEditor {

  public static void main(String[] args) throws IOException, InvalidMidiDataException,
          InterruptedException {

    try {
      FileReader reader = new FileReader(args[0]);
      Sheet s = MusicReader.parseFile(reader, new Sheet.Builder());
      SynthesizerMock sMock = new SynthesizerMock();
      ConcreteGuiViewPanel view = new ConcreteGuiViewPanel(s);
      MidiViewImpl midiView = new MidiViewImpl(s);
      MidiViewImpl midiview2 = new MidiViewImpl(s, sMock);
      toConsole myToConsole = new toConsole(s);

      //Factory that outputs the view based on the string taken in
      switch (args[1]) {
        case "midi":
          midiView.render();
          // midiview2.render();
          //System.out.println(midiview2.toString());
          break;
        case "console":
          myToConsole.toConsole(System.out);
          break;
        case "graphic":
          view.render();
      }
    } catch (FileNotFoundException e) {
      throw new FileNotFoundException();
    }


    // You probably need to connect these views to your model, too...
  }
}