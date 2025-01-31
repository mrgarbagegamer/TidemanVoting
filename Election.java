import java.util.*;
public class Election 
{
    public static ArrayList<Matchup> createMatchups(ArrayList<Candidate> candidates)
    {
        ArrayList<Matchup> matchups = new ArrayList<Matchup>();
        for (int i = 0; i < candidates.size(); i++)
        {
            for (int j = i + 1; j < candidates.size(); j++)
            {
                matchups.add(new Matchup(candidates.get(i), candidates.get(j)));
            }
        }
        return matchups;
    }

    public static void sortMatchups(ArrayList<Matchup> matchups)
    {
        for (int i = 0; i < matchups.size(); i++)
        {
            for (int j = i + 1; j < matchups.size(); j++)
            {
                if (matchups.get(i).getWinPercentage() < matchups.get(j).getWinPercentage())
                {
                    Matchup temp = matchups.get(i);
                    matchups.set(i, matchups.get(j));
                    matchups.set(j, temp);
                }
            }
        }
    }
}