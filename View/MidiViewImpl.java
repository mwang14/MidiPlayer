package cs3500.music.View;
//package cs3500.music.view;


import cs3500.music.iMusic.Sheet;
import cs3500.music.iMusic.ANote;
import cs3500.music.iMusic.iMusic;

import javax.sound.midi.*;

/**
 * A skeleton for MIDI playback
 */

public class MidiViewImpl implements View {
  private Synthesizer synth;
  private Receiver receiver;
  private iMusic sheet;

  public MidiViewImpl(iMusic sheet) {
    try {
      this.synth = MidiSystem.getSynthesizer();
      this.receiver = synth.getReceiver();
      this.synth.open();
      this.sheet = sheet;
    } catch (MidiUnavailableException e) {
      e.printStackTrace();
    }
  }

  // Convenience contructor that allows to choose between mock receiver and the actual receiver
  public MidiViewImpl(Sheet sheet, Synthesizer synth) {
    try {
      this.synth = MidiSystem.getSynthesizer();
      this.receiver = synth.getReceiver();
      this.sheet = sheet;
      this.synth.open();
    } catch (MidiUnavailableException e) {
      e.printStackTrace();
    }
  }
  /**
   * Relevant classes and methods from the javax.sound.midi library:
   * <ul>
   *  <li>{@link MidiSystem#getSynthesizer()}</li>
   *  <li>{@link Synthesizer}
   *    <ul>
   *      <li>{@link Synthesizer#open()}</li>
   *      <li>{@link Synthesizer#getReceiver()}</li>
   *      <li>{@link Synthesizer#getChannels()}</li>
   *    </ul>
   *  </li>
   *  <li>{@link Receiver}
   *    <ul>
   *      <li>{@link Receiver#send(MidiMessage, long)}</li>
   *      <li>{@link Receiver#close()}</li>
   *    </ul>
   *  </li>
   *  <li>{@link MidiMessage}</li>
   *  <li>{@link ShortMessage}</li>
   *  <li>{@link MidiChannel}
   *    <ul>
   *      <li>{@link MidiChannel#getProgram()}</li>
   *      <li>{@link MidiChannel#programChange(int)}</li>
   *    </ul>
   *  </li>
   * </ul>
   * @see <a href="https://en.wikipedia.org/wiki/General_MIDI">
   *   https://en.wikipedia.org/wiki/General_MIDI
   *   </a>
   */

  /**
   * Lets us enjoy music
   */
  public void render() throws InvalidMidiDataException, InterruptedException {
    ShortMessage start = new ShortMessage();
    ShortMessage end = new ShortMessage();
    for (int i = 0; i <= sheet.songDuration(); i++) {
      for (ANote n : sheet.notesStartPlayingAtRow(i)) {
        start.setMessage(ShortMessage.NOTE_ON, n.getInstrument(), n.totalNotePitch(),
                n.getVolume());
        end.setMessage(ShortMessage.NOTE_OFF, n.getInstrument(), n.totalNotePitch(),
                n.getVolume());
        receiver.send(start, -1);
        receiver.send(end, synth.getMicrosecondPosition() + n.getEndTime() * sheet.getTempo());
      }
      Thread.sleep(sheet.getTempo() / 1000);
    }
    this.receiver.close(); // Only call this once you're done playing *all* notes
  }

  @Override
  public String toString() {
    return this.receiver.toString();
  }
}


