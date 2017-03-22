import java.io.IOException;

/**
 * Created by V on 22.03.2017.
 */
class SpeedInput
{


    private static byte nul=0;

    private static byte setNulDec()
    {
        return SpeedInput.nul--;
    }

    private static byte setNul()
    {
        return ++SpeedInput.nul;
    }

    static void getNul() //debug
    {
        System.out.println(nul);
    }

    private static int readIntNext(int num, int decimal) throws IOException {
        int temp = System.in.read();

        num*=decimal;
        if (num==0)
            setNul();

        if (temp >= 48 && temp <= 58){

            num = num+readIntNext(temp^0b110000, decimal*10);
        }
        else
            return num;
        return  num;
    }


    protected static int readInt() throws IOException {


        int num = System.in.read();
        while (num <= 48 && num <= 58 )
        {
            num = System.in.read();
        }

        num^= 0b110000;

        int temp = System.in.read();
        final int decimal = 10  ;
        if (temp >= 48 && temp <= 58){
            num+= readIntNext(temp^0b110000, decimal );
            return revers(num);
        }
        else return  revers(num);


    }

    private static  int revers (int n)
    {

        if  (SpeedInput.nul != 0 )
        {
            int temp = 1;
            while (SpeedInput.nul !=0){
                temp*=10;
                setNulDec();
            }
            return recursionNext(n, 0)*temp;
        }
        else return recursionNext(n,0);

    }

    private static int recursionNext(int n, int i) {
        return (n==0) ?  i : recursionNext( n/10, i*10 + n%10 );
    }
}

