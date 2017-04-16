import rewards.Customer
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_rewards_customerprofile_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/profile.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'customer.label', default: 'Customer'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
if(true && (flash.message)) {
printHtmlPart(5)
expressionOut.print(flash.message)
printHtmlPart(6)
}
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(9)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(10)
expressionOut.print(error.field)
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('message','g',18,['error':(error)],-1)
printHtmlPart(13)
})
invokeTag('eachError','g',19,['bean':(customerInstance),'var':("error")],3)
printHtmlPart(14)
})
invokeTag('hasErrors','g',21,['bean':(customerInstance)],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(15)
invokeTag('hiddenField','g',23,['name':("version"),'value':(customerInstance?.version)],-1)
printHtmlPart(16)
invokeTag('actionSubmit','g',25,['class':("save"),'action':("updateProfile"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: customerInstance, field: 'firstName', 'error'))
printHtmlPart(18)
invokeTag('message','g',30,['code':("customer.firstName.label"),'default':("First Name")],-1)
printHtmlPart(19)
invokeTag('textField','g',33,['name':("firstName"),'value':(customerInstance?.firstName)],-1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: customerInstance, field: 'lastName', 'error'))
printHtmlPart(21)
invokeTag('message','g',38,['code':("customer.lastName.label"),'default':("Last Name")],-1)
printHtmlPart(19)
invokeTag('textField','g',41,['name':("lastName"),'value':(customerInstance?.lastName)],-1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: customerInstance, field: 'phone', 'error'))
printHtmlPart(22)
invokeTag('message','g',45,['code':("customer.phone.label"),'default':("Phone")],-1)
printHtmlPart(23)
invokeTag('phone334','g',46,['phone':(customerInstance.phone)],-1)
printHtmlPart(24)
expressionOut.print(hasErrors(bean: customerInstance, field: 'email', 'error'))
printHtmlPart(25)
invokeTag('message','g',51,['code':("customer.email.label"),'default':("Email")],-1)
printHtmlPart(19)
invokeTag('textField','g',54,['name':("email"),'value':(customerInstance?.email)],-1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: customerInstance, field: 'totalPoints', 'error'))
printHtmlPart(26)
invokeTag('message','g',58,['code':("customer.totalPoints.label"),'default':("Total Points")],-1)
printHtmlPart(27)
invokeTag('fieldValue','g',59,['bean':(customerInstance),'field':("totalPoints")],-1)
printHtmlPart(28)
})
invokeTag('form','g',64,['url':([resource:customerInstance, action:'updateProfile']),'method':("PUT")],2)
printHtmlPart(29)
if(true && (flash.message)) {
printHtmlPart(30)
expressionOut.print(flash.message)
printHtmlPart(6)
}
printHtmlPart(31)
invokeTag('sortableColumn','g',75,['property':("type"),'title':(message(code: 'award.type.label', default: 'Type'))],-1)
printHtmlPart(32)
invokeTag('sortableColumn','g',77,['property':("awardDate"),'title':(message(code: 'award.checkinDate.label', default: 'Award Date'))],-1)
printHtmlPart(33)
invokeTag('message','g',79,['code':("award.customer.label"),'default':("Phone")],-1)
printHtmlPart(34)
invokeTag('sortableColumn','g',81,['property':("points"),'title':(message(code: 'award.points.label', default: 'Points'))],-1)
printHtmlPart(35)
loop:{
int i = 0
for( checkinInstance in (customerInstance.awards) ) {
printHtmlPart(36)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(37)
expressionOut.print(fieldValue(bean: checkinInstance, field: "type"))
printHtmlPart(38)
expressionOut.print(fieldValue(bean: checkinInstance, field: "awardDate"))
printHtmlPart(38)
invokeTag('phone334','g',93,['phone':(customerInstance.phone)],-1)
printHtmlPart(38)
expressionOut.print(fieldValue(bean: checkinInstance, field: "points"))
printHtmlPart(39)
i++
}
}
printHtmlPart(40)
})
invokeTag('captureBody','sitemesh',102,[:],1)
printHtmlPart(41)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1492238803000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
