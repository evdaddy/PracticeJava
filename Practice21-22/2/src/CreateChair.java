public class CreateChair implements Chair{
    @Override
    public Venerian createVenerianChair() { return new VenerianChair(); };

    @Override
    public Multi createMultiChair() { return new MultiChair(); };

    @Override
    public Magic createMagicChair() { return new MagicChair(); };

    @Override
    public void sit(Chair chair) {};
}
