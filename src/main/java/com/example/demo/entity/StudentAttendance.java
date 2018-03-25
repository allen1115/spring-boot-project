package com.example.demo.entity;

public class StudentAttendance {
    private Long id;

    private Long studentId;

    private String courseName;

    private String courseCode;

    private Long attended;

    private Long explainedAbsence;

    private Long sessions;

    private Double attendance;

    private String term;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode == null ? null : courseCode.trim();
    }

    public Long getAttended() {
        return attended;
    }

    public void setAttended(Long attended) {
        this.attended = attended;
    }

    public Long getExplainedAbsence() {
        return explainedAbsence;
    }

    public void setExplainedAbsence(Long explainedAbsence) {
        this.explainedAbsence = explainedAbsence;
    }

    public Long getSessions() {
        return sessions;
    }

    public void setSessions(Long sessions) {
        this.sessions = sessions;
    }

    public Double getAttendance() {
        return attendance;
    }

    public void setAttendance(Double attendance) {
        this.attendance = attendance;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term == null ? null : term.trim();
    }
}