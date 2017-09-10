import junit.framework.TestCase;
import java.util.*;

import tester.IllegalUseOfTraversalException;
import tester.Tester;
import tester.Traversal;

// represents junit tests for city class
public class CityTest extends TestCase {

        /** data for the methods and tests */
        USMap newEngland = new USMap();

        ArrayList<String> meneighbors = new ArrayList<String>();
        ArrayList<String> vtneighbors = new ArrayList<String>();
        ArrayList<String> maneighbors = new ArrayList<String>();
        ArrayList<String> ctneighbors = new ArrayList<String>();
        ArrayList<String> nhneighbors = new ArrayList<String>();
        ArrayList<String> rineighbors = new ArrayList<String>();
        
        
        //sample City
        City augusta = new City(4330, "Augusta", "me", 69.766548, 44.323228);
        City montpellier = new City(
                5602, "Montpelier", "vt", 72.576992, 44.264082);
        City boston = new City(2115,  "Boston", "ma", 71.092215, 42.342706);
        City hartford = new City(6120,  "Hartford", "ct", 72.675807, 41.78596);
        City concord = new City(3301, "Concord", "nh", 71.527734, 43.218525);
        City providence = new City(
                2908, "Providence", "ri", 71.437684, 41.838294);
        City boston2 = new City(2115,  "Boston", "ma", 71.092215, 42.342706);
        
        //sample State
        State me = new State("me", augusta, meneighbors );
        State vt = new State("vt", montpellier, vtneighbors );
        State ma = new State("ma", boston, maneighbors);
        State ct = new State("ct", hartford, ctneighbors );
        State nh = new State("nh", concord, nhneighbors );
        State ri = new State("ri", providence, rineighbors );

        /** Generate lists of neighboring states */
        public void makeNewEngland() {
            meneighbors.add("nh");

            vtneighbors.add("nh");
            vtneighbors.add("ma");
            
            maneighbors.add("ct");
            maneighbors.add("ri");
            maneighbors.add("nh");
            
            ctneighbors.add("ma");
            ctneighbors.add("ri");
            
            nhneighbors.add("me");
            nhneighbors.add("ma");
            nhneighbors.add("vt");
            
            rineighbors.add("ma");
            rineighbors.add("ct");
            
        }

        /** Generate New England states */
        public void makeStates() {

            newEngland.states.put(augusta, me);
            newEngland.states.put(montpellier, vt);
            newEngland.states.put(boston, ma);
            newEngland.states.put(hartford, ct);
            newEngland.states.put(concord, nh);
            newEngland.states.put(providence, ri);
            
        }

        ArrayList<City> cities = new ArrayList<City>();

        /** initialize cities with the data from a file */
        public void initCities() {
            Traversal<City> tr = new InFileCityTraversal();

            try {
                while (!tr.isEmpty()) {
                    cities.add(tr.getFirst());
                    tr = tr.getRest();
                }
            }
            catch (IllegalUseOfTraversalException e) {
                System.out.println(
                        "IllegalUseOfTraversalException: cannot happen" +
                        e.getMessage());
            } 
        }
        
        //initialize the hashMap
        public void initMap() {
     
            newEngland.states.put(augusta, me);
            newEngland.states.put(montpellier, vt);
            newEngland.states.put(boston, ma);
            newEngland.states.put(hartford, ct);
            newEngland.states.put(concord, nh);
            newEngland.states.put(providence, ri);
            newEngland.states.put(boston2, ma);
        }
        

        /** Display the instances using toString... */
        public void testPrint( ) {
            this.makeNewEngland();
            this.makeStates();

            System.out.println("After initialization:");
            System.out.println("Concord: " + newEngland.states.get(concord));
            System.out.println("Montpellier: " + 
                               newEngland.states.get(montpellier));
            System.out.println("Augusta: " + newEngland.states.get(augusta));
            System.out.println("Boston: " + newEngland.states.get(boston));
            System.out.println(
                    "Providence: " + newEngland.states.get(providence));
            System.out.println("Hartford: " + newEngland.states.get(hartford));
            System.out.println("Boston: " + newEngland.states.get(boston2));

            initCities();
            for (City c : cities) {
                System.out.println(c.toString());
            }
            
        }
        
        // test the size of the initialized map, and that it contains at least 3
        // of the added values/keys
        public void testInitMap() {
            initMap();
            assertEquals(newEngland.states.size(), 6);
            assertTrue(newEngland.states.containsKey(providence));
            assertTrue(newEngland.states.containsValue(ma));
            assertTrue(newEngland.states.containsKey(hartford));
        }
        
        //test for toString
        public void testCityToString() {
            assertEquals(new City(
                    3301, "Concord", "NH", 71.527734, 43.218525).toString(),
                         "new City(03301, Concord, NH, 71.527734, 43.218525)");
            assertEquals(new City(
                    4330, "Augusta", "ME", 69.766548, 44.323228).toString(),
                         "new City(04330, Augusta, ME, 69.766548, 44.323228)");
        }
        
      //test for equal and hashcode
        public void testEqual() {
            assertEquals(boston.equals(null), false);
            assertEquals(augusta.equals(boston), false);
            assertEquals(boston.equals(boston), true);
            assertEquals(boston.equals(boston2), true);
            
            assertEquals(boston.hashCode(), 1995581380);
            assertEquals(augusta.hashCode(), 1006538016);
        }
        //test for belowLat
        public void testBelowLat() {
            assertEquals(boston.belowLat(40), false);
            assertEquals(concord.belowLat(50), true);
        }
        
        //test for sameCity
        public void testSameCity(Tester t) {
            assertEquals(boston.sameCity(boston), true);
            assertEquals(boston.sameCity(augusta), false);
        }
    
}
