/**
*
* A program that calculators the Spherical and Planar
* distance between two points
*
*
* @author Robert McMillion
*
*/


public class DistanceCalculator{
    
    /** Earth Radiaus */
    public static int EARTH_RADIUS = 3959;

    /** Raleigh Latitude */
    public static double RALEIGH_LATITUDE = 35.78;

    /** Raleigh Longitude */
    public static double RALEIGH_LONGITUDE = -78.64;

    /** Minimum Latitude , mid, and Maximum Latitude */
    public static double MIN_LATITUDE = 30, long40 = 40, MAX_LATITUDE = 50;  

    /** Min_Longitude */
    public static int MIN_LONGITUDE = -120;

    /** Max Longitude */
    public static int MAX_LONGITUDE = -50;

    /** Longitude Increment */
    public static int LONGITUDE_INCREMENT = 5;
    
     
        
    /** Main method with no args
    *
    *
    * @params args no arguements
    *
    */
    public static void main(String[] args){
    
    System.out.println();
    
    // Print the Table Banner
    System.out.println("\tDistance (miles) from Raleigh (lat 35.78 long -78.64)");
    System.out.println("\t\t lat 30 \t\t lat 40 \t\t lat 50");
    System.out.println("long \t   Planar Spherical \t   Planar Spherical \t   Planar Spherical");
    System.out.println("---- \t   ------ --------- \t   ------ --------- \t   ------ ---------");
    
    for(int i = MIN_LONGITUDE ; i <= MAX_LONGITUDE ; i += LONGITUDE_INCREMENT){
            
        System.out.printf("%4d \t", i);
        
        //Planar and Spherical at 30 degrees
        System.out.printf("%9.0f ", calculatePlanarDistance(RALEIGH_LATITUDE, RALEIGH_LONGITUDE,
                                                        MIN_LATITUDE, (double)i));
        System.out.printf("%9.0f \t", calculateSphericalDistance(RALEIGH_LATITUDE, RALEIGH_LONGITUDE,
                                                        MIN_LATITUDE, (double)i)); 
        
        //Planar and Spherical at 40 degrees
        System.out.printf("%9.0f ", calculatePlanarDistance(RALEIGH_LATITUDE, RALEIGH_LONGITUDE,
                                                        long40, (double)i));
        System.out.printf("%9.0f \t", calculateSphericalDistance(RALEIGH_LATITUDE, RALEIGH_LONGITUDE,
                                                        long40, (double)i));
        
        //Planar and Spherical at 40 degrees
        System.out.printf("%9.0f ", calculatePlanarDistance(RALEIGH_LATITUDE, RALEIGH_LONGITUDE,
                                                        MAX_LATITUDE, (double)i));
        System.out.printf("%9.0f \n", calculateSphericalDistance(RALEIGH_LATITUDE, RALEIGH_LONGITUDE,
                                                        MAX_LATITUDE, (double)i));                                                
                                                                                                       
    
    }
        
}
    
    
    /**
    *
    *
    * This method calculates the Planar Distance between two points
    *
    * @param lat1 Latitude of the first place
    * @param long1 Longitude of the first place
    * @param lat2 Latitude of the second place
    * @param long2 Longitude of second place
    *
    * @return Return the Planar Distance
    */
    
    
    public static double calculatePlanarDistance(double lat1, double long1,
                                                    double lat2, double long2){
        // Convert lat to radians
        lat1 = lat1 * Math.PI / 180;
        lat2 = lat2 * Math.PI / 180;
        
        // Convert longs to radians
        long1 = long1 * Math.PI / 180;
        long2 = long2 * Math.PI / 180;
        
        // Find the average and difference of lats and longs
        double diffLats = lat1 - lat2;
        double averageLats = (lat1 + lat2) / 2;
        double diffLongs = long2 - long1;
        
        // Calculate Planar Distance and return
        double result = (double)EARTH_RADIUS * Math.sqrt(Math.pow(diffLats, 2) + 
                        Math.pow((Math.cos(averageLats) *
                        diffLongs), 2));
                      
        return result;
    }
    
    /**
    *
    *
    * This method calculates the Spherical Distance between two points
    *
    * @param lat1 Latitude of the first place
    * @param long1 Longitude of the first place
    * @param lat2 Latitude of the second place
    * @param long2 Longitude of second place
    *
    * @return Return the Spherical Distance
    */
    
    public static double calculateSphericalDistance(double lat1, double long1,
                                                    double lat2, double long2){
        // Convert lat to radians
        lat1 = lat1 * Math.PI / 180;
        lat2 = lat2 * Math.PI / 180;
        
        // Convert longs to radians
        long1 = long1 * Math.PI / 180;
        long2 = long2 * Math.PI / 180;
        
        /* Find the difference between longitudes, calculate Spherical distnace
            and return the result */
        double diffLongs = long1 - long2;
                        
        double result = (double)EARTH_RADIUS * Math.acos(Math.sin(lat1) * Math.sin(lat2) + 
                        Math.cos(lat1) *
                        Math.cos(lat2) * Math.cos(diffLongs));
                 
        return result;                      
    
    
    
    }


}