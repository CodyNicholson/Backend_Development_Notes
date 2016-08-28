package patterns.factorymethod;

import java.io.File;
import java.util.Arrays;
import java.util.Hashtable;

// Class that, given a directory's absolute path, provides a list of the files in that directory.
class DirectoryListing {
    private static Hashtable<String, DirectoryListing> pool = new Hashtable<String, DirectoryListing>();

    private File dir;

    private File[] files;

    private long lastTimeCheck;

    @SuppressWarnings("unused")
    private DirectoryListing() {
    } // Why do we have this?
      // (not really needed in this case because of the additional constructor)

    DirectoryListing(String path) {
        dir = new File(path);
        lastTimeCheck = 0;
        update();
    }

    public File[] getContents() {
        update();
        return files;
    }

    private void update() {
        long lastModified;

        lastModified = dir.lastModified();
        if (lastTimeCheck != lastModified) {
            lastTimeCheck = lastModified;
            files = dir.listFiles();
            Arrays.sort(files);
        }
    }

    /**
     * Create a DirectoryListing object
     * 
     * Because DirectoryListing objects are expensive to create, this method may
     * return an existing DirectoryListing object if one exists
     */
    public static DirectoryListing createDirectoryListing(String path) {
        DirectoryListing dl;

        dl = pool.get(path);
        if (dl == null) {
            System.out.println("Creating new DirectoryListing object for "
                    + path);
            dl = new DirectoryListing(path);
            pool.put(path, dl);
        } else {
            System.out.println("Reusing DirectoryListing object for " + path);
        }
        return dl;
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        // String path1 = "/Users/orso/6300/Lectures";
        // String path2 = "/Users/orso/3300/Lectures";
        String path1 = ".";
        String path2 = "..";
        DirectoryListing dl1 = DirectoryListing.createDirectoryListing(path1);
        DirectoryListing dl2 = DirectoryListing.createDirectoryListing(path2);
        DirectoryListing dl3 = DirectoryListing.createDirectoryListing(path1);
        DirectoryListing dl4 = DirectoryListing.createDirectoryListing(path2);
        if (dl1 == dl3 && dl2 == dl4) {
            System.out.println("The pool works");
        }

        System.out.println("Files for " + path1 + ":");
        File[] files = dl1.getContents();
        for (File f : files) {
            System.out.println("\t" + f.getName());
        }
    }
}
