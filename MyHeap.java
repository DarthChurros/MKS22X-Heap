public class MyHeap {
  private static void swap(int[] data, int a, int b) {
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }

  private static void pushDown(int[] data, int size, int index) {
    boolean run = true;
    while (run && index < size) {
      if (2*index+2 < size) {
        if (data[index] >= data[2*index+1] && data[index] >= data[2*index+2]) {
          run = false;
        } else if (data[2*index+1] > data[2*index+2]){
          swap(data, index, 2*index+1);
          index = 2*index+1;
        } else {
          swap(data, index, 2*index+2);
          index = 2*index+2;
        }
      } else if (2*index+1 < size && data[index] < data[2*index+1]) {
        swap(data, index, 2*index+1);
        run = false;
      } else {
        run = false;
      }
    }
  }

  public static void heapify(int[] data) {
    for (int i = (int)Math.pow(2,Math.log(data.length)/Math.log(2)); i >= 0; i--) {
      //System.out.println("pushing down data["+i+"]");
      pushDown(data, data.length, i);
    }
  }

  public static void heapsort(int[] data) {
    heapify(data);
    for (int i = data.length-1; i >= 0; i--) {
      swap(data, 0, i);
      pushDown(data, i, 0);
    }
  }

  public static void main(String[] args) {
    int size = 15;
    int[] test = new int[size];
    for (int i = 0; i < size; i++) test[i] = (int)(Math.random()*9);
    HeapPrinter.print(test);
    heapsort(test);
    HeapPrinter.print(test);
  }
}
