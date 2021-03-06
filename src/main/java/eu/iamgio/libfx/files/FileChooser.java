package eu.iamgio.libfx.files;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * File chooser
 * @author Gio
 */
public class FileChooser {

    private File folder;

    public FileChooser(File folder) {
        this.folder = folder;
    }

    public FileChooser() {}

    /**
     * Opens a file chooser window
     * @param title File chooser title
     * @param multi <tt>true</tt> for multiple files
     * @param extensions Supported extensions
     * @return Choosen file
     */
    private List<File> choose(String title, boolean multi, javafx.stage.FileChooser.ExtensionFilter...extensions) {
        javafx.stage.FileChooser fileChooser = new javafx.stage.FileChooser();
        if(folder != null) fileChooser.setInitialDirectory(folder);
        if(title != null) fileChooser.setTitle(title);
        fileChooser.getExtensionFilters().addAll(extensions);
        return multi ? fileChooser.showOpenMultipleDialog(null) : Arrays.asList(fileChooser.showOpenDialog(null));
    }

    /**
     * Opens a file chooser window
     * @param title File chooser title
     * @param extensions Supported extensions
     * @return Choosen file
     */
    public File choose(String title, javafx.stage.FileChooser.ExtensionFilter...extensions) {
        return choose(title, false, extensions).get(0);
    }

    /**
     * Opens a file chooser window to open multiple files
     * @param title File chooser title
     * @param extensions Supported extensions
     * @return Choosen file(s)
     */
    public List<File> chooseMulti(String title, javafx.stage.FileChooser.ExtensionFilter...extensions) {
        return choose(title, true, extensions);
    }
}
