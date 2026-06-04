class TotalWavinessOfNumbersInRangeI{
 public int totalWaviness(int num1, int num2) {
        int sum =0;
        while(num1<=num2){
            String s = num1+"";
            int n = s.length();
            int index = 0;
            while(index < n-2){
                char ch1 = s.charAt(index);
                char ch2 = s.charAt(index+1);
                char ch3 = s.charAt(index+2);
                //check for peak
                if(ch1<ch2 && ch3<ch2)sum +=1;
                //check for valley
                if(ch1>ch2 && ch3>ch2)sum +=1;
                index++;
            }
            num1++;
        }
        return sum;
    }
}
