# Notes (28 November, 2022)

## Previously Discussed

- JFrame
- JMenuBar
- JMenu
- JMenuItem

## Today's Topics

- Menu Driven App
  - JFileChooser..Open..Save..Save As (Dialog Box)
  - JColorChooser (Dialog Box)
  - JOptionPane

## General Notes

- ItemListener doesn't have adapter whereas WindowListener and KeyListener has it.

## Programs

### Program 1a:-

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class EditFrame{
    JFrame frm;
    JTextArea ta;
    JMenuBar mb;
    JMenu filemnu;
    JMenu colormnu;
    JMenuItem savemnuitm,opMenuItem;
    JCheckBoxMenuItem bcmnuitm,fcmnuitm;
    EditFrame(){
        frm=new JFrame("Wordpad");
        frm.setVisible(true);
        frm.setSize(500,500);
        frm.setLayout(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ta=new JTextArea("Enter here...");
        ta.setBounds(0,0,frm.getWidth(),frm.getHeight());
        frm.add(ta);

        mb=new JMenuBar();
        frm.setJMenuBar(mb);
        filemnu=new JMenu("File");
        mb.add(filemnu);

        colormnu=new JMenu("Color");
        mb.add(colormnu);
        savemnuitm=new JMenuItem("Save");
        opMenuItem=new JMenuItem("Open");
        filemnu.add(savemnuitm);
        filemnu.add(opMenuItem);

        bcmnuitm=new JCheckBoxMenuItem("Background");
        fcmnuitm=new JCheckBoxMenuItem("Foreground");
        colormnu.add(bcmnuitm);
        colormnu.add(fcmnuitm);
        bcmnuitm.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                Color c=JColorChooser.showDialog(frm,"Select a color",Color.white);
                ta.setBackground(c);
                frm.getContentPane().repaint();
            }
        });
        //fcmnuitm.addItemListener(new );

    }

    public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() { //nameless object
                    public void run(){
                        new EditFrame();
                    }
            });
    }
}
```

- Output:-

[1.webm](https://user-images.githubusercontent.com/26346867/204316060-3baa84ca-754a-4dc4-ae18-e8e3c01998a0.webm)

<center><video width="100%" height= "auto" controls>
  <source src="https://user-images.githubusercontent.com/26346867/204316060-3baa84ca-754a-4dc4-ae18-e8e3c01998a0.webm" type="video/webm">
  Your browser does not support the video tag.
</video></center>

### Program 1b:-

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class EditFrame{
    JFrame frm;
    JTextArea ta;
    JMenuBar mb;
    JMenu filemnu;
    JMenu colormnu;
    JMenuItem savemnuitm,openmnuitm;
    JCheckBoxMenuItem bcmnuitm,fcmnuitm;
    EditFrame(){
        frm=new JFrame("Wordpad");
        frm.setVisible(true);
        frm.setSize(500,500);
        frm.setLayout(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ta=new JTextArea("Enter here...");
        ta.setBounds(0,0,frm.getWidth(),frm.getHeight());
        frm.add(ta);

        mb=new JMenuBar();
        frm.setJMenuBar(mb);
        filemnu=new JMenu("File");
        mb.add(filemnu);

        colormnu=new JMenu("Color");
        mb.add(colormnu);
        savemnuitm=new JMenuItem("Save",KeyEvent.VK_0);
        savemnuitm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        openmnuitm=new JMenuItem("Open",KeyEvent.VK_0);
        openmnuitm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        filemnu.add(savemnuitm);
        filemnu.add(openmnuitm);

        openmnuitm.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                JFileChooser jc=new JFileChooser();
                int opt=jc.showOpenDialog(frm);
                if(opt==JFileChooser.APPROVE_OPTION){ //APPROVE_OPTION -> static data member
                try{
                    File f=jc.getSelectedFile(); //getSelected file -> non-static function
                    FileInputStream fin=new FileInputStream(f);
                    byte d[]=new byte[(int)f.length()]; //Java doesn't allow long in byte arrays so we use int for explicit type conversion
                    ta.setText(new String(d)); //byte array to String conversion
                    frm.getContentPane().repaint();
                    fin.close();
                }catch(Exception e){
                    ta.setText("Caught.."+e);
                }
              }
            }
        });

        savemnuitm.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                JFileChooser jc=new JFileChooser();
                int opt=jc.showSaveDialog(frm);
                if(opt==JFileChooser.APPROVE_OPTION){
                    try{
                        File f=jc.getSelectedFile();
                        FileInputStream fin=new FileInputStream(f);
                        byte d[]=new byte[(int)f.length()]; //Java doesn't allow long in byte arrays so we use int for explicit type conversion
                        ta.setText(new String(d)); //byte array to String conversion
                        frm.getContentPane().repaint();
                        fin.close();
                    }catch(Exception e){
                        ta.setText("Caught.."+e);
                    }
                }
            }
        });

        bcmnuitm=new JCheckBoxMenuItem("Background");
        fcmnuitm=new JCheckBoxMenuItem("Foreground");
        colormnu.add(bcmnuitm);
        colormnu.add(fcmnuitm);
        bcmnuitm.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                Color c=JColorChooser.showDialog(frm,"Select a color",Color.white);
                ta.setBackground(c);
                frm.getContentPane().repaint();
            }
        });
        //fcmnuitm.addItemListener(new );

    }

   


    public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() { //nameless object
                    public void run(){
                        new EditFrame();
                    }
            });
    }
}
```

