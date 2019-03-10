public class info {
    public static double getInfo(double p){
        double Thresthold = 1e-6;
       if(p < Thresthold)
           return 0.0;
        return -p*Math.log(p);
    }
    public static double entropy(double[] pArr)
    {
        double sum = 0.0;
        for (int i = 0;i < pArr.length;i++)
        {
            sum+=pArr[i];
        }
        for (int i = 0;i < pArr.length;i++)
        {
            pArr[i]/=sum;
        }
        double entropySum = 0.0;
        for (int i=0;i<pArr.length;i++)
        {
            entropySum += getInfo(pArr[i]);
        }
        return entropySum;
    }
    public static double conditionalEntropy(double[][] pArr,int y)
    {
        if(y>pArr[0].length||y<=0)
            return -1;
        double sum = 0.0;
        for(int i = 0;i<pArr.length;i++)
        {
            for (int j = 0;j<pArr[i].length;j++)
            {
                sum+=pArr[i][j];
            }
        }
        for(int i = 0;i<pArr.length;i++)
        {
            for (int j = 0;j<pArr[i].length;j++)
            {
                pArr[i][j]/=sum;
            }
        }
        double h = 0.0;
        double sum1 = 0.0;
        for(int i = 0;i<pArr.length;i++)
        {
            sum1+=pArr[i][y];
        }
        for(int i = 0;i<pArr.length;i++)
        {
            pArr[i][y]/=sum1;
        }
        for(int i = 0;i<pArr.length;i++)
            h += getInfo(pArr[i][y]);
        return h;
    }
    public static double mean_conditionalEntropy(double[][] pArr)
    {
        double arr[] = new double[pArr[0].length];
        for(int i = 0;i<pArr[0].length;i++)
        {
            double sum = 0.0;
            for(int j = 0;j<pArr.length;j++)
            {
                sum+=pArr[j][i];
                System.out.println("---"+pArr[j][i]);
            }
            arr[i] = sum;
            System.out.println(arr[i]);
        }
        double entropyMean = 0.0;
        for(int i = 0;i<pArr[0].length;i++)
        {
            entropyMean +=arr[i]*conditionalEntropy(pArr,i);
        }
        return entropyMean;
    }
    public static void main(String args[])
    {
        double a[] ={1.0/3.0,2.0/3.0};
        double b[][] = {{0.2,0.3},{0.1,0.4}};
//        System.out.println(conditionalEntropy(b,1));
        System.out.println(mean_conditionalEntropy(b));
        System.out.println(getInfo(0.5));
        System.out.println(entropy(a));
    }
}
