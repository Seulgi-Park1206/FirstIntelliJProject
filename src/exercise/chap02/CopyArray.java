package exercise.chap02;

// 배열 b의 모든 요소를 배열 a에 복사하는 copy 메서드 작성
// 배열 b의 모든 요소를 배열 a에 역순으로 복사하는 rcopy 메서드 작성
// 배열 a, b의 요소 개수가 모두 같다고 가정하고 작성함.

class CopyArray {
    // 배열 b의 모든 요소를 배열 a에 복사하는 copy 메서드
    static void copy(int[] a, int[] b){
        for(int i = 0; i < b.length; i++){
            a[i] = b[i];
        }
    }

    // 배열 b의 모든 요소를 배열 a에 역순으로 복사하는 rcopy
    static void rcopy(int[] a, int[] b){
        for(int i = 0; i < b.length; i++){
            a[b.length-1-i] = b[i];
        }
    }

    static void printArr(int[] a){
        System.out.print("배열:");

        for(int j : a){
            System.out.print(" " + j);
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] x = {1, 4, 7, 8};
        int[] y = new int[x.length];


        System.out.print("y ");
        printArr(y);

        System.out.print("복사 대상 ");
        printArr(x);

        copy(y, x);
        System.out.print(">>> 복사 한 ");
        printArr(y);

        System.out.println();

        y = new int[x.length];
        System.out.print("y ");
        printArr(y);
        rcopy(y, x);
        System.out.print(">>> 역순 복사 한 ");
        printArr(y);

    }
}
