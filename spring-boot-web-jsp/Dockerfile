FROM java:8
EXPOSE 8080
add /var/jenkins_home/.m2/repository/org/springframework/boot/spring-boot-web-jsp/1.0/spring-boot-web-jsp-1.0.war spring-boot-web-jsp-1.0.war
ENTRYPOINT ("java","-jar","spring-boot-web-jsp-1.0.war")
