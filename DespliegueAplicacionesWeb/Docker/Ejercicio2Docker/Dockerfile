FROM node:14

WORKDIR /app

# Primero copiamos TODO el código de Windows al contenedor
COPY . .

# Ahora instalamos las dependencias DIRECTAMENTE dentro del contenedor
# Esto garantiza que 'express' exista en /app/node_modules
RUN npm install

EXPOSE 80

CMD [ "node", "server.js" ]
