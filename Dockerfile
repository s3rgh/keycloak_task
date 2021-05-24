FROM maven:3.8.1-jdk-8

MAINTAINER Mezinov Sergey (https://t.me/s3rgh)

# Install wget.
RUN apt-get install -y wget

# Google Chrome
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
	&& echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list \
	&& apt-get update -qqy \
	&& apt-get -qqy install google-chrome-stable \
	&& rm /etc/apt/sources.list.d/google-chrome.list \
	&& rm -rf /var/lib/apt/lists/* /var/cache/apt/* \
	&& sed -i 's/"$HERE\/chrome"/"$HERE\/chrome" --no-sandbox/g' /opt/google/chrome/google-chrome

COPY pom.xml /usr/local/keyclock_task/pom.xml

COPY src /usr/local/keyclock_task/src

WORKDIR /usr/local/keyclock_task

CMD ["mvn","clean","test"]