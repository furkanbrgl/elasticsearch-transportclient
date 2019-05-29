### Used Dependencies
  Spring Boot Version - 1.5.6.RELEASE
  
  Elasticsearch Java Api Version - 5.5.0
  
  elasticsearch.client.transport Version - 5.5.3 
  
  Elastic Engine Version - elasticsearch - 5.5.3
    
### Guides
 In this project Spring Data Elastic was not used. We use Elastic Client Transport instead of SDE.
 
 Why we used Elastic Client Transport instead of SDE
 
 SDE (version 3.x) support Elastic Engine 5.x but Spring Boot ( version 1.5.6) dont support SDE 3.x 
 
 Detail;
   - Spring Boot 1.5 support SDE 2.x (SDE 2.x support Elastic Engine 2.x version)
   - Spring Boot 2.x support SDE 3.x (SDE 3.x support Elastic Engine 5.x version)
    
   [1.5.1.RELEASE appendix-dependency-versions](https://docs.spring.io/spring-boot/docs/1.5.1.RELEASE/reference/html/appendix-dependency-versions.html)
   
   [Spring Data ElasticSearch Can't Connect with ElasticSearch 5.5.0](https://stackoverflow.com/questions/45264023/spring-data-elasticsearch-cant-connect-with-elasticsearch-5-5-0)

   [Spring Data Elasticsearch Spring Boot version matrix](https://github.com/spring-projects/spring-data-elasticsearch/wiki/Spring-Data-Elasticsearch---Spring-Boot---version-matrix)
   
  

 In This Case There are two ways over come the problem;
 
 a- We have to upgrade spring boot version from 1.5.x to 2.0.x to use SDE 3.x . After That config we can deal Elastic Engin 5.x by SDE 3.x

 b- We dont change using spring version (1.5.60) and use elastic.client.transport (version 5.5.3) instead of SDE  
 
 