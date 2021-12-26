FROM node:14
WORKDIR /loginapp
COPY package.json /loginapp
RUN npm install 
COPY . /loginapp
CMD ["node","login_api.js"]
EXPOSE 8001