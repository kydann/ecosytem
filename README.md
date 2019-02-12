<h1>BANCA DEL FUTURO</h1>

<h2>Ecosystem and archetype for Electronic Banking migration project</h2>

<p>This is a general template archetype and generic infraestructure for Electronic Banking developers based on a 
<a href="https://martinfowler.com/microservices/"> Microservice Architecture Pattern</a> 
using <a href="https://projects.spring.io/spring-boot/">Spring Boot</a>, <a href="http://projects.spring.io/spring-cloud/">
Spring Cloud</a>, <a href="https://www.docker.com/">Docker</a> and <a href="https://jenkins.io/">Jenkins</a>.

<p>The proposed architecture, infrastructure and technology stack are designed to achieve an independent integration 
of the platform on which applications are deployed. The main goal is to have the development and 
infrastructure layer isolated from each other in order to have Functional Services hat can be deployed on any platform.</p> 

<p>This is the first approximation of the platform of development and continuous integration for the domain of electronic 
banking.</p>

<p>All the contributions and proposals for improvement and adaptation of the architecture are well received.</p>

<h2>Infrastructure services</h2>

<p>The infrastructure shown is based on spring cloud and spring boot in order to implement 
commons patterns based on distributed system.</p>

![infraestructure](https://github.com/mikecoronel/ecosystem-microservices/blob/master/infraestructure.png)

<p>Gray modules are not found in the present architecture, due to lack of definition of the project, but if it is 
necessary those modules can be included in a future the work to do that is minimal.</p>

<h3>Config Service</h3>

<p><a href="https://spring.io/guides/gs/centralized-configuration/">Config service </a>
is using native profile, which simply loads config files from the local classpath. You can see shared 
directory in <a href="https://github.com/anzen/bne_microservices_archetypes/tree/master/config/src/main/resources">Config service resources. </a>When a Service request it's configuration, <b>Config Service</b> responses with shared/service-name.yml and shared/application.yml (which is inherited and shared between all client applications).</p>

<p>The present configuration can change according to the needs of the project and the different environments existing 
in the bank's infrastructure.</p>

<h3>Discovery Service</h3>

<p>For our development local enviroment we are using <a href="https://spring.io/guides/gs/service-registration-and-discovery/">
Eureka</a> as client side discovery pattern in order for determining 
locations of available service instances (using Registry server) and <a href="https://www.nginx.com/resources/glossary/load-balancing/">
Load Balancing</a> requests across them.</p>

<p>Eureka provides a simple interface, where you can track running services and number of available instances: <code>http://registry:8761</code></p>

<h3>API Gateway</h3>

<p>For our purpose we using <a href="https://spring.io/guides/gs/routing-and-filtering/">Zuul</a> 
as our API Gateway in development local enviroment in order to expose the routes of the different services 
exposed to the client that can be invoked by different channels.</p>

<p>Zuul does not require any direct interaction with the client, which is why it is only part of our infrastructure
without affecting the deploy of our application in other platforms or enviroments.</p>

<p>Zuul only require a <a href="https://docs.pivotal.io/spring-cloud-services/1-3/common/service-registry/">
Service Discovery</a> (in our case Eureka) mechanism to locate any service exposed to the client.</p>

<h2>Functional Archetype</h2>

<p><a href="https://github.com/anzen/bne_microservices_archetypes/tree/master/archetype">Functional Archetype</a> 
provides us an easy way to create a <b>Functional Service</b> with the minimal dependencies and connectors 
so that the developers concentrate the effort in programming defined business rules.</p>

<p>Archetype provides Tuxedo Connector (under constuction) and JDBC Connector (SQL Server BNE Database) through 
Feign Client which give us an easy way to get a Rest Client over http or https protocol. Feign can use service name 
through eureka server in order to get the ip address and port where the service is instantiated and listening, also
can use url to consume the service directly in the same way.</p>

<p>The Archetype contains the minimal dependencies that we have avaluated in order to create Functional Services that 
meet minimum development and deployment standards. It give us the posibility to compile the Service for local 
developmnt enviroment or another enviroment using <a href="http://projects.spring.io/spring-cloud/">
Spring Cloud</a> dependencies. For local enviroment we are using Spring cloud Netflix Eureka, Spring cloud Netflix 
Zuul and Spring Cloud Config Service.</p>

<h2>How To Build.</h2>

<b>Minimum requirements:</b>

<ul>
    <li>At least 4 GB RAM available.</li>
</ul>

<b>Installation Requirements:</b>

<ul>
    <li>Maven 3.5.0 or higher</li>
    <li>jdk 1.8</li>
    <li>Docker CE and Docker Compose <small>(for windows machine or Mac, you must install Boot2Docker and VirtualBox with a Linux SO installed)</small>.</li>
    <li>Export variable CONFIG_SERVICE_PASSWORD</li>
</ul>

<p>It is necessary to modify your hosts file with the following entries: <code>127.0.0.1   config gateway  registry</code></p>

<b>Building Archetype</b>

<p>The following steps should only be executed once:</p>

<ul>
    <li>Clone the repository into your local machine</li>
    <li>Go to archetype directory <code>$cd archetype</code></li>
    <li>Create the new archetype with <code>$mvn install</code></li>
</ul>

<p>Before commands will create a local archetype where <code>archetypeGroupId=com.citibanamex.bne</code>, <code>archetypeArtifactId=api-domain-archetype</code> 
and <code>archetypeVersion=1.0.0-SNAPSHOT</code>, to validate the correct creation of the archetype verify the file archetype-catalog.xml
in your local repository.</p>

<b>Create a new project</b>

<ul>
    <li>Go to scripts path</li>
    <li>Run the build script <code>$./build.sh ${artifactId} /path/to/empty/project</code></li>
</ul>

<p>where ${artifactId} is the name of the project (e.g. accounts, transfers, customers, payments) and path_to_project is
the path where you want to create your project, we recommend an empty directory (or maybe your IDE workspace) and it 
should be different from the directory where you made your clone.</p>

<p>After build your project, the configuration files your project needs to run on the local infraestructure will
be in the configuration server and API gateway paths repectively. Make sure you do not build the project twice, if you want 
to rebuild the project first run the script clean.sh</p>

<p>Once the project was created, you can import it to your development IDE.</p>

<b>Running the enviroment</b>

<ul>
    <li>Go to your cloned repository</li>
    <li>Run the command <code>$mvn clean install -Dmaven.test.skip=true</code></li>
    <li><code>$docker-compose up</code>
</ul>

<p>This will start the local development environment, once started we can check the next <b>important endpoints</b> 
in your browser:</p> 

<ul>
    <li><a href="http://config:8888/shared/${artifactId}">http://config:8888/shared/${artifactId}</a></li>
    <li><a href="http://registry:8761">http://registry:8761</a></li>
    <li><a href="http://gateway:8080">http://gateway:8080</a></li>
</ul>

<b>Running the porject</b>

<ul>
    <li>Go to your project path</li>
    <li><code>mvn spring-boot:run -Pdevelopment</code></li>
</ul>

<p>There is one end point inside the project in order to test it:</p>

<ul>
  <li><code>$curl -v -H "Content-Type: application/json" -X POST http://gateway:8080/${artifactId}/v1/generic/endpoint2</code></li>
</ul>

<p>curl is a Linux tool, there is another options in order to send the post.</p>













