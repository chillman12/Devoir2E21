package chain;

import controler.Command;
import controler.Factory;
import model.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JavaHandler extends Handler {

    List<String> list = new ArrayList<>();

    @Override
    public void handleRequest(Node node) {
        if (applyRules(node)) {
            Factory factory = Factory.get();
            Command command = factory.create(Factory.ID.JAVA, node.getFile());
            command.execute();
            list.add("    F: " + node.getFile().getName() + "\n");
            list.addAll(command);
        }
        else
            successor.handleRequest(node);
    }

    @Override
    public List<String> printMsg(){
        return list;
    }

    private boolean applyRules(Node node){
        String extension = "";

        int i = node.getFile().getName().lastIndexOf('.');
        if (i > 0) {
            extension = node.getFile().getName().substring(i+1);
        }

        return extension.equals("java");
    }

}
