FROM nginx:alpine
MAINTAINER zhaw.ch
RUN rm -rf /usr/share/nginx/html/*
COPY www/* /usr/share/nginx/html/
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
