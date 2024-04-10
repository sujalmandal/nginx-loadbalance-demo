## load balancing example using nginx
### stack
    - quarkus framework
    - docker containers
    - nginx reverse proxy

### description
This example demonstrates how to use Nginx as a reverse proxy for load balancing multiple Quarkus applications. The solution consists of two Quarkus applications and one Nginx container running on Docker. The 2 Quarkus applications are deployed on different containers, inside the same docker stack, thus they have different dns (same as docker service name).

To achieve load balancing, we utilize the `proxy_pass` directive in the Nginx configuration file. This directive forwards incoming requests from the client to one of the two Quarkus application servers based on a round-robin algorithm.

### deployment
The deployment process involves the following steps:
1. `./start.cmd`
2. To update the nginx.conf and view the effects on load balancing, use `./start.cmd -skipBuild` to avoid building the microservices every time conf is changed.

### usage
Once the deployment is complete
    - visit `localhost:8080` to load static files directly served from the nginx instance.
    - run `localhost:8080/api/ping/test` to run `/ping/{payload}` resource written in the quarkus microservices.