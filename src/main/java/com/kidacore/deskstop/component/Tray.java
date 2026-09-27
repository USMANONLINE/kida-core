package com.kidacore.deskstop.component;

import com.kidacore.server.config.Default;
import javafx.application.Platform;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URI;

@Slf4j
public class Tray {
    private TrayIcon trayIcon;

    public void initialize (Stage stage) {
        if (!SystemTray.isSupported()) {
            log.info("System tray is not supported");
            return;
        }

        SystemTray tray = SystemTray.getSystemTray();
        Image image = createIcon();

        MenuItem open = new MenuItem("Open Kida");
        open.addActionListener(e ->
            Platform.runLater(() -> {
                stage.show();
                stage.toFront();
            })
        );

        MenuItem exit = new MenuItem("Exit");
        exit.addActionListener(e ->
            Platform.runLater(() -> {
                tray.remove(trayIcon);
                Platform.exit();
            })
        );

        PopupMenu popupMenu = new PopupMenu();
        popupMenu.add(open);
        popupMenu.addSeparator();
        popupMenu.add(exit);

        trayIcon = new TrayIcon(image, "Kida", popupMenu);
        trayIcon.setImageAutoSize(true);
        try {
            tray.add(trayIcon);
            launchBrowser("http://localhost:" + Default.SERVER_PORT);
        } catch (AWTException e) {
            log.error("Unable to add tray icon ", e);
        }
    }

    public void launchBrowser (String url) {
        try {
            boolean desktopIsSupported = Desktop.isDesktopSupported()
                    && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE);
            if (desktopIsSupported) {
                Desktop.getDesktop().browse(new URI(url));
            }
        } catch (Exception ex) {
            log.error("Unable to launch browser ", ex);
        }
    }

    private Image createIcon() {
        BufferedImage image = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = image.createGraphics();
        graphics.drawString("K", 8, 22);
        graphics.dispose();
        return image;
    }
}