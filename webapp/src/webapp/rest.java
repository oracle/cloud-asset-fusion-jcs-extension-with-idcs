/*
**
** Copyright © 2018, Oracle and/or its affiliates. All rights reserved.
** Licensed under the Universal Permissive License v 1.0 as shown at https://oss.oracle.com/licenses/upl.
*/

package webapp;

import java.net.URI;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Configurable;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import oracle.wsm.metadata.feature.AbstractPolicyFeature;
import oracle.wsm.metadata.feature.PolicyReferenceFeature;
import oracle.wsm.metadata.feature.PolicySetFeature;
import oracle.wsm.metadata.feature.PropertyFeature;
import oracle.wsm.security.util.SecurityConstants;

import weblogic.logging.NonCatalogLogger;

@Generated(value = { "wadl|file:///Users/max/Desktop/accounts.wadl", "run|74b48ca2-bd05-4c89-8045-1df0100579bb" },
           comments = "wadl2java, http://wadl.java.net", date = "2018-11-21T11:58:15.606+01:00")
public class rest {

    /**
     * The base URI for the resource represented by this proxy
     *
     */
    public final static URI BASE_URI;

    static {
        URI originalURI = URI.create("https://yourEngagementCloudBaseURL");
        // Look up to see if we have any indirection in the local copy
        // of META-INF/java-rs-catalog.xml file, assuming it will be in the
        // oasis:name:tc:entity:xmlns:xml:catalog namespace or similar duck type
        java.io.InputStream is = rest.class.getResourceAsStream("/META-INF/jax-rs-catalog.xml");
        if (is != null) {
            try {
                // Ignore the namespace in the catalog, can't use wildcard until
                // we are sure we have XPath 2.0
                String found =
                    javax.xml
                                    .xpath
                                    .XPathFactory
                                    .newInstance()
                                    .newXPath()
                                    .evaluate("/*[name(.) = 'catalog']/*[name(.) = 'uri' and @name ='" + originalURI +
                                              "']/@uri", new org.xml.sax.InputSource(is));
                if (found != null && found.length() > 0) {
                    originalURI = java.net
                                      .URI
                                      .create(found);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (java.io.IOException e) {
                }
            }
        }
        BASE_URI = originalURI;
    }

    /**
     * Accounts.
     *
     */
    public static rest.Accounts accounts(Client client,
                                                                                               URI baseURI) {
        return new rest.Accounts(client, baseURI);
    }

    /**
     * Template method to allow tooling to customize the new Client
     *
     */
    private static void customizeClientConfiguration(Configurable cc) {
        // Client policy features configuration.

        // JWT
        cc.property(AbstractPolicyFeature.ABSTRACT_POLICY_FEATURE,
                    new PolicySetFeature(new PolicyReferenceFeature("oracle/http_jwt_token_over_ssl_client_policy")));
        
/*
        // Other security policies for developer's convenience
        // either to exchange JWT with SAML Bearer Tokens as authentication mechanism
        // or to help during development with debugging & testing

        // SAML security policy for implementing authentication using SAML Bearer Tokens
        cc.property(AbstractPolicyFeature.ABSTRACT_POLICY_FEATURE,
                    new PolicySetFeature(new PolicyReferenceFeature("oracle/http_saml20_token_bearer_over_ssl_client_policy")));


        // Basic Authentication security policy for implementing authentication using HTTP Basic Authentication
        // should be used for debugging & testing only
        PropertyFeature uname = new
                 PropertyFeature(SecurityConstants.ClientConstants.WSM_USERNAME_PROPERTY,"username");
        PropertyFeature pwd = new
                 PropertyFeature(SecurityConstants.ClientConstants.WSM_PASSWORD_PROPERTY,"password");
        PropertyFeature[] propFeatures = new PropertyFeature[] { uname, pwd };
        cc.property(AbstractPolicyFeature.ABSTRACT_POLICY_FEATURE,
                    new PolicySetFeature(new PolicyReferenceFeature("oracle/http_basic_auth_over_ssl_client_policy"),propFeatures));
*/
    }

    /**
     * Template method to allow tooling to override Client factory
     *
     */
    private static Client createClientInstance() {
        return ClientBuilder.newClient();
    }

    /**
     * Create a new Client instance
     *
     */
    public static Client createClient() {
        Client client = createClientInstance();
        customizeClientConfiguration(client);
        return client;
    }

    /**
     * Accounts.
     *
     */
    public static rest.Accounts accounts() {
        return accounts(createClient(), BASE_URI);
    }

    /**
     * Accounts.
     *
     */
    public static rest.Accounts accounts(Client client) {
        return accounts(client, BASE_URI);
    }


    /**
     * Accounts.
     *
     */
    public static class Accounts {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;

        private Accounts(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        /**
         * Create new instance using existing Client instance, and a base URI and any parameters
         *
         */
        public Accounts(Client client, URI baseUri) {
            _client = client;
            _uriBuilder = UriBuilder.fromUri(baseUri);
            _uriBuilder = _uriBuilder.path("crmRestApi/resources/latest/accounts");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        /**
         * Accounts.
         *
         */
        public <T> T getAsVndOracleAdfResourcecollectionJson(GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebTarget resource = _client.target(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            javax.ws.rs.client.Invocation.Builder resourceBuilder =
                resource.request("application/vnd.oracle.adf.resourcecollection+json");
            Response response;
            response = resourceBuilder.build("GET").invoke();
            if (response.getStatus() >= 400) {
                throw new rest.WebApplicationExceptionMessage(response);
            }
            return response.readEntity(returnType);
        }

        /**
         * Accounts.
         *
         */
        public <T> T getAsVndOracleAdfResourcecollectionJson(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebTarget resource = _client.target(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            javax.ws.rs.client.Invocation.Builder resourceBuilder =
                resource.request("application/vnd.oracle.adf.resourcecollection+json");
            Response response;
            response = resourceBuilder.build("GET").invoke();
            if (!Response.class.isAssignableFrom(returnType)) {
                if (response.getStatus() >= 400) {
                    throw new rest.WebApplicationExceptionMessage(response);
                }
            }
            if (!Response.class.isAssignableFrom(returnType)) {
                return response.readEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

        /**
         * Account Details.
         *
         */
        public String getAccountDetails(String id) {
            String result;
            NonCatalogLogger myLogger = null;
            myLogger = new NonCatalogLogger("edashboard");

            _uriBuilder = UriBuilder.fromUri(BASE_URI);
            _uriBuilder = _uriBuilder.path("crmRestApi/resources/latest/accounts");
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebTarget resource = _client.target(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            resource=resource.queryParam("q", "OrganizationName="+id);
            resource=resource.queryParam("fields", "OrganizationName,PartyId,PartyNumber,OwnerEmailAddress");
            resource=resource.queryParam("onlyData", "true");
            javax.ws.rs.client.Invocation.Builder resourceBuilder =
                resource.request("application/vnd.oracle.adf.resourcecollection+json");
            Response response;
            response = resourceBuilder.build("GET").invoke();
            if (!Response.class.isAssignableFrom(String.class)) {
                result = response.readEntity(String.class);
            } else {
                result = String.class.cast(response);
            }
            if (response.getStatus() != 200) {
                myLogger.error("Get Account Details failed");
                myLogger.error("HTTP status code: " + response.getStatus());
                myLogger.error("HTTP reason: " + response.getStatusInfo().getReasonPhrase());
                result = "{ \"response\": \"" + result + "\", " +
                         "\"HTTPStatusCode\": \"" + response.getStatus() + "\", " +
                         "\"HTTPReason\": \"" + response.getStatusInfo().getReasonPhrase() + "\" }";
            }
            return result;
        }

    }


    /**
     * Workaround for JAX_RS_SPEC-312
     *
     */
    private static class WebApplicationExceptionMessage extends WebApplicationException {


        private WebApplicationExceptionMessage(Response response) {
            super(response);
        }

        /**
         * Workaround for JAX_RS_SPEC-312
         *
         */
        public String getMessage() {
            Response response = getResponse();
            Response.Status status = Response.Status.fromStatusCode(response.getStatus());
            if (status != null) {
                return (response.getStatus() + (" " + status.getReasonPhrase()));
            } else {
                return Integer.toString(response.getStatus());
            }
        }

        public String toString() {
            String s = "javax.ws.rs.WebApplicationException";
            String message = getLocalizedMessage();
            return (s + (": " + message));
        }

    }

}
