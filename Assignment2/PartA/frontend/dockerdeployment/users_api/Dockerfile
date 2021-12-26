FROM node:14
WORKDIR /usersapp
COPY package.json /usersapp
RUN npm install 
COPY . /usersapp
CMD ["node","users_api.js"]
EXPOSE 8002