package exercise.chap02;

import java.util.Scanner;

class YMD {
    int y;
    int m;
    int d;
    static int[][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},		// 평년
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},		// 윤년
    };

    //--- year 년은 윤년인가?(윤년 : 1/평년 : 0) ---//
    static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }

    YMD(int y, int m, int d){
        this.y = y;
        this.m = m;
        this.d = d;
    }

    // n일 뒤의 날짜를 반환
    YMD after(int n){
        YMD tmp = new YMD(this.y, this.m, this.d);
        if(n < 0)
            return before(-n);

        tmp.d += n;

        while(tmp.d > mdays[isLeap(tmp.y)][tmp.m-1]){
            tmp.d -= mdays[isLeap(tmp.y)][tmp.m-1];
            if(++tmp.m > 12) {
                tmp.y++;
                tmp.m = 1;
            }
        }
        return tmp;
    }

    // n일 앞의 날짜를 반환
    YMD before(int n){
        YMD tmp = new YMD(this.y, this.m, this.d);
        if (n < 0)
            return after(-n);

        tmp.d -= n;

        while(tmp.d < 1){
            if(--tmp.m < 1){
                tmp.y--;
                tmp.m = 12;
            }
            tmp.d += mdays[isLeap(tmp.y)][tmp.m-1];
        }
        return tmp;
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.print("날짜를 입력하세요.\n");
        System.out.print("년 : "); int y = stdIn.nextInt();
        System.out.print("월 : "); int m = stdIn.nextInt();
        System.out.print("일 : "); int d = stdIn.nextInt();

        YMD date = new YMD(y, m, d);

        System.out.print("며칠 전/후의 날짜를 구할까요? : ");
        int n = stdIn.nextInt();

        YMD d1 = date.after(n);
        System.out.printf("%d일 후의 날짜는 %d년%d월%d일입니다. \n", n, d1.y, d1.m, d1.d);

        YMD d2 = date.before(n);
        System.out.printf("%d일 전의 날짜는 %d년%d월%d일입니다. \n", n, d2.y, d2.m, d2.d);

    }
}
