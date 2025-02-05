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

    // A method that allows for the addition of votes to a matchup. It must be able to find a matchup based on the provided candidates and then add a vote to that matchup. A value of 1 should correspond to the first candidate winning and a value of 2 should correspond to the second candidate winning.
    public void addVote(Candidate candidate1, Candidate candidate2, int vote)
    {
        for (Matchup matchup : matchups)
        {
            if (matchup.getFirstCandidate() == candidate1 && matchup.getSecondCandidate() == candidate2)
            {
                matchup.addVote(vote);
                return;
            }
            else if (matchup.getFirstCandidate() == candidate2 && matchup.getSecondCandidate() == candidate1)
            {
                if (vote == 1)
                {
                    matchup.addVote(2);
                }
                else
                {
                    matchup.addVote(1);
                }
                return;
            }
        }
    }

    public void sortMatchups()
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

    public boolean causesCycle(Candidate losingCandidate)
    {
        // Return true IF every other candidate has at least one loss marked against them
        for (Candidate candidate : candidates)
        {
            if (candidate != losingCandidate && candidate.getLosses() == 0)
            {
                return false;
            }
        }
        return true;
    }

    // Method to mark winners and remove matchups that have a cycle

    public void performRankedPairs()
    {
        // Sort matchups
        sortMatchups();
        
        // Iterate through matchups and mark wins and losses
        for (Matchup matchup : matchups)
        {
            // Remove matchups that cause a cycle
            if (causesCycle(matchup.getLoser()))
            {
                matchups.remove(matchup);
            }
            else
            {
                matchup.getWinner().incrementWins();
                matchup.getLoser().incrementLosses();
            }
        }
    }

    public Candidate getWinner()
    {
        for (Candidate candidate : candidates)
        {
            if (candidate.getLosses() == 0)
            {
                return candidate;
            }
        }
        // If no winner is found, return null (there is a big problem)
        System.out.println("Uh oh, there was no winner found! Have fun debugging this, Apollo!");
        return null;
    }
}