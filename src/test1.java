import java.util.Stack;

public class test1 {

    public static void main(String[] args) {
        largestRectangleArea(new int[]{2,1,5,6,2,3});
    }
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[heights.length+2];
        for(int i=0;i<heights.length;i++){
            arr[i+1]=heights[i];
        }
        stack.push(0);
        int max=0;
        int h=0;
        int wid=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[stack.peek()]){
                h=arr[stack.pop()];
                wid=i-stack.peek()-1;
                stack.push(i);
                max=Math.max(max,wid*h);
            }
        }
        return max;
    }
}
