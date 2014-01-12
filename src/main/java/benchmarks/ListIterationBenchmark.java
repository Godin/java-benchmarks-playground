package benchmarks;

import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@State(Scope.Thread)
public class ListIterationBenchmark {

  private int size;
  private Integer[] array;
  private List<Integer> arrayList;
  private List<Integer> linkedList;

  @Setup
  public void setup() {
    size = Integer.getInteger("n", 4096);
    array = new Integer[size];
    arrayList = new ArrayList<Integer>(size);
    linkedList = new LinkedList<Integer>();

    for (int i = 0; i < size; i++) {
      Integer value = new Integer(i * 100);
      array[i] = value;
      arrayList.add(value);
      linkedList.add(value);
    }
  }

  @GenerateMicroBenchmark
  public int arrayIndexed() {
    int sum = 0;
    for (int i = 0; i < size; i++) {
      sum += array[i].hashCode();
    }
    return sum;
  }

  @GenerateMicroBenchmark
  public int arrayIndexedLength() {
    int sum = 0;
    for (int i = 0; i < array.length; i++) {
      sum += array[i].hashCode();
    }
    return sum;
  }

  @GenerateMicroBenchmark
  public int arrayFor() {
    int sum = 0;
    for (Object value : array) {
      sum += value.hashCode();
    }
    return sum;
  }

  @GenerateMicroBenchmark
  public int arrayListIndexed() {
    int sum = 0;
    for (int i = 0; i < size; i++) {
      sum += arrayList.get(i).hashCode();
    }
    return sum;
  }

  @GenerateMicroBenchmark
  public int arrayListIndexedLength() {
    int sum = 0;
    for (int i = 0; i < arrayList.size(); i++) {
      sum += arrayList.get(i).hashCode();
    }
    return sum;
  }

  @GenerateMicroBenchmark
  public int arrayListFor() {
    int sum = 0;
    for (Object value : arrayList) {
      sum += value.hashCode();
    }
    return sum;
  }

  @GenerateMicroBenchmark
  public int linkedListFor() {
    int sum = 0;
    for (Object value : linkedList) {
      sum += value.hashCode();
    }
    return sum;
  }

}
