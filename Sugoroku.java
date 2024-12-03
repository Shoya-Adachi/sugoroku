import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

class Sugoroku {
    private String location;
    private int ToGoal = 30; 
    private int Count;
    public int sum;
    public boolean Goal;

    BufferedReader br = new BufferedReader(
                                new InputStreamReader( System.in ) );
    StringBuilder sb;
    Random RandObj = new Random();

    public void Init() {
        ToGoal = 30; 
        Goal = false;
        Count = 0;
        sum = 0;
        location = "|_____________________________";
    }

    public void Start() throws IOException{
        System.out.println(location + "|上がり!");
        System.out.println("残り" + ToGoal + "マスです。サイコロの数は？");

        this.Count = Integer.parseInt(br.readLine());
    }

    public void Calculation() { 
        for (int i = 0; i < this.Count; i++){
            this.sum += (RandObj.nextInt(3) + 1 ); 
        }
        if (this.sum > 30) {
            this.sum = 30 - (this.sum -30);
        }

        this.ToGoal = 30 - (this.sum);

        sb = new StringBuilder();

        for (int j = 0; j < 30; j++) {
            if (j == this.sum){
                sb.append("|");
            } else {
                sb.append("_");
            }
        }
        
        this.location = sb.toString();
        
    }

    public boolean CheckGoal(int count) {
        if (this.ToGoal == 0) {
            this.Goal = true;
            System.out.println("おめでとう!" + count + "回目で上がりです");
        }

        return this.Goal;
    }
}
