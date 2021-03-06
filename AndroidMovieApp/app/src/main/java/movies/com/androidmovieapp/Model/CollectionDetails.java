package movies.com.androidmovieapp.Model;

public class CollectionDetails
{
    private String id;

    private String backdrop_path;

    private String overview;

    private String name;

    private Parts[] parts;

    private String poster_path;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getBackdrop_path ()
    {
        return backdrop_path;
    }

    public void setBackdrop_path (String backdrop_path)
    {
        this.backdrop_path = backdrop_path;
    }

    public String getOverview ()
    {
        return overview;
    }

    public void setOverview (String overview)
    {
        this.overview = overview;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public Parts[] getParts ()
    {
        return parts;
    }

    public void setParts (Parts[] parts)
    {
        this.parts = parts;
    }

    public String getPoster_path ()
    {
        return poster_path;
    }

    public void setPoster_path (String poster_path)
    {
        this.poster_path = poster_path;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", backdrop_path = "+backdrop_path+", overview = "+overview+", name = "+name+", parts = "+parts+", poster_path = "+poster_path+"]";
    }
}