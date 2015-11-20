package cs3500.music.iMusic;

import java.util.ArrayList;
import java.util.TreeMap;

public interface iMusic {

  /**
   * Adds a note to the song piece.
   *
   * @throws IllegalArgumentException if trying to add an already existing note
   */
  void addNote(int newPitch, int newOctave, int newStartTime, int newEndTime, int
          newInstrument, int newVolume);

  /**
   * Changes an existing note's values by replacing them with a new note values.
   *
   * @throws IllegalArgumentException if note to be changed is not in the sheet.
   */
  void changeNote(int pitchFrom, int octaveFrom, int startTimeFrom, int endTimeFrom, int
          instrumentFrom, int volumeFrom, int pitchTo, int octaveTo, int startTimeTo,
                  int endTimeTo,
                  int instrumentTo, int volumeTo);

  /**
   * Removes a note from the sheet music to be played.
   *
   * @throws IllegalArgumentException if note you want to remove is not in the sheet.
   */
  void removeNote(int pitchR, int octaveR, int startTimeR, int endTimeR, int instrumentR, int
          volumeR);

  /**
   * Returns the duration of the song in beats.
   *
   * @return An integer representing length of the song.
   */
  int songDuration();

  /**
   * Returns the Notes being played in the row (time beat) as a string.
   *
   * @return A string describing the nodes that are being played at the given row (beat).
   */
  String notesPlayingAtRowAsString(int rowNumber);

  /**
   * Returns the lowest octave that is played in this sheet of music.
   *
   * @return an integer that is the lowest octave played in this piece.
   */
  int getLowestOctave();

  /**
   * Returns a String that represents the note (with details) with the lowest key in this sheet
   * music (or piece).
   *
   * @return a String that represents the note played at the lowest key
   */
  String lowestNoteString();

  /**
   * Returns the highest octave that is played in this sheet of music.
   *
   * @return an integer that is the highest octave played in this piece.
   */
  int getHighestOctave();

  /**
   * Returns a String that represents the note (with details) with the highest key in this sheet
   * music (or piece).
   *
   * @return a String that represents the note played at the highest key
   */

  String highestNoteString();

  /**
   * Returns an ArrayList of Strings that represents the range of all the notes
   * in the sheet music
   * (song) to be used to represent the sheet.
   *
   * @return an ArrayList of Strings of the range of all possible notes in the song in blank.
   */
  ArrayList<String> notesFromLowestToHighest();

  /**
   * Returns the range of all notes in a piece
   *
   * @return Integer representing the range of all notes in a piece
   */
  int noteRange();

  /**
   * returns an abstracted list of Notes in the piece the starting at the Row
   *
   * @return an ArrayList of ANotes
   */
  ArrayList<ANote> notesStartPlayingAtRow(int time);

  /**
   * returns the notes currently playing at the row
   *
   * @return an ArrayList of ANotes
   */
  ArrayList<ANote> notesPlayingAtRow(int time);

  /**
   * gets the tempo
   *
   * @return an Integer representing the tempo
   */
  int getTempo();

  /**
   * returns the Treemap of notes
   *
   * @return a Treemap where each Integer represents the beat
   */
  TreeMap<Integer, ArrayList<ANote>> getNotes();


  /**
   * Takes in a beat/row, and prints out all the notes playing at that beat as a String
   *
   * @return String
   */
  String rowToString(int rowNumber);

  /**
   * Takes a String s, andn pads it to numPad digits
   *
   * @return a padded String
   */
  String pad(String s, int numPad);

  /**
   * returns the lowest ANote in the piece
   *
   * @return ANote which is the lowest
   */
  ANote lowestNote();

  /**
   * returns the highest ANote in the piece
   *
   * @return ANote which is the highest
   */
  ANote highestNote();

  /**
   * Takes in an int n which represents a pitch, and returns it as a String
   *
   * @return String of pitch which represents n
   */
  String pitchToString(int n);

  /**
   * sets the music's tempo to the newTempo
   */
  void setTempo(int newTempo);

  /**
   * sets the Notes of a piece of music to notes
   */
  void setNotes(TreeMap<Integer, ArrayList<ANote>> notes);


}