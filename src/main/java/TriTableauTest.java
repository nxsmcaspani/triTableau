import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

public class TriTableauTest {
    @Test
    public void triTest1(){
        int[] list1 = new int[]{1, 5, 8, 10, 11, 5, 8, 3 };
        TriTableau tab1 = new TriTableau(list1);
//        System.out.println("Tab1 min value is: "+tab1.getMinVal());
//        System.out.println("Tab2 max value is: "+tab1.getMaxVal());
        tab1.compress();
        System.out.println(Arrays.toString(tab1.getCompressedTab()));
        tab1.sorted();
        Assert.assertArrayEquals(new int[]{1, 3, 5, 5, 8, 8, 10, 11}, tab1.getSortedTab());
    }

    @Test
    public void triTest2() {
        int[] list2 = new int[]{6, 15, 18, 11, 11, 8, 12, 13, 25, 44, 32, 21};
        TriTableau tab2 = new TriTableau(list2);
//        System.out.println("Tab1 min value is: " + tab2.getMinVal());
//        System.out.println("Tab2 max value is: " + tab2.getMaxVal());
        tab2.compress();
        System.out.println(Arrays.toString(tab2.getCompressedTab()));
        tab2.sorted();
//        System.out.println(Arrays.toString(tab2.getSortedTab()));
        Assert.assertArrayEquals(new int[]{6, 8, 11, 11, 12, 13, 15, 18, 21, 25, 32, 44}, tab2.getSortedTab());
    }

    @Test
    public void triTest3() {
        int[] list3 = new int[]{1, 96, 3, 65, 15, 2};
        TriTableau tab3 = new TriTableau(list3);
//        System.out.println("Tab1 min value is: " + tab2.getMinVal());
//        System.out.println("Tab2 max value is: " + tab2.getMaxVal());
        tab3.compress();
        System.out.println(Arrays.toString(tab3.getCompressedTab()));
        tab3.sorted();
//        System.out.println(Arrays.toString(tab2.getSortedTab()));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 15, 65, 96}, tab3.getSortedTab());
    }

    @Test
    public void triTest4() {
        int[] list4 = new int[]{15, 11, 12, 9, 8, 6, 4, 2, 1, 0};
        TriTableau tab4 = new TriTableau(list4);
//        System.out.println("Tab1 min value is: " + tab2.getMinVal());
//        System.out.println("Tab2 max value is: " + tab2.getMaxVal());
        tab4.compress();
        System.out.println(Arrays.toString(tab4.getCompressedTab()));
        tab4.sorted();
//        System.out.println(Arrays.toString(tab2.getSortedTab()));
        Assert.assertArrayEquals(new int[]{0,1,2,4,6,8,9,11,12,15}, tab4.getSortedTab());
    }
}
