public class AbstractFabricForComplex {
    public interface complexInterface {
        type1 createComplex1();
        type2 createComplex2();
    };

    public static class ComplexNumber implements complexInterface {
        @Override
        public type1 createComplex1() {
            return new complexType1();
        };

        @Override
        public type2 createComplex2() {
            return new complexType2();
        };
    }

    public interface type1 {};
    public interface type2 {};

    public static class complexType1 implements type1 {
        public complexType1() {
            System.out.println("Complex number1 has created");
        }
    }

    public static class complexType2 implements type2 {
        public complexType2() {
            System.out.println("Complex number2  has created");
        }
    }
}
