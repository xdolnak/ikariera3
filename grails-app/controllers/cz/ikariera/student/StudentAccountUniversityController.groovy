package ikariera.student

import cz.ikariera.security.User
import cz.ikariera.student.StudentAccount


class StudentAccountUniversityController {


    def springSecurityService

    def index() {

        User user = springSecurityService.getCurrentUser()
        if (!user) {
            redirect(controller: "login")
        }

        render(view: "/studentAccountUniversity/index", model: [studentInstance: user.studentAccount])
    }


    def save() {

        User userInstance = springSecurityService.getCurrentUser() as User
        if (!userInstance) {
            redirect(controller: "login")
        }

        StudentAccount studentInstance = userInstance.studentAccount

        studentInstance?.educations?.clear()

        bindData(studentInstance, params)

        studentInstance.validate()

        if (studentInstance.hasErrors()) {

            //println(studentInstance.errors)

            render(view: "/studentAccountUniversity/index", model: [userInstance: userInstance])
            return
        }


        if (!studentInstance.save(failOnError: true, flush: true)) {

            render(view: "/studentAccountUniversity/index", model: [userInstance: userInstance])
            return
        }
        flash.message = message(code: 'student.account.update')
        redirect(action: "index")

    }


}
