//3370. Smallest Number With All Set Bits

class Solution3 {
    public int smallestNumber(int num) {
        // String bitsStr = Integer.toBinaryString(num);
        // int bits = Integer.parseInt(bitsStr);
        // int ans = 0;
        // while(bits>0){
        //     int a = bits&1;
        //     if(a == 0){
        //         a = 1;
        //     }
        //     ans = ans*10 + a;
        //     bits/=10;
        // }

        // int result = 0;
        // int base = 1;
        // while(ans != 0){
        //     int digit = ans%10;
        //     result += base * digit;
        //     base = base * 2;
        //     ans/=10;
        // }
        // return result;


        // other appraoch;
        // int ans = 0;
        // int n = Integer.toBinaryString(num).length();
        // int result = 0;
        // int base = 1;
        // while(n != 0){
        //     result += base * 1;
        //     base = base * 2;
        //     n--;
        // }
        // return result;


        // other
        // int n = Integer.toBinaryString(num).length();
        // return (1<<n) - 1;


        // other: most optimal approach
        int x = num;
        while((x&(x+1)) != 0){
            x++;
        }
        return x;
    }
}