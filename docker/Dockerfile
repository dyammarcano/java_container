# get oracle database image
FROM oracle/database:11.2.0.2-xe

# install oracle jdbc driver
RUN yum install -y oracle-jdbc11

# set working directory
WORKDIR /app

# copy jar file
COPY .. /app/app.jar

# copy oracle jdbc driver
COPY driver/ojdbc11.jar /app/ojdbc.jar

# copy entrypoint.sh
COPY ./docker/entrypoint.sh /app/entrypoint.sh

# set environment variables
ENV ORACLE_URL="jdbc:oracle:thin:@localhost:1521:xe"
ENV ORACLE_USER="system"
ENV ORACLE_PASSWORD="oracle"

# prevent root user from running
RUN chown -R oracle:dba /app

# change user to oracle
RUN chmod +x /app/entrypoint.sh

# run entrypoint.sh
ENTRYPOINT ["/app/entrypoint.sh"]
