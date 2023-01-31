public class PrivateInterfaceMethods {
    public static void main(String[] args) {
        System.out.println("print() method invokes the private method greetMethod()");

        InterfaceWithPrivateMethod interfaceWithPrivateMethod = new InterfaceWithPrivateMethod() {};
        System.out.println("Invoking print() method directly from interface");
        interfaceWithPrivateMethod.print();

        ImplementationClass implementationClass = new ImplementationClass();
        System.out.println("Invoking print() method from implementation class");
        implementationClass.print();
        System.out.println("Invoking print() method through other method from the implementation class");
        implementationClass.method();
    }

    public static class ImplementationClass implements InterfaceWithPrivateMethod {
        public void method(){
            this.print();
        }
    }


}
