package cs3500.music.View;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;

/**
 * Creates a mock receiver in order to test MidiView
 */
public class ReceiverMock implements Receiver {
  private StringBuilder stringBuilder;

  public ReceiverMock() {
    this.stringBuilder = new StringBuilder();
  }

  @Override
  public void send(MidiMessage message, long timeStamp) {
    ShortMessage shortM = (ShortMessage) message;
    stringBuilder.append("\n");
    if (shortM.getCommand() == ShortMessage.NOTE_ON) {
      stringBuilder.append("Note Pitch: " + shortM.getData1() + " starts playing at: " +
              timeStamp + " by instrument number: " + shortM.getChannel() + " at volume " +
              shortM.getData2() + ".");
    } else {
      stringBuilder.append("Note Pitch: " + shortM.getData1() + " ends playing at: " +
              timeStamp + " by instrument number: " + shortM.getChannel() + " at volume " +
              shortM.getData2() + ".");
    }
  }

  @Override
  public void close() {
    System.out.println("Close receiver was called!");
  }

  @Override
  public String toString() {
    return stringBuilder.toString();
  }
}