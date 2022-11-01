# Library Service  
  
## Info   
The purpose of this service is to act as a library store.  
The Order and Student services will be able to look up books and manipulate data regarding books through the REST endpoints in /titles.  
All data is stored in the open source relational database PostgreSQL.  
  
**To run this service use the following commands**  

```docker
docker build -t library-service .
``` 
&&  
  
```docker
docker-compose -f library.docker-compose.yml up -d --build
```  
  
To take down the services again use the following command:  
  
```docker
docker-compose -f library.docker-compose.yml down
```
