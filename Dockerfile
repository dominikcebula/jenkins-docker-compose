FROM jenkins/jenkins:lts-jdk21

USER jenkins

COPY plugins/plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli --plugin-file /usr/share/jenkins/ref/plugins.txt

COPY jobs /usr/share/jenkins/ref/jobs

COPY local-plugins/* /usr/share/jenkins/ref/plugins/

EXPOSE 8080 50000
