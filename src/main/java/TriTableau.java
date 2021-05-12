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

//    public static void main(String[] args){
//
//    }
}
