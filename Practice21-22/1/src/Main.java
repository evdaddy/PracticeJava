public class Main {
    public static void main(String[] args) {

        AbstractFabricForComplex.complexInterface factory;
        factory = new AbstractFabricForComplex.ComplexNumber();

        factory.createComplex1();
        factory.createComplex2();
    }
}
