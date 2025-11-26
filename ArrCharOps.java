public class ArrCharOps {

    public static void main(String[] args) {
        String str = "clearly";
        char[] arr1 = {'c','l','e','a','r','l','y'};
        char[] arr2 = {'U','n','d','e','r','s','t', 'o', 'o', 'd'};
        System.out.println(str);
        println(arr1);
        System.out.println(charAt(arr1,2));
        System.out.println(indexOf(arr1,'l'));
        System.out.println(indexOf(arr1,'l',3));
        System.out.println(lastIndexOf(arr1, 'l'));
        System.out.println(concat(arr1, arr2));
        System.out.println(subArray(arr2, 2, 9));
        System.out.println(compareTo("abcd", "abcd"));
        System.out.println(compareTo("abc", "abcd"));
        System.out.println(compareTo("abw", "abcd"));
        System.out.println(compareTo("Abcd", "a"));
        System.out.println(compareTo("apple", "banana"));
        System.out.println(compareTo("apple", "applepie"));
        System.out.println(compareTo("Zoo", "zoo"));
        System.out.println(hashCode(arr1));
        System.out.println(hashCode(arr2));
    }

    public static void println(char[] arr) {
        for (char c : arr) System.out.print(c);
        System.out.println();
    }

    public static char charAt(char[] arr, int index) {
        if (index < 0 || index >= arr.length) return 0;
        return arr[index];
    }

    public static boolean equals(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public static int indexOf(char[] arr, char ch) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ch) return i;
        }
        return -1;
    }

    public static int indexOf(char[] arr, char ch, int fromIndex) {
        if (fromIndex < 0) fromIndex = 0;
        for (int i = fromIndex; i < arr.length; i++) {
            if (arr[i] == ch) return i;
        }
        return -1;
    }

    public static int lastIndexOf(char[] arr, char ch) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == ch) return i;
        }
        return -1;
    }

    public static char[] concat(char[] arr1, char[] arr2) {
        char[] out = new char[arr1.length + arr2.length];

        for (int i = 0; i < arr1.length; i++)
            out[i] = arr1[i];

        for (int i = 0; i < arr2.length; i++)
            out[arr1.length + i] = arr2[i];

        return out;
    }

    public static char[] subArray(char[] arr, int beginIndex, int endIndex) {
        char[] sub = new char[endIndex - beginIndex];
        for (int i = 0; i < sub.length; i++)
            sub[i] = arr[beginIndex + i];
        return sub;
    }

    public static long hashCode(char[] arr) {
        if (arr.length == 0) return 0;

        long sum = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            sum += ((long) arr[i]) * pow7(n - 1 - i);
        }

        return sum;
    }

    private static long pow7(int exp) {
        long result = 1;
        for (int i = 0; i < exp; i++) {
            result *= 7;
        }
        return result;
    }

    public static int compareTo(String str1, String str2) {
        // حالة إدخال غلط (اختياري للهوموورك، مش مطلوب بالـtests)
        if (str1 == null || str2 == null || 
            str1.length() == 0 || str2.length() == 0) {
            return -2;
        }

        int n = Math.min(str1.length(), str2.length());

        for (int i = 0; i < n; i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if (c1 < c2) return -1;
            if (c1 > c2) return 1;
        }

        if (str1.length() < str2.length()) return -1;
        if (str1.length() > str2.length()) return 1;

        return 0; // هون الحالة الوحيدة المنطقية: نفس النص ونفس الطول
    }

}
