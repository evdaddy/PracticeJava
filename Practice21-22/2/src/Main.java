public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        Chair chair;

        chair = new CreateChair();
        chair.createMultiChair();
        client.sit(chair);

        Chair chair2;
        chair2 = new CreateChair();
        chair2.createMagicChair();
        client.sit(chair2);

        Chair chair3;
        chair3 = new CreateChair();
        chair3.createVenerianChair();
        client.sit(chair3);
    }
}
