//package pers.dlx.offer;
//
//import edu.princeton.cs.algs4.StdOut;
//
//public class TwoDimensionSearch {
//
//    public static boolean Find(int target, int [][] array) {
//        int i = 0;
//        int j = array[0].length - 1;
//
//        while (i < array.length && j >= 0) {
//            int cmp = target - array[i][j];
//            if (cmp < 0) {
//                j--;
//            } else if (cmp > 0) {
//                i++;
//            } else {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        int[][] array = {
//                {0, 1, 2, 5},
//                {2, 3, 4, 7},
//                {4, 4, 4, 8},
//                {5, 7, 7, 9}
//        };
//
//        assert Find(3, array) == true;
//        assert Find(0, array) == true;
//        assert Find(1, array) == true;
//        assert Find(2, array) == true;
//        assert Find(5, array) == true;
//        assert Find(10, array) == false;
//
////        int[][] array = {
////                {1, 2, 8, 9},
////                {4, 7, 10, 13}
////        };
////
////        if (Find(7, array) != true) throw new AssertionError();
//    }
//}
