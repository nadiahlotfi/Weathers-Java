import java.util.*;
import java.util.Random;

//Weathers main class
class Weather {
	public static void main(String args[]){
		WeatherList weatherlist = new WeatherList();
		weatherlist.readWeather();
	}
}	

//Weather class
public class Weathers{
	private float temperature;
	private float precipitation;
	private float humidity;
	private float wind;
	
	public void generate(float TempRange[],float WindRange[],float HumiRange[],float PreciRange[]){
		Random rand = new Random();
		
		temperature = rand.nextFloat() * (TempRange[1] - TempRange[0]) + TempRange[0];
		wind = rand.nextFloat() * (WindRange[1] - WindRange[0]) + WindRange[0] ;
		humidity = rand.nextFloat() * (HumiRange[1] - HumiRange[0]) + HumiRange[0];
		precipitation = rand.nextFloat() * (PreciRange[1] - PreciRange[0]) ;
		
	}
	
	//display all the temperature, precipitation, wind and humidity
	public void display () {
		System.out.println("\nTemperature : " + temperature);
		System.out.println("Wind : " + wind);
		System.out.println("Humidity : " + humidity);
		System.out.println("Precipitation : " + precipitation);
	}
	
	// getter for private attributes
	public float getTemperature(){
		
		return temperature;
	}
		
	// getter for private attributes
	public float getWind(){
		
		return wind;
	}
		
	// getter for private attributes
	public float getHumidity(){
		
		return humidity;
	}
		
	// getter for private attributes
	public float getPrecipitation(){
		
		return precipitation;
	}
		
	// setter for private attributes
	public void setTemperature(float temp){
		if(temperature > 50){
			System.out.println("Error");
			return;
		}
		
		temperature = temp;
	}
		
	// setter for private attributes
	public void setWind(float wind){
		if(wind > 50){
			System.out.println("Error");
			return;
		}
			
		this.wind = wind ;
	}
		
	// setter for private attributes
	public void setHumidity(float humi){
		if(humidity > 50){
			System.out.println("Error");
			return;
		}
			
		humidity = humi;
	}
		
	// setter for private attributes
	public void setPrecipitation(float preci){
		if(wind > 50){
			System.out.println("Error");
			return;
		}
			
		precipitation = preci;
	}
}

//WeatherList class
class WeatherList{
	final int num = 10;  //conatant the numberdata
	Weathers weather = new Weathers();
	Weathers weatherData[] = new Weathers[num];
	
	public void readWeather(){
		float TempRange[] = {20,45};
		float WindRange[] = {0,50};
		float HumiRange[] = {20,45};
		float PreciRange[] = {20,45};
		weather.generate(TempRange, WindRange,HumiRange,PreciRange);
		
		String location[] = {"Batu Gajah", "Ipoh"};
		for (int j=0; j<2; j++){
			System.out.println("\n***** Location : " + location[j] + " *****");
			for (int i=0; i<weatherData.length; i++){
				weatherData[i] = new Weathers();
				weatherData[i].generate(TempRange,WindRange,HumiRange,PreciRange);
				weatherData[i].display();
		}
			//display minimum
			System.out.println("\n ----- Minimum (" + location[j] + ") -----");
			System.out.println("Temperature : " + minTemp());
			System.out.println("Precipitation : " + minPreci());
			System.out.println("Precipitation : " + minWind());
			System.out.println("Precipitation : " + minHumi());
			//display maximum
			System.out.println("\n ----- Maximum (" + location[j] + ")  -----");
			System.out.println("Temperature : " + maxTemp());
			System.out.println("Precipitation : " + maxPreci());
			System.out.println("Precipitation : " + maxWind());
			System.out.println("Precipitation : " + maxHumi());
			//display average
			System.out.println("\n ----- Average (" + location[j] + ")  -----");
			System.out.println("Temperature : " + avgTemp());
			System.out.println("Precipitation : " + avgPreci());
			System.out.println("Precipitation : " + avgWind());
			System.out.println("Precipitation : " + avgHumi());
			//display standard deviation
			System.out.println("\n ----- Standard Deviation (" + location[j] + ")  -----");
			System.out.println("Temperature : " + stddevTemp());
			System.out.println("Precipitation : " + stddevPreci());
			System.out.println("Precipitation : " + stddevWind());
			System.out.println("Precipitation : " + stddevHumi());
		}
}
	
	//calculate the minimum of temperature
	public float minTemp(){
		float min = weatherData[0].getTemperature();
		for (int i=1; i<num; i++){
			if(weatherData[i].getTemperature() < min){
				min = weatherData[i].getTemperature();
			}
		}
		return min;
	}
	
