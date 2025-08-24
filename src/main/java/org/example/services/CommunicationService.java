package org.example.services;

import org.example.daos.CommunicationDao;
import org.example.daos.CourseDao;
import org.example.daos.TeacherDao;
import org.example.entities.Communication;
import org.example.entities.Course;
import org.example.entities.Student;
import org.example.entities.Teacher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CommunicationService {
    private final CommunicationDao communicationDao;
    private final TeacherDao teacherDao;
    private final CourseDao courseDao;


    public CommunicationService(CommunicationDao communicationDao, TeacherDao teacherDao, CourseDao courseDao) {
        this.communicationDao = communicationDao;
        this.teacherDao = teacherDao;
        this.courseDao = courseDao;
    }

    public List<Communication> createForCourse(Long teacherId, String message, Long courseId) {
        Course course = courseDao.findBYId(courseId);
        Teacher teacher = teacherDao.findBYId(teacherId);
        List<Student> students = course.getStudents();
        List<Communication> communications = new ArrayList<>();
        students.forEach(student -> {
            Communication communication = new Communication();
            communication.setMessage(message);
            communication.setTeacher(teacher);
            communication.setStudent(student);
            communication.setSentDate(LocalDate.now());
            communication = communicationDao.save(communication);
            communications.add(communication);
        });
        return communications;
    }
    public  void  deleteMessage(Long id){
        communicationDao.delete(id);
    }
}
