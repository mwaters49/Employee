/*
 * Matthew Waters
 * G00357709@gmit.ie
 * EmployeeTests.java
 */
package ie.gmit.employee;

import ie.gmit.employee.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeTests {
    private Employee employeeMr;
    private Employee employeeMrs;
    private Employee employeeMiss;

    @BeforeEach
    void initialize()
    {
        employeeMr = new Employee("Mr", "Matthew","Full-time","123456",1234567, 22);
        employeeMrs = new Employee("Mrs", "Matthew","Full-time","123456",1234567, 22);
        employeeMiss = new Employee("Miss", "Matthew","Part-time","123456",1234567, 22);
    }

    @DisplayName("Test Constructor")
    @Test
    void constructorTest()
    {
        assertEquals("Mrs", employeeMrs.getTitle());
        assertEquals("Miss", employeeMiss.getTitle());

        assertEquals("Mr", employeeMr.getTitle());
        assertEquals("Matthew", employeeMr.getName());

        assertEquals("Full-time", employeeMr.getType());
        assertEquals("Part-time", employeeMiss.getType());

        assertEquals(1234567, employeeMr.getPhone());
        assertEquals("123456", employeeMr.getPpsid());
        assertEquals(22, employeeMr.getAge());
    }

    @DisplayName("Test title is valid")
    @Test
    void invalidTitleTest()
    {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Employee("notMr",
                                                                                        "Matthew",
                                                                                        "Full-time",
                                                                                        "123456",
                                                                                        1234567,
                                                                                        22));
        assertEquals("Must enter a valid title (Mr, Mrs, Miss)", ex.getMessage());


    }

    @DisplayName("Test name is valid")
    @Test
    void invalidNameTest()
    {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Employee("Mr",
                                                                                        "t",
                                                                                        "Full-time",
                                                                                        "123456",
                                                                                        1234567,
                                                                                        22));
        assertEquals("Name must be minimum 5 characters and maximum 22 characters", ex.getMessage());

        Exception ex1 = assertThrows(IllegalArgumentException.class, () -> new Employee("Mr",
                                                                                        "ThisIs23CharactersLong1",
                                                                                        "Full-time",
                                                                                        "123456",
                                                                                        1234567,
                                                                                        22));
        assertEquals("Name must be minimum 5 characters and maximum 22 characters", ex1.getMessage());
    }

    @DisplayName("Test PPSID is valid")
    @Test
    void invalidPpsidTest()
    {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Employee("Mr",
                                                                                        "Matthew",
                                                                                        "Full-time",
                                                                                        "123",
                                                                                        1234567,
                                                                                        22));
        assertEquals("PPSID must be 6 characters long", ex.getMessage());
    }

    @DisplayName("Test phone is valid")
    @Test
    void invalidPhoneTest()
    {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Employee("Mr",
                                                                                        "Matthew",
                                                                                        "Full-time",
                                                                                        "123456",
                                                                                        123,
                                                                                        22));
        assertEquals("Phone must be 7 characters long", ex.getMessage());
    }

    @DisplayName("Test type is valid")
    @Test
    void invalidTypeTest()
    {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Employee("Mr",
                                                                                        "Matthew",
                                                                                        "notFull-time",
                                                                                        "123456",
                                                                                        1234567,
                                                                                        22));
        assertEquals("ie.gmit.employee.Employee type must be Part-time or Full-time", ex.getMessage());
    }

    @DisplayName("Test age is valid")
    @Test
    void invalidAgeTest()
    {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Employee("Mr",
                                                                                        "Matthew",
                                                                                        "Full-time",
                                                                                        "123456",
                                                                                        1234567,
                                                                                        16));
        assertEquals("ie.gmit.employee.Employee too young to work, must be over 18", ex.getMessage());
    }
}
