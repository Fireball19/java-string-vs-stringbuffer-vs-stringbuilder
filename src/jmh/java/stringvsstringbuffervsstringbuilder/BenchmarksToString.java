package stringvsstringbuffervsstringbuilder;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(value = 1)
@Warmup(iterations = 5000, timeUnit = TimeUnit.NANOSECONDS, time = 5000)
@Measurement(iterations = 5000, timeUnit = TimeUnit.NANOSECONDS, time = 5000)
public class BenchmarksToString {
  StringBuilder stringBuilder = new StringBuilder("abc");
  StringBuffer stringBuffer = new StringBuffer("abc");
  String string = "abc";

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  public String stringBuilder() {
    return stringBuilder.toString();
  }

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  public String stringBuffer() {
    return stringBuffer.toString();
  }

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  public String stringClass() {
    return string;
  }
}
