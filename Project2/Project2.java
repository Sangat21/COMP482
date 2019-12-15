import java.util.*;
import java.io.*;

class Project2{

  public static void QSort(int[] arr, int start, int end)
  {
      int partition = partition(arr, start, end);

      if((partition - 1) > start)
      {
          QSort(arr, start, partition - 1);
      }
      if((partition + 1) < end)
      {
          QSort(arr, partition + 1, end);
      }
  }

  public static int partition(int[] arr, int start, int end)
  {
      int pivot = arr[end];

      for(int i = start; i < end; i++)
      {
          if(arr[i]<pivot)
          {
              int temp= arr[start];

              arr[start]=arr[i];
              arr[i]=temp;

              start++;

          }
      }

      int temp = arr[start];

      arr[start] = pivot;
      arr[end] = temp;

      return start;
  }

  public int ithItem(int i, int N, int[] data)
  {
    //System.out.println("in");
    int answer, mom, j=0, k=0, l;
    int[] medians, smaller, larger;

    if (N < 6)
    {
      //System.out.println(Arrays.toString(data));
      //System.out.println("N: " + N + "   is small");
      Arrays.sort(data, 0, N);
      //System.out.println(Arrays.toString(data));
      answer =  data[i];
      //System.out.println("i: " + i + "th element: " + answer);
    }
    else
    {
      //System.out.println("N: " + N + "   is big");
      medians = new int[N/5];
      smaller = new int[N];
      larger = new int[N];

      for (l=0; l < N/5; l++)
      {
        int [] temp = new int[5];
        for(int x = 0; x < 5; x++) {
          temp[x] = data[(l*5)+x];
        }
        //for(int x = 0; x < 5; x++)
        //{
          //System.out.println("Finding median[" + l + "]");
          medians[l] = ithItem(5/2,  5, temp);
          //System.out.println("medians["+l+"]: "+ medians[l]);
        //}

      }
      //System.out.println("Finding mom");
      //j = 0;
      mom = ithItem(N/10,N/5,medians);
      //System.out.println("mom: " + mom);

      j = 0;
      k = 0;
      for (l=0; l<N; l++)
      {
        if (data[l] < mom)
          smaller[j++] = data[l];
        else
          larger[k++] = data[l];
      }



      for(int d = 0; d < j; d++){
        //System.out.println("smaller[" + d + "]: " + smaller[d] + "   ");
      }

      for(int d = 0; d < k; d++){
      //System.out.println("larger[" + d + "]: " + larger[d] + "   ");
      }

      if (i<j) {
      //System.out.println("i is smaller than j: " + i + "<" + j);
        answer = ithItem(i, j, smaller);
      }
      else {
      //System.out.println("i is NOT smaller than j: " + i + ">=" + j);
        answer = ithItem(i-j, k, larger);
      }
    }
    //System.out.println("out");
    return answer;
}

  //public int median(int k)

  public static void main(String[] args) throws FileNotFoundException {

    // Declare file and scanner to read file
    File file = new File("input2.txt");
    Scanner sc = new Scanner(file);

    int ithSmallest = -1;
    int size = -1;

    // Read Input
    if (sc.hasNextLine()){

      // Read the ithSmallest number
      ithSmallest = Integer.parseInt(sc.next());

      // Read size of array
      size = Integer.parseInt(sc.next());
    }

    int [] MahArr = new int[size];

    // Read all numbers and input in Array(int): pairs
    for(int i = 0; i < size; i++)
    {
      if(sc.hasNextLine()) // check if next line exists
      {
        MahArr[i] = Integer.parseInt(sc.next());

      } else {
        System.out.println("Not enough Inputs!"); }
    }

    // Input is Correct
    /*
    System.out.println("ith Smallest: " + ithSmallest);
    System.out.println("size: " + size);
    for(int i = 0; i < size; i++){
      System.out.println("MahArr[" + i + "]: " + MahArr[i]);
    }
    */

    // Do Regular Sort
    int [] sortArr = MahArr;
    Arrays.sort(sortArr);
    System.out.println("Sort Finds " + sortArr[ithSmallest]);

    // Do Quick Sort
    int [] qSortArr = MahArr;
    Project2 quick = new Project2();
    quick.QSort(qSortArr, 0, (size-1));
    System.out.println("Quick Sort Finds " + qSortArr[ithSmallest]);

    // Do Median of Medians
    int [] mSortArr = MahArr;
    Project2 median = new Project2();
    int x = median.ithItem(ithSmallest, size, mSortArr);
    System.out.println("MOM Finds " + x);


  }
}
