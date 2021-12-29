package Practice;

import org.junit.Test;
import org.testng.annotations.DataProvider;

public class DataProviderTest {
@Test
public void readDataProviderPracticeTest(String Name,int qty)
{
	System.out.println("mobile name -------->"+Name+"mobile qty-------->"+qty);
}
@DataProvider
public Object[][] getData()
{
	Object [][] objArr = new Object [3][2];
	 objArr [0][0] ="iphone";
	 objArr [0][1]=10;
	 
	 objArr [1][0] ="Samsung";
	 objArr [1][1]=20;
	 
	 objArr [2][0] ="MI";
	 objArr [2][1]=30;
	 
	 return objArr;
}
}
