package jpa.entitymodels;

import java.util.Date;

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
@Table(name = "student_course")
public class StudentCourse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="student_id", insertable=false, updatable=false)
	private Integer studentId;
	
	@Column(name="course_id", insertable=false, updatable=false)
	private Integer courseId;
	
	/* To Student */
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
	
	/* To Course */
	@ToString.Exclude
//	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
}
