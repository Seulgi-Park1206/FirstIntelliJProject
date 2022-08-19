package exercise.chap02;
import java.util.Random;

// 사람의 수 와 키를 난수로 생성하시오.

class MaxOfArrayRand {
    // 배열의 최댓값을 구해 반환
    static int maxOf(int[] a){
        int max = a[0];

        for (int j : a) {
            if (j > max)
                max = j;
        }

        return max;
    }

    public static void main(String[] args){
        Random rand = new Random();

        System.out.println("키의 최댓값을 구합니다.");
        int num = rand.nextInt(10);
        System.out.println("사람 수: " + num);

        int[] height = new int[num];

        System.out.println("키의 값은 아래와 같습니다.");

        for(int i = 0; i < num; i++){
            height[i] = 100 + rand.nextInt(90); // 요소의 값을 난수로 생성
            System.out.println("height[" + i + "]: " + height[i]);
        }

        System.out.println("최댓값은 " + maxOf(height) + "입니다.");
    }
}
