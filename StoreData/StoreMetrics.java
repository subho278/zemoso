package StoreData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StoreMetrics {

	List<StoreDataPoint> list = new ArrayList<StoreDataPoint>();
	public StoreMetrics() throws IOException {
		File file = new File("/home/zemoso02/store_data.csv");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String str;
		int i = 0;
		br.readLine();
		while ((str = br.readLine()) != null) {

			StoreDataPoint sdp = new StoreDataPoint();
			String[] s = str.split(",");
			list.add(sdp);
			list.get(i).data(s);
			i++;
		}
		
		
	}
	
	public String highestSales(String month,String category){
		int hs=0;
		int i=0;
		String name=null;
		while(i<list.size()){
			if((list.get(i).getMonth().equals(month))&&(list.get(i).getCategory().equals(category))){
				if(list.get(i).getSales()>hs){
					hs=list.get(i).getSales();
					name=list.get(i).getName();
				}
				
			}
			
			i++;
		}
		return name;
	}
	public String highestSales(String month){
		
		int r=0,h=0,m=0,w=0,i=0;
		String name = null;
		while(i<list.size()){
			if(list.get(i).getMonth().equals(month)){
				if(list.get(i).getName().equals("Reliance")){
					r=r+list.get(i).getSales();
				}if(list.get(i).getName().equals("Heritage")){
					h=h+list.get(i).getSales();
				}if(list.get(i).getName().equals("More")){
					m=m+list.get(i).getSales();
				}if(list.get(i).getName().equals("Walmart")){
					w=+list.get(i).getSales();
				}
			}
			i++;
		}
		
		int sales[] = {r,h,m,w};
		int maxSales  = 0;
		int check = maxSales;
		
		for (i=0; i<sales.length; i++){
			if (sales[i]>maxSales){
				maxSales=sales[i];
			}
		}
				
		if (check != maxSales){
		if (maxSales == r){name = "Reliance";}
		if (maxSales == h){name = "Heritage";}
		if (maxSales == m){name = "More";}
		if (maxSales == w){name = "Walmart";}
		}
		
		return name;
	}
	public float avgMonthlySales(String category){
		int i=0;
		float sales=0;
		while(i<list.size()){
			if(list.get(i).getCategory().equals(category)){
				sales=sales+list.get(i).getSales();
			}
			i++;
		}
		return sales/12;
	}
	
}