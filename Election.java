import java.util.*;
public class Election 
{
    private ArrayList<Candidate> candidates;
    private ArrayList<Matchup> matchups;

    public Election(ArrayList<Candidate> candidateList)
    {
        candidates = candidateList;
        matchups = new ArrayList<Matchup>();
        for (int i = 0; i < candidates.size(); i++)
        {
            for (int j = i + 1; j < candidates.size(); j++)
            {
                matchups.add(new Matchup(candidates.get(i), candidates.get(j)));
            }
        }
    }

    public void sortMatchups(ArrayList<Matchup> matchups)
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

    // A method that allows for the addition of votes to a matchup. It must be able to find a matchup based on the provided candidates and then add a vote to that matchup. A value of 1 should correspond to the first candidate winning and a value of 2 should correspond to the second candidate winning.
    public void addVote(Candidate candidate1, Candidate candidate2, int result)
    {
        for (Matchup matchup : matchups)
        {
            if (matchup.getFirstCandidate() == candidate1 && matchup.getSecondCandidate() == candidate2)
            {
                matchup.addResult(result);
                return;
            }
            else if (matchup.getFirstCandidate() == candidate2 && matchup.getSecondCandidate() == candidate1)
            {
                if (result == 1)
                {
                    matchup.addResult(2);
                }
                else
                {
                    matchup.addResult(1);
                }
                return;
            }
        }
    }
}