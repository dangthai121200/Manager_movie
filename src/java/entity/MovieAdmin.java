package entity;
// Generated Nov 10, 2021 5:11:14 PM by Hibernate Tools 4.3.1



/**
 * MovieAdmin generated by hbm2java
 */
public class MovieAdmin  implements java.io.Serializable {


     private Integer idMovieAdmin;
     private Admin admin;
     private Movie movie;

    public MovieAdmin() {
    }

    public MovieAdmin(Admin admin, Movie movie) {
       this.admin = admin;
       this.movie = movie;
    }
   
    public Integer getIdMovieAdmin() {
        return this.idMovieAdmin;
    }
    
    public void setIdMovieAdmin(Integer idMovieAdmin) {
        this.idMovieAdmin = idMovieAdmin;
    }
    public Admin getAdmin() {
        return this.admin;
    }
    
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    public Movie getMovie() {
        return this.movie;
    }
    
    public void setMovie(Movie movie) {
        this.movie = movie;
    }




}


