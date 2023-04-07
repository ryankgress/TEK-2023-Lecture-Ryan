package springexamples.formbeans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeFormBean {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String extension;
    private String jobTitle;
    private Integer vacationHours;
    private Integer officeId;
    private String profileImage;
}