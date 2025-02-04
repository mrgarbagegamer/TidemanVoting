import java.util.*;
public class Matchup 
{
    private Candidate firstCandidate;
    private Candidate secondCandidate;
    private ArrayList<Integer> votes = new ArrayList<Integer>();

    public Matchup(Candidate firstCandidate, Candidate secondCandidate) 
    {
        this.firstCandidate = firstCandidate;
        this.secondCandidate = secondCandidate;
    }

    public Candidate getFirstCandidate() 
    {
        return firstCandidate;
    }
    
    public Candidate getSecondCandidate() 
    {
        return secondCandidate;
    }
    
    // Adds a result to the matchup, with 1 corresponding to the first candidate winning and 2 corresponding to the second candidate winning.
    public void addVote(int vote) 
    {
        votes.add(vote);
    }

    public Candidate getWinner() 
    {
        int firstCandidateWins = 0;
        int secondCandidateWins = 0;
        for (int vote : votes) 
        {
            if (vote == 1) {
                firstCandidateWins++;
            } else {
                secondCandidateWins++;
            }
        }
        if (firstCandidateWins >= secondCandidateWins) 
        {
            return firstCandidate;
        } 
        else 
        {
            return secondCandidate;
        }
    }

    public Candidate getLoser() 
    {
        int firstCandidateWins = 0;
        int secondCandidateWins = 0;
        for (int vote : votes) 
        {
            if (vote == 1) {
                firstCandidateWins++;
            } else {
                secondCandidateWins++;
            }
        }
        if (firstCandidateWins < secondCandidateWins) 
        {
            return firstCandidate;
        } 
        else 
        {
            return secondCandidate;
        }
    }

    public double getWinPercentage()
    {
        Candidate winner = getWinner();
        int wins = 0;
        if (winner.equals(firstCandidate))
        {
            for (int vote : votes) 
            {
                if (vote == 1) 
                {
                    wins++;
                }
            }
        }
        else
        {
            for (int vote : votes) 
            {
                if (vote == 2) 
                {
                    wins++;
                }
            }
        }
        return (double) wins / (votes.size());
    }
}