public class GradeTracker{

    static double[] cutoffs = {90, 80, 70, 60};
    static char[] letters = {'A','B','C','D',};

    static char letterFor(double grade) {
        for (int i = 0; i < cutoffs.length; i++) {
            if (grade >= cutoffs[i])  return letters[i];
        }
        return 'F';
    }
    public static void main(String[] args) {
        System.out.println(letterFor(95));
        System.out.println(letterFor(72));
        System.out.println(letterFor(50));
    }

}
