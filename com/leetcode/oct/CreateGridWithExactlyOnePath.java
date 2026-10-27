import java.util.Arrays;

/**
 * CreateGridWithExactlyOnePath
 */
public class CreateGridWithExactlyOnePath {
    public static void main(String[] args) {
        int m =2;
        int n = 3;
        String [] res = createGrid(m,n);
        for(String s:res)
            System.out.println(s+", ");
    }
    private static String [] createGrid(int m, int n){
        String [] res = new String[m];
        char [][] charArr = new char[m][n];
        //fill it with .
        for(char [] cArr:charArr)
            Arrays.fill(cArr, '#');
        //start traversing
        for(int j=0;j<n;j++){
            charArr[0][j] = '.';
        }
        for(int i=1;i<m;i++){
            charArr[i][n-1] = '.';
        }
        int k=0;
        for(int i=0;i<m;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                sb.append(charArr[i][j]);
            }
            res[k++] = sb.toString();
        }

        return res;
    }
}