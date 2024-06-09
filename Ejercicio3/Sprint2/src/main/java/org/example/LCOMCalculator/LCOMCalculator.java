package org.example.LCOMCalculator;

import java.util.*;

public class LCOMCalculator {
    public static class ClassInfo {
        List<String> methods = new ArrayList<>();
        Map<String, Set<String>> methodAttributes = new HashMap<>();
        Set<String> attributes = new HashSet<>();
        public void addMethod(String methodName, Set<String> attrs) {
            methods.add(methodName);
            methodAttributes.put(methodName, attrs);
            attributes.addAll(attrs);
        }
    }

    public static void calcularLCOM (List<String> methods, ClassInfo classInfo){
        int p = 0, q = 0;
        for (int i = 0; i < methods.size(); i++) {
            for (int j = i + 1; j < methods.size(); j++) {
                String method1 = methods.get(i);
                String method2 = methods.get(j);
                Set<String> attrs1 = classInfo.methodAttributes.get(method1);
                Set<String> attrs2 = classInfo.methodAttributes.get(method2);
                // Calculamos si comparten atributos
                Set<String> intersection = new HashSet<>(attrs1);
                intersection.retainAll(attrs2);
                if (intersection.isEmpty()) {
                    p++; // No comparten atributos
                } else {
                    q++; // Comparten al menos un atributo
                }
            }
        }
        int lcom = p - q;
        System.out.println("LCOM = " + lcom);
    }

    public static void main(String[] args) {
        ClassInfo GameClass = new ClassInfo();
        // Sprint 1:
        // Game
        GameClass.addMethod("Game", new HashSet<>(Arrays.asList("wordSelector", "hintGenerator")));
        GameClass.addMethod("start", new HashSet<>(Arrays.asList("wordSelector", "hintGenerator")));
        List<String> GameMethods = GameClass.methods;
        calcularLCOM(GameMethods, GameClass);

        // HintGenerator
        ClassInfo HintGenerator = new ClassInfo();
        HintGenerator.addMethod("HintGenerator", new HashSet<>(Arrays.asList("wordToGuess")));
        HintGenerator.addMethod("generateHint", new HashSet<>(Arrays.asList("wordToGuess")));
        List<String> HintGeneratorMethods = HintGenerator.methods;
        calcularLCOM(HintGeneratorMethods, HintGenerator);

        // WordSelector
        ClassInfo WordSelector = new ClassInfo();
        WordSelector.addMethod("WordSelector", new HashSet<>(Arrays.asList("possibleWords", "selectedWordIndex")));
        WordSelector.addMethod("selectWord", new HashSet<>(Arrays.asList("possibleWords", "selectedWordIndex")));
        List<String> WordSelectorMethods = WordSelector.methods;
        calcularLCOM(WordSelectorMethods, WordSelector);

        //List<String> methods = classInfo.methods;
        //calcularLCOM(methods, classInfo);

    }
}