package hibernate;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "movie_rentals")
public class MovieRental {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="user_id", insertable=false, updatable=false)
	private Integer userId;
	
	@Column(name="movie_id", insertable=false, updatable=false)
	private Integer movieId;
	
	/* To Movie */
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
	
	@ToString.Exclude
//	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
	
}
