import java.io.IOException;

/**
 * Created by V on 22.03.2017.
 */
 class SpeedInput

{
    private static int readIntNext(int num, int deciman) throws IOException {
        int temp = System.in.read();

        num*=deciman;

        if (temp >= 47 && temp <= 58){
            System.out.println("nul");
            num = num+readIntNext(temp^0b110000, deciman*10);
        }
        else
            return num;
        return  num;
    }


    static int readInt() throws IOException {

        int num = System.in.read();
        while (num <= 47 && num <= 58 )
        {
            num = System.in.read();
        }

        num^= 0b110000;

        int temp = System.in.read();
        final int decimal = 10  ;
        if (temp >= 47 && temp <= 58){
            num+= readIntNext(temp^0b110000, decimal );
            return revers(num);
        }
        else return  revers(num);


    }

    private static  int revers (int n)
    {
        return  recursionNext(n,0);
    }

    private static int recursionNext(int n, int i) {
        return (n==0) ?  i : recursionNext( n/10, i*10 + n%10 );
    }
}

