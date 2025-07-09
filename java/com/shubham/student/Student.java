package com.shubham.student;

public class Student {
    private int id;
    private String name;
    private String course;
    private int marks;
    private String email;
    private String phone;

    public Student() {}

    public Student(int id, String name, String course, int marks, String email, String phone) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
        this.email = email;
        this.phone = phone;
    }

    public int getId() { 
        return id; 
    }

    public String getName() { 
        return name; 
    }

    public String getCourse() { 
        return course; 
    }

    public int getMarks() { 
        return marks; 
    }

    public String getEmail() { 
        return email; 
    }

    public String getPhone() { 
        return phone; 
    }

    public void setId(int id) { 
        this.id = id; 
    }

    public void setName(String name) { 
        this.name = name; 
    }

    public void setCourse(String course) { 
        this.course = course; 
    }

    public void setMarks(int marks) { 
        this.marks = marks; 
    }

    public void setEmail(String email) { 
        this.email = email; 
    }

    public void setPhone(String phone) { 
        this.phone = phone; 
    }

    @Override
    public String toString() {
        return "  ID: " + id +
               ", Name: " + name +
               ", Course: " + course +
               ", Marks: " + marks +
               ", Email: " + email +
               ", Phone: " + phone;
    }
}
