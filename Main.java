public class Main {
    public static void main(String[] args) {
        final int MAX = 1000000000;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<1000000; i+=10) {
            int money = (int) (Math.random()*MAX);
            int minratio = (int) (Math.random()*100);
            int maxratio = (int) (Math.random()*(100-minratio+1))+minratio;
            int ranksize = (int) (Math.random()*MAX)+1;
            int threshold = (int) (Math.random()*MAX);
            int months = (int) (Math.random()*360) + 1;

            SolutionRight solutionRight = new SolutionRight();
            SolutionWrong solutionWrong = new SolutionWrong();

            if(solutionWrong.solution(money,minratio,maxratio,ranksize,threshold,months)
                != solutionRight.solution(money,minratio,maxratio,ranksize,threshold,months))
                sb.append(String.format("**%d,%d,%d,%d,%d,%d\n",money,minratio,maxratio,ranksize,threshold,months));
            else sb.insert(0,String.format("%d,%d,%d,%d,%d,%d\n",money,minratio,maxratio,ranksize,threshold,months));
        }
        System.out.println(sb.toString());
    }
}

class SolutionWrong {
    public int solution(int money, int minratio, int maxratio, int ranksize, int threshold, int months) {
        for(int m=0;m<months;m++) {
            int aprxMoney = money-money%100;
            if(aprxMoney<threshold) break;
            int ratio = calculateRatio(money, minratio, maxratio, ranksize, threshold);
            int tax = (aprxMoney/100)*ratio;
            money-=tax;
        }

        return money;
    }

    public int calculateRatio(int money, int minratio, int maxratio, int ranksize, int threshold) {
        int i=1;
        for(;i<maxratio-minratio+1;i++) {
            if(money<threshold+i*ranksize) break;
        }
        return minratio+i-1;
    }
}

class SolutionRight {
    public int solution(int money, int minratio, int maxratio, int ranksize, int threshold, int months) {
        for(int m=0;m<months;m++) {
            int aprxMoney = money-money%100;
            if(aprxMoney<threshold) break;
            int ratio = minratio + (aprxMoney-threshold)/ranksize;
            if(ratio>maxratio) ratio=maxratio;
            int tax = (aprxMoney/100)*ratio;
            money-=tax;
        }

        return money;
    }
}