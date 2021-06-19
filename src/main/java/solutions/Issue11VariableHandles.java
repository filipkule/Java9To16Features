package solutions;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.Arrays;

public class Issue11VariableHandles {
    public static void main(String[] args) {
        try {
            Person instance = new Person();

            nameVarHandleExample(instance);
            agePrivateVarHandleExample(instance);
            addressArrayVarHandleExample(instance);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    private static void nameVarHandleExample(Person instance) throws NoSuchFieldException, IllegalAccessException {
        VarHandle nameVarHandle;
        System.out.println("=============================================================");
        nameVarHandle = MethodHandles.lookup().in(Person.class).findVarHandle(
                Person.class, "name", String.class);

        System.out.println("Original name: " + nameVarHandle.get(instance));
        nameVarHandle.set(instance, "New Name");
        System.out.println("Changing the name.");
        System.out.println("New name: " + nameVarHandle.get(instance));
        System.out.println("=============================================================");
    }

    private static void agePrivateVarHandleExample(Person instance) throws NoSuchFieldException, IllegalAccessException {
        VarHandle ageVarHandle;
        System.out.println("Private variable lookup");
        ageVarHandle = MethodHandles.privateLookupIn(Person.class, MethodHandles.lookup()).findVarHandle(
                Person.class, "age", Integer.class);

        System.out.println("Age: " + ageVarHandle.get(instance));
        System.out.println("=============================================================");
    }

    private static void addressArrayVarHandleExample(Person instance) {
        VarHandle addressesVarHandle;
        addressesVarHandle = MethodHandles.arrayElementVarHandle(String[].class);

        System.out.println("Setting addresses.");
        addressesVarHandle.set(instance.addresses, 0, "Address 1");
        addressesVarHandle.set(instance.addresses, 1, "Address 2");
        System.out.println(Arrays.stream(instance.addresses).toList());
        System.out.println("Fetching main address: " + addressesVarHandle.get(instance.addresses, 0));
        System.out.println("Fetching secondary address: " + addressesVarHandle.get(instance.addresses, 1));
        System.out.println("=============================================================");
    }
}

class Person {
    String name = "Stranger";
    private Integer age = 27;
    String[] addresses = new String[5];
}
