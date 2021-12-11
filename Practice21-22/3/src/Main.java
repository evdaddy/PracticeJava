public class Main {
    public static void main(String[] args) {
        TextFile text = new TextFile();
        text.Open();
        TextFile newText = (TextFile) text.NewFile();
        newText.Save();

        TextFabric newFabric = new TextFabric() {
            @Override
            public IDocument CreateNew() {
                return TextFabric.super.CreateNew();
            }

            @Override
            public IDocument CreateOpen() {
                return TextFabric.super.CreateOpen();
            }
        };

        newFabric.CreateNew();
        newFabric.CreateOpen();
    }
}