	//calculate the minimum of precipitation
	public float minPreci(){
		float min = weatherData[0].getPrecipitation();
		for (int i=0; i<weatherData.length; i++){
			if(weatherData[i].getPrecipitation() < min){
				min = weatherData[i].getPrecipitation();
			}
		}
		return min;
	}
	
	//calculate the minimum of wind
	public float minWind(){
		float min = weatherData[0].getWind();
		for (int i=0; i<weatherData.length; i++){
			if(weatherData[i].getWind() < min){
				min = weatherData[i].getWind();
			}
		}
		return min;
	}
	
	//calculate the minimum of humidity
	public float minHumi(){
		float min = weatherData[0].getHumidity();
		for (int i=0; i<weatherData.length; i++){
			if(weatherData[i].getHumidity() < min){
				min = weatherData[i].getHumidity();
			}
		}
		return min;
	}
	
	//calculate the maximum of temperature
	public float maxTemp(){
		float max = weatherData[0].getTemperature();
		for (int i=1; i<weatherData.length; i++){
			if(weatherData[i].getTemperature() > max){
				max = weatherData[i].getTemperature();
			}
		}
		return max;
	}
	
	//calculate the maximum of precipitation
	public float maxPreci(){
		float max = weatherData[0].getPrecipitation();
		for (int i=0; i<weatherData.length; i++){
			if(weatherData[i].getPrecipitation() > max){
				max = weatherData[i].getPrecipitation();
			}
		}
		return max;
	}
	
	//calculate the maximum of wind
	public float maxWind(){
		float max = weatherData[0].getWind();
		for (int i=0; i<weatherData.length; i++){
			if(weatherData[i].getWind() > max){
				max = weatherData[i].getWind();
			}
		}
		return max;
	}
	
	//calculate the maximum of humidity
	public float maxHumi(){
		float max = weatherData[0].getHumidity();
		for (int i=0; i<weatherData.length; i++){
			if(weatherData[i].getHumidity() > max){
				max = weatherData[i].getHumidity();
			}
		}
		return max;
	}
	
	//calculate the average of temperature
	public float avgTemp(){
		float total = 0, avg;
		for (int i=0; i<weatherData.length; i++){
			total += weatherData[i].getTemperature();
		}
		avg = total / weatherData.length;
		
		return avg;
	}
	
	//calculate the average of precipitation
	public float avgPreci(){
		float total = 0, avg;
		for (int i=0; i<weatherData.length; i++){
			total += weatherData[i].getPrecipitation();
		}
		avg = total / weatherData.length;
		
		return avg;
	}
	
	//calculate the average of wind
	public float avgWind(){
		float total = 0, avg;
		for (int i=0; i<weatherData.length; i++){
			total += weatherData[i].getWind();
		}
		avg = total / weatherData.length;
		
		return avg;
	}
	
	//calculate the average of humidity
	public float avgHumi(){
		float total = 0, avg;
		for (int i=0; i<weatherData.length; i++){
			total += weatherData[i].getHumidity();
		}
		avg = total / weatherData.length;
		
		return avg;
	}
	
	//calculate the standard deviation of temperature
	public float stddevTemp(){
		float avg = avgTemp();
		float sum = 0,total = 0, stddev, std;
		for(int i=1; i<weatherData.length; i++){
			sum = (float)Math.pow(weatherData[i].getTemperature() - avg,2);
			total += sum;
		}
		stddev = (total/(weatherData.length-1));
		std = (float)Math.sqrt(stddev);
		return std;
	}
	
	//calculate the standard deviation of precipitation
	public float stddevPreci(){
		float avg = avgPreci();
		float sum = 0,total = 0, stddev, std;
		for(int i=1; i<weatherData.length; i++){
			sum = (float)Math.pow(weatherData[i].getPrecipitation() - avg,2);
			total += sum;
		}
		stddev = (total/(weatherData.length-1));
		std = (float)Math.sqrt(stddev);
		return std;
	}
	
	//calculate the standard deviation of wind
	public float stddevWind(){
		float avg = avgWind();
		float sum = 0,total = 0, stddev, std;
		for(int i=1; i<weatherData.length; i++){
			sum = (float)Math.pow(weatherData[i].getWind() - avg,2);
			total += sum;
		}
		stddev = (total/(weatherData.length-1));
		std = (float)Math.sqrt(stddev);
		return std;
	}
	
	//calculate the standard deviation of humidity
	public float stddevHumi(){
		float avg = avgHumi();
		float sum = 0,total = 0, stddev, std;
		for(int i=1; i<weatherData.length; i++){
			sum = (float)Math.pow(weatherData[i].getHumidity() - avg,2);
			total += sum;
		}
		stddev = (total/(weatherData.length-1));
		std = (float)Math.sqrt(stddev);
		return std;
	}
}