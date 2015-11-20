package cs3500.music.iMusic;

import java.util.Objects;

final class Note extends ANote {


  Note(int pitch, int octave, int startTime, int endTime, int instrument, int volume) {

    super(pitch, octave, startTime, endTime, instrument, volume);
    if (pitch < 0 || pitch > 11) {
      throw new IllegalArgumentException("A number out of the range 0-11 is not a valid pitch!");
    }

    if (octave < -1 || octave > 10) {
      throw new IllegalArgumentException("A note can only be in a range of -1 - 10 " +
              "octave!");
    }

    if (startTime < 0) {
      throw new IllegalArgumentException("A note cannot start playing at a negative beat!");
    }

    if (endTime < startTime) {
      throw new IllegalArgumentException("A note cannot end before it even starts playing!");
    }

  }


  /**
   * Overwrites .equals to compare whether this note is equal to that object.
   *
   * @return boolean whether this is equal to object o.
   */
  @Override
  public boolean equals(Object o) {
    if (o instanceof Note) {
      return this.pitch == ((Note) o).pitch && this.octave == ((Note) o).octave &&
              this.startTime == ((Note) o).startTime && this.endTime == ((Note) o).endTime &&
              this.instrument == ((Note) o).instrument;
    } else {
      return false;
    }
  }

  // Overwrites original hashCode so new .equals can function as redefined.
  @Override
  public int hashCode() {
    return Objects.hash(pitch, octave, startTime, endTime, instrument);
  }


}