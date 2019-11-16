public class RootSolver {


    public static void bisekcja(double xl, double xu, double eaMax, double trueVal,int maxIter, ScalarFunction f) {

        double xr=0;

        double xrOld=0;
        for(int i =1;i<=maxIter;i++) {
             xr = (xl + xu) / 2;
            double fxr = f.function(xr);
            double fxl = f.function(xl);


            if (fxr * fxl < 0) {
                xu = xr;

            } else if (fxl * fxr > 0) {
                xl = xr;


            } else if (fxl * fxr == 0) {
                xl = xr;
                xu = xr;

            }
            double ea= Math.abs(((xr - xrOld) / xr) * 100);
            double et=Math.abs((trueVal-xr)/trueVal)*100;
            System.out.println("iteracja: " + i + "  xr= " + xr + "    blad ea: " + ea + " %   blad et: "+et+" %");
            if (ea>eaMax) {
                xrOld = xr;
            }
            else{
                break;
            }

        }
    }

    public static void falsi(double xl, double xu, double eaMax, double trueVal,int maxIter, ScalarFunction f){
        double xr=0;

        double xrOld=0;
        for(int i =1;i<=maxIter;i++) {


            double fxl = f.function(xl);
            double fxu = f.function(xu);
            xr=xu-((fxu*(xl-xu))/(fxl-fxu));
            double fxr = f.function(xr);


            if (fxr * fxl < 0) {
                xu = xr;

            } else if (fxl * fxr > 0) {
                xl = xr;


            } else if (fxl * fxr == 0) {
                xl = xr;
                xu = xr;

            }
            double ea= Math.abs(((xr - xrOld) / xr) * 100);
            double et=Math.abs((trueVal-xr)/trueVal)*100;
            System.out.println("iteracja: " + i + "  xr= " + xr + "    blad ea: " + ea + " %   blad et: "+et+" %");
            if (ea>eaMax) {
                xrOld = xr;
            }
            else{
                break;
            }

        }

    }

    public static void pktStały(double x0,double eaMax, double trueVal,int maxIter, ScalarFunction f){
        double xn=0;


        for(int i =1;i<=maxIter;i++) {
        xn=f.function(x0)+x0;
            double ea= Math.abs(((xn - x0) / xn) * 100);
            double et=Math.abs((trueVal-xn)/trueVal)*100;
            System.out.println("iteracja: " + i + "  xn= " + xn + "    blad ea: " + ea + " %   blad et: "+et+" %");
            if (ea>eaMax) {
                x0=xn;
            }
            else{
                break;
            }
        }
    }

    public static void styczne(double xi,double eaMax, double trueVal,int maxIter, ScalarFunction f){
        double x0=xi;
        for(int i =1;i<=maxIter;i++) {
            xi= x0-(f.function(x0))/(-1*Math.exp(-x0)-1);
            double ea= Math.abs(((xi - x0) / xi) * 100);
            double et=Math.abs((trueVal-xi)/trueVal)*100;
            System.out.println("iteracja: " + i + "  xi= " + xi + "    blad ea: " + ea + " %   blad et: "+et+" %");
            if (ea>eaMax) {
                x0=xi;
            }
            else{
                break;
            }
        }

    }

    public static void sieczne(double xi,double xj,double eaMax, double trueVal,int maxIter, ScalarFunction f){

        for(int i =1;i<=maxIter;i++) {
            double xn= xi-(f.function(xi)*(xj-xi)/(f.function(xj)-f.function(xi)));
            double ea= Math.abs(((xn - xj) / xn) * 100);
            double et=Math.abs((trueVal-xn)/trueVal)*100;
            System.out.println("iteracja: " + i + "  xn= " + xn + "    blad ea: " + ea + " %   blad et: "+et+" %");
            if (ea>eaMax) {
                xi=xj;
                xj=xn;

            }
            else{
                break;
            }
        }

    }


}
