import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class log_mapper extends Mapper<Object,Text,Text,IntWritable>
{
	public Text word = new Text();
	public void map(Object key,Text value,Context context) throws InterruptedException,IOException
	{
		String s = new String(value.toString());
		String splitfirst = "\n";
		String []b = s.split(splitfirst);
		for(String b1:b)
		{
			String year = b1.substring(15, 19);
			String temp = b1.substring(87, 92);
			int temp1 = Integer.parseInt(temp);
			IntWritable one = new IntWritable(temp1); 
			word.set(year);
			context.write(word, one);
		}
	}
}
