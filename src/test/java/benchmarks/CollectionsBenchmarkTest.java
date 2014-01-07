package benchmarks;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class CollectionsBenchmarkTest {

  private final CollectionsBenchmark benchmark = new CollectionsBenchmark();

  @Test
  public void test() {
    assertThat(benchmark.my_add()).isTrue();
    assertThat(benchmark.hashSet_add()).isTrue();
  }

}
