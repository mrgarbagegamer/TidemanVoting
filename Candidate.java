public class Candidate 
{
    private String name;
    private int wins;
    private int losses;

    public Candidate(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getWins()
    {
        return wins;
    }
    
    public void incrementWins()
    {
        wins++;
    }

    public int getLosses()
    {
        return losses;
    }

    public void incrementLosses()
    {
        losses++;
    }
}
