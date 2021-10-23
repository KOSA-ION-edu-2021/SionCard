FROM node:14

WORKDIR /app

COPY package*.json ./

#RUN npm install -g http-server
RUN npm install

COPY . .

RUN npm run build

EXPOSE 8080

CMD ["npm" ,"run", "serve"]


# sudo docker build -t front-image
# sudo docker run -p 8080:8080 -v /app/dist -v /app/node_modules -v $(pwd):/app front-image
