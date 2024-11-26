package com.crm.Controller;

import com.crm.entity.Employee;
import com.crm.payload.EmployeeDto;
import com.crm.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")

public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(
            @Valid @RequestBody EmployeeDto dto, BindingResult result) {
               if(result.hasErrors()){
                 return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
                   }
        EmployeeDto employeeDto = employeeService.addEmployee(dto);
        return new ResponseEntity<>(employeeDto,HttpStatus.CREATED);
        }



    @DeleteMapping
        public ResponseEntity<String> deleteEmployee(@RequestParam Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);

        }
//        @PutMapping
//    public ResponseEntity<String> updateEmployee(@RequestParam Long id, @RequestBody EmployeeDto Dto) {
//
//        employeeService.updateEmployee(id, Dto);
//        return new ResponseEntity<>("updated",HttpStatus.OK);
//        }
@PutMapping
public ResponseEntity<EmployeeDto> updateEmployee(@RequestParam Long id, @RequestBody EmployeeDto Dto) {

    EmployeeDto employeeDto = employeeService.updateEmployee(id, Dto);
    return new ResponseEntity<>(employeeDto, HttpStatus.OK);
}
//    @GetMapping
//    public ResponseEntity<List<EmployeeDto>>getEmployees() {
//        List<EmployeeDto> employees=employeeService.getEmployees();
//        return new ResponseEntity<>(employees,HttpStatus.OK);
//
//        }
//    @GetMapping("/empId{empId}")
//    public ResponseEntity<EmployeeDto>getEmployeeById(
//            @PathVariable Long empId
//    ) {
//        EmployeeDto dto = employeeService.getEmployeeById(empId);
//        return new ResponseEntity<>(dto, HttpStatus.OK);
//
//    }

    @GetMapping("/emp")
    public ResponseEntity<List<EmployeeDto>>getEmployee(
            @RequestParam (name="pageNo",required = false,defaultValue = "0")int pageNo,
            @RequestParam (name="pageSize",required = false,defaultValue = "5")int pageSize,
            @RequestParam (name="sortBy",required = false, defaultValue = "id")String sortBy,
            @RequestParam (name="sortDir",required = false, defaultValue = "asc")String sortDir
    )
    {
        List<EmployeeDto> dto = employeeService.getEmployee(pageNo,pageSize,sortBy,sortDir );
        return new ResponseEntity<>(dto, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {

        List<Employee> employees=employeeService.getEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
