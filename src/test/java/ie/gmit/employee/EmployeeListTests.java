/*
 * Matthew Waters
 * G00357709@gmit.ie
 * EmployeeListTests.java
 */
package ie.gmit.employee;

import ie.gmit.employee.Employee;
import ie.gmit.employee.EmployeeList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeListTests {
    private EmployeeList employeeList;
    private Employee employee1, employee2, employee3;


    @BeforeEach
    void initialise()
    {
        employeeList = new EmployeeList();
        employee1 = new Employee("Mr", "Matthew","Full-time","123456",1234567, 22);
        employee2 = new Employee("Mrs", "Sarah","Full-time","567891",1234567, 19);
        employee3 = new Employee("Miss", "Millie","Part-time","654321",1234567, 40);
    }

    @DisplayName("Test duplicate employee doesnt get added")
    @Test
    void addEmployeeTest()
    {
        employeeList.addEmployee(employee1);
        assertEquals(1, employeeList.getListSize());
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                                                                employeeList.addEmployee(new Employee("Mr",
                                                                                                        "Matthew",
                                                                                                        "Full-time",
                                                                                                        "123456",
                                                                                                        1234567,
                                                                                                        22)));
        assertEquals("Duplicate Employee details found, no object added", ex.getMessage());


    }

    @DisplayName("Test getListSize gets correct size")
    @Test
    void getListSizeTest()
    {
        employeeList.addEmployee(employee1);
        employeeList.addEmployee(employee2);
        employeeList.addEmployee(employee3);

        assertEquals(3, employeeList.getListSize());
    }
}
