import java.util.Arrays;

public class TriTableau {
    private int minVal;
    private int maxVal;
    private int[] unsortedTab;
    private int[] compressedTab;
    private int[] sortedTab;

    public int getMinVal() { return this.minVal; }
    public int getMaxVal() { return this.maxVal; }
    public int[] getUnsortedTab() { return this.unsortedTab; }
    public int[] getCompressedTab() { return compressedTab; }
    public int[] getSortedTab() { return sortedTab; }

    public TriTableau(int[] unsortedTab) {
        this.unsortedTab = unsortedTab;
        getExtremeVals();
    }

    private void getExtremeVals(){
        this.minVal = unsortedTab[0];
        this.maxVal= unsortedTab[0];
        for(int i=0; i<unsortedTab.length; i++){
            if(unsortedTab[i] < this.minVal) this.minVal = unsortedTab[i];
            if(unsortedTab[i] > this.maxVal) this.maxVal = unsortedTab[i];
        }
    }

    public void compress(){
        this.compressedTab = new int[this.maxVal-this.minVal+1];
        for(int i=0; i<this.compressedTab.length; i++){
            this.compressedTab[i] = getAmountOfInt(this.getMinVal()+i);
        }
    }

    private int getAmountOfInt(int val){
        int amount = 0;
        for (int i=0; i < this.unsortedTab.length; i++){
            if(this.unsortedTab[i] == val) amount+=1;
        }
        return amount;
    }

    public void sorted(){
        this.sortedTab = new int[this.unsortedTab.length];
        int position = 0;
        for(int i=0; i<this.compressedTab.length; i++){
            int amount=0;
            if(this.compressedTab[i] != 0) {
                while(amount < this.compressedTab[i]) {
                    this.sortedTab[position] = (this.getMinVal() + i);
                    position++;
                    amount++;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] list1 = new int[]{1, 5, 8, 10, 11, 5, 8, 3 };
        TriTableau tab1 = new TriTableau(list1);
        System.out.println("Tab1 min value is: "+tab1.getMinVal());
        System.out.println("Tab2 max value is: "+tab1.getMaxVal());
        tab1.compress();
        System.out.println(Arrays.toString(tab1.getCompressedTab()));
        tab1.sorted();
        System.out.println(Arrays.toString(tab1.getSortedTab()));

        int[] list2 = new int[]{6, 15, 18, 11, 11, 8, 12, 13, 25, 44, 32, 21 };
        TriTableau tab2 = new TriTableau(list2);
        System.out.println("Tab1 min value is: "+tab2.getMinVal());
        System.out.println("Tab2 max value is: "+tab2.getMaxVal());
        tab2.compress();
        System.out.println(Arrays.toString(tab2.getCompressedTab()));
        tab2.sorted();
        System.out.println(Arrays.toString(tab2.getSortedTab()));
    }
}
