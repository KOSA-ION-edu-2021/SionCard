FROM node:14 as node_build

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . .

RUN npm run build

# nginx
FROM nginx:latest
COPY ./nginx.conf /etc/nginx/conf.d/default.conf

COPY --from=node_build /app/dist /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]


# sudo docker build -t front-image
# sudo docker run -p 8080:8080 -v /app/dist -v /app/node_modules -v $(pwd):/app front-image
