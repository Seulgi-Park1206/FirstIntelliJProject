package exercise.chap02;

import java.util.Scanner;

// 그 해의 경과 일수 및 남은 일수 구하기

class DayOfYear {
    static int[][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, // 평년
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, // 윤년
    };

    static int isLeap(int year){
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }

    static int dayOfYear(int y, int m, int d){
        // 1. for 문 사용(days, i 사용)
        /*
        int days = d;

        for(int i = 1; i < m; i++){
            days += mdays[isLeap(y)][i-1];
        }
        return days;
        */

        // 2. days, i 없이 while 문으로 구현
        while(m > 1){
            d += mdays[isLeap(y)][--m];

        }
        return d;
    }

    // y년 m월 d일의 그 해 남은 일 수(12월 31일이면 0, 12월 30일이면 1)를 구하는 메서드
    static int leftDayOfYear(int y, int m, int d){
        int leftDay = 0;

        for(int i = m; i < 13; i++){
            leftDay += mdays[isLeap(y)][i-1];

            if(i == m)
                leftDay -= d;
        }
        return leftDay;
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        String[] ymd;
        int year, month, day;
        System.out.println("그 해 경과 일수를 구합니다.");

        do {
            System.out.print("년/월/일: ");
            ymd = stdIn.next().split("/");
            year = Integer.parseInt(ymd[0]);
            month = Integer.parseInt(ymd[1]);
            day = Integer.parseInt(ymd[2]);
        } while(ymd.length != 3);

        System.out.printf("그 해 %d일째입니다. \n", dayOfYear(year, month, day));
        System.out.printf("그 해의 남은 일수는 %d일입니다.\n", leftDayOfYear(year, month,day));
    }

}
