FROM node:14

WORKDIR /app

#COPY package*.json ./

RUN npm install -g http-server
#RUN npm install

#COPY . .
COPY ./dist .

#RUN npm run build

EXPOSE 80

CMD ["http-server", "."]


# sudo docker build -t front-image
# sudo docker run -p 8080:8080 front-image
