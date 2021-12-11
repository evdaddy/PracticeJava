public class Client implements Chair{
    @Override
    public void sit(Chair chair) {
        System.out.println("Sit on this chair"); // + chair.getClass().getSimpleName());   Хотел таким образом вывести имя стула, на который садимся, но не вышло
    }

    @Override
    public Venerian createVenerianChair() {
        return null;
    }

    @Override
    public Multi createMultiChair() {
        return null;
    }

    @Override
    public Magic createMagicChair() {
        return null;
    }
}
