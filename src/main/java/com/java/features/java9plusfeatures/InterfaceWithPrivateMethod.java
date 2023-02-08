package com.java.features.java9plusfeatures;

interface InterfaceWithPrivateMethod {
        default void print(){
            System.out.println(greetMethod());
        }

        private String greetMethod(){
            return "Hello Stranger!";
        }
    }