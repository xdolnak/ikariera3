import cz.ikariera.security.Role

/**
 * Created by Michal Dolnak on 23.7.2016.
 */
// locations to search for config files that get merged into the main config
// config files can either be Java properties files or ConfigSlurper scripts

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }


grails.web.url.converter = 'hyphenated'

grails.app.context = "/"

grails.project.groupId = ikariera // change this to alter the default package name and Maven publishing destination

grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false


grails.project.fork = [
        // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
        //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
        //debug: [maxMemory: 768, minMemory: 64, debug: true, maxPerm: 256, forkReserve: false],
        // configure settings for the test-app JVM, uses the daemon by default
        test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon: true],
        // configure settings for the run-app JVM
        run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve: false],
        // configure settings for the run-war JVM
        war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve: false],
        // configure settings for the Console UI JVM
        console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]


// Find problem with css from here

grails.mime.disable.accept.header.userAgents = ['Gecko', 'WebKit', 'Presto', 'Trident']
grails.mime.types = [
        all          : '*/*',
        atom         : 'application/atom+xml',
        css          : 'text/css',
        csv          : 'text/csv',
        form         : 'application/x-www-form-urlencoded',
        html         : ['text/html', 'application/xhtml+xml'],
        js           : 'text/javascript',
        json         : ['application/json', 'text/json'],
        multipartForm: 'multipart/form-data',
        rss          : 'application/rss+xml',
        text         : 'text/plain',
        hal          : ['application/hal+json', 'application/hal+xml'],
        xml          : ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*', '/catalog/*']


// The default codec used to encode data with ${}
 grails.views.default.codec = "html" // none, html, base64

// The default scope for controllers. May be prototype, session or singleton.
// If unspecified, controllers are prototype scoped.
grails.controllers.defaultScope = 'singleton'

grails.views.gsp.encoding = "UTF-8"

grails.databinding.dateFormats = ['yyyy-MM-dd', 'yyyy-MM-dd HH:mm:ss.S']

grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside ${}
                scriptlet = 'html' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        filteringCodecForContentType {
            //'text/html' = 'html'
        }
    }
}

grails.converters.encoding = "UTF-8"
grails.converters.json.date = "javascript"
grails.converters.default.pretty.print = true

// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart = false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password', 'passwordConfirm', 'password1', 'password2', 'passwordOld']

// enable query caching by default
grails.hibernate.cache.queries = true


// until here

environments {
    development {
        grails.logging.jul.usebridge = true
        server.port = 8089  // funguje

    }
    production {
        grails.logging.jul.usebridge = false
        grails.serverURL = 'http://www.cz.cz.cz.ikariera.cz'

    }
    test {

        grails.logging.jul.usebridge = false
        grails.serverURL = 'http://localhost:8090'//8090

    }
}

def homeDirectory = ""

environments {
    development {

        homeDirectory = System.getProperty("user.home") + "/ikariera/" //premenna prostredia je zle nastavena


    }
    production {

        homeDirectory = "/var/uploads/ikariera/"

    }
    test {

        homeDirectory = System.getProperty("user.home") + "/ikariera/"


    }
}

upload.directory.hero = homeDirectory + "hero"
upload.directory.mediaFile = homeDirectory + "media"
upload.directory.studentPhoto = homeDirectory + "photo"
upload.directory.studentCv = homeDirectory + "cv"
upload.directory.emailAttachments = homeDirectory + "attachment"
upload.directory.companyMainLogo = homeDirectory + "mainLogo"
upload.directory.adminMainLogo = homeDirectory + "adminMainLogo"
upload.directory.adminLogo = homeDirectory + "adminLogo"
upload.directory.banner = homeDirectory + "advertisement"
upload.directory.advertisement = homeDirectory + "advertisement"
upload.directory.companyLogo = homeDirectory + "smallLogo"
upload.directory.companyGallery = homeDirectory + "companyGallery"
upload.directory.companyGalleryView = homeDirectory + "companyGallery"



// Added by the Spring Security Core plugin:

grails.plugin.springsecurity.securityConfigType = 'Requestmap'

grails.plugin.springsecurity.auth.loginFormUrl = '/login/auth' // '/'
grails.plugin.springsecurity.successHandler.defaultTargetUrl = '/'


grails.plugin.springsecurity.logout.filterProcessesUrl = '/logout/index'
grails.plugin.springsecurity.apf.filterProcessesUrl = '/security/login_acccess_check'    //Login form post URL, intercepted by Spring Security filter.
grails.plugin.springsecurity.apf.usernameParameter = 'security_username'  //	Login form username parameter.
grails.plugin.springsecurity.apf.passwordParameter = 'security_password'  //	Login form password parameter.


grails.plugin.springsecurity.useSecurityEventListener = true

grails.plugin.springsecurity.useBasicAuth = false
grails.plugin.springsecurity.basic.realmName = "iKariera"


grails.plugin.springsecurity.onInteractiveAuthenticationSuccessEvent = { e, appCtx ->

    cz.ikariera.security.User.withTransaction {
        def user = cz.ikariera.security.User.get(appCtx.springSecurityService.principal.id)
        user.lastLoginDate = new Date()
        user.save(flush: true, failOnError: true)
    }
}

grails.plugin.springsecurity.userLookup.userDomainClassName = 'cz.ikariera.security.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'cz.ikariera.security.UserRole'
grails.plugin.springsecurity.authority.className = 'cz.ikariera.security.Role'
grails.plugin.springsecurity.requestMap.className = 'cz.ikariera.security.Requestmap'

grails.plugin.springsecurity.password.algorithm = 'SHA-256'
grails.plugin.springsecurity.password.hash.iterations = 1

grails.plugin.springsecurity.dao.reflectionSaltSourceProperty = 'username'
grails.plugin.springsecurity.adh.errorPage = null

grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/dbconsole/**',   access: ['permitAll']],
        [pattern: '/',               access: ['permitAll']],
        [pattern: '/error',          access: ['permitAll']],
        [pattern: '/index',          access: ['permitAll']],
        [pattern: '/index.gsp',      access: ['permitAll']],
        [pattern: '/shutdown',       access: ['permitAll']],
        [pattern: '/assets/**',      access: ['permitAll']],
        [pattern: '/**/js/**',       access: ['permitAll']],
        [pattern: '/**/css/**',      access: ['permitAll']],
        [pattern: '/**/images/**',   access: ['permitAll']],
        [pattern: '/**/fonts/**',    access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']],
        [pattern: '/check', 		 access: ['permitAll']],
        [pattern: '/**', 	  		 access: ["ROLE_ADMIN"]]
]

grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/assets/**',      filters: 'none'],
        [pattern: '/**/js/**',       filters: 'none'],
        [pattern: '/**/css/**',      filters: 'none'],
        [pattern: '/**/images/**',   filters: 'none'],
        [pattern: '/**/fonts/**',    filters: 'none'],
        [pattern: '/**/favicon.ico', filters: 'none'],
        [pattern: '/**',             filters: 'JOINED_FILTERS'],
]

grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*', '/fonts/*']
grails.resources.adhoc.includes = ['/images/**', '/css/**', '/js/**', '/plugins/**', '/fonts/**']

grails.controllers.upload.maxFileSize = 5242880
grails.controllers.upload.maxRequestSize = 5242880

environments {
    production {
        grails.plugin.springsecurity.secureChannel.definition = [
                //   '/rest/**': 'REQUIRES_SECURE_CHANNEL'
        ]

    }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////


/*environments {
    test {
        grails {
            mail {

                overrideAddress = "test_admin@ikariera.eu"
            }
        }

    }
    development {
        grails {
            mail {
                host = "smtp.gmail.com"
                port = 465
                username = "grailsdevelop@gmail.com"
                password = "hamachi42"
                props = ["mail.smtp.security"              : "true",
                         "mail.smtp.socketFactory.port"    : "465",
                         "mail.smtp.socketFactory.class"   : "javax.net.ssl.SSLSocketFactory",
                         "mail.smtp.socketFactory.fallback": "false"]

                overrideAddress = "iaeste@atlas.cz"
            }
        }


    }


}*/

internalEmailService {
    name = " - iKariera.cz"
    //replyAddress = "info@ikariera.cz"
    replyAddress = "czikariera@gmail.com"
    subjectPrefix = "[iKariera.cz] "

    //infoEmails = "info@ikariera.cz"
    infoEmails = "czikariera@gmail.com"
    infoEmailsSubjectPrefix = "[Notification iKariera.cz] "
    //infoEmailsReply = "no-reply@ikariera.cz"
    infoEmailsReply = "czikariera@gmail.com"
}


defaultCountry="cze" // used for contry selects

/* Rendering engine for burning image plugin */
bi.renderingEngine = RenderingEngine.IMAGE_MAGICK

bi.imageMagickQuality = 100
bi.imageMagickCompression = 0

/* recaptcha */

// Added by the Recaptcha plugin:
recaptcha {
    // These keys are generated by the ReCaptcha service
    publicKey = "6Lehze4SAAAAAH3GhvEbn-B5CSf3hyp47i9lHpkn"
    privateKey = "6Lehze4SAAAAAP6_-sEQ1WEo_OAYrC1gfWHt-gRP"

// Include the noscript tags in the generated captcha
    includeNoScript = true

// Force language change. See this for more: http://code.google.com/p/recaptcha/issues/detail?id=133
    forceLanguageInURL = false

// Set to false to disable the display of captcha
    enabled = true

// Communicate using HTTPS
    useSecureAPI = true
}

mailhide { // Generated by the Mailhide service
    publicKey = ""
    privateKey = ""
}




environments {
    production {

        mailchimp.server = true


    }
    development {

        mailchimp.server = false

    }

}