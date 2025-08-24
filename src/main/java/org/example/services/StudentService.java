package org.example.services;

import org.example.daos.CourseDao;
import org.example.daos.StudentDao;
import org.example.entities.Course;
import org.example.entities.Student;

public class StudentService {
    private final StudentDao studentDao;
    private final CourseDao courseDao;


    public StudentService(StudentDao studentDao, CourseDao courseDao) {
        this.studentDao = studentDao;
        this.courseDao = courseDao;
    }

    public Student create(Student student, Long courseId) {
        Course course = courseDao.findBYId(courseId);
        student.setCourse(course);
        return studentDao.save(student);
    }

    public Student update(Student student, Long courseId) {
        Student existingStudent = studentDao.findBYId(student.getId());
        existingStudent.setName(student.getName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setBirthday(student.getBirthday());
        existingStudent.setCourse(courseDao.findBYId(courseId));
        return studentDao.save(existingStudent);
    }
}
