FROM node:14
WORKDIR /frontapp
COPY package.json /frontapp
RUN npm install 
RUN npm install react-scripts@4.0.3
RUN npm install jquery popper.js
COPY . /frontapp
CMD ["npm","start"]
EXPOSE 3000