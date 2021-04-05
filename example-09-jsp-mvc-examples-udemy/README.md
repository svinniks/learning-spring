Generic examples:

1. GET /example1 renders a form, which sends POST to /example1, which renders form data in a JSP view.
2. GET /example2 renders a form, which sends POST to /example2, which uses Model to render some data in a JSP view.
3. GET /assets/img/demotivator.jpg will load an image from static resource (configured in the AppConfig);
GET /example3 will render a JSP page with the same picture. ( It uses ${pageContext.request.contextPath} to correctly resolve
resource if the dispatcher servlet is registered to a non-root mapping)
4. GET /example4/hello demonstrates @RequestMapping on the controller level

Form tag examples:

1. GET /form-tags/example1 renders a form using the Spring forms taglib and an object (Person) bound to the model, with some prepopulated field values.
It then sends POST to the same URL, passing form data to the @ModelAttribute, which is populated to the model and
passed further to the view JSP, which displays it in HTML. The form uses several Spring taglib tags.

