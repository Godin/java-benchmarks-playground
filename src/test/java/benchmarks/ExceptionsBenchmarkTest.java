package benchmarks;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ExceptionsBenchmarkTest {

  @Test
  public void test() {
    ExceptionsBenchmark benchmark = new ExceptionsBenchmark();
    benchmark.baseline();
    assertThat(benchmark.exception()).isNotEqualTo(0);
    assertThat(benchmark.static_exception()).isNotEqualTo(0);
  }

}
