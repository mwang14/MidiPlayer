package cs3500.music.iMusic;

public abstract class ANote {
  // Represents a pitch from 0-11 (C, C#, ..., B) respectively.
  protected int pitch;

  // Represents the Octave of the pitch.
  protected int octave;

  // Represents the time (the beat) at which the note starts playing.
  protected int startTime;

  // Represents the beat at which the note stops playing.
  protected int endTime;

  // Represents the instrument that is playing the note.
  protected int instrument;

  //Represents the Volume of the note
  protected int volume;

  /**
   * Represents an abstracted note
   */
  protected ANote(int pitch, int octave, int startTime, int endTime, int instrument, int volume) {
    if (pitch < 0 || pitch > 11) {
      throw new IllegalArgumentException("A number out of the range 0-11 is not a valid pitch!");
    }
    this.pitch = pitch;

    if (octave < -1 || octave > 10) {
      throw new IllegalArgumentException("A note can only be heard in a range of -1 - 10 " +
              "octave!");
    }
    this.octave = octave;

    if (startTime < 0) {
      throw new IllegalArgumentException("A note cannot start playing at a negative beat!");
    }
    this.startTime = startTime;

    if (endTime < startTime) {
      throw new IllegalArgumentException("A note cannot end before it even starts playing!");
    }
    this.endTime = endTime;
    this.instrument = instrument;
    this.volume = volume;
  }

  /**
   * Returns the Note's pitch
   *
   * @return int this note's pitch
   */
  public int getPitch() {
    return this.pitch;
  }

  /**
   * Returns the Note's octave
   *
   * @return int this note's octave
   */
  public int getOctave() {
    return this.octave;
  }

  /**
   * Returns the Note's startTime
   *
   * @return int this note's startTime
   */
  public int getStartTime() {
    return this.startTime;
  }

  /**
   * Returns the Note's endTime
   *
   * @return int this note's endTime
   */
  public int getEndTime() {
    return this.endTime;
  }

  /**
   * Returns the Note's instrument
   *
   * @return int this note's instrument
   */
  public int getInstrument() {
    return this.instrument;
  }

  public int getVolume() {
    return this.volume;
  }

  /**
   * Returns the name of the given integer pitch (from 0-11) as a String (ex. C or C#). (Note that
   * C# = D flat and hence only sharp naming convention will be used to represent the pitch).
   *
   * @return a string with the pitch in letter form.
   */

  private String pitchToStringNote() {
    if (this.pitch == 0) {
      return "C";
    } else if (this.pitch == 1) {
      return "C#";
    } else if (this.pitch == 2) {
      return "D";
    } else if (this.pitch == 3) {
      return "D#";
    } else if (this.pitch == 4) {
      return "E";
    } else if (this.pitch == 5) {
      return "F";
    } else if (this.pitch == 6) {
      return "F#";
    } else if (this.pitch == 7) {
      return "G";
    } else if (this.pitch == 8) {
      return "G#";
    } else if (this.pitch == 9) {
      return "A";
    } else if (this.pitch == 10) {
      return "A#";
    } else {
      return "B";
    }
  }

  public int totalNotePitch() {
    return this.pitch + ((1 + this.octave) * 12);
  }


  /**
   * Returns the name of the note (ex. C3) as a String (Note that C# = D flat and hence only sharp
   * naming convention will be used to represent the pitch).
   *
   * @return a string with the pitch (in letter form) and octave of the note.
   */

  protected String noteNameToString() {
    return this.pitchToStringNote() + Integer.toString(this.octave);
  }

  /**
   * Returns this node in String format with specifics of the note.
   *
   * @return string containing details of this note.
   */
  public String noteToString() {
    return "Note: " + this.noteNameToString() + ", starting beat at: " + Integer.toString(this
            .startTime) + ", ending beat at: " + Integer.toString(this
            .endTime) + ", played using instrument number: " + Integer.toString(this.instrument);
  }

  public Note createNote(int notePitch, int octave, int start, int end, int instrument, int
          volume) {
    return new Note(notePitch, octave, start, end, instrument, volume);
  }
}