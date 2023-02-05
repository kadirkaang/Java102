import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> teams = new ArrayList<>();
        teams.add("Galatasaray");
        teams.add("Bursaspor");
        teams.add("Fenerbahçe");
        teams.add("Beşiktaş");
        teams.add("Başakşehir");



        FixtureBuilder roundRobin = new FixtureBuilder(teams);
        roundRobin.build();
        ArrayList<ArrayList<String[]>> result = roundRobin.getResult();
        for (int k = 0; k < result.size(); k++) {
            ArrayList<String[]> rounds = result.get(k);
            System.out.println("------- Week " + (k + 1) + " -------");
            for (String[] team : rounds) {
                System.out.println(Arrays.toString(team));
            }
        }
    }
}