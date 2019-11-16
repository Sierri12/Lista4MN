public class Main {
    public static void main(String[] args) {
        System.out.println("Metoda bisekcji: ");
       RootSolver.bisekcja(0,2,0.05,0.56714329,30,(x) ->Math.exp(-x)-x);

        System.out.println();

        System.out.println("Metoda reguły falsi: ");
        RootSolver.falsi(0,2,0.05,0.56714329,30,x -> Math.exp(-x)-x);
        System.out.println();

        System.out.println("Metoda punktu stałego:");
        RootSolver.pktStały(0,0.05,0.56714329,30,x -> Math.exp(-x)-x);
        System.out.println();

        System.out.println("Metoda stycznych");
        RootSolver.styczne(2,0.05,0.56714329,30,x -> Math.exp(-x)-x);
        System.out.println();

        System.out.println("Metoda siecznych");
        RootSolver.sieczne(2,1.5,0.05,0.56714329,30,x -> Math.exp(-x)-x);
        System.out.println();


    }
}
