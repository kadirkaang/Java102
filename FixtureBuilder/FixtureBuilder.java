import java.util.*;

public class FixtureBuilder {
    private final ArrayList<String> teams;
    private final ArrayList<ArrayList<String[]>> result;
    private final LinkedList<String> homeTeams;
    private final LinkedList<String> awayTeams;
    private final int weeklyMatch;
    private final int weeks;

    public FixtureBuilder(ArrayList<String> teams) {
        if (teams.size() % 2 == 1) {
            teams.add("Bay");
        }
        Collections.shuffle(teams);
        this.teams = teams;
        this.weeklyMatch = this.teams.size() / 2;
        this.weeks = (this.teams.size() - 1) * 2;
        this.result = new ArrayList<>();
        this.homeTeams = new LinkedList<>();
        this.awayTeams = new LinkedList<>();
    }

    public void build() {
        int i = 0;
        while (i < this.teams.size() / 2) {
            homeTeams.add(this.teams.get(i));
            i++;
        }
        while (i < this.teams.size()) {
            awayTeams.add(this.teams.get(i));
            i++;
        }
        String firstTeam = homeTeams.removeFirst();
        roundBuild(firstTeam, 0);
        for (int j = 1; j < weeks; j++) {
            String[] tempTeam = new String[]{homeTeams.removeLast(), awayTeams.removeFirst()};
            homeTeams.addFirst(tempTeam[1]);
            awayTeams.addLast(tempTeam[0]);
            roundBuild(firstTeam, j);
        }
        for (int j = 0; j < this.weeks; j++) {
            Collections.shuffle(result.get(j));
        }
    }

    private void roundBuild(String firstTeam, int index) {
        this.result.add(new ArrayList<>());
        String temp = awayTeams.element();
        String temp1;
        if (index % 2 == 0) {
            this.result.get(index).add(new String[]{firstTeam, awayTeams.remove()});
            awayTeams.addLast(temp);
            for (int i = 1; i < weeklyMatch; i++) {
                temp = awayTeams.getFirst();
                temp1 = homeTeams.getFirst();
                this.result.get(index).add(new String[]{homeTeams.remove(), awayTeams.remove()});

                awayTeams.add(temp);
                homeTeams.add(temp1);
            }
        } else {
            this.result.get(index).add(new String[]{awayTeams.remove(), firstTeam});
            awayTeams.addLast(temp);
            for (int i = 1; i < weeklyMatch; i++) {
                temp = awayTeams.getFirst();
                temp1 = homeTeams.getFirst();
                this.result.get(index).add(new String[]{awayTeams.remove(), homeTeams.remove()});

                awayTeams.add(temp);
                homeTeams.add(temp1);
            }
        }
    }

    public ArrayList<ArrayList<String[]>> getResult() {
        return result;
    }
}
