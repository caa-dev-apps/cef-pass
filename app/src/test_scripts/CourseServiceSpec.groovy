// File: CourseServiceSpec.groovy
package com.mrhaki.blog

@Grab('org.spockframework:spock-core:0.4-groovy-1.7')
import spock.lang.Specification

class CourseServiceSpec extends Specification {

    def "Create new course with teacher and description"() {
        setup:
        def courseService = new CourseService()

        when:
        def course = courseService.create('mrhaki', 'Groovy Goodness')

        then:
        'Mrhaki' == course.teacher.name
        'Groovy Goodness' == course.description
        !course.students
    }

}

class CourseService {
    Course create(String teacherName, String description) {
        new Course(teacher: new Person(name: teacherName), description: description)
    }
}

class Course {
    Person teacher
    String description
    List<Person> students
}

class Person {
    String name
}
