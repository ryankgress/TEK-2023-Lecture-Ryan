package jpa.entitymodels;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer sId;
	
	@Column(name = "email")
	private String sEmail;
	
	@Column(name = "name")
	private String sName;
	
	@Column(name = "password")
	private String sPass;
	
	/* To Course */		// Needs changed
//	@ToString.Exclude
//	@LazyCollection(LazyCollectionOption.FALSE)
//	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
//	private List<Course> courses;
	
	
	// Add a many to many joiner table?
}
