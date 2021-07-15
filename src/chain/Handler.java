package chain;

import controler.Command;
import model.Node;

import java.io.File;
import java.util.List;

public abstract class Handler {
    public static final String START = "\n\t>>>> ";

    Handler successor;

    public void setProchain(Handler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(Node node);

    public abstract List<String> printMsg();

}
