package com.jyothish.ems.ems_api.repository;

import com.jyothish.ems.ems_api.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{


//    @Query("SELECT e FROM Employee e WHERE " +
//            "LOWER(e.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
//            "LOWER(e.lastName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
//            "LOWER(e.email) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
//            "LOWER(e.department) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
//            "LOWER(e.designation) LIKE LOWER(CONCAT('%', :keyword, '%'))")
//    public List<Employee> getEmployeesByKeyword(@Param("keyword") String keyword);

}
