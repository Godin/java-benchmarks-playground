package benchmarks;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.logic.BlackHole;

import java.util.concurrent.TimeUnit;

/**
 * Benchmarks cost of throwing an exception.
 */
@Warmup(iterations = 5, timeUnit = TimeUnit.SECONDS, time = 3)
@Measurement(iterations = 10, timeUnit = TimeUnit.SECONDS, time = 3)
@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class Exceptions {

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
