import rewards.Customer
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_rewards_customerlookup_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/lookup.gsp" }
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
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('message','g',10,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(4)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(5)
invokeTag('message','g',13,['code':("default.home.label")],-1)
printHtmlPart(6)
createTagBody(2, {->
invokeTag('message','g',14,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',14,['class':("create"),'action':("create")],2)
printHtmlPart(7)
invokeTag('message','g',18,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
invokeTag('sortableColumn','g',26,['property':("phone"),'title':(message(code: 'customer.phone.label', default: 'Phone'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',28,['property':("firstName"),'title':(message(code: 'customer.firstName.label', default: 'First Name'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',30,['property':("lastName"),'title':(message(code: 'customer.lastName.label', default: 'Last Name'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',32,['property':("email"),'title':(message(code: 'customer.email.label', default: 'Email'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',34,['property':("totalPoints"),'title':(message(code: 'customer.totalPoints.label', default: 'Total Points'))],-1)
printHtmlPart(13)
loop:{
int i = 0
for( customerInstance in (customerInstanceList) ) {
printHtmlPart(14)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(15)
createTagBody(3, {->
printHtmlPart(16)
expressionOut.print(fieldValue(bean: customerInstance, field: "phone"))
})
invokeTag('link','g',42,['action':("show"),'id':(customerInstance.id)],3)
printHtmlPart(17)
expressionOut.print(fieldValue(bean: customerInstance, field: "firstName"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: customerInstance, field: "lastName"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: customerInstance, field: "email"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: customerInstance, field: "totalPoints"))
printHtmlPart(18)
i++
}
}
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',57,[:],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1492231111000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
