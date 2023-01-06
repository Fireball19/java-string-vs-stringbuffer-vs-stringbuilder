package stringvsstringbuffervsstringbuilder;

import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkRunner {

  public static void main(String[] args) throws RunnerException {
    Options options = new OptionsBuilder()
        .include(BenchmarksToString.class.getSimpleName())
        .resultFormat(ResultFormatType.CSV)
        .result("./results/" + System.currentTimeMillis() + ".csv")
        .build();
    new Runner(options).run();
  }
}