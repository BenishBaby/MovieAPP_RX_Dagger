package movies.com.androidmovieapp.Model;

public class NowPlayingMoviesDetails
{
    private NowPlayingMoviesResults[] results;

    private NowPlayingMoviesDates dates;

    private String page;

    private String total_pages;

    private String total_results;

    public NowPlayingMoviesResults[] getResults ()
    {
        return results;
    }

    public void setResults (NowPlayingMoviesResults[] results)
    {
        this.results = results;
    }

    public NowPlayingMoviesDates getDates ()
    {
        return dates;
    }

    public void setDates (NowPlayingMoviesDates dates)
    {
        this.dates = dates;
    }

    public String getPage ()
    {
        return page;
    }

    public void setPage (String page)
    {
        this.page = page;
    }

    public String getTotal_pages ()
    {
        return total_pages;
    }

    public void setTotal_pages (String total_pages)
    {
        this.total_pages = total_pages;
    }

    public String getTotal_results ()
    {
        return total_results;
    }

    public void setTotal_results (String total_results)
    {
        this.total_results = total_results;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [results = "+results+", dates = "+dates+", page = "+page+", total_pages = "+total_pages+", total_results = "+total_results+"]";
    }
}