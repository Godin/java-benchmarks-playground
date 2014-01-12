package benchmarks;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ListIterationBenchmarkTest {

  public final ListIterationBenchmark benchmark = new ListIterationBenchmark();

  @Test
  public void test() {
    benchmark.setup();

    assertThat(benchmark.arrayIndexed()).isNotEqualTo(0);
    assertThat(benchmark.arrayIndexedLength()).isNotEqualTo(0);
    assertThat(benchmark.arrayFor()).isNotEqualTo(0);

    assertThat(benchmark.arrayListIndexed()).isNotEqualTo(0);
    assertThat(benchmark.arrayListIndexedLength()).isNotEqualTo(0);
    assertThat(benchmark.arrayListFor()).isNotEqualTo(0);

    assertThat(benchmark.linkedListFor()).isNotEqualTo(0);
  }

}
