# Ride Sharing App Web Interface

This third and final work aims to create a web interface for the RSA. This work is based on the previous practical work in which the logic of this application was developed. In this work GWT will be used to provide this package with a web interface.

After creating a GWT project we developed the shared types, server and client packages:

<ul>
  <li> <b>Shared Types</b> - The rsa.shared package is configured so that its classes are visible by both the rsa.client package (which runs in the browser) and the rsa.server package (which runs on the server). In this package there are the classes already defined in job 2. These classes will be used by RPC to send data from the server to the clients. </li>
  <li> <b>Server</b>- The RSA service will allow the interface installed on the client to communicate with the classes in the package installed on the server, and the definition of some classes will be shared between client and server. </li>
  <li> <b>Client</b> - In the client package are placed the classes that produce and manage the graphical user interface (GUI), as well as the RPC communication with the server. This package has a single entry point, that is, a class implemented EntryPoint. This class maintains the reference for asynchronous communication with the service. </li>
</ul>
