package dataDrivenTest;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

public class sampleTest extends dataDriven{
	
	@Test
	public void fetchData() throws IOException
	{
		
		//we fetched the excel data into an arrayList.

		List<String> al = getDataFromExcel1("Add Prod to Cart");
		System.out.println(al);
		
//		for(int i=0;i<al.size();i++)
//		{
//			
//			System.out.println(al.get(i));
//			
//			
//		}
		
		
		
		
	}
	

}
