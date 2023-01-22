import org.apache.beam.runners.dataflow.DataflowRunner;
import org.apache.beam.runners.dataflow.options.DataflowPipelineOptions;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Create;

import java.util.Arrays;
import java.util.List;

public class DF2 {

    public static void main(String[] args) {

        DataflowPipelineOptions pipelineOptions= PipelineOptionsFactory.as(DataflowPipelineOptions.class);
        pipelineOptions.setJobName("SampleDF1");
        pipelineOptions.setProject("gcpdemo-375112");
        pipelineOptions.setRegion("us-central1");
        pipelineOptions.setRunner(DataflowRunner.class);
        pipelineOptions.setTempLocation("gs://rkgfirstbucket//top");
        Pipeline pipeline = Pipeline.create(pipelineOptions);
        final List<String> input = Arrays.asList("New_words", "new_list", "dataflowsss", "cloud_bucket");
        pipeline.apply(Create.of(input)).apply(TextIO.write().to("gs://rkgfirstbucket//results").withSuffix(".txt"));
        pipeline.run().waitUntilFinish();



    }
}
