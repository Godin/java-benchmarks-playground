package benchmarks;

import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.State;

import java.util.HashSet;
import java.util.Set;

@State
public class CollectionsBenchmark {

  private int n = Integer.getInteger("n", 42);

  @GenerateMicroBenchmark
  public boolean my_add() {
    boolean result = true;
    Set<Integer> set = new MySet<Integer>();
    for (int i = 0; i < n; i++) {
      result &= set.add(i);
    }
    return result;
  }

  @GenerateMicroBenchmark
  public boolean hashSet_add() {
    boolean result = true;
    Set<Integer > set = new HashSet<Integer>();
    for (int i = 0; i < n; i++) {
      result &= set.add(i);
    }
    return result;
  }

}
