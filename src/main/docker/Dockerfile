FROM java:8
ADD bank_system-1.0.0-SNAPSHOT.jar banksystem.jar
ADD wrapper.sh wrapper.sh
RUN bash -c 'chmod +x /wrapper.sh'
RUN sh -c 'touch /banksystem.jar'
ENTRYPOINT ["/bin/bash", "/wrapper.sh"]