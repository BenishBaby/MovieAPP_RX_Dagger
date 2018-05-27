package movies.com.androidmovieapp.Model;

public class NowPlayingMoviesDates
{
    private String minimum;

    private String maximum;

    public String getMinimum ()
    {
        return minimum;
    }

    public void setMinimum (String minimum)
    {
        this.minimum = minimum;
    }

    public String getMaximum ()
    {
        return maximum;
    }

    public void setMaximum (String maximum)
    {
        this.maximum = maximum;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [minimum = "+minimum+", maximum = "+maximum+"]";
    }
}