package org.example.services;

import org.example.daos.CourseDao;
import org.example.daos.TeacherDao;
import org.example.entities.Course;
import org.example.entities.Teacher;

public class CourseService {
    private final CourseDao courseDao;
    private final TeacherDao teacherDao;


    public CourseService(CourseDao courseDao, TeacherDao teacherDao) {
        this.courseDao = courseDao;
        this.teacherDao = teacherDao;
    }

    public Course create(String name, Long teacherId) {
        Teacher teacher = teacherDao.findBYId(teacherId);
        Course course = new Course();
        course.setName(name);
        course.setTeacher(teacher);
        return courseDao.save(course);
    }
}
