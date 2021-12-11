public class TextFile implements IDocument{
    @Override
    public IDocument NewFile() {
        return new TextFile();
    }

    @Override
    public IDocument Open() {
        System.out.println("File is open");
        return null;
    }

    @Override
    public IDocument Save() {
        System.out.println("File was saved");
        return null;
    }
}

interface TextFabric extends ICreateDocument {

    @Override
    default IDocument CreateNew() {
        return new TextFile();
    }

    @Override
    default IDocument CreateOpen() {
        System.out.println("New file created and open");
        return new TextFile();
    }
}
