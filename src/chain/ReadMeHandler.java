package chain;

import controler.Command;
import controler.Factory;
import model.Node;

import java.util.ArrayList;
import java.util.List;

public class ReadMeHandler extends Handler {

    List<String> list = new ArrayList<>();

    @Override
    public void handleRequest(Node node) {
        if (applyRules(node)) {
            Factory factory = Factory.get();
            Command command = factory.create(Factory.ID.README, node.getFile());
            command.execute();
            list.addAll(command);
        } else
            successor.handleRequest(node);
    }

    @Override
    public List<String> printMsg() {
        return list;
    }

    private boolean applyRules(Node node) {

        return node.getFile().getName().equals("README.md");
    }

}
