FROM node:14
WORKDIR /registerapp
COPY package.json /registerapp
RUN npm install 
COPY . /registerapp
CMD ["node","register_api.js"]
EXPOSE 8000