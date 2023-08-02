# get oracle database image
FROM oraclelinux:9

# install oracle jdbc driver
RUN dnf update -y && \
    dnf install -y https://download.oracle.com/otn_software/linux/instantclient/2111000/oracle-instantclient-basic-21.11.0.0.0-1.el8.x86_64.rpm && \
    dnf install -y java-17-openjdk && \
    dnf clean all && \
    rm -rf /var/cache/dnf

# set working directory
WORKDIR /app

# copy jar file
COPY ./docker/*.jar /app/app.jar

# copy oracle jdbc driver
#COPY ./driver/ojdbc11.jar /app/ojdbc.jar

# copy entrypoint.sh
COPY ./docker/entrypoint.sh /app/entrypoint.sh

# set environment variables
ENV ORACLE_URL="jdbc:oracle:thin:@localhost:1521:xe"
ENV ORACLE_USER="system"
ENV ORACLE_PASSWORD="oracle"
ENV LANG en_US.utf8
ENV JAVA_HOME /usr/java/jdk-8
ENV PATH $PATH:$JAVA_HOME/bin

# prevent root user from running
#RUN chown -R oracle:dba /app

# change user to oracle
#RUN chmod +x /app/entrypoint.sh

# run entrypoint.sh
#CMD ["entrypoint.sh"]
