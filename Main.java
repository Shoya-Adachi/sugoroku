import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

     
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(
                                new InputStreamReader( System.in ) );
        Sugoroku sugoroku = new Sugoroku();
        int Count = 0;
        boolean roop = true;

        System.out.println("△ すごろく△");
        System.out.println("30マス先にゴールがあります。");
        System.out.println("1,2,3の3つの目を持つ特別なサイコロ10個を、好きな数だけ振って駒を進めます。");
        System.out.println("ぴったり上がりに止まれば終わりです。\n目の数が多ければ、余った目の数だけ戻ります。");
        System.out.println("---------------------------------");
    
        while(roop) {
            sugoroku.Init();

            while (!sugoroku.Goal) {
                Count++;

                sugoroku.Start();
                sugoroku.Calculation();
                sugoroku.CheckGoal(Count);
            }

            System.out.println("もう一度やりますか？（1=Yes; 0=No!）");
            int res = Integer.parseInt(br.readLine());

            if (res == 0) {
                roop = false;
            }
        }
        
        
    }
}