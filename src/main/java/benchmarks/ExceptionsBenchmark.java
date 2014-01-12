package benchmarks;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.logic.BlackHole;

import java.util.concurrent.TimeUnit;

/**
 * Benchmarks cost of exceptions.
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class ExceptionsBenchmark {

  private static final MyException EXCEPTION = new MyException();

  private static class MyException extends Exception {
  }

  @GenerateMicroBenchmark
  public void baseline() {
    BlackHole.consumeCPU(1);
  }

  @GenerateMicroBenchmark
  public int exception() {
    try {
      BlackHole.consumeCPU(1);
      throw new MyException();
    } catch (MyException e) {
      return e.hashCode();
    }
  }

  @GenerateMicroBenchmark
  public int static_exception() {
    try {
      BlackHole.consumeCPU(1);
      throw EXCEPTION;
    } catch (MyException e) {
      return e.hashCode();
    }
  }

}
