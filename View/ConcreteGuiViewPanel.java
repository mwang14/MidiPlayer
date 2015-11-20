package cs3500.music.View;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.*;

import cs3500.music.iMusic.ANote;
import cs3500.music.iMusic.Sheet;
import cs3500.music.iMusic.iMusic;

/**
 * Draws the sheet of music to a separate panel
 */
public class ConcreteGuiViewPanel extends JPanel implements View {
  private iMusic sheet;

  /**
   * Creates the Graphic View
   */
  public ConcreteGuiViewPanel(iMusic sheet) {
    this.sheet = sheet;
  }

  /**
   * Renders the sheet of music
   */
  public void render() {
    ConcreteGuiViewPanel a = new ConcreteGuiViewPanel(sheet);
    GuiViewFrame g = new GuiViewFrame();
    //JPanel panel = new JPanel();
    //panel.add(a);
    JScrollPane scrollPane = new JScrollPane(a);
    JFrame jp1 = new JFrame();
    //jp1.getContentPane().add(scrollPane, BorderLayout.CENTER);
    //jp1.getContentPane().add(panel, BorderLayout.CENTER);
    jp1.getContentPane().add(scrollPane);
    //jp1.getContentPane().add(a, BorderLayout.CENTER);
    //jp1.setSize(g.getPreferredSize());
    jp1.setVisible(true);
    jp1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    int height = this.getPreferredSize().height;

    //prints out the numbers on the top
    for (int i = 0; i <= (sheet.songDuration() / 4); i++) {
      g.drawString(Integer.toString(4 * i), 100 * (i + 1), 30);
    }
    int highestOctave = sheet.getHighestOctave();
    // Prints out the Notes on the left side
    for (int j = 1; j <= sheet.noteRange() + 1; j++) {
      int printNote = (sheet.highestNote().getPitch() + (sheet.getHighestOctave() * 12) - j + 1)
              % 12;
      g.drawString(sheet.pitchToString(printNote) + Integer.toString(highestOctave),
              70, (40 * j) + 20);
      if (printNote == 0) {
        highestOctave = highestOctave - 1;
      }
    }

    // Prints out all the rectangles
    for (int i = 1; i <= sheet.noteRange() + 1; i++) {
      for (int j = 1; j <= (sheet.songDuration() / 4) + 1; j++) {
        g.drawRect(100 * j, 40 * i, 100, 40);
      }
    }
    //fills the rectangles with the starting spots
    for (Map.Entry<Integer, ArrayList<ANote>> entry : sheet.getNotes().entrySet()) {
      int key = entry.getKey();
      ArrayList<ANote> notes = entry.getValue();
      for (int i = 0; i < notes.size(); i++) {
        g.fillRect(100 + (25 * key), height - (notes.get(i).totalNotePitch() + 1 - sheet
                .lowestNote().totalNotePitch()) * 40, 25, 40);
      }
    }

    //prints out all the note duration(the green ones)
    for (int i = 0; i <= sheet.songDuration(); i++) {
      ArrayList<ANote> noteshere = sheet.notesPlayingAtRow(i);
      g.setColor(Color.green);
      for (int j = 0; j < noteshere.size(); j++) {
        //.out.println(height);
        if (!sheet.notesStartPlayingAtRow(i).contains(noteshere.get(j))) {
          g.fillRect(100 + (25 * i), height - (noteshere.get(j).totalNotePitch() + 1 - sheet
                  .lowestNote().totalNotePitch()) * 40, 25, 40);
        }
      }
    }

  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(((sheet.songDuration() / 4) + 1) * 100, (sheet.noteRange() + 1) * 40);
  }

}