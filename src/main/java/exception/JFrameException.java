package exception;

import javax.swing.*;

public class JFrameException extends RuntimeException {

    private String errorMessage;
    private JFrame frame;

    public JFrameException(JFrame frame, String errorMessage) {
        super(errorMessage);
        JOptionPane.showMessageDialog(frame, errorMessage);
    }

}
