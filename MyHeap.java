public class MyHeap {
  private static void swap(int[] data, int a, int b) {
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }

  private static void pushDown(int[] data, int size, int index) {
    boolean run = true;
    while (run && index < size) {
      try {
        if (data[index] >= data[2*index+1] && data[index] >= data[2*index+2]) {
          run = false;
        } else if (data[2*index+1] > data[2*index+2]){
          swap(data, index, 2*index+1);
          index = 2*index+1;
        } else {
          swap(data, index, 2*index+2);
          index = 2*index+2;
        }
      } catch (IndexOutOfBoundsException e) {
        try {
          swap(data, index, 2*index+1);
        } catch (IndexOutOfBoundsException f) {}
        run = false;
      }
    }
  }

  public static void heapify(int[] data) {
    for (int i = (int)(Math.log(data.length)/Math.log(2)); i >= 0; i--) {
      pushDown(data, data.length, i);
    }
  }

  public static void main(String[] args) {
    int[] test = new int[]{1, 2, 3, 4, 5, 6, 7};
    HeapPrinter.print(test);
    pushDown(test, 7, 0);
    HeapPrinter.print(test);
  }
}
