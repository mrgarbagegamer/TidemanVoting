import java.util.*;
public class Matchup {
    private Candidate firstCandidate;
    private Candidate secondCandidate;
    private ArrayList<Integer> results = new ArrayList<Integer>();

    public Matchup(Candidate firstCandidate, Candidate secondCandidate) 
    {
        this.firstCandidate = firstCandidate;
        this.secondCandidate = secondCandidate;
    }

    public void addResult(int result) 
    {
        results.add(result);
    }

    public Candidate getWinner() 
    {
        int firstCandidateWins = 0;
        int secondCandidateWins = 0;
        for (int result : results) 
        {
            if (result == 1) {
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

    public double getWinPercentage()
    {
        int firstCandidateWins = 0;
        for (int result : results) 
        {
            if (result == 1) 
            {
                firstCandidateWins++;
            }
        }
        return (double) firstCandidateWins / (results.size());
    }
}