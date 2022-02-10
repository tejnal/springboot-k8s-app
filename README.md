# Project 
 Build and deploy spring app on local k8s cluster using local jenkins server 

## Tech Stack
Spring boot, java 11, Spring Data, Spring documentation, Spring Actuator
Spring web, Spring data jpa, embedded tomcat, docker, k8s and Jenkins 

## kubernates components that been used in this project 
 1. Kind - to create local k8 cluster , we do this differently in cloud using Terraform and AWS EKS  
 2. Ingress - for routing rules, manage inbound and outbound traffic 
 3. Deployment.ymal -- to create pods on kubernetes 
 4. Service.yaml -- service is an abstraction that defines a logical set of pods
 

## Step 1: Create application 

## Step 2: Dockerise your application and push image to Docker Hub
 * Created Dockerfile 
 * Build docker image 
  ```
docker build -t springboot-k8s-app .
     
  ```
 * run your image 
  ```
docker run -p 8080:8081 springboot-k8s-app

  ```
 * Create repository in docker hub and push the app
  ```
   docker tag springboot-k8s-app tejnal/kubernetes:springboot-k8s-app
   docker push tejnal/kubernetes:springboot-k8s-app
  ```
 
 ## Step 3: Create k8s cluster 
 
 1. Install Kind or Minikub to setup local k8s cluster 
   ```
     brew install kind 
   
     Crete a cluster by running kind-config.yaml by
   
     kind create cluster -- config kind-config.yaml 
   
     check cluster name -  run - kind get clusters

    ```

  2. Create Deployment.ymal - it provides the ability to create pods 
     ```
       to create deplayment.yaml and run that kubectl apply -f deployment.yaml
     ```
  3. Create Service.ymal -- a k8s component that allow you to access the pod 
    ```
      to create service.yaml and run kubectl apply -f service.yaml

     ```
  4. create Ingress.ymal -- Network filter they rout the inbound and outbound request based on certain rule 
      ```
        to create ingress.ymal and run kubectl apply -f ingress.yaml 
      ```
 
 
 ## Step 4: Deploy Docker Image To Kubernetes Cluster Using Jenkins

 1. Install jenkins server on your system [ for mac]  
     ```
        docker run -p 8080:8080 -p 50000:50000 -v ~/jenkins_home:/var/jenkins_home jenkins/jenkins:lts
       
        ```
 2. Integate jenkind with you gitgub or bitbucket 

 3. Create Jenkins file 

 4. Push you code to source code managment 

 5. This will automatically trigger the build and deploy  your service on k8s 



 
 











