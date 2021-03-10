/*
 * Matthew Waters
 * G00357709@gmit.ie
 * Employee.java
 */
package ie.gmit.employee;

public class Employee {
    String title;
    String name;
    String type;
    String ppsid;
    int phone;
    int age;


    Employee(String title, String name, String type, String ppsid, int phone, int age) {
        checkTitle(title);
        checkName(name);
        checkType(type);
        checkPhone(phone);
        checkPpsid(ppsid);
        checkAge(age);

    }

    void checkTitle(String title) {
        if (title.equals("Mr") || title.equals("Mrs") || title.equals("Miss")) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("Must enter a valid title (Mr, Mrs, Miss)");
        }
    }

    void checkName(String name) {
        if (name.length() >= 5 && name.length() <= 22) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name must be minimum 5 characters and maximum 22 characters");
        }
    }

    void checkPpsid(String ppsid) {
        if (ppsid.length() == 6) {
            this.ppsid = ppsid;
        } else {
            throw new IllegalArgumentException("PPSID must be 6 characters long");
        }
    }

    void checkPhone(int phone) {
        if (String.valueOf(phone).length() == 7) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Phone must be 7 characters long");
        }

    }

    void checkType(String type) {
        if (type.equals("Part-time") || type.equals("Full-time")) {
            this.type = type;
        } else {
            throw new IllegalArgumentException("Employee type must be Part-time or Full-time");
        }
    }

    void checkAge(int age) {
        if (age > 18) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Employee too young to work, must be over 18");
        }
    }

    public String getTitle() { return title; }

    public String getName() { return name; }

    public String getPpsid() { return ppsid; }

    public String getType() { return type; }

    public int getPhone() { return phone; }

    public int getAge() { return age; }
}


