/**
 * 
 */
package logdriver;

import java.io.IOException;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class logreducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	public void reduce(Text t_key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
		Text key = t_key;
		int frequencyForCountry = 0;
		for (IntWritable val : values)  {
			// replace type of value with the actual type of our value
			frequencyForCountry += val.get();
			
		}
		//output.collect(key, new IntWritable(frequencyForCountry));
		context.write(key, new IntWritable(frequencyForCountry));

	}
}
