package agh.ii.prinjava.lab02.lst02_02;

class DerivedClass extends BaseClass {

    @Override
    public void m2() {
        System.out.println("Breaking the consistent state of the inherited part (2)");
    }

    @Override
    protected void m3() {
        System.out.println("Breaking the consistent state of the inherited part (3)");
    }

    // 'fM1()' cannot override 'fM1()' in 'BaseClass'; overridden method is final
    // @Override public final void fM1() {}
}

public class Main {
    public static void main(String[] args) {
        DerivedClass dc = new DerivedClass();

        System.out.println("\nAbout to call fM1, m2, m3, and fm4...");
        dc.fM1();
        dc.m2();
        dc.m3();
        dc.fM4();
    }
}
