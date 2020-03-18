import java.util.*;


public class Banker{

   public static void main(String[] argc){
      int isFail = 0;
      int safe = 0;
      boolean fail = false;
      Scanner obama = new Scanner(System.in);
      
      System.out.println("Insert number of Customers | Resources");
      String s= obama.nextLine();
      String[] sa = s.split(" ");
      int z =  Integer.parseInt(sa[0]);
      int w = Integer.parseInt(sa[1]);
      int[][] allocation = new int[z][];
      int[][] maximum = new int[z][];
      int[][] needs = new int[z][];
      int[] available = new int[z];
      
      System.out.println("Insert Available Matrix:");
      String s2 = obama.nextLine();
      String[] av = s2.split(" ");
      
      System.out.println("Insert the Allocation Matrix:");
      for(int x = 0; x<z; x++){
         allocation[x] = new int[w];
         String s3 = obama.nextLine();
         String[] s4 = s3.split(" ");
         for(int y = 0; y <w; y++)allocation[x][y] = Integer.parseInt(s4[y]);
      }
      
      System.out.println("Insert the Maximum Matrix:");
      for(int x = 0; x<z; x++){
         maximum[x] = new int[w];
         needs[x] = new int[w];
         String s3 = obama.nextLine();
         String[] s4 = s3.split(" ");
         for(int y = 0; y <w; y++){
            maximum[x][y] = Integer.parseInt(s4[y]);
            needs[x][y] = maximum[x][y] - allocation[x][y];
            available[y] = Integer.parseInt(av[y]);
         }
      }
      System.out.println("Needs:\n" + Arrays.deepToString(needs));
      while (true){
         isFail = safe;
         for(int x = 0; x<z; x++){
            fail = false;
            for(int y = 0; y<w; y++){
               if(needs[x] != null && needs[x][y]>available[y])fail = true;
            }
            if (safe == z){
               System.out.println("Request Accepted");
               System.exit(0);
            }
            else if(fail == false && needs[x] != null){
               for(int r =0; r<w; r++){
                  available[r] += allocation[x][r];
               }
               System.out.println("Proccess Allocated:" + x);
               needs[x] = null;
               safe+=1;
            }
         }
         if (isFail == safe){
            System.out.println("Reject Request");
            System.exit(0);
         }
      }
   }

}