- Output:-

[out.webm](https://user-images.githubusercontent.com/26346867/204316194-b2c99c9b-4c1b-4baa-bc79-38c50df6ff26.webm)

<center><video width="100%" height= "auto" controls>
  <source src="https://user-images.githubusercontent.com/26346867/204316194-b2c99c9b-4c1b-4baa-bc79-38c50df6ff26.webm" type="video/webm">
  Your browser does not support the video tag.
</video></center>

- To try: Clipboard using JClipboard class

## References

### JColorChooser class (*disassembeled*)

```bash
$ javap javax.swing.JColorChooser
Compiled from "JColorChooser.java"
public class javax.swing.JColorChooser extends javax.swing.JComponent implements javax.accessibility.Accessible {
  public static final java.lang.String SELECTION_MODEL_PROPERTY;
  public static final java.lang.String PREVIEW_PANEL_PROPERTY;
  public static final java.lang.String CHOOSER_PANELS_PROPERTY;
  protected javax.accessibility.AccessibleContext accessibleContext;
  public static java.awt.Color showDialog(java.awt.Component, java.lang.String, java.awt.Color) throws java.awt.HeadlessException;
  public static java.awt.Color showDialog(java.awt.Component, java.lang.String, java.awt.Color, boolean) throws java.awt.HeadlessException;
  public static javax.swing.JDialog createDialog(java.awt.Component, java.lang.String, boolean, javax.swing.JColorChooser, java.awt.event.ActionListener, java.awt.event.ActionListener) throws java.awt.HeadlessException;
  public javax.swing.JColorChooser();
  public javax.swing.JColorChooser(java.awt.Color);
  public javax.swing.JColorChooser(javax.swing.colorchooser.ColorSelectionModel);
  public javax.swing.plaf.ColorChooserUI getUI();
  public void setUI(javax.swing.plaf.ColorChooserUI);
  public void updateUI();
  public java.lang.String getUIClassID();
  public java.awt.Color getColor();
  public void setColor(java.awt.Color);
  public void setColor(int, int, int);
  public void setColor(int);
  public void setDragEnabled(boolean);
  public boolean getDragEnabled();
  public void setPreviewPanel(javax.swing.JComponent);
  public javax.swing.JComponent getPreviewPanel();
  public void addChooserPanel(javax.swing.colorchooser.AbstractColorChooserPanel);
  public javax.swing.colorchooser.AbstractColorChooserPanel removeChooserPanel(javax.swing.colorchooser.AbstractColorChooserPanel);
  public void setChooserPanels(javax.swing.colorchooser.AbstractColorChooserPanel[]);
  public javax.swing.colorchooser.AbstractColorChooserPanel[] getChooserPanels();
  public javax.swing.colorchooser.ColorSelectionModel getSelectionModel();
  public void setSelectionModel(javax.swing.colorchooser.ColorSelectionModel);
  protected java.lang.String paramString();
  public javax.accessibility.AccessibleContext getAccessibleContext();
  public javax.swing.plaf.ComponentUI getUI();
}
```

### KeyEvent class (*disassembeled*)

```bash
$ javap java.awt.event.KeyEvent
Compiled from "KeyEvent.java"
public class java.awt.event.KeyEvent extends java.awt.event.InputEvent {
  public static final int KEY_FIRST;
  public static final int KEY_LAST;
  public static final int KEY_TYPED;
  public static final int KEY_PRESSED;
  public static final int KEY_RELEASED;
  public static final int VK_ENTER;
  public static final int VK_BACK_SPACE;
  public static final int VK_TAB;
  public static final int VK_CANCEL;
  public static final int VK_CLEAR;
  public static final int VK_SHIFT;
  public static final int VK_CONTROL;
  public static final int VK_ALT;
  public static final int VK_PAUSE;
  public static final int VK_CAPS_LOCK;
  public static final int VK_ESCAPE;
  public static final int VK_SPACE;
  public static final int VK_PAGE_UP;
  public static final int VK_PAGE_DOWN;
  public static final int VK_END;
  public static final int VK_HOME;
  public static final int VK_LEFT;
  public static final int VK_UP;
  public static final int VK_RIGHT;
  public static final int VK_DOWN;
  public static final int VK_COMMA;
  public static final int VK_MINUS;
  public static final int VK_PERIOD;
  public static final int VK_SLASH;
  public static final int VK_0;
  public static final int VK_1;
  public static final int VK_2;
  public static final int VK_3;
  public static final int VK_4;
  public static final int VK_5;
  public static final int VK_6;
  public static final int VK_7;
  public static final int VK_8;
  public static final int VK_9;
  public static final int VK_SEMICOLON;
  public static final int VK_EQUALS;
  public static final int VK_A;
  public static final int VK_B;
  public static final int VK_C;
  public static final int VK_D;
  public static final int VK_E;
  public static final int VK_F;
  public static final int VK_G;
  public static final int VK_H;
  public static final int VK_I;
  public static final int VK_J;
  public static final int VK_K;
  public static final int VK_L;
  public static final int VK_M;
  public static final int VK_N;
  public static final int VK_O;
  public static final int VK_P;
  public static final int VK_Q;
  public static final int VK_R;
  public static final int VK_S;
  public static final int VK_T;
  public static final int VK_U;
  public static final int VK_V;
  public static final int VK_W;
  public static final int VK_X;
  public static final int VK_Y;
  public static final int VK_Z;
  public static final int VK_OPEN_BRACKET;
  public static final int VK_BACK_SLASH;
  public static final int VK_CLOSE_BRACKET;
  public static final int VK_NUMPAD0;
  public static final int VK_NUMPAD1;
  public static final int VK_NUMPAD2;
  public static final int VK_NUMPAD3;
  public static final int VK_NUMPAD4;
  public static final int VK_NUMPAD5;
  public static final int VK_NUMPAD6;
  public static final int VK_NUMPAD7;
  public static final int VK_NUMPAD8;
  public static final int VK_NUMPAD9;
  public static final int VK_MULTIPLY;
  public static final int VK_ADD;
  public static final int VK_SEPARATER;
  public static final int VK_SEPARATOR;
  public static final int VK_SUBTRACT;
  public static final int VK_DECIMAL;
  public static final int VK_DIVIDE;
  public static final int VK_DELETE;
  public static final int VK_NUM_LOCK;
  public static final int VK_SCROLL_LOCK;
  public static final int VK_F1;
  public static final int VK_F2;
  public static final int VK_F3;
  public static final int VK_F4;
  public static final int VK_F5;
  public static final int VK_F6;
  public static final int VK_F7;
  public static final int VK_F8;
  public static final int VK_F9;
  public static final int VK_F10;
  public static final int VK_F11;
  public static final int VK_F12;
  public static final int VK_F13;
  public static final int VK_F14;
  public static final int VK_F15;
  public static final int VK_F16;
  public static final int VK_F17;
  public static final int VK_F18;
  public static final int VK_F19;
  public static final int VK_F20;
  public static final int VK_F21;
  public static final int VK_F22;
  public static final int VK_F23;
  public static final int VK_F24;
  public static final int VK_PRINTSCREEN;
  public static final int VK_INSERT;
  public static final int VK_HELP;
  public static final int VK_META;
  public static final int VK_BACK_QUOTE;
  public static final int VK_QUOTE;
  public static final int VK_KP_UP;
  public static final int VK_KP_DOWN;
  public static final int VK_KP_LEFT;
  public static final int VK_KP_RIGHT;
  public static final int VK_DEAD_GRAVE;
  public static final int VK_DEAD_ACUTE;
  public static final int VK_DEAD_CIRCUMFLEX;
  public static final int VK_DEAD_TILDE;
  public static final int VK_DEAD_MACRON;
  public static final int VK_DEAD_BREVE;
  public static final int VK_DEAD_ABOVEDOT;
  public static final int VK_DEAD_DIAERESIS;
  public static final int VK_DEAD_ABOVERING;
  public static final int VK_DEAD_DOUBLEACUTE;
  public static final int VK_DEAD_CARON;
  public static final int VK_DEAD_CEDILLA;
  public static final int VK_DEAD_OGONEK;
  public static final int VK_DEAD_IOTA;
  public static final int VK_DEAD_VOICED_SOUND;
  public static final int VK_DEAD_SEMIVOICED_SOUND;
  public static final int VK_AMPERSAND;
  public static final int VK_ASTERISK;
  public static final int VK_QUOTEDBL;
  public static final int VK_LESS;
  public static final int VK_GREATER;
  public static final int VK_BRACELEFT;
  public static final int VK_BRACERIGHT;
  public static final int VK_AT;
  public static final int VK_COLON;
  public static final int VK_CIRCUMFLEX;
  public static final int VK_DOLLAR;
  public static final int VK_EURO_SIGN;
  public static final int VK_EXCLAMATION_MARK;
  public static final int VK_INVERTED_EXCLAMATION_MARK;
  public static final int VK_LEFT_PARENTHESIS;
  public static final int VK_NUMBER_SIGN;
  public static final int VK_PLUS;
  public static final int VK_RIGHT_PARENTHESIS;
  public static final int VK_UNDERSCORE;
  public static final int VK_WINDOWS;
  public static final int VK_CONTEXT_MENU;
  public static final int VK_FINAL;
  public static final int VK_CONVERT;
  public static final int VK_NONCONVERT;
  public static final int VK_ACCEPT;
  public static final int VK_MODECHANGE;
  public static final int VK_KANA;
  public static final int VK_KANJI;
  public static final int VK_ALPHANUMERIC;
  public static final int VK_KATAKANA;
  public static final int VK_HIRAGANA;
  public static final int VK_FULL_WIDTH;
  public static final int VK_HALF_WIDTH;
  public static final int VK_ROMAN_CHARACTERS;
  public static final int VK_ALL_CANDIDATES;
  public static final int VK_PREVIOUS_CANDIDATE;
  public static final int VK_CODE_INPUT;
  public static final int VK_JAPANESE_KATAKANA;
  public static final int VK_JAPANESE_HIRAGANA;
  public static final int VK_JAPANESE_ROMAN;
  public static final int VK_KANA_LOCK;
  public static final int VK_INPUT_METHOD_ON_OFF;
  public static final int VK_CUT;
  public static final int VK_COPY;
  public static final int VK_PASTE;
  public static final int VK_UNDO;
  public static final int VK_AGAIN;
  public static final int VK_FIND;
  public static final int VK_PROPS;
  public static final int VK_STOP;
  public static final int VK_COMPOSE;
  public static final int VK_ALT_GRAPH;
  public static final int VK_BEGIN;
  public static final int VK_UNDEFINED;
  public static final char CHAR_UNDEFINED;
  public static final int KEY_LOCATION_UNKNOWN;
  public static final int KEY_LOCATION_STANDARD;
  public static final int KEY_LOCATION_LEFT;
  public static final int KEY_LOCATION_RIGHT;
  public static final int KEY_LOCATION_NUMPAD;
  int keyCode;
  char keyChar;
  int keyLocation;
  public java.awt.event.KeyEvent(java.awt.Component, int, long, int, int, char, int);
  public java.awt.event.KeyEvent(java.awt.Component, int, long, int, int, char);
  public java.awt.event.KeyEvent(java.awt.Component, int, long, int, int);
  public int getKeyCode();
  public void setKeyCode(int);
  public char getKeyChar();
  public void setKeyChar(char);
  public void setModifiers(int);
  public int getKeyLocation();
  public static java.lang.String getKeyText(int);
  public static java.lang.String getKeyModifiersText(int);
  public boolean isActionKey();
  public java.lang.String paramString();
  public int getExtendedKeyCode();
  public static int getExtendedKeyCodeForChar(int);
  static {};
}
```

### JMenuItem class (*disassembeled*)

```bash
$ javap javax.swing.JMenuItem
Compiled from "JMenuItem.java"
public class javax.swing.JMenuItem extends javax.swing.AbstractButton implements javax.accessibility.Accessible,javax.swing.MenuElement {
  public javax.swing.JMenuItem();
  public javax.swing.JMenuItem(javax.swing.Icon);
  public javax.swing.JMenuItem(java.lang.String);
  public javax.swing.JMenuItem(javax.swing.Action);
  public javax.swing.JMenuItem(java.lang.String, javax.swing.Icon);
  public javax.swing.JMenuItem(java.lang.String, int);
  public void setModel(javax.swing.ButtonModel);
  void initFocusability();
  protected void init(java.lang.String, javax.swing.Icon);
  public void setUI(javax.swing.plaf.MenuItemUI);
  public void updateUI();
  public java.lang.String getUIClassID();
  public void setArmed(boolean);
  public boolean isArmed();
  public void setEnabled(boolean);
  boolean alwaysOnTop();
  public void setAccelerator(javax.swing.KeyStroke);
  public javax.swing.KeyStroke getAccelerator();
  protected void configurePropertiesFromAction(javax.swing.Action);
  void setIconFromAction(javax.swing.Action);
  void largeIconChanged(javax.swing.Action);
  void smallIconChanged(javax.swing.Action);
  void configureAcceleratorFromAction(javax.swing.Action);
  protected void actionPropertyChanged(javax.swing.Action, java.lang.String);
  public void processMouseEvent(java.awt.event.MouseEvent, javax.swing.MenuElement[], javax.swing.MenuSelectionManager);
  public void processKeyEvent(java.awt.event.KeyEvent, javax.swing.MenuElement[], javax.swing.MenuSelectionManager);
  public void processMenuDragMouseEvent(javax.swing.event.MenuDragMouseEvent);
  public void processMenuKeyEvent(javax.swing.event.MenuKeyEvent);
  protected void fireMenuDragMouseEntered(javax.swing.event.MenuDragMouseEvent);
  protected void fireMenuDragMouseExited(javax.swing.event.MenuDragMouseEvent);
  protected void fireMenuDragMouseDragged(javax.swing.event.MenuDragMouseEvent);
  protected void fireMenuDragMouseReleased(javax.swing.event.MenuDragMouseEvent);
  protected void fireMenuKeyPressed(javax.swing.event.MenuKeyEvent);
  protected void fireMenuKeyReleased(javax.swing.event.MenuKeyEvent);
  protected void fireMenuKeyTyped(javax.swing.event.MenuKeyEvent);
  public void menuSelectionChanged(boolean);
  public javax.swing.MenuElement[] getSubElements();
  public java.awt.Component getComponent();
  public void addMenuDragMouseListener(javax.swing.event.MenuDragMouseListener);
  public void removeMenuDragMouseListener(javax.swing.event.MenuDragMouseListener);
  public javax.swing.event.MenuDragMouseListener[] getMenuDragMouseListeners();
  public void addMenuKeyListener(javax.swing.event.MenuKeyListener);
  public void removeMenuKeyListener(javax.swing.event.MenuKeyListener);
  public javax.swing.event.MenuKeyListener[] getMenuKeyListeners();
  protected java.lang.String paramString();
  public javax.accessibility.AccessibleContext getAccessibleContext();
}
```

### JFileChooser class (*disassembeled*)

```bash
$ javap javax.swing.JFileChooser
Compiled from "JFileChooser.java"
public class javax.swing.JFileChooser extends javax.swing.JComponent implements javax.accessibility.Accessible {
  public static final int OPEN_DIALOG;
  public static final int SAVE_DIALOG;
  public static final int CUSTOM_DIALOG;
  public static final int CANCEL_OPTION;
  public static final int APPROVE_OPTION;
  public static final int ERROR_OPTION;
  public static final int FILES_ONLY;
  public static final int DIRECTORIES_ONLY;
  public static final int FILES_AND_DIRECTORIES;
  public static final java.lang.String CANCEL_SELECTION;
  public static final java.lang.String APPROVE_SELECTION;
  public static final java.lang.String APPROVE_BUTTON_TEXT_CHANGED_PROPERTY;
  public static final java.lang.String APPROVE_BUTTON_TOOL_TIP_TEXT_CHANGED_PROPERTY;
  public static final java.lang.String APPROVE_BUTTON_MNEMONIC_CHANGED_PROPERTY;
  public static final java.lang.String CONTROL_BUTTONS_ARE_SHOWN_CHANGED_PROPERTY;
  public static final java.lang.String DIRECTORY_CHANGED_PROPERTY;
  public static final java.lang.String SELECTED_FILE_CHANGED_PROPERTY;
  public static final java.lang.String SELECTED_FILES_CHANGED_PROPERTY;
  public static final java.lang.String MULTI_SELECTION_ENABLED_CHANGED_PROPERTY;
  public static final java.lang.String FILE_SYSTEM_VIEW_CHANGED_PROPERTY;
  public static final java.lang.String FILE_VIEW_CHANGED_PROPERTY;
  public static final java.lang.String FILE_HIDING_CHANGED_PROPERTY;
  public static final java.lang.String FILE_FILTER_CHANGED_PROPERTY;
  public static final java.lang.String FILE_SELECTION_MODE_CHANGED_PROPERTY;
  public static final java.lang.String ACCESSORY_CHANGED_PROPERTY;
  public static final java.lang.String ACCEPT_ALL_FILE_FILTER_USED_CHANGED_PROPERTY;
  public static final java.lang.String DIALOG_TITLE_CHANGED_PROPERTY;
  public static final java.lang.String DIALOG_TYPE_CHANGED_PROPERTY;
  public static final java.lang.String CHOOSABLE_FILE_FILTER_CHANGED_PROPERTY;
  protected javax.accessibility.AccessibleContext accessibleContext;
  public javax.swing.JFileChooser();
  public javax.swing.JFileChooser(java.lang.String);
  public javax.swing.JFileChooser(java.io.File);
  public javax.swing.JFileChooser(javax.swing.filechooser.FileSystemView);
  public javax.swing.JFileChooser(java.io.File, javax.swing.filechooser.FileSystemView);
  public javax.swing.JFileChooser(java.lang.String, javax.swing.filechooser.FileSystemView);
  protected void setup(javax.swing.filechooser.FileSystemView);
  public void setDragEnabled(boolean);
  public boolean getDragEnabled();
  public java.io.File getSelectedFile();
  public void setSelectedFile(java.io.File);
  public java.io.File[] getSelectedFiles();
  public void setSelectedFiles(java.io.File[]);
  public java.io.File getCurrentDirectory();
  public void setCurrentDirectory(java.io.File);
  public void changeToParentDirectory();
  public void rescanCurrentDirectory();
  public void ensureFileIsVisible(java.io.File);
  public int showOpenDialog(java.awt.Component) throws java.awt.HeadlessException;
  public int showSaveDialog(java.awt.Component) throws java.awt.HeadlessException;
  public int showDialog(java.awt.Component, java.lang.String) throws java.awt.HeadlessException;
  protected javax.swing.JDialog createDialog(java.awt.Component) throws java.awt.HeadlessException;
  public boolean getControlButtonsAreShown();
  public void setControlButtonsAreShown(boolean);
  public int getDialogType();
  public void setDialogType(int);
  public void setDialogTitle(java.lang.String);
  public java.lang.String getDialogTitle();
  public void setApproveButtonToolTipText(java.lang.String);
  public java.lang.String getApproveButtonToolTipText();
  public int getApproveButtonMnemonic();
  public void setApproveButtonMnemonic(int);
  public void setApproveButtonMnemonic(char);
  public void setApproveButtonText(java.lang.String);
  public java.lang.String getApproveButtonText();
  public javax.swing.filechooser.FileFilter[] getChoosableFileFilters();
  public void addChoosableFileFilter(javax.swing.filechooser.FileFilter);
  public boolean removeChoosableFileFilter(javax.swing.filechooser.FileFilter);
  public void resetChoosableFileFilters();
  public javax.swing.filechooser.FileFilter getAcceptAllFileFilter();
  public boolean isAcceptAllFileFilterUsed();
  public void setAcceptAllFileFilterUsed(boolean);
  public javax.swing.JComponent getAccessory();
  public void setAccessory(javax.swing.JComponent);
  public void setFileSelectionMode(int);
  public int getFileSelectionMode();
  public boolean isFileSelectionEnabled();
  public boolean isDirectorySelectionEnabled();
  public void setMultiSelectionEnabled(boolean);
  public boolean isMultiSelectionEnabled();
  public boolean isFileHidingEnabled();
  public void setFileHidingEnabled(boolean);
  public void setFileFilter(javax.swing.filechooser.FileFilter);
  public javax.swing.filechooser.FileFilter getFileFilter();
  public void setFileView(javax.swing.filechooser.FileView);
  public javax.swing.filechooser.FileView getFileView();
  public java.lang.String getName(java.io.File);
  public java.lang.String getDescription(java.io.File);
  public java.lang.String getTypeDescription(java.io.File);
  public javax.swing.Icon getIcon(java.io.File);
  public boolean isTraversable(java.io.File);
  public boolean accept(java.io.File);
  public void setFileSystemView(javax.swing.filechooser.FileSystemView);
  public javax.swing.filechooser.FileSystemView getFileSystemView();
  public void approveSelection();
  public void cancelSelection();
  public void addActionListener(java.awt.event.ActionListener);
  public void removeActionListener(java.awt.event.ActionListener);
  public java.awt.event.ActionListener[] getActionListeners();
  protected void fireActionPerformed(java.lang.String);
  public void updateUI();
  public java.lang.String getUIClassID();
  public javax.swing.plaf.FileChooserUI getUI();
  protected java.lang.String paramString();
  public javax.accessibility.AccessibleContext getAccessibleContext();
  public javax.swing.plaf.ComponentUI getUI();
}
```
