package de.dhbw.studienarbeit.sqllernsoftware.frontend;

import javafx.application.Platform;
import javafx.scene.Node;

public class UIThread extends Thread {

    Node node;
    Boolean correct;
    Boolean waiting;
    Boolean wrong;

    public UIThread(Node node) {
        setDaemon(true);
        this.node = node;
        correct = false;
        waiting = true;
        wrong = false;
    }

    @Override
    public void run() {
        super.run();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (node instanceof StatusIcon) {
                    StatusIcon icon = (StatusIcon) node;
                    icon.statusLoading();
                    while (waiting) {
                        try {
                            sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (correct) {
                        icon.statusCorrect();
                    } else if (wrong) {
                        icon.statusWrong();
                    }

                }
            }
        });
    }

    public void statusCorrect() {
        this.waiting = false;
        this.correct = true;
        this.wrong = false;
    }

    public void statusWrong() {
        this.waiting = false;
        this.correct = false;
        this.wrong = true;
    }
}
