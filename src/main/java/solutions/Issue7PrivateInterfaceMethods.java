package solutions;

public class Issue7PrivateInterfaceMethods {
    public static void main(String[] args) {
        System.out.println("print() method invokes the private method greetMethod()");
        Issue7InterfaceWithPrivateMethod issue7InterfaceWithPrivateMethod = new Issue7InterfaceWithPrivateMethod() {};
        System.out.println("Invoking print() method directly from interface");
        issue7InterfaceWithPrivateMethod.print();

        ImplementationClass implementationClass = new ImplementationClass();
        System.out.println("Invoking print() method from implementation class");
        implementationClass.print();
        System.out.println("Invoking print() method through other method from the implementation class");
        implementationClass.method();
    }

    public static class ImplementationClass implements Issue7InterfaceWithPrivateMethod {
        public void method(){
            this.print();
        }
    }


}
