package cs3500.music.View;

import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;

public interface View {
  void render() throws InvalidMidiDataException, InterruptedException, IOException;

}