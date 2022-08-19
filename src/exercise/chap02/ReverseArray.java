package exercise.chap02;

// 배열을 역순하는 과정을 출력하고, 그 배열의 모든 요소의 합계를 구하는 메서드 작성.

class ReverseArray {
    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void reverse(int[] a){
        for(int i = 0; i < a.length / 2; i++){
            swap(a, i, a.length - 1 - i);
        }
    }

    static int sumOf(int[] a){
        int sum = 0;

        for(int i : a){
            sum += i;
        }

        return sum;
    }

    static void printArray(int[] a){
        System.out.print("배열 :");
        for (int j : a) {
            System.out.print(" " + j);
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] x = {1, 2, 3, 4, 5};
        System.out.print("역순정렬 전 ");
        printArray(x);

        reverse(x);

        System.out.print("역순정렬 후 ");
        printArray(x);

        System.out.println("배열의 요소 합: " + sumOf(x));
    }
}
