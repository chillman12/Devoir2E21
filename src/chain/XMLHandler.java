package chain;

import controler.Command;
import controler.Factory;
import model.Node;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLHandler extends Handler {

    List<String> list = new ArrayList<>();

    @Override
    public void handleRequest(Node node) {
        if (applyRules(node)) {
            Factory factory = Factory.get();
            Command command = factory.create(Factory.ID.XML, node.getFile());
            command.add("    F: " + node.getFile().getName() + "\n");
            command.execute();
            list.addAll(command);
        }
    }

    @Override
    public List<String> printMsg() {
        return list;
    }

    private boolean applyRules(Node node) {
        String extension = "";

        int i = node.getFile().getName().lastIndexOf('.');
        if (i > 0) {
            extension = node.getFile().getName().substring(i + 1);
        }

        return extension.equals("xml");
    }

}
