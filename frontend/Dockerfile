FROM node:14 as node_build

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . .

RUN npm run build

# nginx
FROM nginx:latest
COPY ./nginx.conf /etc/nginx/conf.d/default.conf
COPY ./cert.crt /etc/nginx/cert.crt
COPY ./cert.key /etc/nginx/cert.key

COPY --from=node_build /app/dist /usr/share/nginx/html

EXPOSE 443

CMD ["nginx", "-g", "daemon off;"]