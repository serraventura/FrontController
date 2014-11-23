FrontController
===============

A custom Front Controller pattern implementation. For small web apps which there's no need to use any framework.


How to use:
===============

 - Create a new class into package "Controller" using the SUFIX "Ctrl";
 - Implement the Interface IAction;
 - Create the HTML or JSP file related to the Controller into "WebContent" folder;
 - Define the VIEW as return in your controller specifying the HTML/JSP you have just created;