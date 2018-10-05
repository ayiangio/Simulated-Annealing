
package sa;
import static java.lang.Math.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SA {

    static double fungsi (double x1, double x2)
    {
       return (-(abs(sin(x1)*cos(x2)*exp(abs(1-(sqrt(pow(x1,2)+pow(x2,2))/3.14))))));
    }
    
    static double accept_prob(double old_cost, double new_cost, double t0)
    {
        return pow(exp(1),((old_cost - new_cost) / t0));
    }
    
     
    public static void main(String[] args) {       
        double x1 = ThreadLocalRandom.current().nextDouble(-10,10);
        double x2 = ThreadLocalRandom.current().nextDouble(-10,10);
        double old_cost = fungsi(x1,x2);        
        double t0 = 1.0;
        double t1 = 0.000001;
        double alpha = 0.9;       
        while(t0 > t1)
        {
            int i = 1;
            while(i <= 5000)
            {
                double x1_new = ThreadLocalRandom.current().nextDouble(-10,10);
                double x2_new = ThreadLocalRandom.current().nextDouble(-10,10);
                double new_cost = fungsi(x1_new,x2_new);
                double rand = ThreadLocalRandom.current().nextDouble(0,1);
                double ap = accept_prob(old_cost,new_cost,t0);
                if (new_cost < old_cost || ap > rand )
                {
                    x1 = x1_new;
                    x2 = x2_new;
                    old_cost = new_cost;
                }
                i++;                
            }
            t0 = t0*alpha;
        }
        System.out.println("Nilai minimum dari X1 : "+ x1);
        System.out.println("Nilai minimum dari X2 : "+ x2);
        System.out.println("Nilai Minimu dari X1 dan X2 adalah : "+ old_cost);
       
    }
    
}
