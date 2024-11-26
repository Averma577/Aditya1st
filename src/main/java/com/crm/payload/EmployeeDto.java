package com.crm.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data

public class EmployeeDto {
    private Long id;
    @NotBlank
    @Size(min=3,message="At least 3char required")
    private String name;

   //annotation for email
    @Email
    private String emailId;


    @Size(min= 10,max=10,message="10 digits required")
    private String mobile;



//    private Date date;


}
