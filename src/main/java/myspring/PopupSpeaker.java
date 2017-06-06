package myspring;

import javax.swing.*;

/**
 * Created by Evegeny on 06/06/2017.
 */
public class PopupSpeaker implements Speaker {
    @Override
    public void speak(String message) {
        JOptionPane.showMessageDialog(null,message);
    }
}
