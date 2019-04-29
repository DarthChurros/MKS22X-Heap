public class MyHeap {
  private static void swap(int[] data, int a, int b) {
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }

  private static void pushDown(int[] data, int size, int index) {
    boolean run = true;
    while (run && index < size) {
      if (data[index] >= data[2*index+1] && data[index] < data[2*index+2]) {
        swap(data, index, 2*index+2);
        index = 2*index+2;
        run = false;
      } else if (data[index] > data[2*index+1] && data[index] >= data[2*index+1]){
        swap(data, index, 2*index+1);
        index = 2*index+1;
        run = false;
      }
    }
  }
}
