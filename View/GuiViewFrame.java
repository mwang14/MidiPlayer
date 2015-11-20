package cs3500.music.View;

import java.awt.*;

import javax.swing.*;

import cs3500.music.iMusic.Sheet;

/**
 * A skeleton Frame (i.e., a window) in Swing
 */
public class GuiViewFrame extends javax.swing.JFrame implements View {
  private Sheet sheet;
  private final JPanel displayPanel; // You may want to refine this to a subtype of JPanel


  /**
   * Creates new GuiView
   */


  public GuiViewFrame() {
    Sheet sheet = new Sheet();
    this.displayPanel = new ConcreteGuiViewPanel(sheet);
    this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    this.getContentPane().add(displayPanel);
    this.pack();
  }

  // renders the view
  public void render() {
  }

  //ensures that it is visible
  public void initialize() {
    this.setVisible(true);
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(2000, 1000);
  }


}
