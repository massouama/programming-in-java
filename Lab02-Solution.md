# Réponses aux Questions sur Java

## 1. Révision des spécifications du langage Java
 Done 

## 2. Avantages de l'utilisation de constantes en programmation
- **Sécurité du code** : les constantes ne peuvent pas être modifiées une fois initialisées, ce qui aide à prévenir les modifications accidentelles des valeurs qui ne devraient pas changer.
- **Maintenance du code** : les constantes rendent le code plus lisible et plus facile à comprendre, car elles peuvent être nommées de manière significative.
- **Optimisation des performances** : l'utilisation de constantes peut aider le compilateur à optimiser le code en sachant que certaines valeurs ne changeront jamais.

## 3. Signification du mot-Clé `final`
- **Variables locales** : Une fois initialisée, la variable ne peut plus être modifiée.
- **Variables d'instance** : La variable doit être initialisée au moment de la déclaration ou dans le constructeur, et ne peut plus être modifiée par la suite.
- **Constantes statiques** : Utilisé pour définir une constante au niveau de la classe, qui sera la même et non modifiable pour toutes les instances.
- **Méthodes** : La méthode ne peut pas être surchargée ou modifiée par des classes héritières.
- **Classes** : La classe ne peut pas être étendue (aucune classe ne peut hériter de cette classe).

## 4. Questions sur l'immuabilité
- Si une classe contient uniquement des champs de données privés et aucune méthode de définition, la classe est-elle immuable ? 
- **Oui**, car il n'y a aucun moyen de modifier les champs de données après la construction de l'objet.
- Si tous les champs de données d'une classe sont privés et de types primitifs, et que la classe ne contient aucune méthode de définition, la classe est-elle immuable ? **Oui**, pour la même raison que ci-dessus. Les types primitifs privés sans setters contribuent à l'immutabilité.

## 5. Immutabilité de la Classe C
La classe `C` suivante n'est pas immuable car elle expose directement son tableau `values` via la méthode `getValues()`. Même si le tableau est privé, le fait de le retourner directement permet à d'autres classes de modifier le contenu du tableau, ce qui viole l'immutabilité.

```java

public class C {
    private int[] values;

    public int[] getValues() {
        return values;
    }
}
```
## 6. Refactorisation pour immutabilité

```java

public class C {
private int[] values;

    public int[] getValues() {
        // Retourne une copie du tableau pour préserver l'immutabilité
        return values.clone();
    }
}
```
## Exercice 2

## Analyse de l'implémentation singleton

### Est-ce correct?
Oui, l'utilisation d'une énumération pour implémenter le modèle Singleton est correcte en Java.

### Est-ce thread-safe?
L'instanciation de l'énumération est thread-safe. Cependant, la méthode `setValue` n'est pas synchronisée ce qui pourrait poser des problèmes si plusieurs threads tentent de modifier `value` en même temps.

## Refactorisation pour une structure one file-one class

### Refactorisation proposée:
Chaque classe ou énumération serait contenue dans son propre fichier source pour améliorer la lisibilité et la maintenabilité.

### Exemple de fichier pour le singleton:
```java
// EnumBasedSingleton.java
public enum EnumBasedSingleton {
    INSTANCE;

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
```

## Exercice 3




## Exercise 4

# Java Programming Exercises

## Exercise Analysis and Responses

### 1. Review Java language specification chapters on abstract classes and interfaces

- **Review**: The chapters would cover the definition, purpose, and use-cases for abstract classes and interfaces in Java, explaining how they support abstraction and polymorphism in Java's object-oriented programming paradigm.

### 2. Main differences between abstract classes and interfaces in Java

- **Differences**:
    - Abstract classes can have implemented methods, whereas interfaces cannot (prior to Java 8).
    - A class can extend only one abstract class but implement multiple interfaces.
    - Interfaces provide a form of multiple inheritance as they can declare methods without implementing them, allowing the implementing classes to provide the actual functionality.
    - Abstract classes can maintain state with instance variables; interfaces cannot until Java 8's introduction of static and default methods.

### 3. Possible types of members in Java interfaces

- **Member Types**:
    - Constants (public static final variables)
    - Method declarations (abstract methods)
    - Default methods (with an implementation, introduced in Java 8)
    - Static methods (introduced in Java 8)

### 4. Correct definition of an abstract class

- **Correct Definition**: `class B { abstract void m1(); }`
    - An abstract class is not required to have abstract methods. The given class `B` is not explicitly declared abstract, so it is not a correct definition of an abstract class.

### 5. Correct definition of an interface

- **Correct Definition**: `interface D { void m1(); }`
    - An interface can declare methods without providing an implementation, and is not to be marked as `abstract`, as that is implicit.

### 6. Execution result of main Class

```java
interface A {}
class C {}
class D extends C {}
class B extends D implements A {}

public class Main {
  public static void main(String[] args) {
    B b = new B();
    if (b instanceof A) {
      System.out.println("b is an instance of A");
    }
    if (b instanceof C) {
      System.out.println("b is an instance of C");
    }
  }
}
```
b is an instance of A
b is an instance of C.\
Because B implements A and extends D, which in turn extends C. Therefore, b is an instance of both A and C.

### 7. Refactoriser le code source pour one file-one classstructurer

- Voir fichier Zip lab02-solution


## exercise 5

## 1. Révision des spécifications du langage Java
Les chapitres relatifs aux classes abstraites et aux interfaces fonctionnelles dans la spécification du langage Java détaillent comment ces constructions soutiennent l'abstraction en programmation orientée objet.

## 2. Relation entre les expressions lambda et les interfaces fonctionnelles
Les expressions lambda permettent une syntaxe concise pour implémenter une méthode d'une interface fonctionnelle sans créer une classe anonyme traditionnelle.

## 3. Écriture et implémentation des interfaces fonctionnelles
Les interfaces fonctionnelles selon les signatures fonctionnelles fournies :

```java
@FunctionalInterface
interface FunctionVoidToInt {
    int apply();
}

@FunctionalInterface
interface FunctionIntToVoid {
    void apply(int x);
}

@FunctionalInterface
interface FunctionIntToInt {
    int apply(int x);
}

@FunctionalInterface
interface BiFunctionIntsToVoid {
    void apply(int x, int y);
}
```