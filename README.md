#https://techdozo.dev/deploying-a-restful-spring-boot-microservice-on-kubernetes/

Spring boot actuator 
Spring swagger documentation 
create as a docker image 
publish to public docker hub 
deploy to kubernates 
proper logging 


# Step1: Create app 











#### docker images 

https://www.bezkoder.com/spring-boot-jpa-h2-example/

https://github.com/mkyong/spring-boot/tree/master/spring-boot-docker



How b

#bulild docker image 
docker build -t springboot-k8s-app .

# build docker run 
docker run -p 8080:8080 springboot-k8s-app


# Create repository in docker hub and push the app
docker tag springboot-k8s-app tejnal/kubernetes:springboot-k8s-app
docker push tejnal/kubernetes:springboot-k8s-app


## Start kubernetes cluster 

 #Install Kind or Minikub to setup local k8s cluster 
 
   brew install kind 
   
   Crete a cluster by running kind-config.yaml by
   
   kind create cluster --config kind-config.yaml 
   
   to check clusternae you can run [kind get clusters]
   
 # Deployment of micro services locally 
 
    Deployment: it provides the ability to create pods 
    Service : a k8s component that allow you to access the pod 
    Ingress: Network filter they rout the inbound and outbound request based on certain rule 
    
    Create deplayment.yaml and run that kubectl apply -f deployment.yaml
    
    check for pods --  [kubectl get pods]
    
     Two pods created --> pod gets its own IP address but this IP address is not permanent.
     
     
     set up the service 
     create a file called service.yaml and run kubectl apply -f service.yaml
     now get  kubectl get service
     
     
     set up the ingress 
     create a file called ingress.ymal and run kubectl apply -f ingress.yaml 
     
     
     deployment using helm charts 
     
     helm install springboot-k8s-app kubernetres\helm\springboot-k8s-app --dry-run
    
                         
Deploy Docker Image To Kubernetes Cluster Using Jenkins
    
    
   
   
    https://faun.pub/ci-cd-pipeline-using-jenkins-to-deploy-on-kubernetes-cf2fd5e185b8
    
    https://www.betsol.com/blog/devops-using-jenkins-docker-and-kubernetes/
    
    https://medium.com/codex/deploy-docker-image-to-kubernetes-cluster-using-jenkins-8182cc0a8de7
    
    https://medium.com/javarevisited/deploying-a-springboot-application-in-docker-using-jenkins-cicd-2489bfe752c3
    
    https://techdozo.dev/getting-started-with-kind-quick-start-a-multi-node-local-kubernetes-cluster/
    
    
    https://medium.com/codex/how-to-push-a-docker-image-to-docker-hub-using-jenkins-487fb1fcbe25
    
    
 
 
 
 
install jenkins on mac 

how deploy on aws 
https://www.youtube.com/watch?v=ENNBdmNn4r0
https://www.bezkoder.com/spring-boot-jpa-h2-example/



#Install jenkins server on mac 
 
https://coralogix.com/blog/how-to-install-and-configure-jenkins-on-the-mac-os/

docker run -p 8080:8080 -p 50000:50000 -v ~/jenkins_home:/var/jenkins_home jenkins/jenkins:lts


# integrate github and jenkins 



# Integrate between docker hub  and jenkins 

add global secrets 



have a docker access token : a0bb5d5f-5268-4847-8337-105d42816813

