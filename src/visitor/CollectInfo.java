package visitor;

import chain.*;
import controler.Command;
import model.Directory;
import model.FileV;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectInfo implements Visitor {

    List<String> imports = new ArrayList<>();

    Handler javaHandler;
    Handler licenseHandler;
    Handler readMeHandler;
    Handler XMLHandler;

    @Override
    public void visit(FileV filev) {
        javaHandler = new JavaHandler();
        licenseHandler = new LicenseHandler();
        readMeHandler = new ReadMeHandler();
        XMLHandler = new XMLHandler();

        javaHandler.setProchain(licenseHandler);
        licenseHandler.setProchain(readMeHandler);
        readMeHandler.setProchain(XMLHandler);

        javaHandler.handleRequest(filev);

        imports.addAll(readMeHandler.printMsg());
        imports.addAll(licenseHandler.printMsg());
        imports.addAll(javaHandler.printMsg());
        imports.addAll(XMLHandler.printMsg());

    }

    @Override
    public void visit(Directory directory) {
        imports.add(directory.getFile().getPath() + "\n");
    }

    @Override
    public Iterator<String> iterator() {
        return imports.iterator();
    }

}
