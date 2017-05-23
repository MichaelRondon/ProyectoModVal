FROM gersua/payara:latest
EXPOSE 8080
ENV WORKSPACE /opt
WORKDIR ${WORKSPACE}
ENV WAR_FILE saldos-service.war
COPY target/${WAR_FILE} .