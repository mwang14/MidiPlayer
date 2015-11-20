package cs3500.music.View;

import java.io.IOException;

import cs3500.music.View.View;
import cs3500.music.iMusic.iMusic;

// Sends the rows and columns of the sheet to console to be printed out later.
public class toConsole implements View {
  private final iMusic music;

  public toConsole(iMusic music) {
    this.music = music;
  }

  //Prints out the view on the console
  public void toConsole(Appendable output) throws IOException {
    output.append(music.pad("", 4));
    if (music.getLowestOctave() == music.getHighestOctave()) {
      for (int i = music.lowestNote().getPitch(); i <= music.highestNote().getPitch(); i++) {
        output.append(music.pad((music.pitchToString(i) +
                Integer.toString(music.getLowestOctave()) + " "), 4));
      }
    } else {
      for (int i = music.lowestNote().getPitch(); i < 12; i++) {
        output.append(music.pad((music.pitchToString(i) +
                Integer.toString(music.getLowestOctave()) + " "), 4));
      }
      for (int x = music.getLowestOctave() + 1; x <= music.getHighestOctave() - 1; x++) {
        for (int y = 0; y < 12; y++) {
          output.append(music.pad((music.pitchToString(y) + Integer.toString(x) + " "), 4));
        }
      }
      for (int i = 0; i <= music.highestNote().getPitch(); i++) {
        output.append(music.pad((music.pitchToString(i) +
                Integer.toString(music.getHighestOctave()) + " "), 4));
      }
    }
    output.append("\n");
    for (int i = 0; i <= music.songDuration(); i++) {
      output.append(music.pad(Integer.toString(i), 4));
      output.append(music.rowToString(i) + "\n");
    }
  }

  public void render() throws IOException {
    this.toConsole(System.out);
  }
}