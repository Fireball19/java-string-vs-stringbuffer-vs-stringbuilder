package stringvsstringbuffervsstringbuilder;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 1)
@Warmup(iterations = 5, timeUnit = TimeUnit.MILLISECONDS, time = 5000)
@Measurement(iterations = 5, timeUnit = TimeUnit.MILLISECONDS, time = 5000)
public class Benchmarks {
  @Param({"1", "10", "25", "50", "100", "250", "500", "1000", "2500", "5000", "10000", "25000", "50000", "100000"})
  public int arg;

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  public String stringBuilder() {
    StringBuilder stringBuilder = new StringBuilder();

    for (int i = 0; i < arg; i++) {
      stringBuilder.append("a");
    }

    return stringBuilder.toString();
  }

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  public String stringBuffer() {
    StringBuffer stringBuffer = new StringBuffer();

    for (int i = 0; i < arg; i++) {
      stringBuffer.append("a");
    }

    return stringBuffer.toString();
  }

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  public String stringClass() {
    String string = "";

    for (int i = 0; i < arg; i++) {
      string += "a";
    }

    return string;
  }
}
