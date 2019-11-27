## *This sample shows how to extend Oracle Fusion Cloud Applications with Oracle Java Cloud Service secured by Oracle Identity Cloud Service*

## Overview
Oracle Java Cloud Service (JCS) can be used to extend Oracle Engagement Cloud (OEC) by building custom web pages and embedding them into OEC.  One desired feature is to have the extension secured by Oracle Identity Cloud Service. The high-level approach for this happen is to setup identity federation between JCS, IDCS and OEC and then leverage OWSM security policies for all API calls from JCS to OEC.  

Through identity federation, JCS receives the Web-SSO username and subsequently OWSM can use this username to add an Authorization Bearer Token to all outbound OEC REST API calls.

This sample demonstrates this technique in action and can be used as a starting point for your project.

## Products Involved

- Oracle Engagement Cloud (OEC Release 19 or later ), other Fusion pillars such as HCM, ERP can also be used using the relevant page integration techniques.
- Oracle Java Cloud Service (JCS Release 19 or later)  
- Oracle Web Services Manager (OWSM) (already included in JCS)  
- Oracle Identity Cloud Service (IDCS Release 19 or later)  



## Prerequisites for this sample
* Identity Federation between OEC , JCS and IDCS needs to be configured in advance. The following links 
  [Enable Oracle Fusion Applications Cloud Service Federation and OAuth Trust with Oracle Identity Cloud Service](https://docs.oracle.com/en/solutions/extend-saas-with-java-cloud-service-apps/enable-oracle-fusion-applications-cloud-service-federation-and-oauth-trust-oracle-identity-cloud-serv1.html#GUID-53C8A800-3DC3-48F0-930E-11797185406B) and [Oracle Identity Cloud Service: Integrating with Weblogic Server](https://www.oracle.com/webfolder/technetwork/tutorials/obe/cloud/idcs/idcs_wls_obe/wls.html#section2s1) ,  can be used as guidelines for this configuration.
* JCS needs to be configured with OWSM in place so that it sends an appropriate Authorization Bearer token when needed. Within OEC, JCS needs to be setup as a Trusted JWT Client so that the Bearer token gets accepted on the OEC side.
* For this sample to work , a user with an group "manager" needs to be created in IDCS which in turn will allow access to the secured JCS web page.  

## Deploying and running the code
1. Open the sample application using Oracle JDeveloper 12c

2. Adjust the Base URL of our OEC instance in line 39 of the ```rest.java``` file.  

3. Compile and deploy the app to your JCS instance from within JDeveloper 12c.  

   It is assumed the reader knows how to deploy an application to JCS, if not then please refer to the relevant JDeveloper documentation on how to deploy to a Java Cloud Service instance.

4. Embed the JCS web page into OEC using the OEC App Composer. Note OEC expects a DNS name instead of an IP address when embedding the JCS web page.

## License
Copyright © 2018, Oracle and/or its affiliates. All rights reserved.
This project is licensed under the Universal Permissive License v 1.0 as shown at https://oss.oracle.com/licenses/upl.