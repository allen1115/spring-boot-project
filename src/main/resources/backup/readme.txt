Environment Setup Guidance:
1. Install Java into your computer and setup environment variable
2. Install Maven into your computer and setup environment variable
3. Install mysql8.0 into your computer and setup environment variable
4. Replace database connection credentials with your own in application.yaml spring.datasource.username & spring.datasource.password, ensure application can connect database successfully.
5. Create new database called final_year_project
6. Restore the database using backup 'final_year_project_0507.sql' which located under resources/backup/DB_Backup
7. Run mvn spring-boot:run under directory that contains the pom.xml file
8. Visit localhost:8080 and login using admin/admin