package benchmarks;

import org.junit.Test;

public class ExceptionsTest {

  @Test
  public void test() {
    Exceptions benchmark = new Exceptions();
    benchmark.baseline();
    benchmark.exception();
    benchmark.static_exception();
  }

}
