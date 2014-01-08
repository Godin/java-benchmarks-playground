package benchmarks;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ExceptionsTest {

  @Test
  public void test() {
    Exceptions benchmark = new Exceptions();
    benchmark.baseline();
    assertThat(benchmark.exception()).isNotEqualTo(0);
    assertThat(benchmark.static_exception()).isNotEqualTo(0);
  }

}
