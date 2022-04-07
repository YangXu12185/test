import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main22 {
    static int endR;
    static int endC;
    static int m;
    static int n;
    static List<Integer> res= new ArrayList<>();
    static int[][] lakecoor;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m=sc.nextInt();
        n=sc.nextInt();
        int startR = sc.nextInt();
        int startC =sc.nextInt();
        int lakeNums = sc.nextInt();

        boolean[][] visit = new boolean[m][n];

        lakecoor=new int[lakeNums][2];
        for (int i = 0; i < lakeNums; i++) {
            lakecoor[i][0] =sc.nextInt();
            lakecoor[i][1] =sc.nextInt();


        }

        dfs(startR,startC,0,visit);
        int min =Integer.MIN_VALUE;
        for (int i = 0; i < res.size(); i++) {
            min=Math.min(min,res.get(i));

        }
        int count = 0;
        for (int i = 0; i < res.size(); i++) {
            if(res.get(i)==min){
                count++;
            }
        }
        System.out.println(count+""+min);
    }

    public static void dfs(int i,int j,int length,boolean[][] visted){
        if(i<0||i>=m||j<0||j>=n){
            return;
        }
        for (int k = 0; k < lakecoor.length; k++) {
            if(lakecoor[k][0]==i&&lakecoor[k][1]==j){
                return;
            }

        }
        if(i==endR&&j==endC){
            res.add(length);
        }
        visted[i][j]=true;
        dfs(i+1,j,length+1,visted);
        dfs(i-1,j,length+1,visted);
        dfs(i,j-1,length+1,visted);
        dfs(i,j+1,length+1,visted);
        visted[i][j]=false;
    }

}
