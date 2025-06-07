FROM jenkins/jenkins:lts-jdk21

# Switch to root to install packages
USER root

# Install Maven
RUN apt update && \
    apt install -y maven && \
    apt clean && \
    rm -rf /var/lib/apt/lists/*

RUN whereis mvn

# Switch back to jenkins user
USER jenkins

COPY plugins/plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli --plugin-file /usr/share/jenkins/ref/plugins.txt

COPY jobs /usr/share/jenkins/ref/jobs

COPY local-plugins/* /usr/share/jenkins/ref/plugins/

# Create Jenkins configuration directory
RUN mkdir -p /usr/share/jenkins/ref/init.groovy.d/

# Copy Jenkins configuration scripts
COPY jenkins-config/*.groovy /usr/share/jenkins/ref/init.groovy.d/

EXPOSE 8080 50000
