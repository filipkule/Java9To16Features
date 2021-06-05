package solutions;

interface Issue7InterfaceWithPrivateMethod {
        default void print(){
            System.out.println(greetMethod());
        }

        private String greetMethod(){
            return "Hello Stranger!";
        }
    }