package eu.iamgio.libfx.files;

import com.sun.istack.internal.Nullable;

import java.io.File;

/**
 * File chooser
 * @author Gio
 */
public class FileCreator {

    /**
     * Opens a file chooser window
     * @param title File chooser title
     * @param extensions Supported extensions
     * @return Choosen file
     */
    public File create(@Nullable String title, javafx.stage.FileChooser.ExtensionFilter...extensions) {
        javafx.stage.FileChooser fileChooser = new javafx.stage.FileChooser();
        if(title != null) fileChooser.setTitle(title);
        fileChooser.getExtensionFilters().addAll(extensions);
        return fileChooser.showSaveDialog(null);
    }
}
