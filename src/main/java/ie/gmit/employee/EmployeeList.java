/*
 * Matthew Waters
 * G00357709@gmit.ie
 * EmployeeList.java
 */
package ie.gmit.employee;

import java.util.ArrayList;

public class EmployeeList {

    ArrayList<Employee> employeeList = new ArrayList<Employee>();


    void addEmployee(Employee employee)
    {
        boolean isPpsidSame = false;

        for(Employee empLoop : employeeList)
        {
            if(empLoop.getPpsid().equals(employee.getPpsid()))
            {
                isPpsidSame = true;
            }
        }

        if(isPpsidSame)
        {
            throw new IllegalArgumentException("Duplicate Employee details found, no object added");
        }
        else
        {
            employeeList.add(employee);
        }
    }

    int getListSize()
    {
        return employeeList.size();
    }
}
