import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class log_reducer extends Reducer<Text,IntWritable,Text,IntWritable> 
{
	IntWritable result = new IntWritable();
	public void reduce(Text key, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException
	{
			int max = 0;
			for(IntWritable val:values)
			{
				int temp = (val.get());
				if(max < temp)
				{
					max = temp;
				}
			}
			result.set(max);
			context.write(key, result);
			
	}
}
