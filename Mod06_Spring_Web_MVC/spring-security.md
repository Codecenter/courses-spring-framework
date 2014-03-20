Example of Using Spring Security
--------------------------------

This exercise contains example configuration for enabling Spring Security. 

When enabled the web application is protected using HTTP Basic Authentication. The username to access the application is `john` and the password is `secret`. The single username is defined in `/WEB-INF/securityContext.xml` under `src/main/webapp`.

To enable Spring Security perform the following changes to the example:

1. Verify that the `pom.xml` has Spring Security related dependencies enabled at the end of the file.
2. Make the following modifications to `web.xml`:
 1. Uncomment `/WEB-INF/securityContext.xml` in `contextConfigLocation`.
 2. Uncomment `springSecurityFilterChain` at the end of file.
3. Study contents of `/WEB-INF/securityContext.xml` to see an example how Spring Security can be used.
4. Restart Tomcat to apply the changes.
  