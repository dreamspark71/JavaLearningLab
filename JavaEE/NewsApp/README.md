# NewsApp 

This is code from a NetBeans Tutorial. It creates a NewEntity table in the database contains the fields: ID, title, body.

This basic EE app contains two modules, one EJB module and one Web module. It uses JMS to push messages to and has a listener
to pull messages from the message queue and create an entry in the database via ORM using JPA.
The EJB used is stateless and contains no interface.

It uses Servlets to handle the request coming from the web browser.

### Environment used ###
Java 8 (build 1.8.0_71) was the version this started on.
NetBeans 8.1 IDE using Glassfish 4.0 server.
Ant build system (The ANT build and dist directories have been removed)
